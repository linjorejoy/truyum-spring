package com.cognizant.truyum.dao;

import java.util.List;
import com.cognizant.truyum.model.MenuItem;

/**
 * MenuItem Interface for abstract methods
 * 
 * @author LINJO
 *
 */
public interface MenuItemDao {

    /**
     * To get all the menu items in the view of Administrator
     * 
     * @return {@code List{@code MenuItem}}
     */
    List<MenuItem> getMenuItemListAdmin();

    /**
     * To get all the menu items in the view of Customer
     * 
     * @return {@code List{@code MenuItem}}
     */
    List<MenuItem> getMenuItemListCustomer();

    /**
     * To Modify any menu item present in the MenuItemList
     * 
     * @param menuItem type : {@code MenuItem}
     */
    void modifyMenuItem(MenuItem menuItem);

    /**
     * To return any menu Item from the Menu Item List
     * 
     * @param menuItemId
     * @return {@code MenuItem}
     */
    MenuItem getMenuItem(long menuItemId);

}
