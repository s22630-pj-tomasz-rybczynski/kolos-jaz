package pl.rybczynski.jazs22630nbp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.rybczynski.jazs22630nbp.model.Currency;
import pl.rybczynski.jazs22630nbp.model.CurrencyDbRow;
import pl.rybczynski.jazs22630nbp.model.NBPResponse;
import pl.rybczynski.jazs22630nbp.repository.CurrencyRepository;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;

@Service
public class CurrencyService {

    private final RestTemplate client;
    private final CurrencyRepository repo;

    public CurrencyService(RestTemplate restTemplate, CurrencyRepository repo) {
        this.client = restTemplate;
        this.repo = repo;
    }

    private final String url = "https://api.nbp.pl/api/exchangerates/tables/a";

    public CurrencyDbRow getCurrency(BigDecimal price, LocalDate fromDate, LocalDate toDate) {
        NBPResponse res = client.getForObject(url + "/{fromDate}/{toDate}?format=json", NBPResponse.class, fromDate, toDate);

        BigDecimal avg = BigDecimal.valueOf(res.getRates().stream().map(Currency::getMid).mapToDouble(s -> s).average().orElseThrow())
                .round(new MathContext(3));

//        CurrencyDbRow response = new CurrencyDbRow(avg, code, from, to);
//
//        repo.save(response);

        return response;
    }

}
