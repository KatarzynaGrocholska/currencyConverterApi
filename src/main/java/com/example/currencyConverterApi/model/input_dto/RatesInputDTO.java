package com.example.currencyConverterApi.model.input_dto;

import lombok.*;
import org.springframework.lang.NonNull;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RatesInputDTO {

    @NonNull
    private String currency;
    @NonNull
    private String code;
    @NonNull
    private String bid;
    @NonNull
    private String ask;
}
