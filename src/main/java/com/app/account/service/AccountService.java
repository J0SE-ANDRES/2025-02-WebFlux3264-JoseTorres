package com.app.account.service;

import com.app.account.entity.Account;
import com.app.account.repository.AccountRepository;
import com.app.account.dto.request.AccountRequestDTO;
import com.app.account.dto.response.AccountOwnerBalanceDTO;
import com.app.account.dto.response.AccountResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public List<AccountResponseDTO> getAll() {
        return List.of();
    }

    @Override
    public AccountResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public String update(Long id, AccountRequestDTO request) {
        return "";
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public AccountOwnerBalanceDTO findByNumeroCuenta(String numeroCuenta) {
        return null;
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
