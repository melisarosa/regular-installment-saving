package com.example.regularinstallmentsaving;

public class SavingAccountMapper {

    public static SavingAccountDTO mapToSavingAccountDTO(InstallmentSavingEntity entity){
        SavingAccountDTO dto = new SavingAccountDTO();
        dto.setTenor(entity.getTenor());
        dto.setFirstAmount(entity.getFirstDepositAmount());
        dto.setMonthlyAmount(entity.getMonthlyDepositAmount());
        dto.setSavingId(entity.getId());
        dto.setStatus(entity.getStatus());
        dto.setPurpose(entity.getPurpose());
        return dto;
    }

    public static InstallmentSavingEntity mapToInstallmentSavingEntity(SavingAccountDTO dto){
        InstallmentSavingEntity entity = new InstallmentSavingEntity();
        entity.setTenor(dto.getTenor());
        entity.setFirstDepositAmount(dto.getFirstAmount());
        entity.setMonthlyDepositAmount(dto.getMonthlyAmount());
        entity.setStatus(dto.getStatus());
        entity.setId(0);
        entity.setPurpose(dto.getPurpose());
        return entity;
    }
}
