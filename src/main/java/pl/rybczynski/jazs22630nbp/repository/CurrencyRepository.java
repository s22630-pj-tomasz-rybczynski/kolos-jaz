package pl.rybczynski.jazs22630nbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rybczynski.jazs22630nbp.model.CurrencyDbRow;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyDbRow, Long> {}
