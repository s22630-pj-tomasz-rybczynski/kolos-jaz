package pl.rybczynski.jazs22630nbp.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.rybczynski.jazs22630nbp.model.CurrencyDbRow;
import pl.rybczynski.jazs22630nbp.service.CurrencyService;

import java.math.BigDecimal;
import java.time.LocalDate;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    final private CurrencyService currencyService;

    public RestController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping
    public ResponseEntity<CurrencyDbRow> getCurrency(@RequestParam(value = "price") BigDecimal price, @RequestParam(value = "fromDate") LocalDate fromDate, @RequestParam(value = "toDate") LocalDate toDate) {
        return ResponseEntity.ok(currencyService.getCurrency(price, fromDate, toDate));
    }
}
