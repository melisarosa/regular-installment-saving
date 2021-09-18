package com.example.regularinstallmentsaving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SavingAccountController {

    @Autowired
    SavingAccountService savingAccountService;

    @GetMapping("/calculate")
    public SavingAccountDTO calculateSavingAccount(@RequestParam Integer tenor, @RequestParam BigDecimal firstAmount,
                                                   @RequestParam BigDecimal monthlyAmount){
        return savingAccountService.calculateSavingAccount(tenor, firstAmount, monthlyAmount);
    }

    @PostMapping("/create")
    public SavingAccountDTO createSavingAccount(@RequestParam Integer tenor, @RequestParam BigDecimal firstAmount,
                                                @RequestParam BigDecimal monthlyAmount, @RequestParam String purpose){
        return new SavingAccountDTO();
    }

    @GetMapping("/getAll")
    public List<SavingAccountDTO> getAllSavings(){
        return new ArrayList<>();
    }

    @GetMapping("/getSavingDetails")
    public SavingAccountDTO getSavingDetails(@RequestParam Integer savingId){
        return new SavingAccountDTO();
    }
}
