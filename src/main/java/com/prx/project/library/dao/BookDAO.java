package com.prx.project.library.dao;

import java.io.File;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.prx.project.library.OjFactory.BookFactory;
import com.prx.project.library.model.Book;
import com.prx.project.library.model.BookList;

@Service
public class BookDAO {

	private BookList unmarshalling() {

		BookList books = null;
		try {
			JAXBContext context = JAXBContext.newInstance(BookFactory.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			File file = new File("FileXml/books.xml");
			books = (BookList) unmarshaller.unmarshal(file);
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

		return books;
	}

	private void marshalling(BookList bookList) {
		try {

			JAXBContext context = JAXBContext.newInstance(BookFactory.class);
			Marshaller marshaller = context.createMarshaller();

			File file = new File("FileXml/book.xml");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(bookList, file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public List<Book> getAllBook() {
		return this.unmarshalling().getBook();
	}

	public Book getBook(String id) {

		BookList bookList = this.unmarshalling();

		for (Book b : bookList.getBook()) {
			if (id.equals(b.getId())) {
				return b;
			}
		}

		return null;

	}

	public void insertBook(Book book) {

		BookList bookList = this.unmarshalling();

		Book maxIdBook = bookList.getBook().stream().max(Comparator.comparing(String::valueOf)).get();
		int maxId = 0;
		if (maxIdBook != null) {
			maxId = Integer.parseInt(maxIdBook.getId());
		}

		maxId++;

		book.setId(String.valueOf(maxId));

		bookList.getBook().add(book);

		this.marshalling(bookList);
	}

	public void updateBook(Book book) {

		BookList bookList = this.unmarshalling();

		if (book == null || bookList == null || bookList.getBook().isEmpty()) {
			return;
		}

		for (Book b : bookList.getBook()) {
			if (book.getId().equals(b.getId())) {
				b.setTitle(book.getTitle());
				b.setPrice(book.getPrice());
				b.setAuthor(book.getAuthor());
				b.setDescription(book.getDescription());
				b.setCategory(book.getCategory());
				b.setThumbnail(book.getThumbnail());
				break;
			}
		}

		this.marshalling(bookList);

	}

	public void deleteBook(String bookId) {

		BookList bookList = this.unmarshalling();

		if (bookId == null || bookList == null || bookList.getBook().isEmpty()) {
			return;
		}

		for (Book b : bookList.getBook()) {
			if (bookId.equals(b.getId())) {

				bookList.getBook().remove(b);

				break;
			}
		}

		this.marshalling(bookList);

	}
}
