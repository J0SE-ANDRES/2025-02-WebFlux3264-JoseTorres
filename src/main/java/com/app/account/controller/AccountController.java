package com.app.account.controller;

import java.util.List;

import com.app.account.dto.request.UpdateBalanceRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.account.dto.request.AccountRequestDTO;
import com.app.account.dto.response.AccountResponseDTO;
import com.app.account.dto.response.AccountOwnerBalanceDTO;
import com.app.account.service.IAccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final IAccountService service;

    public AccountController(IAccountService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AccountResponseDTO> create(@Valid @RequestBody AccountRequestDTO request) {
        AccountResponseDTO account = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @GetMapping
    public ResponseEntity<List<AccountResponseDTO>> getAll() {
        List<AccountResponseDTO> accountList = service.getAll();
        return ResponseEntity.ok(accountList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            AccountResponseDTO account = service.getById(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(account);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody UpdateBalanceRequest request) {
        try {
            String mensaje = service.update(id, request);
            return ResponseEntity.ok(mensaje);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/buscar/{numeroCuenta}")
    public ResponseEntity<?> getByNumeroCuenta(@PathVariable String numeroCuenta) {
        try {
            AccountOwnerBalanceDTO accountOwnerBalance = service.findByNumeroCuenta(numeroCuenta);
            return ResponseEntity.ok(accountOwnerBalance);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
