package com.epam.catalog.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWorker {
	
	
	private Integer affected_rows = 0;
	private static DBWorker instance = null;
	
	Statement statement;
	Connection connect;
	
	public static DBWorker getInstance()
	{
		if (instance == null)
		{
			instance = new DBWorker();
		}
		return instance;
	}
	
	
	private DBWorker()
	{	
	}
	
	
	public ResultSet getDBData(String query) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connect = DriverManager.getConnection("jdbc:mysql://localhost/catalog?user=root&password=admin&useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&connectionCollation=utf8_general_ci");
		statement = connect.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		return resultSet;
	}
	
	
	public Integer changeDBData(String query) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connect = DriverManager.getConnection("jdbc:mysql://localhost/catalog?user=root&password=admin&useUnicode=true&characterEncoding=UTF-8&characterSetResults=utf8&connectionCollation=utf8_general_ci");
		statement = connect.createStatement();
		this.affected_rows = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		return this.affected_rows;
		
		
	}

	
	public Integer getAffectedRowsCount()
	{
		return this.affected_rows;
	}
	
	public void closeConnection() throws SQLException {	
			
		if (statement != null) {
			statement.close();
		}
		if (connect != null) {
			connect.close();
		}
	}


}
