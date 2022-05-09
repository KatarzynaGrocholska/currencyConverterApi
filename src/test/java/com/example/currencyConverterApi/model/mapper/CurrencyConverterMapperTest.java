package com.example.currencyConverterApi.model.mapper;

import com.example.currencyConverterApi.model.entity.CurrencyConverter;
import com.example.currencyConverterApi.model.output_dto.CurrencyConverterOutputDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CurrencyConverterMapperTest {

    CurrencyConverterMapper mapper = CurrencyConverterMapper.INSTANCE;

    @Test
    void currencyConverterToCurrencyConverterOutputDto() {
        //given
        CurrencyConverter expected = CurrencyConverter
                .builder()
                .askPriceOfSecondCurrency(3.4)
                .valueInToCurrency(34.2)
                .toCurrencyCode("PLN")
                .fromCurrencyCode("EUR")
                .bidPrice(4.12)
                .askPrice(4.32)
                .amount(100)
                .tradingDate("23-04-2015")
                .build();
        //when
        CurrencyConverterOutputDTO actual =
                mapper.currencyConverterToCurrencyConverterOutputDTO(expected);
        //then
        Assertions.assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual.getAskPriceOfSecondCurrency()).isEqualTo(expected.getAskPriceOfSecondCurrency()),
                () -> assertThat(actual.getBidPrice()).isEqualTo(expected.getBidPrice()),
                () -> assertThat(actual.getAskPrice()).isEqualTo(expected.getAskPrice()),
                () -> assertThat(actual.getTradingDate()).isEqualTo(expected.getTradingDate()),
                () -> assertThat(actual.getFromCurrencyCode()).isEqualTo(expected.getFromCurrencyCode()),
                () -> assertThat(actual.getToCurrencyCode()).isEqualTo(expected.getToCurrencyCode()),
                () -> assertThat(actual.getValueInToCurrency()).isEqualTo(expected.getValueInToCurrency()),
                () -> assertThat(actual.getAmount()).isEqualTo(expected.getAmount()));

    }
}