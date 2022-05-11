package com.example.currencyConverterApi.model.entity;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.transaction.Transactional;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="rates")
public class Rates {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
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
