package com.app.account.dto;

import java.math.BigDecimal;

public class AccountOwnerBalanceDTO {

    private String dueno;
    private BigDecimal balanceActual;

    public AccountOwnerBalanceDTO() {}

    public AccountOwnerBalanceDTO(String dueno, BigDecimal balanceActual) {
        this.dueno = dueno;
        this.balanceActual = balanceActual;
    }
}
