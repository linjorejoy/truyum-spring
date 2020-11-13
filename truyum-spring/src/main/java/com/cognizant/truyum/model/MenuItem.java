package com.cognizant.truyum.model;

import java.util.Date;

/**
 * To create MenuItem objects to store details for each Menu Item
 * 
 * @author LINJO
 *
 */
public class MenuItem {

    /**
     * To store ID
     */
    private long id;
    /**
     * To store Name of the product
     */
    private String name;
    /**
     * To store price of a product
     */
    private float price;
    /**
     * Boolean value to check if product is available
     */
    private boolean active;
    /**
     * Date variable to store the date of launch
     */
    private Date dateOfLaunch;
    /**
     * String to store the type of MenuItem Available
     */
    private String category;
    /**
     * Boolean variable to check the availability of free Delivery
     */
    private boolean freeDelivery;

    /**
     * No Argument Constructor
     */
    public MenuItem() {
        super();
    }

    /**
     * 7-Argument constructor to create 
     * {@link MenuItem} object
     * 
     * @param id
     * @param name
     * @param price
     * @param active
     * @param dateOfLaunch
     * @param category
     * @param freeDelivery
     */
    public MenuItem(final long id, final String name, final float price, final boolean active, final Date dateOfLaunch,
            final String category, final boolean freeDelivery) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.active = active;
        this.dateOfLaunch = dateOfLaunch;
        this.category = category;
        this.freeDelivery = freeDelivery;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id : the id to set
     */
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(final float price) {
        this.price = price;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(final boolean active) {
        this.active = active;
    }

    /**
     * @return the dateOfLaunch
     */
    public Date getDateOfLaunch() {
        return dateOfLaunch;
    }

    /**
     * @param dateOfLaunch the dateOfLaunch to set
     */
    public void setDateOfLaunch(final Date dateOfLaunch) {
        this.dateOfLaunch = dateOfLaunch;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(final String category) {
        this.category = category;
    }

    /**
     * @return the freeDelivery
     */
    public boolean isFreeDelivery() {
        return freeDelivery;
    }

    /**
     * @param freeDelivery the freeDelivery to set
     */
    public void setFreeDelivery(final boolean freeDelivery) {
        this.freeDelivery = freeDelivery;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    /**
     * For comparing 2 
     * {@link MenuItem}
     *  and are equated based on their ID
     * 
     * @param obj :
     */
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MenuItem other = (MenuItem) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    /**
     * Overridden toString method of {@link Object}
     */
    public String toString() {
        return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", dateOfLaunch="
                + dateOfLaunch + ", category=" + category + ", freeDelivery=" + freeDelivery + "]";
    }

}
