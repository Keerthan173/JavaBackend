package com.keer.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

//@Data
//@AllArgsConstructor
//public class AccountDto {
//    private Long id;
//    private String accountHolderName;
//    private double balance;
//}


public record AccountDto(Long id,
                         String accountHolderName,
                         double balance){

}

/*
Used a record, which is:
- A Java 16+ feature
- A concise way to create an immutable DTO
- Automatically creates:
    1. Constructor
    2. Getters
    3. equals(), hashCode(), toString()

 */