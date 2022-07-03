package pl.rybczynski.jazs22630nbp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.rybczynski.jazs22630nbp.model.Currency;
import pl.rybczynski.jazs22630nbp.model.CurrencyDbRow;
import pl.rybczynski.jazs22630nbp.model.CurrencyResponse;
import pl.rybczynski.jazs22630nbp.model.NBPResponse;
import pl.rybczynski.jazs22630nbp.repository.CurrencyRepository;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class CurrencyService {

    private final RestTemplate client;
    private final CurrencyRepository repo;

    public CurrencyService(RestTemplate restTemplate, CurrencyRepository repo) {
        this.client = restTemplate;
        this.repo = repo;
    }

//    [
//    {
//        "table":"A",
//            "no":"199/A/NBP/2020",
//            "effectiveDate":"2020-10-12",
//            "rates":[
//        {
//            "currency":"bat (Tajlandia)",
//                "code":"THB",
//                "mid":0.1217
//        },

    private final String url = "https://api.nbp.pl/api/exchangerates/tables/a";

    public CurrencyResponse getCurrency(Double price, LocalDate fromDate, LocalDate toDate) {
        NBPResponse[] res = client.getForObject(url + "/{fromDate}/{toDate}?format=json", NBPResponse[].class, fromDate, toDate);
        List<Currency> currencies = Arrays.stream(res).toList().stream().flatMap(nbpRes -> nbpRes.getRates().stream().filter(currency -> price > currency.getMid())).toList();
//        BigDecimal avg = BigDecimal.valueOf(res.getRates().stream().map(Currency::getMid).mapToDouble(s -> s).average().orElseThrow())
//                .round(new MathContext(3));

//        CurrencyDbRow response = new CurrencyDbRow(avg, code, from, to);
//
//        repo.save(response);

        return response;
    }

}
