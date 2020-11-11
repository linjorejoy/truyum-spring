package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {

    private List<MenuItem> menuItemList;

    public List<MenuItem> getMenuItemList() {

        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {

        this.menuItemList = menuItemList;
    }

    public List<MenuItem> getMenuItemListAdmin() {

        return menuItemList;
    }

    public List<MenuItem> getMenuItemListCustomer() {
        List<MenuItem> customerItemList = new ArrayList<>();
        Date currDate = new DateUtil().convertToDate("20/10/2020");

        for (MenuItem item : menuItemList) {
            if (item.isActive() && currDate.after(item.getDateOfLaunch())) {
                customerItemList.add(item);
            }
        }
        return customerItemList;
    }

    public void modifyMenuItem(MenuItem menuItem) {

        for (MenuItem eachItem : menuItemList) {
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

    public MenuItem getMenuItem(long menuItemId) {

        for (MenuItem menuItem : menuItemList) {
            if (menuItem.getId() == menuItemId) {
                return menuItem;
            }
        }
        return null;
    }

}
