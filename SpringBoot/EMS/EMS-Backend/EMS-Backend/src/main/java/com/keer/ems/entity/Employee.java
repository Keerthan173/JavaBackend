/*
JPA Entity:
A JPA entity is just a Java class that represents a table in your database.

JPA = Java Persistence API
"Entity" = Something that gets saved in the database

The employees table is the actual table in the database where employee data will be stored.
 */



package com.keer.ems.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter                 // Lombok auto-generates getter/setter methods.
@NoArgsConstructor      // Creates a no-argument constructor.
@AllArgsConstructor     // Creates a constructor with all fields.

@Entity                     // Tells Spring this class maps to a table in the database
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email;
}