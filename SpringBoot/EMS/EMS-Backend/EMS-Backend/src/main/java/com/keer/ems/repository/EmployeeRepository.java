/*
What does EmployeeRepository do?
It is a DAO (Data Access Object) that handles all database operations for the Employee entity
— like save, find, delete, update, etc.
 */



package com.keer.ems.repository;

import com.keer.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// interface extends another interface
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}


/*
| Part            | Meaning                                                              |
| --------------- | -------------------------------------------------------------------- |
| `JpaRepository` | Spring Data JPA interface that gives you **ready-made CRUD methods** |
| `Employee`      | The **entity** (table) it works with                                 |
| `Long`          | The **type of primary key** (`id` is of type `Long`)                 |

 */