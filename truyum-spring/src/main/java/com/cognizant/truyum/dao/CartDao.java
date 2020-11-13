/**
 * An Interface for aiding in the implementation of Cart DAO Classes
 * 
 */
package com.cognizant.truyum.dao;

import java.util.List;
import com.cognizant.truyum.model.MenuItem;

/**
 * Cart DAO Interface for abstract methods
 * 
 * @author LINJO REJOY
 *
 */
public interface CartDao {

    /**
     * An abstract method for adding cart items to the cart
     * 
     * @param userId     It denotes the User Id in the User table in the MySQL
     *                   workbench or the Collections
     * @param menuItemId It denotes the Id of
     *                   {@link MenuItem} which the user
     *                   ordered.
     */
    void addCartItem(long userId, long menuItemId);

    /**
     * An abstract method to get all the {@link java.util.ArrayList} 
     * of {@link MenuItem} of cart items in a Cart
     * @param userId This will be the User Id of the user whose cart details we need
     *               to get
     * @return {@link java.util.ArrayList}: A list of Menu Items which the
     *         user ordered
     * @throws CartEmptyException
     */

    List<MenuItem> getAllCartItems(long userId) throws CartEmptyException;

    /**
     * An Abstract method to remove a Menu Item from a cart.
     * 
     * @param userId     It denotes the User Id in the User table in the MySQL
     *                   workbench or the Collections
     * @param menuItemId It denotes the Id of product which the user ordered.
     */
    void removeCartItem(long userId, long menuItemId);

}
