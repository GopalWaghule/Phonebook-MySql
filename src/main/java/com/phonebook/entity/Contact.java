package com.phonebook.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity(name="CONTACT_DETAILS")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="CONTACT_NAME")
	private String name;

	@Column(name="CONTACT_EMAIL")
	private String mail;

	@Column(name="CONTACT_NUMBER")
	private String number;
	
	private Character activeSwitch;
	
	@CreationTimestamp @Column (updatable=false)
	private LocalDate dateCreated;
	
	@UpdateTimestamp @Column (insertable =false)
	private LocalDate lastUpdate;

	public Contact(String name, String mail, String number) {
		super();
		this.name = name;
		this.mail = mail;
		this.number = number;
	}
	
	public Contact() {
		super();
		
	}
	
	
	

	

}

