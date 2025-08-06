/*
DTO = Data Transfer Object
A DTO is used to transfer data between layers
(like from Controller → Service → Client),
without exposing the full entity.
 */


package com.keer.ems.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
