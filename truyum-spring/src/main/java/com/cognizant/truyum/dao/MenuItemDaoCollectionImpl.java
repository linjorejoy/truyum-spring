package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

@Component
@ImportResource("classpath:spring-config.xml")
/**
 * Menu Item DAO Implementation class
 * 
 * @author LINJO
 *
 */
public class MenuItemDaoCollectionImpl implements MenuItemDao {

    @Autowired
    /**
     * {@link java.util.ArrayList} of {@link MenuItem}
     * Menu Item List which will be autowired from spring configuration file
     */
    private List<MenuItem> menuItemList;

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(final List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    /**
     * No argument constructor for aiding in the creation of bean
     */
    public MenuItemDaoCollectionImpl() {
        super();
    }

    /**
     * Single argument Constructor
     * 
     * @param menuItemList
     */
    public MenuItemDaoCollectionImpl(final List<MenuItem> menuItemList) {
        super();
        this.menuItemList = menuItemList;
    }

    /**
     * For getting 
     * {@link java.util.ArrayList} of {@link MenuItem}
     * in view of Administrator
     */
    public List<MenuItem> getMenuItemListAdmin() {

        return menuItemList;
    }

    /**
     * For getting 
     * {@link java.util.ArrayList} of {@link MenuItem}
     * in view of Customer
     */
    public List<MenuItem> getMenuItemListCustomer() {
        final List<MenuItem> customerItemList = new ArrayList<>();
        final Date currDate = new Date();

        for (final MenuItem item : menuItemList) {
            if (item.isActive() && currDate.after(item.getDateOfLaunch())) {
                customerItemList.add(item);
            }
        }
        return customerItemList;
    }


    /**
     * 
     * @param menuItemList The Item to be modified
     */
    public void modifyMenuItem(final MenuItem menuItem) {

        for (final MenuItem eachItem : menuItemList) {
            if (menuItem.equals(eachItem)) {
                eachItem.setId(menuItem.getId());
                eachItem.setName(menuItem.getName());
                eachItem.setPrice(menuItem.getPrice());
                eachItem.setActive(menuItem.isActive());
                eachItem.setDateOfLaunch(menuItem.getDateOfLaunch());
                eachItem.setCategory(menuItem.getCategory());
                eachItem.setFreeDelivery(menuItem.isFreeDelivery());
                return;
            }
        }
        menuItemList.add(menuItem);
    }

    /**
     * To get a menu item from 
     * {@link java.util.ArrayList} of {@link com.cognizant.truyum.model.MenuItem}
     * 
     * @param menuItemId the Id of the menu Item to be returned
     */
    public MenuItem getMenuItem(final long menuItemId) {
        MenuItem item = null;
        for (final MenuItem menuItem : menuItemList) {
            if (menuItem.getId() == menuItemId) {
                item = menuItem;
            }
        }
        return item;
    }

}
