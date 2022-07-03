package pl.rybczynski.jazs22630nbp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.rybczynski.jazs22630nbp.model.Currency;
import pl.rybczynski.jazs22630nbp.model.CurrencyDbRow;
import pl.rybczynski.jazs22630nbp.model.CurrencyResponse;
import pl.rybczynski.jazs22630nbp.model.NBPResponse;
import pl.rybczynski.jazs22630nbp.repository.CurrencyRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

@Service
public class CurrencyService {

    private final RestTemplate client;
    private final CurrencyRepository repo;

    public CurrencyService(RestTemplate restTemplate, CurrencyRepository repo) {
        this.client = restTemplate;
        this.repo = repo;
    }

    private static <T> Predicate<T> distinctByKey(
            Function<? super T, ?> keyExtractor) {

        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    private final String url = "https://api.nbp.pl/api/exchangerates/tables/a";

    public CurrencyResponse getCurrency(Double price, LocalDate fromDate, LocalDate toDate) {
        ResponseEntity<NBPResponse[]> res = client.getForEntity(url + "/{fromDate}/{toDate}?format=json", NBPResponse[].class, fromDate, toDate);

        List<Currency> currencies = Arrays.stream(Objects.requireNonNull(res.getBody())).toList().stream()
                .flatMap(nbpRes -> nbpRes.getRates().stream().filter(currency -> price < currency.getMid()))
                .filter(distinctByKey(Currency::getCode)).toList();

        Integer amountOfCurrencies = currencies.size();

        repo.save(new CurrencyDbRow(price, currencies.size(), fromDate, toDate));

        return new CurrencyResponse(amountOfCurrencies);
    }

}
