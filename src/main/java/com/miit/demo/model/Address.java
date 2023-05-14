package com.miit.demo.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class Address {
    @Valid
    @NotEmpty(message = "Street name is required")
    private String street;

    @Valid
    @NotEmpty(message = "City name is required")
    private String city;

    @Valid
    @NotEmpty(message = "Province state name is required")
    private String provinceState;

    @Valid
    @NotEmpty(message = "Postal code is required")
    @Pattern(regexp = "^[A-Za-z]\\d[A-Za-z][ -]?\\d[A-Za-z]\\d$", message = "Postal code must be in the format A1A 1A1")
    private String postalCode;

    @Valid
    @NotEmpty(message = "Country Address is required")
    private String country;
}
