package com.cognizant.truyum.model;

import java.util.List;

/**
 * Cart Object which stores the Object of a users Cart
 * 
 * @author LINJO
 *
 */
public class Cart {
    /**
     * To hold {@code List{{@code {@link MenuItem}}} of a particular User
     */
    private List<MenuItem> menuItemList;
    /**
     * To store the total price of all the {@code {@link MenuItem}} in a {@code Cart}
     */
    private double total;

    /**
     * A No Argument Constructor for aiding in creation of beans in COnfiguration
     * File
     */
    public Cart() {
        super();
    }

    /**
     * Single Argument Constructor which takes 
     * @param menuItemList as the parameter 
     * @param menuItemList      : {@code List{@code {@link MenuItem}}}
     */
    public Cart(List<MenuItem> menuItemList) {
        super();
        this.menuItemList = menuItemList;
    }

    public Cart(List<MenuItem> menuItemList, double total) {
        super();
        this.menuItemList = menuItemList;
        this.total = total;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((menuItemList == null) ? 0 : menuItemList.hashCode());
        long temp;
        temp = Double.doubleToLongBits(total);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cart other = (Cart) obj;
        if (menuItemList == null) {
            if (other.menuItemList != null)
                return false;
        } else if (!menuItemList.equals(other.menuItemList))
            return false;
        if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
    }

}
