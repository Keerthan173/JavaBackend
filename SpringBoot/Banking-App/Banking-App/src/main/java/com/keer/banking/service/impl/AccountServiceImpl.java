package com.keer.banking.service.impl;

import com.keer.banking.dto.AccountDto;
import com.keer.banking.entity.Account;
import com.keer.banking.exception.AccountException;
import com.keer.banking.mapper.AccountMapper;
import com.keer.banking.repository.AccountRepository;
import com.keer.banking.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;


    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new AccountException("Account with ID " + id + " not found."));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new AccountException("Account with ID " + id + " not found."));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new AccountException("Account with ID " + id + " not found."));
        if(account.getBalance() < amount){
            throw new AccountException("Insufficient balance in account with ID " + id);
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(account -> AccountMapper.mapToAccountDto(account))
                .toList();
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()-> new AccountException("Account with ID " + id + " not found."));
        accountRepository.deleteById(id);
    }

}
