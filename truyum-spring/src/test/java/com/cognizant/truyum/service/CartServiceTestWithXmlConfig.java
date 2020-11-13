package com.cognizant.truyum.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

/**
 * Testing all with XML Config
 * 
 * @author LINJO
 *
 */
public class CartServiceTestWithXmlConfig {
    /**
     * {@link CartService} instance variable
     */
    CartService cartService;

    /**
     * To check Exception is thrown
     */
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    /**
     * initialization
     */
    public void initializeService() {
        final ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        cartService = context.getBean(CartService.class);
    }

    @Test(expected = CartEmptyException.class)
    /**
     * Test to make sure
     * {@link CartDaoCollectionImpl#getAllCartItems(long)} throws a 
     * {@link com.cognizant.truyum.dao.CartEmptyException} when 
     * {@link com.cognizant.truyum.model.Cart} is Empty
     * 
     * @throws CartEmptyException
     */
    public void testGetAllCartItemThrowsExceptionEmptyCart() throws CartEmptyException {
        cartService.getAllCartItems(1);
    }

    @Test(expected = CartEmptyException.class)
    /**
     * Test to check
     * {@link com.cognizant.truyum.dao.CartDaoCollectionImpl#addCartItem(long, long)}
     * adds the correct MenuItem to Cart
     * 
     * @throws CartEmptyException
     */
    public void testAddCartItemCheck() throws CartEmptyException {
        boolean hasSandwich = false;
        for (final MenuItem item : cartService.getAllCartItems(1)) {
            if (item.getName().equalsIgnoreCase("Sandwich")) {
                hasSandwich = true;
            }
        }
        final boolean before = hasSandwich;

        hasSandwich = false;
        cartService.addCartItem(1, 1);
        for (final MenuItem item : cartService.getAllCartItems(1)) {
            if (item.getName().equalsIgnoreCase("Sandwich")) {
                
                hasSandwich = true;
            }
        }
        assertTrue("Item already present or Not Added", hasSandwich && !before);
    }

    @Test
    /**
     * Test to check
     * {@link 
     * com.cognizant.truyum.dao.CartDaoCollectionImpl#removeCartItem(long, long)}
     * removes the {@link com.cognizant.truyum.dao.MenuItem} from 
     * {@link com.cognizant.truyum.model.Cart}
     * @throws CartEmptyException
     */
    public void testRemoveCartitem() throws CartEmptyException {
        boolean hasSandwich = false;
        for (final MenuItem item : cartService.getAllCartItems(2)) {
            if (item.getName().equalsIgnoreCase("Sandwich")) {
                hasSandwich = true;
            }
        }
        final boolean before = hasSandwich;

        cartService.removeCartItem(2, 1);
        hasSandwich = false;
        for (final MenuItem item : cartService.getAllCartItems(2)) {
            if (item.getName().equalsIgnoreCase("Sandwich")) {
                hasSandwich = true;
            }
        }
        assertFalse("Item to remove not Present in Cart of Item not properly removed", hasSandwich && !before);
    }

}
