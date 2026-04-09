package com.example.atmManagementSystem;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ATMuser {

    @Id
    private String cardNumber;
    private int pin;
    private double balance;
    private String name;

    public String getCardNumber() 
    { 
    	return cardNumber; 
    	}
    public void setCardNumber(String cardNumber) 
    { 
    	this.cardNumber = cardNumber; 
    	}

    public int getPin() { 
    	return pin; 
    	}
    public void setPin(int pin) { 
    	this.pin = pin; 
    	}

    public double getBalance() { 
    	return balance; 
    	}
    public void setBalance(double balance) { 
    	this.balance = balance; 
    	}

    public String getName() { 
    	return name;  
    	}
    public void setName(String name) { 
    	this.name = name; 
    	}
}
