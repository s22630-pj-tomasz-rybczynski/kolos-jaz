package pl.rybczynski.jazs22630nbp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


//Każdorazowe wykonanie zapytania ma zapisać w bazie danych następujące informacje: id
//        (automatycznie przypisywane), średnią cenę dla jakiej zostało wykonane zapytanie, datę
//        rozpoczynającą przedział, datę kończącą przedział, liczbę walut, data oraz godzina
//        zapytania.

@Entity
public class CurrencyDbRow {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CurrencyDbRow() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal avg;
    private String currency;
    private LocalDate fromDate;
    private LocalDate toDate;
    private LocalDateTime createdAt = LocalDateTime.now();


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public CurrencyDbRow(Long id, BigDecimal avg, String currency, LocalDate fromDate, LocalDate toDate) {
        this.id = id;
        this.avg = avg;
        this.currency = currency;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public CurrencyDbRow(BigDecimal avg, String currency, LocalDate fromDate, LocalDate toDate) {
        this.avg = avg;
        this.currency = currency;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public BigDecimal getAvg() {
        return avg;
    }

    public void setAvg(BigDecimal avg) {
        this.avg = avg;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public void setToDate(LocalDate to) {
        this.toDate = to;
    }
}
