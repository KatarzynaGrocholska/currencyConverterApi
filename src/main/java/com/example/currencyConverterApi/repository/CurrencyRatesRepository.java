package com.example.currencyConverterApi.repository;

import com.example.currencyConverterApi.model.entity.CurrencyRates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRatesRepository extends JpaRepository<CurrencyRates,Integer> {
}
