package com.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phonebook.entity.Contact;
import com.phonebook.service.ContactService;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	public ContactService contactService;

	@GetMapping("/getContact")
	public String addContact(Model model) {

		Contact contactobj = new Contact();

		model.addAttribute("contact", contactobj);

		return "saveContact";
	}

	@PostMapping("/saveContact")
	public String saveContact(Contact contact, Model model) {

		boolean saveContact = contactService.saveContact(contact);
		if (saveContact) {

			model.addAttribute("success", "Contact Saved Successfully...");
		} else {
			model.addAttribute("error", "Failed to save contact...");
		}

		model.addAttribute("contact", new Contact());

		return "saveContact";
	}

	@GetMapping("/viweContacts")
	public String viweAllContact(Model model) {

		List<Contact> collect = contactService.getAllContact();
		model.addAttribute("contacts", collect);
		return "contacts";
	}

	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer id, Model model) {

		Contact contact = contactService.getContactById(id);

		model.addAttribute("contact", contact);

		return "saveContact";
	}

	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer id, Model model) {

		contactService.deleteContactById(id);

		return "redirect:viweContacts";
	}

}
