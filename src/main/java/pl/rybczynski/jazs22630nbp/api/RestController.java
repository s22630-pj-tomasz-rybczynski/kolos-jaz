package pl.rybczynski.jazs22630nbp.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.rybczynski.jazs22630nbp.model.CurrencyResponse;
import pl.rybczynski.jazs22630nbp.service.CurrencyService;

import java.time.LocalDate;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    final private CurrencyService currencyService;

    public RestController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("nbp")
    public ResponseEntity<CurrencyResponse> getCurrency(@RequestParam(value = "price") Double price, @RequestParam(value = "fromDate") String fromDate, @RequestParam(value = "toDate") String toDate) {
        return ResponseEntity.ok(currencyService.getCurrency(price, LocalDate.parse(fromDate), LocalDate.parse(toDate)));
    }
}
