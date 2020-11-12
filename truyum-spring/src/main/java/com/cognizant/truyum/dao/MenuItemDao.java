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
     * @return {@link java.util.ArrayList} of
     *          {@link com.cognizant.truyum.model.MenuItem}
     */
    List<MenuItem> getMenuItemListAdmin();

    /**
     * To get all the menu items in the view of Customer
     * 
     * @return {@link java.util.ArrayList} of
     *          {@link com.cognizant.truyum.model.MenuItem}
     */
    List<MenuItem> getMenuItemListCustomer();

    /**
     * To Modify any menu item present in the MenuItemList
     * 
     * @param menuItem type : {@link com.cognizant.truyum.model.MenuItem}
     */
    void modifyMenuItem(MenuItem menuItem);

    /**
     * To return any menu Item from the 
     * {@link java.util.ArrayList} of {@link com.cognizant.truyum.model.MenuItem}
     * 
     * @param menuItemId
     * @return {@link com.cognizant.truyum.model.MenuItem}
     */
    MenuItem getMenuItem(long menuItemId);

}
