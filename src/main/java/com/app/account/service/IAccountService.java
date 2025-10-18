package com.app.account.service;

import java.util.List;

import com.app.account.dto.request.AccountRequestDTO;
import com.app.account.dto.request.UpdateBalanceRequest;
import com.app.account.dto.response.AccountResponseDTO;
import com.app.account.dto.response.AccountOwnerBalanceDTO;
import com.app.account.entity.Account;

public interface IAccountService {

    // Utils
    Account getAccountById(Long id);

    // CRUD
    AccountResponseDTO create(AccountRequestDTO request);
    List<AccountResponseDTO> getAll();
    AccountResponseDTO getById(Long id);
    String update(Long id, UpdateBalanceRequest request);
    void delete(Long id);

    AccountOwnerBalanceDTO findByNumeroCuenta(String numeroCuenta);

    // Util
    AccountResponseDTO toResponse(Account account);
}
