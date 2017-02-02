package com.epam.catalog.dao;

import java.util.ArrayList;

import com.epam.catalog.beans.News;

public interface NewsDAO {
	
	ArrayList findAll() throws DAOException;
	ArrayList findByTitle(String title) throws DAOException;
	ArrayList findByAuthor(String author) throws DAOException;
	ArrayList findByYear(int year) throws DAOException;
	ArrayList findByText(String text) throws DAOException;
	ArrayList findByGenre(String genre) throws DAOException;
	void addNews(News news) throws DAOException;
	
}
