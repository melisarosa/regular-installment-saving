package com.example.regularinstallmentsaving;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SavingAccountService {


    public SavingAccountDTO calculateSavingAccount(Integer tenor, BigDecimal firstAmount, BigDecimal monthlyAmount){
        BigDecimal grandTotal = firstAmount.add(monthlyAmount.multiply(BigDecimal.valueOf(tenor - 1)));
        BigDecimal interestRate = BigDecimal.valueOf(tenor).divide(new BigDecimal(12))
                .multiply(BigDecimal.valueOf(6)).divide(BigDecimal.valueOf(100));
        BigDecimal estimatedFinalAmount = interestRate.multiply(grandTotal).add(grandTotal);
        SavingAccountDTO dto = new SavingAccountDTO();
        dto.setEstimatedFinalAmount(estimatedFinalAmount);
        return dto;
    }

    public void createSavingAccount(Integer tenor, BigDecimal firstAmount, BigDecimal monthlyAmount, String purpose ){

    }

    public void getAllSavings(){

    }

    public void getSavingDetails(String savingAccountId){

    }
}
