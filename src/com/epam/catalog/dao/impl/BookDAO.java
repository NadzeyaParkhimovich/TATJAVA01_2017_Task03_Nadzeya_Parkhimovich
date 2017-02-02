package com.epam.catalog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.epam.catalog.beans.Book;
import com.epam.catalog.beans.BookGenre;
import com.epam.catalog.beans.News;
import com.epam.catalog.dao.DAOException;
import com.epam.catalog.dao.NewsDAO;

public class BookDAO implements NewsDAO{
		
	DBWorker db = DBWorker.getInstance();
	ArrayList<Book> books = new ArrayList<Book>();
	ResultSet result;
	
	public ArrayList<Book> findAll() throws DAOException {
		result = db.getDBData("SELECT * FROM `book`");
		try {
			while (result.next()) {
				Book book = new Book(result.getString("title"),result.getString("author"),result.getInt("year"),
						result.getString("text"),BookGenre.valueOf(result.getString("genre")),result.getInt("numberOfPages"));
				books.add(book);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return books;
	}
	
	public ArrayList<Book> findByTitle(String title) throws DAOException {
		result = db.getDBData("SELECT * FROM `book` WHERE `title`=\"" + title +"\"");
		try {
			while (result.next()) {
				Book book = new Book(result.getString("title"),result.getString("author"),result.getInt("year"),
						result.getString("text"),BookGenre.valueOf(result.getString("genre")),result.getInt("numberOfPages"));
				books.add(book);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return books;
	}

	public ArrayList<Book> findByAuthor(String author) throws DAOException {
		result = db.getDBData("SELECT * FROM `book` WHERE `author`=\"" + author + "\"");
		try {
			while (result.next()) {
				Book book = new Book(result.getString("title"),result.getString("author"),result.getInt("year"),
						result.getString("text"),BookGenre.valueOf(result.getString("genre")),result.getInt("numberOfPages"));
				books.add(book);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return books;
	}
	
	public ArrayList<Book> findByYear(int year) throws DAOException {
		result = db.getDBData("SELECT * FROM `book` WHERE `year`=" + year);
		try {
			while (result.next()) {
				Book book = new Book(result.getString("title"),result.getString("author"),result.getInt("year"),
						result.getString("text"),BookGenre.valueOf(result.getString("genre")),result.getInt("numberOfPages"));
				books.add(book);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return books;
	}
	
	public ArrayList<Book> findByText(String text) throws DAOException {
		result = db.getDBData("SELECT * FROM `Book` WHERE `text`=\"" + text + "\"");
		try {
			while (result.next()) {
				Book book = new Book(result.getString("title"),result.getString("author"),result.getInt("year"),
						result.getString("text"),BookGenre.valueOf(result.getString("genre")),result.getInt("numberOfPages"));
				books.add(book);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return books;
	}
	
	public ArrayList<Book> findByGenre(String genre) throws DAOException {
		result = db.getDBData("SELECT * FROM `Book` WHERE `genre`=\"" + genre + "\"");
		try {
			while (result.next()) {
				Book book = new Book(result.getString("title"),result.getString("author"),result.getInt("year"),
						result.getString("text"),BookGenre.valueOf(result.getString("genre")),result.getInt("numberOfPages"));
				books.add(book);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return books;
	}
	
	public ArrayList<Book> findByPages(int numberOfPages) throws DAOException {
		result = db.getDBData("SELECT * FROM `Book` WHERE `numberOfPages`=" + numberOfPages);
		try {
			while (result.next()) {
				Book book = new Book(result.getString("title"),result.getString("author"),result.getInt("year"),
						result.getString("text"),BookGenre.valueOf(result.getString("genre")),result.getInt("numberOfPages"));
				books.add(book);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
		return books;
	}
	
	public void addNews(News news) throws DAOException {
		if (news instanceof Book) {
			Book book = (Book)news;
			String query = "INSERT INTO `film` (`title`,`author`,`year`,`text`,`genre`,`numberOfPages`) "
					+ "VALUES (\"" + book.getTitle() + "\",\"" + book.getAuthor() + "\","
					+ book.getYear() + ",\"" + book.getText() + "\",\"" + book.getGenre() + "\"," + book.getNumberOfPages() + ")";
			if(db.changeDBData(query) != 1) {
				throw new DAOException("Problem in insert file");
			}
		} else {
			throw new DAOException("Incorrect type of news");
		}
		
	}
		
}
