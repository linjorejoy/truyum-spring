package com.cognizant.truyum.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;


public class MenuItemServiceTest {
    MenuItemService menuItemService;
    
    @Before
    public void initializeService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        menuItemService = context.getBean(MenuItemService.class);
    }
    
    @Test
    public void testGetMenuItemListAdminSize() {
        assertEquals(5, menuItemService.getMenuItemListAdmin().size());
    }
    
    @Test
    public void testGetMenuItemListAdminContainsSandwich() {
        boolean sandWichPresent = false;
        for(MenuItem item : menuItemService.getMenuItemListAdmin()) {
            if(item.getName().equalsIgnoreCase("Sandwich")) {
                sandWichPresent = true;
                break;
            }
        }
        assertTrue(sandWichPresent);
    }

    @Test
    public void testGetMenuItemListCustomerSize() {
        assertEquals(3, menuItemService.getMenuItemListCustomer().size());
    }
    
    @Test
    public void testGetMenuItemListCustomerNotContainsFrenchFries() {
        boolean frenchFriesPresent = false;
        for(MenuItem item : menuItemService.getMenuItemListCustomer()) {
            if(item.getName().equalsIgnoreCase("French Fries")) {
                frenchFriesPresent = true;
                break;
            }
        }
        assertFalse(frenchFriesPresent);
    }

    @Test
    public void testGetMenuItem() {
        assertEquals(1, menuItemService.getMenuItem(1).getId());
    }
    
    @Test
    public void testModifyMenuItem() {
        MenuItem modifieditem = new MenuItem(1, "Sandwich", 150, true, new Date(), "Main Course", false);
        menuItemService.editMenuItem(modifieditem);
        assertTrue(150.0 == menuItemService.getMenuItem(1).getPrice());
    }
    
    
    
    
    
}
