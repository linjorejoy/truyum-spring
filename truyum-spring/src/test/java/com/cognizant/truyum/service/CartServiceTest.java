package com.cognizant.truyum.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.dao.CartEmptyException;

public class CartServiceTest {
    CartService cartService;
    
    public ExpectedException exceptionRule = ExpectedException.none();
    
    @Before
    public void initializeService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        cartService = (CartService) context.getBean(CartService.class);
    }

    
    @Test(expected = CartEmptyException.class)
    public void testGetAllCartItemThrowsExceptionEmptyCart() throws CartEmptyException {
            try {
                cartService.getAllCartItems(1);
            } catch (CartEmptyException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                throw new CartEmptyException();
            }
    }
}
