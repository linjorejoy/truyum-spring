package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {
	private static PreparedStatement preparedStatement = null;
	
	@Override
	public void addCartItem(long userId, long menuItemId) {

		try {
			
			Connection connection = ConnectionHandler.getConnection();
			
			String query = "INSERT INTO CART(CT_USER_ID, CT_MENU_ID) VALUES (?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, menuItemId);
			
			if(preparedStatement.executeUpdate() > 0) {
				System.out.println("Query Successful");
			}else {
				System.out.println("Query Unsuccessful");
			}
			preparedStatement.clearParameters();
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}

	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		List<MenuItem> menuItemList = new ArrayList<>();
		Cart cart = new Cart(menuItemList, 0);
		double total = 0;
		try {
			Connection connection = ConnectionHandler.getConnection();
			
			String query = "SELECT * FROM MENU_ITEMS WHERE ID IN (SELECT CT_MENU_ID FROM CART WHERE CT_USER_ID = ?)";
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			
			prepareStatement.setLong(1, userId);
			
			ResultSet resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()) {
				long id = resultSet.getLong(1);
				String name = resultSet.getString(2);
				float price = resultSet.getFloat(3);
				total += price;
				boolean active = resultSet.getInt(4)==1;
				Date dateOfLaunch = resultSet.getDate(5);
				String category = resultSet.getString(6);
				boolean freeDelivery = resultSet.getInt(7)==1;
				MenuItem menuItem = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
				menuItemList.add(menuItem);
			}
			preparedStatement.clearParameters();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cart.setMenuItemList(menuItemList);
		cart.setTotal(total);
		return menuItemList;
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		
		try {
			Connection connection = ConnectionHandler.getConnection();
			String query = "DELETE FROM CART WHERE CT_MENU_ID = ? AND CT_USER_ID = ?";
			
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			prepareStatement.setLong(1, menuItemId);
			prepareStatement.setLong(2, userId);
			
			if(prepareStatement.executeUpdate() > 0) {
				System.out.println("Query Successful");
			}else {
				System.out.println("Query Unsuccessful");
			}
			preparedStatement.clearParameters();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
