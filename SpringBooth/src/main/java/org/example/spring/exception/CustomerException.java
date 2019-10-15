/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.spring.exception;

/**
 *
 * @author marco
 */
public class CustomerException extends Exception {

    public CustomerException() {
        super();
    }

    public CustomerException(String msg, Object... params) {
        super(String.format(msg, params));
    }

    public CustomerException(Exception e, String msg, Object... params) {
        super(String.format(msg, params), e);
    }

    public CustomerException(String msg, Exception e) {
        super(msg, e);
    }

    public CustomerException(Exception e) {
        super(e.getMessage(), e);
    }

    public CustomerException(String msg, String argument) {
        super(String.format(msg, argument));
    }

    public CustomerException(String message) {
        super(message);
    }

}
