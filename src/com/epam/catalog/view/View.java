package com.epam.catalog.view;

import com.epam.catalog.controller.Controller;

public class View {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller();
		//Здесь должен быть вью, но пока его нет
		//Добавление новости по диску
		String request = "add_news@disk@Vovin2@Therion@1998@hard@METAL";
		System.out.println(controller.executeTask(request));
		
		//Найти все по книгам
		request = "find_all@book";
		System.out.println(controller.executeTask(request));
		
		//Найти по дискам по жанру ROCK
		request = "find_by_genre@disk@ROCK";
		System.out.println(controller.executeTask(request));
		
		//Найти по фильмам по названию Ameli
		request = "find_by_title@film@Ameli";
		System.out.println(controller.executeTask(request));
	}
	
}
