package com.keer.hiber.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;
	
	@Column(name = "student_name", length = 100)
	private String name;
	
	@Column(name = "student_college", length = 200, nullable = true)
	private String college;
	
	private String phone;
	
	private String fatherName;
	
	private boolean isActive = true;
	
	@Lob				// large object
	private String about;
	
	
	
	
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Certificate> certificates = new ArrayList<>();
//	| Part                        | Meaning                                                    |
//	| --------------------------- | ---------------------------------------------------------- |
//	| `@OneToMany`                | One student has many certificates                          |
//	| `mappedBy = "student"`      | Look at the `student` field inside `Certificate.java`      |
//	| `cascade = CascadeType.ALL` | When you save/delete student, do the same for certificates |
//	| `orphanRemoval = true`      | If a certificate is removed from list, delete it from DB   |
//	| `List<Certificate>`         | Store all related certificates                             |
	
//	This tells Hibernate:
//		“Student owns multiple Certificates.”

//	The List<Certificate> exists only in Java, not as a column — it's mapped through that foreign key(student_id).





	
	
	
	
	// Getters and Setters
	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
	public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
	
 // 🔁 Helper method for bidirectional mapping
    public void addCertificate(Certificate cert) {
        cert.setStudent(this);               // link child to parent
        this.certificates.add(cert);         // add child to list
    }
}
