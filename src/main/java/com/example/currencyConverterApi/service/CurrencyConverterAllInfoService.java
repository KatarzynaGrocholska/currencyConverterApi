package com.example.currencyConverterApi.service;

import com.example.currencyConverterApi.model.mapper.CurrencyConverterAllInfoMapper;
import com.example.currencyConverterApi.model.output_dto.CurrencyConverterAllInfoOutputDTO;
import com.example.currencyConverterApi.repository.CurrencyConverterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CurrencyConverterAllInfoService {

    private final CurrencyConverterAllInfoMapper currencyConverterAllInfoMapper;
    private final CurrencyConverterRepository currencyConverterRepository;

    public List<CurrencyConverterAllInfoOutputDTO> showAllColumnsInSavedQueries() {
        return currencyConverterAllInfoMapper
                .currencyConverterTOCurrencyConverterAllInfoOutputDTOList
                        (currencyConverterRepository.findAll());
    }

}
