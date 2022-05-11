package com.example.currencyConverterApi.service;

import com.example.currencyConverterApi.model.entity.CurrencyConverter;
import com.example.currencyConverterApi.model.input_dto.OneCurrencyInputDTO;
import com.example.currencyConverterApi.model.input_dto.RatesInputDTO;
import com.example.currencyConverterApi.model.mapper.CurrencyConverterMapper;
import com.example.currencyConverterApi.model.output_dto.CurrencyConverterOutputDTO;
import com.example.currencyConverterApi.repository.CurrencyConverterRepository;
import com.example.currencyConverterApi.webclient.WebClient;
import lombok.RequiredArgsConstructor;
import org.decimal4j.util.DoubleRounder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyConvertService {

    private final WebClient webClient;
    private final CurrencyRateService currencyRateService;
    private final CurrencyConverterRepository currencyConverterRepository;
    private final CurrencyConverterMapper currencyConverterMapper;
    private final CurrencyConverterParametersValidation currencyConverterParametersValidation;

    public OneCurrencyInputDTO getOneCurrencyInfo(String code) {
        return webClient.callApiForOneCurrency(code);
    }

    public double getAskPriceForFromCurrency(String fromCurrency) {
        return Double.parseDouble(getOneCurrencyInfo(fromCurrency).getRates()[0].getAsk());
    }

    public double getBidPriceForFromCurrency(String fromCurrency) {
        return Double.parseDouble(getOneCurrencyInfo(fromCurrency).getRates()[0].getBid());
    }

    public double getAskPriceForToCurrency(String toCurrency) {
        return Double.parseDouble(getOneCurrencyInfo(toCurrency).getRates()[0].getAsk());
    }

    public double getBidPriceForToCurrency(String toCurrency) {
        return Double.parseDouble(getOneCurrencyInfo(toCurrency).getRates()[0].getBid());
    }

    public double calculateValueIfFromCurrencyIsPLN(double amount, double askPrice) {
        return amount / askPrice;
    }

    public double calculateValueIfToCurrencyIsPLN(double amount, double bidPrice) {
        return amount * bidPrice;
    }

    public double countValueInToCurrency(double bidPrice, double askSecondCurrencyPrice, double amount) {
        return bidPrice * amount / askSecondCurrencyPrice;
    }

    public CurrencyConverter countValueOfGivenAmountInFromCurrencyToCurrency(String fromCurrency,
                                                                             String toCurrency,
                                                                             double amount) {

        currencyConverterParametersValidation.checkIfCurrenciesCodesAreTheSame(toCurrency, fromCurrency);
        currencyConverterParametersValidation.checkIfAmountIsPositive(amount);
        currencyConverterParametersValidation.checkIfCurrencyCodeParameterIsEmpty(fromCurrency, toCurrency);

        List<RatesInputDTO> currenciesFromTableList = currencyRateService.getTableOfCurrencyRates().getRates();

        currencyConverterParametersValidation.checkIfCurrencyCodeExist(fromCurrency, currenciesFromTableList);
        currencyConverterParametersValidation.checkIfCurrencyCodeExist(toCurrency, currenciesFromTableList);

        double valueOfAmountInToCurrency = 0;

        double askPrice = 0;
        double bidPrice = 0;
        double bidSecondCurrencyPrice = 0;

        if (fromCurrency.equalsIgnoreCase("PLN")) {
            askPrice = getAskPriceForToCurrency(toCurrency);
            if (askPrice != 0) {
                valueOfAmountInToCurrency = calculateValueIfFromCurrencyIsPLN(amount, askPrice);
            }
        }
        if (toCurrency.equalsIgnoreCase("PLN")) {
            bidPrice = getBidPriceForFromCurrency(fromCurrency);
            valueOfAmountInToCurrency = calculateValueIfToCurrencyIsPLN(amount, bidPrice);
        } else if (!toCurrency.equalsIgnoreCase("PLN") && !fromCurrency.equalsIgnoreCase("PLN")) {
            askPrice = getAskPriceForFromCurrency(fromCurrency);
            bidSecondCurrencyPrice = getBidPriceForToCurrency(toCurrency);
            valueOfAmountInToCurrency = countValueInToCurrency(askPrice, bidSecondCurrencyPrice, amount);
        }

        return CurrencyConverter.builder()
                .amount(amount)
                .fromCurrencyCode(fromCurrency)
                .toCurrencyCode(toCurrency)
                .askPrice(askPrice)
                .bidPrice(bidPrice)
                .bidPriceOfSecondCurrency(bidSecondCurrencyPrice)
                .tradingDate(currencyRateService.getTableOfCurrencyRates().getEffectiveDate())
                .valueInToCurrency(DoubleRounder.round(valueOfAmountInToCurrency, 2))
                .build();
    }


    public CurrencyConverterOutputDTO saveCurrencyConverterQuery(CurrencyConverter currencyConverter) {
        CurrencyConverter currencyConverterQuery = currencyConverterRepository.save(currencyConverter);
        return currencyConverterMapper.currencyConverterToCurrencyConverterOutputDTO(currencyConverterQuery);
    }

    public List<CurrencyConverterOutputDTO> showAllSavedQueries() {
        return currencyConverterMapper.currencyConverterTOCurrencyConverterOutputDTOList(currencyConverterRepository.findAll());
    }
}