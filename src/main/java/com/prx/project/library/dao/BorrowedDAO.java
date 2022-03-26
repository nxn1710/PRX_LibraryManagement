package com.prx.project.library.dao;

import java.io.File;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.prx.project.library.model.Borrowed;
import com.prx.project.library.model.BorrowedList;

@Service
public class BorrowedDAO {

	private BorrowedList unmarshalling() {

		BorrowedList borrowedList = null;
		try {
			JAXBContext context = JAXBContext.newInstance(BorrowedList.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File("FileXml\\borrowed.xml");
			borrowedList = (BorrowedList) unmarshaller.unmarshal(file);
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

		return borrowedList;
	}

	private void marshalling(BorrowedList borrowedList) {
		try {

			JAXBContext context = JAXBContext.newInstance(BorrowedList.class);
			Marshaller marshaller = context.createMarshaller();

			File file = new File("FileXml\\borrowed.xml");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(borrowedList, file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void insert(Borrowed borrow) {

		BorrowedList borrowedList = this.unmarshalling();

		borrowedList.getBorrowedList().add(borrow);

		this.marshalling(borrowedList);
	}

	public void delete(String borrowedId) {

		BorrowedList borrowedList = this.unmarshalling();

		if (borrowedId == null || borrowedList == null || borrowedList.getBorrowedList().isEmpty()) {
			return;
		}

		for (Borrowed b : borrowedList.getBorrowedList()) {
			if (borrowedId.equals(b.getId())) {

				borrowedList.getBorrowedList().remove(b);

				break;
			}
		}

		this.marshalling(borrowedList);

	}

	public Borrowed get(String borrowedId) {

		BorrowedList borrowedList = this.unmarshalling();

		if (borrowedId == null || borrowedList == null || borrowedList.getBorrowedList().isEmpty()) {
			return null;
		}

		for (Borrowed b : borrowedList.getBorrowedList()) {
			if (borrowedId.equals(b.getId())) {

				return b;
			}
		}
		return null;

	}

	public List<Borrowed> getAllBorrowed() {
		return this.unmarshalling().getBorrowedList();
	}

	public BigDecimal getTotalMoney() {
		List<Borrowed> list = this.getAllBorrowed();

		BigDecimal totalMoney = BigDecimal.ZERO;

		for (Borrowed bro : list) {
			Date rentDate = new Date();
			try {
				rentDate = new SimpleDateFormat("yyyy-MM-dd").parse(bro.getBorrowedTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Date currentDate = new Date();

			if (rentDate.getYear() == currentDate.getYear() && currentDate.getMonth() - rentDate.getMonth() == 0) {
				totalMoney = totalMoney.add(new BigDecimal(bro.getTotalPrice()));
			}

		}

		return totalMoney;

	}
}
