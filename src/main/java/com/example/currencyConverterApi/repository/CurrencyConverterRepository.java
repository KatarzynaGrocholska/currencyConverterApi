package com.example.currencyConverterApi.repository;

import com.example.currencyConverterApi.model.entity.CurrencyConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConverterRepository extends JpaRepository<CurrencyConverter, Integer> {
}
