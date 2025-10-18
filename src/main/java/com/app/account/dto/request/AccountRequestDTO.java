package com.app.account.dto.request;

import java.math.BigDecimal;

public record AccountRequestDTO(
    String numeroCuenta,
    String dueno,
    BigDecimal balanceActual
) {
}
