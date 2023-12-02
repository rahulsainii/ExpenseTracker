package com.contact.manager.CustomException;

public class ExpenseNotFoundException  extends RuntimeException{

    private static final long serialVersionId = 1L;

    public ExpenseNotFoundException(String message){
        super(message);
    }

}
