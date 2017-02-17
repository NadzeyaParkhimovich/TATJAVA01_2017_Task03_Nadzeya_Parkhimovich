package com.epam.catalog.controller.impl;

import com.epam.catalog.controller.Command;

public class Exit implements Command{

	@Override
	public String execute(String request) {
		
		String response = "Goodbye!";
		return response;
	}

}
