package com.cognizant.truyum.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public class CartServiceTestWithXmlConfig {
    CartService cartService;
    
    public ExpectedException exceptionRule = ExpectedException.none();
    
    @Before
    public void initializeService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        cartService = context.getBean(CartService.class);
    }

    
    @Test(expected = CartEmptyException.class)
    public void testGetAllCartItemThrowsExceptionEmptyCart() throws CartEmptyException {
        cartService.getAllCartItems(1);
    }
    
    @Test(expected = CartEmptyException.class)
    public void testAddCartItemCheck() throws CartEmptyException {
        boolean hasSandwich = false;
        for(MenuItem item : cartService.getAllCartItems(1)) {
            if(item.getName().equalsIgnoreCase("Sandwich")) {
                hasSandwich = true;
            }
        }
        assertFalse(hasSandwich);
        hasSandwich = false;
        cartService.addCartItem(1, 1);
        for(MenuItem item : cartService.getAllCartItems(1)) {
            if(item.getName().equalsIgnoreCase("Sandwich")) {
                hasSandwich = true;
            }
        }
        assertTrue(hasSandwich);
        
    }
    
    @Test
    public void testRemoveCartitem() throws CartEmptyException {
        boolean hasSandwich = false;
        for(MenuItem item : cartService.getAllCartItems(2)) {
            if(item.getName().equalsIgnoreCase("Sandwich")) {
                hasSandwich = true;
            }
        }
        assertTrue(hasSandwich);
        
        cartService.removeCartitem(2, 1);
        hasSandwich = false;
        for(MenuItem item : cartService.getAllCartItems(2)) {
            if(item.getName().equalsIgnoreCase("Sandwich")) {
                hasSandwich = true;
            }
        }
        assertFalse(hasSandwich);
    }
    
}
