package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	
	private static MenuItemDaoSqlImpl menuItemDao = new MenuItemDaoSqlImpl();
	
	public static void main(String[] args) {
		System.out.println("MenuItemDaoImplTest Main method begins");
		System.out.println("Admin List of MenuItems");
		testGetMenuItemListAdmin();
		System.out.println("Customer List of Menu Items");
		testGetMenuItemListCustomer();
		System.out.println("Modifying and printing MenuItem");
		testModifyMenuItem();
		testGetMenuItemListAdmin();
		System.out.println("Get Menu Item");
		testGetMenuItem();
	}
	
	public static void testGetMenuItemListAdmin() {
		List<MenuItem> itemAdminList = menuItemDao.getMenuItemListAdmin();
		itemAdminList.forEach(System.out::println);
	}
	
	public static void testGetMenuItemListCustomer() {
		List<MenuItem> itemCustomerList = menuItemDao.getMenuItemListCustomer();
		itemCustomerList.forEach(System.out::println);
	}

	public static void testModifyMenuItem() {
		MenuItem menuItem = new MenuItem(5, "Chocolate", 30.0f, true, new DateUtil().convertToDate("15/03/2017"), "Desert", true);
		menuItemDao.modifyMenuItem(menuItem);
	}
	
	public static void testGetMenuItem() {
		MenuItem menuItem = menuItemDao.getMenuItem(2);
		if(menuItem == null) {
			System.out.println("The Item does not exist in our database");
			return;
		}
		System.out.println(menuItem);
	}
}


// check changes checked changes
