package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inside CartDaoSqlImplTest's Main");
		System.out.println("AddCartItem invoked");
		testAddCartItem();
		System.out.println("getAllCartItem invoked");
		testGetAllCartItem();
		System.out.println("removeCartItem invoked");
		testRemoveCartItem();
		testGetAllCartItem();
		System.out.println("Completed..");
		
	}
	
	public static void testAddCartItem() {
		CartDaoSqlImpl cartDaoImpl = new CartDaoSqlImpl();
		cartDaoImpl.addCartItem(2, 2);
		cartDaoImpl.addCartItem(1, 2);
		cartDaoImpl.addCartItem(2, 2);
		cartDaoImpl.addCartItem(2, 3);
		cartDaoImpl.addCartItem(2, 4);
	}
	
	public static void testGetAllCartItem() {
		int user_id = 2;
		CartDaoSqlImpl cartDaoImpl = new CartDaoSqlImpl();
		try {
			List<MenuItem> menuItemList = cartDaoImpl.getAllCartItems(user_id);
			for(MenuItem item : menuItemList) {
				System.out.println(item);
			}
		} catch (CartEmptyException e) {
			System.out.printf("The user id number %f did not buy anything\n",user_id);
			e.printStackTrace();
		}
	}
	
	public static void testRemoveCartItem() {
		CartDaoSqlImpl cartDaoImpl = new CartDaoSqlImpl();
		long userId = 1;
		System.out.println("\nBefore Delelting");
		try {
			for(MenuItem item : cartDaoImpl.getAllCartItems(userId)) {
				System.out.println(item);
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long menuItemId = 1;
		cartDaoImpl.removeCartItem(userId, menuItemId);
		System.out.println("\nAfter Delelting");
		try {
			for(MenuItem item : cartDaoImpl.getAllCartItems(userId)) {
				System.out.println(item);
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}
}
