package com.app.account.dto.response;

import java.math.BigDecimal;

public record AccountResponseDTO(
        Long id,
        String numeroCuenta,
        String dueno,
        BigDecimal balanceActual,
        boolean active
) {
}
