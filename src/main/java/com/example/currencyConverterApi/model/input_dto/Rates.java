package com.example.currencyConverterApi.model.input_dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rates {
    private String no;
    private String effectiveDate;
    private String bid;
    private String ask;

}
