package com.example.currencyConverterApi.model.entity;

import lombok.*;

import javax.persistence.*;

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
    @Column(length = 3)
    private String fromCurrencyCode;
    @Column(length = 3)
    private String toCurrencyCode;
    private double bidPrice;
    private double askPrice;
    private double bidPriceOfSecondCurrency;
    private String tradingDate;
    private double amount;
    private double valueInToCurrency;
}
