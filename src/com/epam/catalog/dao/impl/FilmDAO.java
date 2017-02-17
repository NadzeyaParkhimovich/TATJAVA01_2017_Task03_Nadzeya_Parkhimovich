package com.epam.catalog.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.catalog.bean.Film;
import com.epam.catalog.bean.News;
import com.epam.catalog.bean.genre.FilmGenre;
import com.epam.catalog.dao.DAOException;
import com.epam.catalog.dao.NewsDAO;

public class FilmDAO implements NewsDAO {
	
	private static final Logger LOG = LogManager.getRootLogger();
	private static final String FILM_FILE ="D:/Projects/Catalog/Film.txt";
	
	@Override
	public ArrayList<? extends News> findAll() throws DAOException {
		FileReader reader = null;
        BufferedReader br = null;
        ArrayList<Film> films = new ArrayList<Film>();
        
        try {
			reader = new FileReader(FILM_FILE);
			br = new BufferedReader(reader);
			String s;
			String [] parts;
			Film film;
			while ((s = br.readLine()) != null) {
				parts = s.split("@");
				film = new Film(parts[0],parts[1],Integer.parseInt(parts[2]),parts[3],FilmGenre.valueOf(parts[4]));
				films.add(film);
				
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
		return films;
	}

	@Override
	public ArrayList<? extends News> findBy(String type, String value) throws DAOException {
		FileReader reader = null;
        BufferedReader br = null;
        ArrayList<Film> films = new ArrayList<Film>();
        
        try {
        	reader = new FileReader(FILM_FILE);
			br = new BufferedReader(reader);
			String s;
			String [] parts;
			Film film;
			int i = Type.numberOfEnum(type);
			while ((s = br.readLine()) != null) {
				parts = s.split("@");
				if (parts[i].equalsIgnoreCase(value)) {
					film = new Film(parts[0],parts[1],Integer.parseInt(parts[2]),parts[3],FilmGenre.valueOf(parts[4]));
					films.add(film);
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
		return films;
	}

	@Override
	public void addNews(News news) throws DAOException {
		
		if (!(news instanceof Film)) {
			LOG.error("Incorrect type of news");
			throw new DAOException("Incorrect type of news");
		}
		
		Film film = (Film) news;
		FileWriter writer = null;
		
        try {
            writer = new FileWriter(FILM_FILE, true);
            writer.write(film.getTitle()+"@"+film.getAuthor()+"@"+film.getYear()+"@"+film.getText()+"@"+film.getGenre());
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
