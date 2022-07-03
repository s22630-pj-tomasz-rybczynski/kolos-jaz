package pl.rybczynski.jazs22630nbp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class CurrencyDbRow {
    public CurrencyDbRow() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double avgPrice;
    private Integer amountOfCurrencies;
    private LocalDate fromDate;
    private LocalDate toDate;
    private LocalDateTime createdAt = LocalDateTime.now();


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public CurrencyDbRow(Long id, Double avgPrice, Integer amountOfCurrencies, LocalDate fromDate, LocalDate toDate) {
        this.id = id;
        this.avgPrice = avgPrice;
        this.amountOfCurrencies = amountOfCurrencies;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public CurrencyDbRow(Double avgPrice, Integer amountOfCurrencies, LocalDate fromDate, LocalDate toDate) {
        this.avgPrice = avgPrice;
        this.amountOfCurrencies = amountOfCurrencies;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate from) {
        this.fromDate = from;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Integer getAmountOfCurrencies() {
        return amountOfCurrencies;
    }

    public void setAmountOfCurrencies(Integer amountOfCurrencies) {
        this.amountOfCurrencies = amountOfCurrencies;
    }

    public void setToDate(LocalDate to) {
        this.toDate = to;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
