package com.prx.project.library.dao;

import java.io.File;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.prx.project.library.OjFactory.MemberFactory;
import com.prx.project.library.model.Member;
import com.prx.project.library.model.MemberList;

@Service
public class MemberDAO {

	public MemberList unmarshalling() {

		MemberList members = null;
		try {
			JAXBContext context = JAXBContext.newInstance(MemberFactory.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File("FileXml/members.xml");
			members = (MemberList) unmarshaller.unmarshal(file);
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

		return members;
	}

	private void marshalling(MemberList memberList) {
		try {

			JAXBContext context = JAXBContext.newInstance(MemberFactory.class);
			Marshaller marshaller = context.createMarshaller();

			File file = new File("FileXml/members.xml");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(memberList, file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public List<Member> getAllMember() {
		return this.unmarshalling().getMember();
	}

	public Member getMemeber(String id) {

		MemberList memberList = this.unmarshalling();

		for (Member m : memberList.getMember()) {
			if (id.equals(m.getId())) {
				return m;
			}
		}

		return null;

	}

	public void insertMemeber(Member member) {

		MemberList memberList = this.unmarshalling();

		Member maxIdMember = memberList.getMember().stream().max(Comparator.comparing(String::valueOf)).get();
		int maxId = 0;
		if (maxIdMember != null) {
			maxId = Integer.parseInt(maxIdMember.getId());
		}

		maxId++;

		member.setId(String.valueOf(maxId));

		memberList.getMember().add(member);

		this.marshalling(memberList);
	}

	public void updateMember(Member member) {

		MemberList memberList = this.unmarshalling();

		if (member == null || memberList == null || memberList.getMember().isEmpty()) {
			return;
		}

		for (Member m : memberList.getMember()) {
			if (member.getId().equals(m.getId())) {
				m.setName(member.getName());

				m.setGender(member.getGender());

				m.setPhone(member.getPhone());
				m.setAge(member.getAge());

				m.setEmail(member.getEmail());

				m.setAddress(member.getAddress());

				break;
			}
		}

		this.marshalling(memberList);

	}

	public void deleteMember(String memberId) {

		MemberList memberList = this.unmarshalling();

		if (memberId == null || memberList == null || memberList.getMember().isEmpty()) {
			return;
		}

		for (Member m : memberList.getMember()) {
			if (memberId.equals(m.getId())) {

				memberList.getMember().remove(m);

				break;
			}
		}

		this.marshalling(memberList);

	}
}
