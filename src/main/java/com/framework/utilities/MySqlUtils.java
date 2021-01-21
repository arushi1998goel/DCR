package com.framework.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.framework.selenium.core.Configuration;

public class MySqlUtils {

	private Connection conn;
	private Statement statement;

	public MySqlUtils() {
		try {
			String databaseServer = Configuration.readApplicationFile("DataBaseHost");
			String database = Configuration.readApplicationFile("DataBaseName");
			String port = Configuration.readApplicationFile("DataBasePort");
			String url = "jdbc:mysql://" + databaseServer + ":" + port + "/" + database + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			String password = "";
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet executeQuery(String query) throws SQLException {
		statement = conn.createStatement();
		// Result set get the result of the SQL query
		ResultSet resultSet = statement.executeQuery(query);
		return resultSet;
	}

	public String getProductId(String productName) throws SQLException {
		String query = "SELECT * FROM `oc_product_description` where `meta_title` = '" + productName + "'";
		ResultSet resultSet = executeQuery(query);
		resultSet.next();
		return resultSet.getString("product_id");
	}

	public int getCartAddedQuantity(String query) throws SQLException {
		ResultSet resultSet = executeQuery(query);
		if (resultSet.next()) {
			return Integer.parseInt(resultSet.getString("quantity"));
		}
		return 0;
	}

	public boolean checkProductWishList(String query) throws SQLException {
		ResultSet resultSet = executeQuery(query);
		if (resultSet.next()) {
			return true;
		}
		return false;
	}

	public String getCustomerId(String userEmail) throws SQLException {
		String queryCustomer = "SELECT * FROM `oc_customer` where `email` = '" + userEmail + "'";
		ResultSet resultSet = executeQuery(queryCustomer);
		resultSet.next();
		return resultSet.getString("customer_id");
	}

	public int getCartProductQuantity(String userEmail, String productName) throws SQLException {
		String productId = getProductId(productName);
		String customerId = getCustomerId(userEmail);
		String query = "SELECT * FROM `oc_cart` where `product_id` = " + Integer.parseInt(productId) + " and `customer_id` = " + Integer.parseInt(customerId);
		int quantityInCart = getCartAddedQuantity(query);
		return quantityInCart;
	}

	public boolean getStatusProductAddedWishListForUser(String userEmail, String productName) throws SQLException {
		String productId = getProductId(productName);
		String customerId = getCustomerId(userEmail);
		String query = "SELECT * FROM `oc_customer_wishlist` where `product_id` = " + Integer.parseInt(productId) + " and `customer_id` = " + Integer.parseInt(customerId);
		return checkProductWishList(query);
	}

	public static void main(String[] str) throws SQLException {
		MySqlUtils sql = new MySqlUtils();
		/*
		 * String queryCustomer =
		 * "SELECT * FROM `oc_customer` where `email` = 'alice.wonderland@gmail.com'"
		 * ; String productId = sql.getProductId("MacBook Air"); String
		 * customerId = sql.getCustomerId(queryCustomer); String query =
		 * "SELECT * FROM `oc_cart` where `product_id` = "
		 * +Integer.parseInt(productId)+" and `customer_id` = "
		 * +Integer.parseInt(customerId); int quantityInCart =
		 * sql.getCartAddedQuantity(query); System.out.println(quantityInCart);
		 */

		boolean status = sql.getStatusProductAddedWishListForUser("alice.wonderland@gmail.com", "MacBook Air");
		System.out.println(status);
	}

}
