package app.service;

import java.util.List;

import app.model.Book;
import app.model.Review;

public interface BookService extends BaseService<Integer, Book> {

	List<Book> loadBooks();
	
	Book save(Book book, Review review);
}