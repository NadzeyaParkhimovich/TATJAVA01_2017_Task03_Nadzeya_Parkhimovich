package com.epam.catalog.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.catalog.bean.Book;
import com.epam.catalog.bean.News;
import com.epam.catalog.bean.genre.BookGenre;
import com.epam.catalog.dao.DAOException;
import com.epam.catalog.dao.NewsDAO;

public class BookDAO implements NewsDAO{
	
	private static final Logger LOG = LogManager.getRootLogger();
	private static final String BOOK_FILE ="D:/Projects/Catalog/Book.txt";
	
	@Override
	public ArrayList<? extends News> findAll() throws DAOException {
		FileReader reader = null;
        BufferedReader br = null;
        ArrayList<Book> books = new ArrayList<Book>();
        
        try {
			reader = new FileReader(BOOK_FILE);
			br = new BufferedReader(reader);
			String s;
			String [] parts;
			Book book;
			while ((s = br.readLine()) != null) {
				parts = s.split("@");
				book = new Book(parts[0],parts[1],Integer.parseInt(parts[2]),parts[3],BookGenre.valueOf(parts[4]),Integer.parseInt(parts[5]));
				books.add(book);
				
			}
		} catch (FileNotFoundException e) {
			LOG.error(e);
			throw new DAOException("Book file is not found", e);
		} catch (IOException e) {
			LOG.error(e);
			throw new DAOException(e);
		} finally {
			try {
				reader.close();
				br.close();
			} catch (IOException e) {
				LOG.error(e);
			}
		}
		return books;
	}

	@Override
	public ArrayList<? extends News> findBy(String type, String value) throws DAOException {
		FileReader reader = null;
        BufferedReader br = null;
        ArrayList<Book> books = new ArrayList<Book>();
        
        try {
        	reader = new FileReader(BOOK_FILE);
			br = new BufferedReader(reader);
			String s;
			String [] parts;
			Book book;
			int i = Type.numberOfEnum(type);
			while ((s = br.readLine()) != null) {
				parts = s.split("@");
				if (parts[i].equalsIgnoreCase(value)) {
					book = new Book(parts[0],parts[1],Integer.parseInt(parts[2]),parts[3],BookGenre.valueOf(parts[4]),Integer.parseInt(parts[5]));
					books.add(book);
				}
			}
			
        }catch (FileNotFoundException e) {
			LOG.error(e);
			throw new DAOException("Book file is not found", e);
		} catch (IOException e) {
			LOG.error(e);
			throw new DAOException(e);
		} finally {
			try {
				reader.close();
				br.close();
			} catch (IOException e) {
				LOG.error(e);
			}
		}
		return books;
	}

	@Override
	public void addNews(News news) throws DAOException {
		
		if (!(news instanceof Book)) {
			LOG.error("Incorrect type of news");
			throw new DAOException("Incorrect type of news");
		}
		
		Book book = (Book) news;
		FileWriter writer = null;
		
        try {
            writer = new FileWriter(BOOK_FILE, true);
            writer.write(book.getTitle()+"@"+book.getAuthor()+"@"+book.getYear()+"@"+book.getText()+"@"+book.getGenre()+"@"+book.getNumberOfPages());
            writer.append("\r\n");
        } catch (FileNotFoundException e) {
			LOG.error(e);
			throw new DAOException("Book file is not found", e);
		} catch (IOException e) {
			LOG.error(e);
			throw new DAOException(e);
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				LOG.error(e);
			}
		}
	}
		
}
