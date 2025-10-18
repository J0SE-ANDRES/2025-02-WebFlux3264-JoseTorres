package com.app.account.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private String ownerName;
    private BigDecimal balance = BigDecimal.ZERO;
    private Boolean active = true;

    public Account() {
    }

    public Account(String accountNumber, String ownerName, BigDecimal balance, Boolean active) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance == null ? BigDecimal.ZERO : balance;
        this.active = active == null ? true : active;
    }

    public static class AccountBuilder {

        private String accountNumber;
        private String ownerName;
        private BigDecimal balance = BigDecimal.ZERO;
        private Boolean active = true;

        public AccountBuilder setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public AccountBuilder setOwnerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public AccountBuilder setBalance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public AccountBuilder setActive(Boolean active) {
            this.active = active;
            return this;
        }

        public Account build() {
            return new Account(accountNumber, ownerName, balance, active);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
