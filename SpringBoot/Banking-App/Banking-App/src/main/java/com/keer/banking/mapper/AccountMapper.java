package com.keer.banking.mapper;

import com.keer.banking.dto.AccountDto;
import com.keer.banking.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
//              // For normal DTO class
//              accountDto.getId(),
//              accountDto.getAccountHolderName(),
//              accountDto.getBalance()

                // For Record DTO
                // record fields become methods automatically, so no get...() needed!
                accountDto.id(),
                accountDto.accountHolderName(),
                accountDto.balance()
        );
        return account;
    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }
}
