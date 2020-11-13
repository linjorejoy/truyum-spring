package com.cognizant.truyum.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;

/**
 * To test all methods in the {@link MenuItemService} class
 * @author LINJO
 *
 */
public class MenuItemServiceTestWithXmlConfig {
    
    /**
     * Instance Variable of {@link MenuItemService}
     */
    private MenuItemService menuItemService;

    @Before
    public void initializeService() {
        final ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        menuItemService = context.getBean(MenuItemService.class);
    }

    @Test
    /**
     * To test the {@see MenuItemService#getMenuItemListAdmin()} for its size
     */
    public void testGetMenuItemListAdminSize() {
        assertEquals("Expected 5 Items But not received it", 5, menuItemService.getMenuItemListAdmin().size());
    }

    @Test
    /**
     * To test the {@see MenuItemService#getMenuItemListAdmin()} if it contains an
     * injected MenuItem
     */
    public void testGetMenuItemListAdminContainsSandwich() {
        boolean hasSandwich = false;
        for (final MenuItem item : menuItemService.getMenuItemListAdmin()) {
            if (item.getName().equalsIgnoreCase("Sandwich")) {
                hasSandwich = true;
                break;
            }
        }
        assertTrue("Sandwich is not present in Admins List", hasSandwich);
    }

    @Test
    /**
     * To test the {@see MenuItemService#getMenuItemListCustomer()} for its expected
     * size
     */
    public void testGetMenuItemListCustomerSize() {
        assertEquals("Expected 3 Items but not received", 3, menuItemService.getMenuItemListCustomer().size());
    }

    @Test
    /**
     * To test the {@see MenuItemService#getMenuItemListCustomer()} does not contain
     * inactive MenuItem
     */
    public void testGetMenuItemListCustomerNotContainsFrenchFries() {
        boolean hasFrenchFries = false;
        for (final MenuItem item : menuItemService.getMenuItemListCustomer()) {
            if (item.getName().equalsIgnoreCase("French Fries")) {
                hasFrenchFries = true;
                break;
            }
        }
        assertFalse("Expected french fries not to be present", hasFrenchFries);
    }

    @Test
    /**
     * To test {@see MenuItemService#getMenuItem(long)}
     */
    public void testGetMenuItem() {
        assertEquals("getMenuItem did not return the requested MenuItem", 1, menuItemService.getMenuItem(1).getId());
    }

    @Test
    /**
     * To test the {@see MenuItemService#editMenuItem(MenuItem)} method
     */
    public void testModifyMenuItem() {
        final float beforePrice = menuItemService.getMenuItem(1).getPrice();
        final MenuItem modifieditem = new MenuItem(1, "Sandwich", 150, true, new Date(), "Main Course", false);
        menuItemService.editMenuItem(modifieditem);
        assertTrue("Either Price before editing was same as price after or Modifying not done successfully",
                150.0 == menuItemService.getMenuItem(1).getPrice() && 150 != beforePrice);
    }

}
