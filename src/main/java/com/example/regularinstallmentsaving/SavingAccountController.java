package com.example.regularinstallmentsaving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class SavingAccountController {

    @Autowired
    private SavingAccountService savingAccountService;

    @GetMapping("/finalAmountEstimation")
    public SavingAccountDTO calculateSavingAccount(@RequestParam Integer tenor, @RequestParam BigDecimal firstAmount,
                                                   @RequestParam BigDecimal monthlyAmount){
        return savingAccountService.calculateSavingAccount(tenor, firstAmount, monthlyAmount);
    }

    @PostMapping("/savingCreation")
    public SavingAccountDTO createSavingAccount(@RequestBody SavingAccountDTO dto){
        return savingAccountService.createSavingAccount(dto);
    }

    @GetMapping("/savingList")
    public List<SavingAccountDTO> getAllSavings(){
        return savingAccountService.getAllSavings();
    }

    @GetMapping("/savingDetails/{savingId}")
    public Optional<SavingAccountDTO> getSavingDetails(@PathVariable Integer savingId){
        return savingAccountService.getSavingDetails(savingId);
    }
}
