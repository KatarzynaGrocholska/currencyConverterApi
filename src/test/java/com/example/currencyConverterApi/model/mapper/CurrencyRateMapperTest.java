package com.example.currencyConverterApi.model.mapper;

import com.example.currencyConverterApi.model.entity.CurrencyConverter;
import com.example.currencyConverterApi.model.input_dto.RatesInputDTO;
import com.example.currencyConverterApi.model.output_dto.CurrencyConverterOutputDTO;
import com.example.currencyConverterApi.model.output_dto.CurrencyRateOutputDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyRateMapperTest {

    CurrencyRateMapper mapper = CurrencyRateMapper.INSTANCE;

    @Test
    void shouldReturnCurrencyRateOutputDTOListWhenGivenRatesInputDTOList() {
        //given
        RatesInputDTO ratesInputDTO = RatesInputDTO
                .builder()
                .ask("3,56")
                .bid("4,56")
                .currency("dolar amerykański")
                .code("USD")
                .build();
        List<RatesInputDTO> expected = new ArrayList<>();
        expected.add(ratesInputDTO);
        //when
        List<CurrencyRateOutputDTO> actual =
                mapper.ratesInputDTOListTOCurrencyOutputDTO(expected);
        //then
        Assertions.assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual.get(0).getAsk()).isEqualTo(expected.get(0).getAsk()),
                () -> assertThat(actual.get(0).getBid()).isEqualTo(expected.get(0).getBid()),
                () -> assertThat(actual.get(0).getCurrency()).isEqualTo(expected.get(0).getCurrency()),
                () -> assertThat(actual.get(0).getCode()).isEqualTo(expected.get(0).getCode()));

    }

}