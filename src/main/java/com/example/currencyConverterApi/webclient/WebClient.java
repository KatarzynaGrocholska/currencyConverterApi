package com.example.currencyConverterApi.webclient;


import com.example.currencyConverterApi.model.input_dto.RateTableInputDTO;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class WebClient {

    private static final String URL_NBP_API = "http://api.nbp.pl/api/exchangerates/tables/C";
    RestTemplate restTemplate = new RestTemplate();

    public RateTableInputDTO callApi() {
       RateTableInputDTO[] tables= restTemplate.getForObject(
                URL_NBP_API, RateTableInputDTO[].class);
        return tables[0];
    }
}
