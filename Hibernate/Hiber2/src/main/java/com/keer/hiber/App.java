package com.keer.hiber;

import com.keer.hiber.entities.Certificate;
import com.keer.hiber.entities.Student;
import com.keer.hiber.services.StudentServices;

public class App {
    public static void main(String[] args) {

        StudentServices service = new StudentServices();

        // ✅ 1. Create new student with certificates
        Student std = new Student();
        std.setName("Keerthan");
        std.setCollege("SCEM");
        std.setPhone("7779999999");
        std.setFatherName("Mr. K");
        std.setActive(true);
        std.setAbout("This is Keerthan's profile");

        Certificate c1 = new Certificate();
        c1.setTitle("Java Certificate");
        c1.setAbout("Basics of Java");
        c1.setLink("https://example.com/java");

        Certificate c2 = new Certificate();
        c2.setTitle("SQL Certificate");
        c2.setAbout("Fundamentals of SQL");
        c2.setLink("https://example.com/sql");

        // Link certificates to student
        std.addCertificate(c1);
        std.addCertificate(c2);

        // Save to DB
        service.saveStudent(std);

        // ✅ 2. Fetch and display student by ID
        Student fetched = service.getStudentById(5L); // use correct ID(long)
        if (fetched != null) {
            System.out.println("\n✅ Student Details:");
            System.out.println("Name      : " + fetched.getName());
            System.out.println("College   : " + fetched.getCollege());
            System.out.println("Phone     : " + fetched.getPhone());
            System.out.println("Father    : " + fetched.getFatherName());
            System.out.println("About     : " + fetched.getAbout());
            System.out.println("Certificates:");
            for (Certificate cert : fetched.getCertificates()) {
                System.out.println(" - " + cert.getTitle() + " (" + cert.getLink() + ")");
            }
        } else {
            System.out.println("Student not found.");
        }

        // ✅ 3. Update student
        Student updated = new Student();
        updated.setName("Updated Keerthan");
        updated.setCollege("Updated SCEM");
        updated.setPhone("7778888888");
        updated.setFatherName("Updated Father");
        updated.setActive(false);
        updated.setAbout("Updated about info");
        service.updateStudent(5L, updated); // update ID = 4

        // ✅ 4. Delete student
        // service.deleteStudent(1L);
    }
}
