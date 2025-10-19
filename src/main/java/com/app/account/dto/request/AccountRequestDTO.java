package com.app.account.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Validated
public record AccountRequestDTO(
    @NotBlank String numeroCuenta,
    @NotBlank String dueno,
    @PositiveOrZero BigDecimal balanceActual
) {
}
