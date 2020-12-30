package com.demo.entrypoint.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.entrypoint.entity.Product;

@Repository
@Component("productsRepositoryImpl")
public class ProductsRepositoryImpl implements ProductsRepository {

	@Override
	public List<Product> getAllProducts() {

		List<Product> productsList = new ArrayList<Product>();

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

			while (resultSet.next()) {
				productsList.add(new Product(Long.valueOf(resultSet.getString("id")).longValue(),
						resultSet.getString("category"), resultSet.getString("name"),
						resultSet.getString("description"), Double.parseDouble(resultSet.getString("unitprice")),
						Integer.parseInt(resultSet.getString("inventory")), resultSet.getString("paymentoption"),
						resultSet.getString("deliverymethod")));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return productsList;
	}
}
