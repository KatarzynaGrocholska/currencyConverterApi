package com.example.currencyConverterApi.model.mapper;

import com.example.currencyConverterApi.model.entity.CurrencyConverter;
import com.example.currencyConverterApi.model.output_dto.CurrencyConverterAllInfoOutputDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CurrencyConverterAllInfoMapperTest {

    CurrencyConverterAllInfoMapper mapper = CurrencyConverterAllInfoMapper.INSTANCE;

    @Test
    void currencyConverterToCurrencyConverterAllInfoOutputDto() {
        //given
        CurrencyConverter currencyConverter = CurrencyConverter
                .builder()
                .valueInToCurrency(34.2)
                .toCurrencyCode("PLN")
                .fromCurrencyCode("EUR")
                .amount(100)
                .tradingDate("23-04-2015")
                .askPrice(3.5)
                .bidPriceOfSecondCurrency(4.5)
                .bidPrice(5.4)
                .build();
        List<CurrencyConverter> expected = new ArrayList<>();
        expected.add(currencyConverter);
        //when
        List<CurrencyConverterAllInfoOutputDTO> actual =
                mapper.currencyConverterTOCurrencyConverterAllInfoOutputDTOList(expected);
        //then
        Assertions.assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual.get(0).getTradingDate()).isEqualTo(expected.get(0).getTradingDate()),
                () -> assertThat(actual.get(0).getFromCurrencyCode()).isEqualTo(expected.get(0).getFromCurrencyCode()),
                () -> assertThat(actual.get(0).getToCurrencyCode()).isEqualTo(expected.get(0).getToCurrencyCode()),
                () -> assertThat(actual.get(0).getValueInToCurrency()).isEqualTo(expected.get(0).getValueInToCurrency()),
                () -> assertThat(actual.get(0).getAmount()).isEqualTo(expected.get(0).getAmount()),
                () -> assertThat(actual.get(0).getAskPrice()).isEqualTo(expected.get(0).getAskPrice()),
                () -> assertThat(actual.get(0).getBidPrice()).isEqualTo(expected.get(0).getBidPrice()),
                () -> assertThat(actual.get(0).getBidPriceOfSecondCurrency()).isEqualTo(expected.get(0).getBidPriceOfSecondCurrency()));

    }

}