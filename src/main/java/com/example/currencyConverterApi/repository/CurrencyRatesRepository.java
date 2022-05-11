package com.example.currencyConverterApi.repository;

import com.example.currencyConverterApi.model.entity.TableCurrencyRates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRatesRepository extends JpaRepository<TableCurrencyRates,Integer> {
}
