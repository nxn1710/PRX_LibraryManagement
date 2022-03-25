package com.prx.project.library.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.prx.project.library.OjFactory.StaffFactory;
import com.prx.project.library.model.Staff;
import com.prx.project.library.model.StaffList;

@Service
public class StaffDAO {

	public StaffList unmarshalling() {

		StaffList staffs = null;
		try {
			JAXBContext context = JAXBContext.newInstance(StaffFactory.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File("FileXml/staffs.xml");
			staffs = (StaffList) unmarshaller.unmarshal(file);
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

		return staffs;
	}

	private void marshalling(StaffList staffList) {
		try {

			JAXBContext context = JAXBContext.newInstance(StaffFactory.class);
			Marshaller marshaller = context.createMarshaller();

			File file = new File("FileXml/staffs.xml");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(staffList, file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public List<Staff> getAllStaff() {
		return this.unmarshalling().getStaffs();
	}

	public Staff getStaff(String id) {

		StaffList staffList = this.unmarshalling();

		for (Staff staff : staffList.getStaffs()) {
			if (id.equals(staff.getId())) {
				return staff;
			}
		}

		return null;

	}
	
	public Staff getStaffByUser(String user) {

		StaffList staffList = this.unmarshalling();

		for (Staff staff : staffList.getStaffs()) {
			if (user.equals(staff.getEmail())) {
				return staff;
			}
		}

		return null;

	}

	public void insertStaff(Staff staff) {

		StaffList staffList = this.unmarshalling();
		Staff maxIdStaff = null;
		if (staffList.getStaffs() != null) {
			maxIdStaff = staffList.getStaffs().stream().max(Comparator.comparing(String::valueOf)).get();
		}else {
			staffList.setStaffs(new ArrayList<>());
		}
		int maxId = 0;
		if (maxIdStaff != null) {
			maxId = Integer.parseInt(maxIdStaff.getId());
		}

		maxId++;

		staff.setId(String.valueOf(maxId));

		staffList.getStaffs().add(staff);

		this.marshalling(staffList);
	}

	public void updateStaff(Staff staff) {

		StaffList staffList = this.unmarshalling();

		if (staff == null || staffList == null || staffList.getStaffs().isEmpty()) {
			return;
		}

		for (Staff s : staffList.getStaffs()) {
			if (staff.getId().equals(s.getId())) {
				s.setEmail(staff.getEmail());
				s.setPassword(staff.getPassword());
				s.setFullName(staff.getFullName());
				s.setGender(staff.getGender());
				s.setAge(staff.getAge());
				s.setPhone(staff.getPhone());
				s.setAddress(staff.getAddress());
				break;
			}
		}

		this.marshalling(staffList);

	}

	public void deleteStaff(String staffId) {

		StaffList staffList = this.unmarshalling();

		if (staffId == null || staffList == null || staffList.getStaffs().isEmpty()) {
			return;
		}

		for (Staff s : staffList.getStaffs()) {
			if (staffId.equals(s.getId())) {

				staffList.getStaffs().remove(s);

				break;
			}
		}

		this.marshalling(staffList);

	}
}
