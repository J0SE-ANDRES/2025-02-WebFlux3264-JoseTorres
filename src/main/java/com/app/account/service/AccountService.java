package com.app.account.service;

import com.app.account.dto.request.UpdateBalanceRequest;
import com.app.account.entity.Account;
import com.app.account.repository.AccountRepository;
import com.app.account.dto.request.AccountRequestDTO;
import com.app.account.dto.response.AccountOwnerBalanceDTO;
import com.app.account.dto.response.AccountResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("La cuenta con id: " + id + " no existe."));
    }

    @Override
    public AccountResponseDTO create(AccountRequestDTO request) {
        String numeroCuenta = request.numeroCuenta();
        String dueno = request.dueno();
        BigDecimal balanceActual = request.balanceActual();

        Account account = Account.builder()
                .setAccountNumber(numeroCuenta)
                .setOwnerName(dueno)
                .setBalance(balanceActual)
                .build();

        accountRepository.save(account);
        return this.toResponse(account);
    }

    @Override
    public List<AccountResponseDTO> getAll() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public AccountResponseDTO getById(Long id) {
        Account account = this.getAccountById(id);
        return this.toResponse(account);
    }

    @Override
    public String update(Long id, UpdateBalanceRequest request) {
        BigDecimal balanceNuevo = request.balance();
        BigDecimal balanceAnterior;

        Account account = this.getAccountById(id);
        balanceAnterior = account.getBalance();

        account.setBalance(balanceNuevo);
        return "La cuenta " + account.getAccountNumber()
                + " fue actualizada: balanceAnterior=" + balanceAnterior
                + ", balanceActual=" + balanceNuevo;
    }

    @Override
    public void delete(Long id) {
        Account account = this.getAccountById(id);
        accountRepository.delete(account);
    }

    @Override
    public AccountOwnerBalanceDTO findByNumeroCuenta(String numeroCuenta) {
        Account account = accountRepository.findByAccountNumber(numeroCuenta);
        return new AccountOwnerBalanceDTO(
                account.getOwnerName(),
                account.getBalance()
        );
    }

    @Override
    public AccountResponseDTO toResponse(Account account) {
        return new AccountResponseDTO(
                account.getId(),
                account.getAccountNumber(),
                account.getOwnerName(),
                account.getBalance(),
                account.getActive()
        );
    }
}
