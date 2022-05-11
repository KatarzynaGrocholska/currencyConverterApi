package com.example.currencyConverterApi.webclient;


import com.example.currencyConverterApi.model.input_dto.OneCurrencyInputDTO;
import com.example.currencyConverterApi.model.input_dto.RateTableInputDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WebClient {

    private static final String URL_NBP_API = "http://api.nbp.pl/api/exchangerates/tables/C";
    private static final String URL_NBP_API_ONE_CURRENCY ="http://api.nbp.pl/api/exchangerates/rates/C/";
    RestTemplate restTemplate = new RestTemplate();

    public RateTableInputDTO callApi() {
        RateTableInputDTO[] tables = restTemplate.getForObject(
                URL_NBP_API, RateTableInputDTO[].class);
        return tables[0];
    }

    public OneCurrencyInputDTO callApiForOneCurrency(String code) {
        OneCurrencyInputDTO oneCurrencyInputDTO= new OneCurrencyInputDTO();
        if(code!=null){
       oneCurrencyInputDTO= restTemplate.getForObject(
                URL_NBP_API_ONE_CURRENCY+code, OneCurrencyInputDTO.class);

        }
        return oneCurrencyInputDTO;
    }

}
