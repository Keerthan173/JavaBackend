package com.keer.hiber.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "certificate")
public class Certificate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long certificateId;
	
	private String title;
	
	private String about;
	
	private String link;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")		// foreign key column
	private Student student;
	
//	| Part                               | Meaning                                                           |
//	| ---------------------------------- | ----------------------------------------------------------------- |
//	| `@ManyToOne`                       | Many certificates belong to one student                           |
//	| `@JoinColumn(name = "student_id")` | Create a foreign key column `student_id` in the certificate table |
//	| `private Student student;`         | Reference to parent `Student`                                     |
//	So now:
//		Every certificate row has a student_id (foreign key)
//		It links to the student table
	
	
	
	
	// Getters and Setters
    public long getCertificateId() { return certificateId; }
    public void setCertificateId(long certificateId) { this.certificateId = certificateId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAbout() { return about; }
    public void setAbout(String about) { this.about = about; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    
}