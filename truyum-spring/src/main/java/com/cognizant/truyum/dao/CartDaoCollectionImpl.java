package com.cognizant.truyum.dao;

import java.util.ArrayList;
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
     * {@link java.util.HashMap} of userCarts
     */
    private Map<Long, Cart> userCarts;

    /**
     * Getter for {@link #userCarts}
     * 
     * @return {@link java.util.HashMap} with {@link java.lang.Long} as key and
     *         {@link Cart} as Value
     */
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
     * Single Argument Constructor to inject {@link java.util.HashMap}
     * 
     * @param userCarts : {@link java.util.HashMap}
     */
    public CartDaoCollectionImpl(final Map<Long, Cart> userCarts) {
        super();
        this.userCarts = userCarts;
    }

    @Override
    /**
     * Add {@link MenuItem} with Id : {@param menuItemId} to
     * the cart of User with User Id : userId
     * 
     * @param userId     : User Id
     * @param menuItemId : MenuItem Id
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
     * To get all the {@link MenuItem} from the particular users cart
     * 
     * @param userId : User Id specified in HashMap - { @link
     *               CartDaoCollectionImpl#userCarts }
     * @return List<MenuItem> list of { @link MenuItem }
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
    /**
     * Remove {@code com.cognizant.truyum.dao.MenuItem} with Id : {@code menuItemId}
     * <code>menuItemId</code>
     * from the cart of User with User Id : @param userId
     * 
     * @param userId     : user Id
     * @param menuItemId : MenuItem Id
     */
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
