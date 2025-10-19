package com.app.account.dto.response;

import java.math.BigDecimal;

public record AccountOwnerBalanceDTO(
    String dueno,
    BigDecimal balanceActual
) {
}
