package com.example.atmManagementSystem;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.atmManagementSystem.ATMuser;

public interface ATMrepository extends JpaRepository<ATMuser, String> {

    ATMuser findByCardNumberAndPin(String cardNumber, int pin);
}