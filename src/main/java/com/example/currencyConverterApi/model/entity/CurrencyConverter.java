package com.example.currencyConverterApi.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurrencyConverter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fromCurrencyCode;
    private String toCurrencyCode;
    private double bidPrice;
    private double askPrice;
    private double askPriceOfSecondCurrency;
    private String tradingDate;
    private double amount;
    private double valueInToCurrency;
}
