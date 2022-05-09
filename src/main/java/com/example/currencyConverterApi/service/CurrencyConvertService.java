package com.example.currencyConverterApi.service;

import com.example.currencyConverterApi.model.entity.CurrencyConverter;
import com.example.currencyConverterApi.model.input_dto.RatesInputDTO;
import com.example.currencyConverterApi.model.mapper.CurrencyConverterMapper;
import com.example.currencyConverterApi.model.output_dto.CurrencyConverterOutputDTO;
import com.example.currencyConverterApi.repository.CurrencyConverterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyConvertService {

    private final CurrencyRateService currencyRateService;
    private final CurrencyConverterRepository currencyConverterRepository;
    private final CurrencyConverterMapper currencyConverterMapper;

    public CurrencyConverter countValueOfGivenAmountInFromCurrencyToCurrency(String fromCurrency, String toCurrency, double amount) {

        List<RatesInputDTO> currenciesFromTableList = currencyRateService.getTableOfCurrencyRates().getRates();
        double valueOfAmountInToCurrency=0;
        double askPrice =0;
        double bidPrice=0;
        double  askSecondCurrencyPrice =0;

        for (int i = 0; i < currenciesFromTableList.size(); i++) {
            for (int j = 0; j < currenciesFromTableList.size(); j++) {
                 askPrice =Double.parseDouble(currenciesFromTableList.get(i).getAsk());
                 bidPrice =Double.parseDouble(currenciesFromTableList.get(i).getBid());
                askSecondCurrencyPrice= Double.parseDouble(currenciesFromTableList.get(j).getAsk());
                if(fromCurrency.equals("PLN")&&currenciesFromTableList.get(i).getCode().equals(toCurrency)){
                    valueOfAmountInToCurrency =  amount/askPrice;
                }
                if(toCurrency.equals("PLN")&&currenciesFromTableList.get(i).getCode().equals(fromCurrency)){
                    valueOfAmountInToCurrency =  bidPrice * amount;
                }
                if (currenciesFromTableList.get(i).getCode().equals(fromCurrency) &&
                        currenciesFromTableList.get(j).getCode().equals(toCurrency)) {

                    double valueOfAmountInPLN = bidPrice * amount;
                    valueOfAmountInToCurrency = valueOfAmountInPLN /askSecondCurrencyPrice ;
                }
            }
        }
        return CurrencyConverter.builder()
                .amount(amount)
                .fromCurrencyCode(fromCurrency)
                .toCurrencyCode(toCurrency)
                .askPrice(askPrice)
                .bidPrice(bidPrice)
                .askPriceOfSecondCurrency(askSecondCurrencyPrice)
                .tradingDate(currencyRateService.getTableOfCurrencyRates().getEffectiveDate())
                .valueInToCurrency(valueOfAmountInToCurrency)
                .build();


    }

    public CurrencyConverterOutputDTO saveCurrencyConverterQuery(CurrencyConverter currencyConverter){
       CurrencyConverter currencyConverterQuery= currencyConverterRepository.save(currencyConverter);
        return currencyConverterMapper.currencyConverterToCurrencyConverterOutputDTO(currencyConverterQuery);
    }

    public List<CurrencyConverterOutputDTO> showAllSavedQueries(){
        return currencyConverterMapper.currencyConverterTOCurrencyConverterOutputDTOList(currencyConverterRepository.findAll());
    }
}