package com.keer.hiber.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity				// Marks this class as a JPA entity
@Table(name="student")
public class Student {
	// fields
	
	@Id				// Marks this field as the primary key.
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// Uses auto-increment (MySQL-style) to generate the ID.
	private long studentId;
	
	@Column(name = "student_name", length = 100)
	// Maps to a column student_name with a max length of 100 characters.
	private String name;
	
	@Column(name = "student_college", length = 200, nullable = true)
	private String college;
	
	private String phone;
	//Auto-mapped to a column named phone (default behavior).
	//No custom column settings are applied here.
	
	private String fatherName;
	
	private boolean isActive = true;
	
	@Lob				// large object
	private String about;

	
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
	
}
