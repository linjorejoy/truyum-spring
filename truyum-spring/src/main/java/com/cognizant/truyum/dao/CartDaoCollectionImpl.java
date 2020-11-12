package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Component
@ImportResource("classpath:spring-config.xml")
public class CartDaoCollectionImpl implements CartDao {

    @Autowired
    @Qualifier("cartDaoMap")
    private Map<Long, Cart> userCarts;

    public Map<Long, Cart> getUserCarts() {
        return userCarts;
    }

    public void setUserCarts(Map<Long, Cart> userCarts) {
        this.userCarts = userCarts;
    }

    @Override
    public void addCartItem(long userId, long menuItemId) {

        MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
        MenuItem item = menuItemDao.getMenuItem(menuItemId);

        if (userCarts.containsKey(userId)) {
            List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
            menuItemList.add(item);
            userCarts.get(userId).setMenuItemList(menuItemList);
        } else {
            List<MenuItem> newUserMenuList = new ArrayList<>();
            newUserMenuList.add(item);
            Cart cart = new Cart(newUserMenuList);
            userCarts.put(userId, cart);
        }

    }

    @Override
    public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {

        Cart cart = userCarts.get(userId);
        List<MenuItem> allCartItems = cart.getMenuItemList();
        if (allCartItems.isEmpty() || allCartItems == null) {
            throw new CartEmptyException();
        } else {
            double total = 0;
            for (MenuItem item : allCartItems) {
                total += item.getPrice();
            }

            cart.setTotal(total);
        }
        return allCartItems;
    }

    @Override
    public void removeCartItem(long userId, long menuItemId) {

        Cart cart = userCarts.get(userId);
        List<MenuItem> allCartItems = cart.getMenuItemList();
        MenuItem itemToRemove = null;

        for (MenuItem item : allCartItems) {
            if (item.getId() == menuItemId) {
                itemToRemove = item;
                break;
            }
        }
        allCartItems.remove(itemToRemove);
        cart.setMenuItemList(allCartItems);
        userCarts.put(userId, cart);
    }

}
