package com.epam.catalog.dao.impl;

public enum Type {
	title,
	author,
	year,
	text,
	genre,
	numberOfPages;
	
	public static int numberOfEnum(String s) {
		Type T = valueOf(s);
		switch (T){
		case title:
			return 0;
		case author:
			return 1;
		case year:
			return 2;
		case text:
			return 3;
		case genre:
			return 4;
		case numberOfPages:
			return 5;
		default: 
			return -1;
		}
	}
}
