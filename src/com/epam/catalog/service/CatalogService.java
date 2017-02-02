package com.epam.catalog.service;

import java.util.ArrayList;

import com.epam.catalog.beans.News;
import com.epam.catalog.dao.DAOException;

public interface CatalogService {
	
	ArrayList findAll() throws ServiceExeption;
	ArrayList findByTitle(String title) throws ServiceExeption;
	ArrayList findByAuthor(String author) throws ServiceExeption;
	ArrayList findByYear(int year) throws ServiceExeption;
	ArrayList findByText(String text) throws ServiceExeption;
	ArrayList findByGenre(String genre) throws ServiceExeption;
	
}
