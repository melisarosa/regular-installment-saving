package com.example.regularinstallmentsaving;

public class SavingAccountMapper {

    public static SavingAccountDTO mapToSavingAccountDTO(InstallmentSavingEntity entity){
        SavingAccountDTO dto = new SavingAccountDTO();
        dto.setTenor(entity.getTenor());
        dto.setFirstAmount(entity.getFirstDepositAmount());
        dto.setMonthlyAmount(entity.getMonthlyDepositAmount());
        dto.setSavingId(entity.getId());
        dto.setStatus(entity.getStatus());
        return dto;
    }
}
