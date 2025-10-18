package com.app.account.service;

import java.util.List;

import com.app.account.dto.request.AccountRequestDTO;
import com.app.account.dto.response.AccountResponseDTO;
import com.app.account.dto.response.AccountOwnerBalanceDTO;
import com.app.account.entity.Account;

public interface IAccountService {
    AccountResponseDTO create(AccountRequestDTO request);
    List<AccountResponseDTO> getAll();
    AccountResponseDTO getById(Long id);
    String update(Long id, AccountRequestDTO request);
    void delete(Long id);

    AccountOwnerBalanceDTO findByNumeroCuenta(String numeroCuenta);
    AccountResponseDTO toResponse(Account account);
}
