package com.app.account.dto.request;

import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Validated
public record UpdateBalanceRequest(
        @PositiveOrZero BigDecimal balance
) {
}
