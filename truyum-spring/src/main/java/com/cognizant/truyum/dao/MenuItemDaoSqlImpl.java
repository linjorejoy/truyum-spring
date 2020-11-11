package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {
	private static PreparedStatement preparedStatement = null;

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		List<MenuItem> menuItemsList = new ArrayList<>();
		try {
			Connection connection = ConnectionHandler.getConnection();
			String query = "SELECT * FROM MENU_ITEMS";
			preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				long id = resultSet.getLong(1);
				String name = resultSet.getString(2);
				float price = resultSet.getFloat(3);
				boolean active = resultSet.getInt(4)==1;
				Date dateOfLaunch = resultSet.getDate(5);
				String category = resultSet.getString(6);
				boolean freeDelivery = resultSet.getInt(7)==1;
				MenuItem item = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
				menuItemsList.add(item);
			}
			preparedStatement.clearParameters();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menuItemsList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> menuItemsList = new ArrayList<>();
		try {
			Connection connection = ConnectionHandler.getConnection();
			String query = "SELECT * FROM MENU_ITEMS WHERE ACTIVE = TRUE AND date_Of_Launch < now()";
			preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				long id = resultSet.getLong(1);
				String name = resultSet.getString(2);
				float price = resultSet.getFloat(3);
				boolean active = resultSet.getInt(4)==1;
				Date dateOfLaunch = resultSet.getDate(5);
				String category = resultSet.getString(6);
				boolean freeDelivery = resultSet.getInt(7)==1;
				MenuItem item = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
				menuItemsList.add(item);
			}
			preparedStatement.clearParameters();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menuItemsList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {

		try {
			Connection connection = ConnectionHandler.getConnection();
			String query = "UPDATE MENU_ITEMS SET item_name = ?, PRICE = ?, ACTIVE = ?, DATE_OF_LAUNCH = ?, CATEGORY = ?, FREE_DELIVERY = ? WHERE ID = ?";
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.clearParameters();
			preparedStatement.setString(1, menuItem.getName());
			preparedStatement.setFloat(2, menuItem.getPrice());
			preparedStatement.setBoolean(3, menuItem.isActive());
			preparedStatement.setString(4, format.format(menuItem.getDateOfLaunch()));
			preparedStatement.setString(5, menuItem.getCategory());
			preparedStatement.setBoolean(6, menuItem.isFreeDelivery());
			preparedStatement.setLong(7, menuItem.getId());
			
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
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem = null;
		try {
			Connection connection = ConnectionHandler.getConnection();
			String query = "SELECT * FROM MENU_ITEMS WHERE ID =?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setLong(1, menuItemId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				long id = resultSet.getLong(1);
				String name = resultSet.getString(2);
				float price = resultSet.getFloat(3);
				boolean active = resultSet.getInt(4)==1;
				Date dateOfLaunch = resultSet.getDate(5);
				String category = resultSet.getString(6);
				boolean freeDelivery = resultSet.getInt(7)==1;
				menuItem = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
			}
			preparedStatement.clearParameters();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menuItem;
	}

}
