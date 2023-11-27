package com.phonebook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.phonebook.entity.Contact;
import com.phonebook.repository.ContactDao;

@Service
public class ContactService_Impl implements ContactService {

	@Autowired
	private ContactDao dao;

	@Override
	public boolean saveContact(Contact contact) {

		if (contact.getName().isEmpty() && contact.getNumber().isEmpty()) {

			return false;
		} else {
			contact.setActiveSwitch('Y');
			dao.save(contact);
			return true;
		}
	}

	@Override
	public List<Contact> getAllContact() {

		List<Contact> findAll = dao.findAll();
		List<Contact> list = new ArrayList<>();

		for (Contact contact : findAll) {

			if (contact.getActiveSwitch() == 'Y') {
				list.add(contact);
			}
		}
		return list;
	}

	@Override
	public Contact getContactById(Integer id) {
		java.util.Optional<Contact> findById = dao.findById(id);

		if (findById.isPresent()) {

			Contact contact = findById.get();
			return contact;
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer id) {
		Optional<Contact> findById = dao.findById(id);
		if (findById.isPresent()) {
			Contact contact = findById.get();
			contact.setActiveSwitch('N');
			dao.save(contact);
			return true;
		}
		return false;
	}

}
