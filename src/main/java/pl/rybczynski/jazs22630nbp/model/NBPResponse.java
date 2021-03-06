package pl.rybczynski.jazs22630nbp.model;

import java.util.List;

public class NBPResponse {
    private List<Currency> rates;

    public NBPResponse(List<Currency> rates) {
        this.rates = rates;
    }

    public NBPResponse() {
    }

    public List<Currency> getRates() {
        return rates;
    }

    public void setRates(List<Currency> rates) {
        this.rates = rates;
    }
}
