package com.example.currencyConverterApi.model.input_dto;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.Column;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RatesInputDTO {

    @NonNull
    private String currency;
    @NonNull
    @Column(length = 3)
    private String code;
    @NonNull
    private String bid;
    @NonNull
    private String ask;
}
