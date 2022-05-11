package com.example.currencyConverterApi.model.mapper;

import com.example.currencyConverterApi.model.entity.TableCurrencyRates;
import com.example.currencyConverterApi.model.entity.Rates;
import com.example.currencyConverterApi.model.input_dto.RatesInputDTO;
import com.example.currencyConverterApi.model.output_dto.TableCurrencyRateOutputDTO;
import com.example.currencyConverterApi.model.output_dto.RatesOutputDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CurrencyRateMapperTest {

    CurrencyRateMapper mapper = CurrencyRateMapper.INSTANCE;

    @Test
    void shouldReturnRatesOutputDTOListWhenGivenRatesEntity() {
        //given
        Rates rates = Rates
                .builder()
                .ask("3,56")
                .bid("4,56")
                .currency("dolar amerykański")
                .code("USD")
                .build();
        List<Rates> expected = new ArrayList<>();
        expected.add(rates);
        //when
        List<RatesOutputDTO> actual =
                mapper.ratesListToRatesOutputDTOList(expected);
        //then
        Assertions.assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual.get(0).getAsk()).isEqualTo(expected.get(0).getAsk()),
                () -> assertThat(actual.get(0).getBid()).isEqualTo(expected.get(0).getBid()),
                () -> assertThat(actual.get(0).getCurrency()).isEqualTo(expected.get(0).getCurrency()),
                () -> assertThat(actual.get(0).getCode()).isEqualTo(expected.get(0).getCode()));

    }
    @Test
    void shouldReturnRateListWhenGivenRatesInputDTO() {
        //given
        RatesInputDTO rates = RatesInputDTO
                .builder()
                .ask("3,56")
                .bid("4,56")
                .currency("dolar amerykański")
                .code("USD")
                .build();
        List<RatesInputDTO> expected = new ArrayList<>();
        expected.add(rates);
        //when
        List<Rates> actual =
                mapper.ratesInputDTOListToRatesList(expected);
        //then
        Assertions.assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual.get(0).getAsk()).isEqualTo(expected.get(0).getAsk()),
                () -> assertThat(actual.get(0).getBid()).isEqualTo(expected.get(0).getBid()),
                () -> assertThat(actual.get(0).getCurrency()).isEqualTo(expected.get(0).getCurrency()),
                () -> assertThat(actual.get(0).getCode()).isEqualTo(expected.get(0).getCode()));

    }
    @Test
    void shouldReturnCurrencyRateOutputDtoWhenGivenCurrencyRates() {
        //given
        TableCurrencyRates expected = TableCurrencyRates
                .builder()
                .tradingDate("22-06-2021")
                .build();

        //when
        TableCurrencyRateOutputDTO actual =
                mapper.currencyRatesToCurrencyRatesOutputDTO(expected);
        //then
        Assertions.assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual.getTradingDate()).isEqualTo(expected.getTradingDate()));


    }
}