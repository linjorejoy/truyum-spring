package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Service("menuItemService")
/**
 * Service Class to implement all the methods in
 * {@link com.cognizant.truyum.dao.MenuItemDaoCollectionImpl} class
 * 
 * @author LINJO
 *
 */
public class MenuItemService {

    /**
     * An instance to store object of
     * {@link com.cognizant.truyum.dao.MenuItemDaoCollectionImpl} class
     * 
     */
    private MenuItemDao menuItemDao;

    @Autowired
    public void setMenuItemDao(final MenuItemDao menuItemDao) {
        this.menuItemDao = menuItemDao;
    }

    public MenuItemDao getMenuItemDao() {
        return menuItemDao;
    }

    /**
     * Invokes {@link 
     * com.cognizant.truyum.dao.MenuItemDaoCollectionImpl#getMenuItemListAdmin()}
     * and return the {@link java.util.ArrayList} of
     * {@link MenuItem} in the view of Administrator
     * 
     * @return
     */
    public List<MenuItem> getMenuItemListAdmin() {

        return menuItemDao.getMenuItemListAdmin();
    }

    /**
     * Invokes {@link 
     * com.cognizant.truyum.dao.MenuItemDaoCollectionImpl#getMenuItemListCustomer()}
     * and returns the {@link java.util.ArrayList} of
     * {@link MenuItem} in the view of Customer
     * 
     * @return
     */
    public List<MenuItem> getMenuItemListCustomer() {

        return menuItemDao.getMenuItemListCustomer();
    }

    /**
     * Invokes
     * {@link com.cognizant.truyum.dao.MenuItemDaoCollectionImpl#getMenuItem(long)}
     * and return the {@link MenuItem}
     * 
     * @param menuItemId
     * @return
     */
    public MenuItem getMenuItem(final long menuItemId) {

        return menuItemDao.getMenuItem(menuItemId);
    }

    /**
     * Invokes the {@link 
     * com.cognizant.truyum.dao.MenuItemDaoCollectionImpl#modifyMenuItem(MenuItem)}
     * 
     * @param menuItem
     */
    public void editMenuItem(final MenuItem menuItem) {
        menuItemDao.modifyMenuItem(menuItem);
    }

}
