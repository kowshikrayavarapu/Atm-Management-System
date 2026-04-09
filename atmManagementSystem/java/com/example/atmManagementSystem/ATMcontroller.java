package com.example.atmManagementSystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.atmManagementSystem.ATMuser;
import com.example.atmManagementSystem.ATMservice;

@RestController
@RequestMapping("/atm")
public class ATMcontroller {

    @Autowired
    ATMservice service;

    @PostMapping("/addUser")
    public ATMuser addUser(@RequestBody ATMuser user) {
        return service.addUser(user);
    }

    @PostMapping("/login")
    public ATMuser login(@RequestBody ATMuser user) {
        return service.login(user.getCardNumber(), user.getPin());
    }

    @GetMapping("/balance/{card}")
    public double getBalance(@PathVariable String card) {
        return service.getBalance(card);
    }

    @PostMapping("/withdraw/{card}/{amount}")
    public double withdraw(@PathVariable String card, @PathVariable double amount) {
        return service.withdraw(card, amount);
    }

    @PostMapping("/deposit/{card}/{amount}")
    public double deposit(@PathVariable String card, @PathVariable double amount) {
        return service.deposit(card, amount);
    }
}