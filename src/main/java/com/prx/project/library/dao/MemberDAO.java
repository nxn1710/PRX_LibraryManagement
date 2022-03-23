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
			File file = new File("D:\\Study\\CN8\\PRX\\PRX_LibraryManagement\\FileXml\\member.xml");
			members = (MemberList) unmarshaller.unmarshal(file);
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

		return members;
	}
}
