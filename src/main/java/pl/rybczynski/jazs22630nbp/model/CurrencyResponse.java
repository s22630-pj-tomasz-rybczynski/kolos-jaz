package pl.rybczynski.jazs22630nbp.model;

public class CurrencyResponse {
    private Integer amountOfCurrencies;

    public CurrencyResponse(Integer amountOfCurrencies) {
        this.amountOfCurrencies = amountOfCurrencies;
    }

    public Integer getAmountOfCurrencies() {
        return amountOfCurrencies;
    }

    public void setAmountOfCurrencies(Integer amountOfCurrencies) {
        this.amountOfCurrencies = amountOfCurrencies;
    }
}
