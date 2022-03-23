package com.prx.project.library.OjFactory;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.prx.project.library.model.Member;
import com.prx.project.library.model.MemberList;

@XmlRegistry
public class MemberFactory {
	private final static QName name_QNAME = new QName("", "name");
	private final static QName gender_QNAME = new QName("", "gender");
	private final static QName phone_QNAME = new QName("", "phone");
	private final static QName email_QNAME = new QName("", "email");
	private final static QName address_QNAME = new QName("", "address");

	public MemberFactory() {
	}

	public MemberList createMemeberList() {
		return new MemberList();
	}

	public Member createMemeber() {
		return new Member();
	}

	@XmlElementDecl(namespace = "", name = "name")
	public JAXBElement<String> createName(String value) {
		return new JAXBElement<String>(name_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "gender")
	public JAXBElement<String> createGender(String value) {
		return new JAXBElement<String>(gender_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "phone")
	public JAXBElement<String> createPhone(String value) {
		return new JAXBElement<String>(phone_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "email")
	public JAXBElement<String> createEmail(String value) {
		return new JAXBElement<String>(email_QNAME, String.class, null, value);
	}

	@XmlElementDecl(namespace = "", name = "address")
	public JAXBElement<String> createAddress(String value) {
		return new JAXBElement<String>(address_QNAME, String.class, null, value);
	}
}
