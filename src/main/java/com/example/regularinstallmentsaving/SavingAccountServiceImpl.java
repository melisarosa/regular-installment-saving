package com.example.regularinstallmentsaving;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SavingAccountServiceImpl implements SavingAccountService {

    @Autowired
    private SavingAccountDAO savingAccountDAO;

    @Override
    public SavingAccountDTO calculateSavingAccount(Integer tenor, BigDecimal firstAmount, BigDecimal monthlyAmount){
        BigDecimal grandTotal = firstAmount.add(monthlyAmount.multiply(BigDecimal.valueOf(tenor - 1)));
        BigDecimal interestRate = BigDecimal.valueOf(tenor).divide(new BigDecimal(12))
                .multiply(BigDecimal.valueOf(6)).divide(BigDecimal.valueOf(100));
        BigDecimal estimatedFinalAmount = interestRate.multiply(grandTotal).add(grandTotal);
        SavingAccountDTO dto = new SavingAccountDTO();
        dto.setEstimatedFinalAmount(estimatedFinalAmount);
        return dto;
    }

    @Override
    public SavingAccountDTO createSavingAccount(SavingAccountDTO dto) {
        InstallmentSavingEntity entity = SavingAccountMapper.mapToInstallmentSavingEntity(dto);
        entity.setCreationDate(Instant.now());
        entity.setStatus(Status.ACTIVE);
        InstallmentSavingEntity savedEntity = savingAccountDAO.save(entity);
        return SavingAccountMapper.mapToSavingAccountDTO(savedEntity);
    }

    @Override
    public List<SavingAccountDTO> getAllSavings() {
        Iterable<InstallmentSavingEntity> iterable = savingAccountDAO.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(SavingAccountMapper::mapToSavingAccountDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SavingAccountDTO> getSavingDetails(Integer savingAccountId){
        return savingAccountDAO.findById(savingAccountId).map(SavingAccountMapper::mapToSavingAccountDTO);
    }
}
