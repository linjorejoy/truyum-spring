package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Component
@ImportResource("classpath:spring-config.xml")
/**
 * CartDaoImplementation
 * 
 * @author LINJO
 *
 */
public class CartDaoCollectionImpl implements CartDao {

    @Autowired
    @Qualifier("cartDaoMap")
    /**
     * Hash Map of userCarts
     */
    private Map<Long, Cart> userCarts;

    public Map<Long, Cart> getUserCarts() {
        return userCarts;
    }

    public void setUserCarts(final Map<Long, Cart> userCarts) {
        this.userCarts = userCarts;
    }

    /**
     * A No Argument Constructor
     */
    public CartDaoCollectionImpl() {
        super();
    }

    /**
     * Single Argument Constructor to inject Map : userCarts
     * 
     * @param userCarts
     */
    public CartDaoCollectionImpl(final Map<Long, Cart> userCarts) {
        super();
        this.userCarts = userCarts;
    }

    @Override
    /**
     * Add {@code MenuItem} with Id : menuItemId to the cart of User with User Id :
     * userId
     * 
     * @param userId     : user Id
     * @param menuItemId : Menu Item Id
     */
    public void addCartItem(final long userId, final long menuItemId) {

        final MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
        final MenuItem item = menuItemDao.getMenuItem(menuItemId);

        if (userCarts.containsKey(userId)) {
            final List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
            menuItemList.add(item);
            userCarts.get(userId).setMenuItemList(menuItemList);
        } else {
            final List<MenuItem> newUserMenuList = new ArrayList<>();
            newUserMenuList.add(item);
            final Cart cart = new Cart(newUserMenuList);
            userCarts.put(userId, cart);
        }

    }

    @Override
    /**
     * 
     * @param userId : User Id specified in HashMap - { @link
     *               CartDaoCollectionImpl#userCarts }
     */
    public List<MenuItem> getAllCartItems(final long userId) throws CartEmptyException {

        final Cart cart = userCarts.get(userId);
        final List<MenuItem> allCartItems = cart.getMenuItemList();
        if (allCartItems == null || allCartItems.isEmpty()) {
            throw new CartEmptyException();
        } else {
            double total = 0;
            for (final MenuItem item : allCartItems) {
                total += item.getPrice();
            }

            cart.setTotal(total);
        }
        return allCartItems;
    }

    @Override
    public void removeCartItem(final long userId, final long menuItemId) {

        final Cart cart = userCarts.get(userId);
        final List<MenuItem> allCartItems = cart.getMenuItemList();
        MenuItem itemToRemove = null;

        for (final MenuItem item : allCartItems) {
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
