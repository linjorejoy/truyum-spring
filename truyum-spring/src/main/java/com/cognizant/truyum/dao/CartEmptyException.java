package com.cognizant.truyum.dao;

public class CartEmptyException extends Exception {

    public CartEmptyException() {
            super();
    }
    public CartEmptyException(String message) {
        super(message);
}

}
