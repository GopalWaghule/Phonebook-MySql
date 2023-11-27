package com.phonebook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phonebook.entity.Contact;

@Service
public interface ContactService {
	
public List<Contact> getAllContact();
	
	public Contact getContactById(Integer id);
	
	public boolean deleteContactById(Integer id);

	boolean saveContact(Contact contact);
	

}
