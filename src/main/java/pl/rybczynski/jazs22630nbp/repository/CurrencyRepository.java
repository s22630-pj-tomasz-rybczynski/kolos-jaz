package pl.rybczynski.jazs22630nbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.rybczynski.jazs22630nbp.model.CurrencyDbRow;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyDbRow, Long> {

    @Modifying
    @Query(value = "INSERT into CurrencyResponse (id, `avg`, currency, fromDate, toDate, createdAt) values (:avg, :currency, :fromDate, :toDate, :createdAt)", nativeQuery = true)
    CurrencyDbRow save(@Param("avg") BigDecimal avg, @Param("currency") String currency, @Param("fromDate") LocalDate from, @Param("toDate") LocalDate to, @Param("createdAt") Instant createdAt);
}
