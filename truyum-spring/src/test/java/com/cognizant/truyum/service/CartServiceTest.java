package com.cognizant.truyum.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

/**
 * Test All the methods in {@link CartDaoCollectionImpl}
 *  using {@link CartService}
 * 
 * @author LINJO
 *
 */
public class CartServiceTest {
    /**
     * Instance variable of CartService
     */
    private CartService cartService;

    @Before
    /**
     * Initializing all the required Application Contexts
     */
    public void initializeService() {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.cognizant.truyum");
        context.refresh();
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
