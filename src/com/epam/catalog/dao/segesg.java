package com.epam.catalog.dao;

import java.util.ArrayList;

import com.epam.catalog.beans.Book;
import com.epam.catalog.beans.Disk;
import com.epam.catalog.beans.Film;
import com.epam.catalog.beans.FilmGenre;
import com.epam.catalog.dao.impl.BookDAO;
import com.epam.catalog.dao.impl.DiskDAO;
import com.epam.catalog.dao.impl.FilmDAO;

public class segesg {

	public static void main(String[] args) throws Exception {
		
		/*
		FilmDAO filmdao = new FilmDAO();
		ArrayList<Film> films = filmdao.findAll();
		for(Film film : films) {
			System.out.println(film.getTitle() + " " + film.getAuthor() + " " + film.getYear() + " " + film.getText() + " " + film.getGenre());
		}
		
		Film film1 = new Film("OOP", "Max", 2016, "hghghghg", FilmGenre.valueOf("COMEDY"));
		filmdao.addNews(film1);
		
		films = filmdao.findAll();
		for(Film film : films) {
			System.out.println(film.getTitle() + " " + film.getAuthor() + " " + film.getYear() + " " + film.getText() + " " + film.getGenre());
		}*/
		
		DAOFactory df = DAOFactory.getInstance();
		NewsDAO nd = df.getFilmDAO();
		ArrayList<Film> films = nd.findAll();
		for(Film film : films) {
			System.out.println(film.getTitle() + " " + film.getAuthor() + " " + film.getYear() + " " + film.getText() + " " + film.getGenre());
		}
		/*BookDAO bookdao = new BookDAO();
		ArrayList<Book> books = bookdao.findAll();
		for(Book book : books) {
			System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getYear() + " " + book.getText() + " " + book.getGenre() + " " + book.getNumberOfPages());
		}
		
		books = bookdao.findByPages(800);
	
		for(Book book : books) {
			System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getYear() + " " + book.getText() + " " + book.getGenre() + " " + book.getNumberOfPages());
		}
		
		DiskDAO diskdao = new DiskDAO();
		ArrayList<Disk> disks = diskdao.findAll();
		
		for(Disk disk : disks) {
			System.out.println(disk.getTitle() + " " + disk.getAuthor() + " " + disk.getYear() + " " + disk.getText() + " " + disk.getGenre());
		}

		disks = diskdao.findByTitle("Sehnsucht");
		
		for(Disk disk : disks) {
			System.out.println(disk.getTitle() + " " + disk.getAuthor() + " " + disk.getYear() + " " + disk.getText() + " " + disk.getGenre());
		}*/
	}

}
