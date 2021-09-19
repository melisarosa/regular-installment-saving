package com.example.regularinstallmentsaving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class SavingAccountController {

    @Autowired
    private SavingAccountService savingAccountService;

    @GetMapping("/finalAmountEstimation")
    public SavingAccountDTO calculateSavingAccount(@RequestParam Integer tenor, @RequestParam BigDecimal firstAmount,
                                                   @RequestParam BigDecimal monthlyAmount) throws Exception {
        return savingAccountService.calculateSavingAccount(tenor, firstAmount, monthlyAmount);
    }

    @PostMapping("/savingCreation")
    public SavingAccountDTO createSavingAccount(@RequestBody SavingAccountDTO dto) throws Exception {
        return savingAccountService.createSavingAccount(dto);
    }

    @GetMapping("/savingList")
    public List<SavingAccountDTO> getAllSavings(){
        return savingAccountService.getAllSavings();
    }

    @GetMapping("/savingDetails/{savingId}")
    public Optional<SavingAccountDTO> getSavingDetails(@PathVariable Integer savingId) throws Exception {
        Optional<SavingAccountDTO> dto = savingAccountService.getSavingDetails(savingId);
        if(!dto.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
        }
        return dto;
    }
}
