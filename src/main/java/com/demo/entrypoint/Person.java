package com.demo.entrypoint;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Person {
	String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String greetings() {
		String url = "jdbc:postgresql://localhost:5432/testdb?user=postgres&password=postgres";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		
		try {
			Connection conn = DriverManager.getConnection(url);
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
			
			while(resultSet.next()){
				System.out.println(resultSet.getString("name"));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return "Hello " + this.getName();
	}

}
