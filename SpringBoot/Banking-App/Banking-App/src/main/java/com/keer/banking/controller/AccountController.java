package com.keer.banking.controller;

import com.keer.banking.dto.AccountDto;
import com.keer.banking.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;


    // Add account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        AccountDto savedAccount = accountService.createAccount(accountDto);
        return new ResponseEntity<>(savedAccount, HttpStatus.CREATED);
    }


    // Get account by ID
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }


    // Deposit REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDto);
    }


    // Withdraw REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }


    // Get all accounts REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accountDtos = accountService.getAllAccounts();
        return ResponseEntity.ok(accountDtos);
    }


    // Delete account by ID
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully!");
    }
}