package com.example.atmManagementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.atmManagementSystem.ATMuser;
import com.example.atmManagementSystem.ATMrepository;

@Service
public class ATMservice {

    @Autowired
    ATMrepository repo;

    public ATMuser login(String card, int pin) {
        return repo.findByCardNumberAndPin(card, pin);
    }

    public double getBalance(String card) {
        ATMuser user = repo.findById(card).get();
        return user.getBalance();
    }

    public double withdraw(String card, double amount) {
        ATMuser user = repo.findById(card).get();
        if (amount <= user.getBalance()) {
            user.setBalance(user.getBalance() - amount);
            repo.save(user);
            return user.getBalance();
        }
        throw new RuntimeException("Insufficient Balance");
    }

    public double deposit(String card, double amount) {
        ATMuser user = repo.findById(card).get();
        user.setBalance(user.getBalance() + amount);
        repo.save(user);
        return user.getBalance();
    }

    public ATMuser addUser(ATMuser user) {
        return repo.save(user);
    }
}
