package com.prx.project.library.dao;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.prx.project.library.OjFactory.MemberFactory;
import com.prx.project.library.model.MemberList;

public class MemberDAO {

	public MemberList unmarshalling() {

		MemberList members = null;
		try {
			JAXBContext context = JAXBContext.newInstance(MemberFactory.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File("/Users/sonit/Documents/workspace-spring-tool-suite-4-4.14.0.RELEASE/PRX_LibraryManagement/FileXml/member.xml");
			members = (MemberList) unmarshaller.unmarshal(file);
			System.out.println("Members: " + members);
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

		return members;
	}
}
