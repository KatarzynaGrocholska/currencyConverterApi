package com.example.currencyConverterApi.model.output_dto;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.Column;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RatesOutputDTO {
    private String currency;
    private String code;
    private String bid;
    private String ask;
}
