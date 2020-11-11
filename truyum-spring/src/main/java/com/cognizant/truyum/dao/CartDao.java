/**
 * An Interface for aiding in the implementation of Cart Dao Classes
 * 
 */
package com.cognizant.truyum.dao;

import java.util.List;
import com.cognizant.truyum.model.MenuItem;


/**
 * 
 * @author LINJO REJOY
 *
 */
public interface CartDao {
	
	/**
	 * An abstract method for adding cart items to the cart
	 * @param userId It denotes the User Id in the User table in the MySQL workbench or the Collections
	 * @param menuItemId It denotes the Id of product which the user ordered.
	 */
	public void addCartItem(long userId, long menuItemId);
	
	/**
	 * An abstract method to get all the MenuItem List of cart items in a Cart 
	 * @param userId This will be the User Id of the user whose cart details we need to get
	 * @return A list of Menu Items which the user ordered
	 * @throws CartEmptyException
	 */
	
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException;
	
	/**
	 * An Abstract method to remove a Menu Item from a cart.
	 * @param userId It denotes the User Id in the User table in the MySQL workbench or the Collections
	 * @param menuItemId It denotes the Id of product which the user ordered.
	 */
	public void removeCartItem(long userId, long menuItemId);
	
}
