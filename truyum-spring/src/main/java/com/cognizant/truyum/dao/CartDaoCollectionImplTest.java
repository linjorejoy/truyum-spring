package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static CartDao cartDao = new CartDaoCollectionImpl();

	public static void main(String[] args) {

		testAddCartItem();
		System.out.println();
		testGetAllCartItems();
		System.out.println();
		testRemoveCartItem();
	}

	private static void testRemoveCartItem() {

		cartDao.removeCartItem(1, 1);
		List<MenuItem> cartItemList;
		try {
			cartItemList = cartDao.getAllCartItems(1);
			cartItemList.forEach(System.out::println);
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void testGetAllCartItems() {


		try {
			List<MenuItem> allCartItems = cartDao.getAllCartItems(1);
			allCartItems.forEach(System.out::println);
		} catch (CartEmptyException e) {

			e.printStackTrace();
		}

	}

	private static void testAddCartItem() {


		cartDao.addCartItem(1, 1);
		try {
			List<MenuItem> cartItemList = cartDao.getAllCartItems(1);
			cartItemList.forEach(System.out::println);
		} catch (CartEmptyException e) {

			e.printStackTrace();
		}
	}

}
