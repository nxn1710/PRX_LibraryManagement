package com.prx.project.library.OjFactory;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.prx.project.library.model.Staff;
import com.prx.project.library.model.StaffList;

@XmlRegistry
public class StaffFactory {
	private final static QName email_QNAME = new QName("", "email");
	private final static QName password_QNAME = new QName("", "password");
	private final static QName fullName_QNAME = new QName("", "fullName");
	private final static QName gender_QNAME = new QName("", "gender");
	private final static QName age_QNAME = new QName("", "age");
	private final static QName phone_QNAME = new QName("", "phone");
	private final static QName address_QNAME = new QName("", "address");

	public StaffFactory() {
	}

	public StaffList createStaffList() {
		return new StaffList();
	}

	public Staff createStaff() {
		return new Staff();
	}

	@XmlElementDecl(namespace = "", name = "email")
	public JAXBElement<String> createEmail(String value) {
		return new JAXBElement<String>(email_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "password")
	public JAXBElement<String> createPassword(String value) {
		return new JAXBElement<String>(password_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "fullName")
	public JAXBElement<String> createFullName(String value) {
		return new JAXBElement<String>(fullName_QNAME, String.class, null, value);
	}
	
	@XmlElementDecl(namespace = "", name = "gender")
	public JAXBElement<String> createGender(String value) {
		return new JAXBElement<String>(gender_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "age")
	public JAXBElement<String> createAge(String value) {
		return new JAXBElement<String>(age_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "phone")
	public JAXBElement<String> createPhone(String value) {
		return new JAXBElement<String>(phone_QNAME, String.class, null, value);
	}
	
	@XmlElementDecl(namespace = "", name = "address")
	public JAXBElement<String> createAddress(String value) {
		return new JAXBElement<String>(address_QNAME, String.class, null, value);
	}

}
