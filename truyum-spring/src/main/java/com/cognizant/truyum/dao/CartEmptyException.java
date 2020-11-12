package com.cognizant.truyum.dao;

/**
 * Exception thrown when trying to access and empty cart
 * 
 * @author LINJO
 *
 */
public class CartEmptyException extends Exception {

    private static final long serialVersionUID = 100L;

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized.
     * No Argument Constructor
     */
    public CartEmptyException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized.
     *
     * @param   message   the detail message. The detail message is saved for
     *          later retrieval by the {@link #getMessage()} method.
     */
    public CartEmptyException(final String message) {
        super(message);
    }

}
