package com.keer.Demo2.controller;

import com.keer.Demo2.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(
                1,
                "Ramesh",
                "Java Brains"
        );
        return student;     // Returns as JSON
    }


    // http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "MSD", "Thala"));
        students.add(new Student(2, "Virat", "King"));
        students.add(new Student(3, "Rohit", "Hitman"));
        return students;    // Returns a list as JSON
    }


    // Path variable
    // http://localhost:8080/student/by-id/333
    // {id} - URI template variable
    @GetMapping("student/by-id/{id}")
    public Student getStudentWithId(@PathVariable int id){
        // PathVariable annotation is used on the method argument to bind it to the value of the URI template variable.
        return new Student(id, "Keerthan", "K");
    }


    // If the path variable name in the URL does not match the method parameter name - explicitly map.
    // http://localhost:8080/student/by-roll/333
    @GetMapping("student/by-roll/{roll}")
    public Student getStudentWithRoll(@PathVariable("roll") int id){
        return new Student(id, "Keerthan", "K");
    }

    // We can pass multiple path variables
    // http://localhost:8080/student/777/Keerthan/K
    @GetMapping("student/{id}/{firstName}/{lastName}")
    public Student getStudent(@PathVariable int id,
                              @PathVariable String firstName,
                              @PathVariable String lastName){
        return new Student(id, firstName, lastName);
    }



    // Request Param
    // http://localhost:8080/student/query?id=99
    @GetMapping("student/query")
    public Student studentRequestVariable(@RequestParam int id){
        return new Student(id, "Keerthan", "K");
    }

    // Multiple query parameter
    // http://localhost:8080/student/query?id=99&firstName=Keerthan&lastName=K
    @GetMapping("student/multipleQuery")
    public Student studentMultipleQuery(@RequestParam int id,
                                        @RequestParam String firstName,
                                        @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }



    /*
    Use @PathVariable when the value is required to find a specific resource.

    Use @RequestParam for optional, extra, or filter-like values.
     */

}
