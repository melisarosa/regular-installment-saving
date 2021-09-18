package com.example.regularinstallmentsaving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;

@Service
public class SavingAccountService {

    @Autowired
    private SavingAccountDAO savingAccountDAO;

    public SavingAccountDTO calculateSavingAccount(Integer tenor, BigDecimal firstAmount, BigDecimal monthlyAmount){
        BigDecimal grandTotal = firstAmount.add(monthlyAmount.multiply(BigDecimal.valueOf(tenor - 1)));
        BigDecimal interestRate = BigDecimal.valueOf(tenor).divide(new BigDecimal(12))
                .multiply(BigDecimal.valueOf(6)).divide(BigDecimal.valueOf(100));
        BigDecimal estimatedFinalAmount = interestRate.multiply(grandTotal).add(grandTotal);
        SavingAccountDTO dto = new SavingAccountDTO();
        dto.setEstimatedFinalAmount(estimatedFinalAmount);
        return dto;
    }

    public SavingAccountDTO createSavingAccount(Integer tenor, BigDecimal firstAmount, BigDecimal monthlyAmount, String purpose ){
        InstallmentSavingEntity entity = new InstallmentSavingEntity();
        entity.setId(0);
        entity.setTenor(tenor);
        entity.setFirstDepositAmount(firstAmount);
        entity.setMonthlyDepositAmount(monthlyAmount);
        entity.setPurpose(purpose);
        entity.setCreationDate(Instant.now());
        entity.setStatus(Status.ACTIVE);
        InstallmentSavingEntity savedEntity = savingAccountDAO.save(entity);
        return SavingAccountMapper.mapToSavingAccountDTO(savedEntity);
    }

    public void getAllSavings(){

    }

    public void getSavingDetails(String savingAccountId){

    }
}
