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
    public SavingAccountDTO calculateSavingAccount(Integer tenor, BigDecimal firstAmount, BigDecimal monthlyAmount)
            throws Exception {
        validateInput(tenor, firstAmount, monthlyAmount);
        BigDecimal grandTotal = firstAmount.add(monthlyAmount.multiply(BigDecimal.valueOf(tenor - 1)));
        BigDecimal interestRate = BigDecimal.valueOf(tenor).divide(new BigDecimal(12), 10, BigDecimal.ROUND_UP)
                .multiply(BigDecimal.valueOf(6)).divide(BigDecimal.valueOf(100));
        BigDecimal estimatedFinalAmount = interestRate.multiply(grandTotal).add(grandTotal);
        SavingAccountDTO dto = new SavingAccountDTO();
        dto.setEstimatedFinalAmount(estimatedFinalAmount);
        return dto;
    }

    private void validateInput(Integer tenor, BigDecimal firstAmount, BigDecimal monthlyAmount) throws Exception {
        if (tenor < 1){
            throw new Exception(Message.TENOR_SHOULD_BE_GREATER_THAN_ZERO.label);
        }
        if (firstAmount.compareTo(BigDecimal.ZERO) < 1 || monthlyAmount.compareTo(BigDecimal.ZERO) < 1) {
            throw new Exception(Message.AMOUNT_SHOULD_BE_GREATER_THAN_ZERO.label);
        }
    }

    @Override
    public SavingAccountDTO createSavingAccount(SavingAccountDTO dto) throws Exception {
        try {
            SavingAccountDTO savedDto = new SavingAccountDTO();
            validateInput(dto.getTenor(), dto.getFirstAmount(), dto.getMonthlyAmount());
            InstallmentSavingEntity entity = SavingAccountMapper.mapToInstallmentSavingEntity(dto);
            entity.setCreationDate(Instant.now());
            entity.setStatus(Status.ACTIVE);
            InstallmentSavingEntity savedEntity = savingAccountDAO.save(entity);
            savedDto = SavingAccountMapper.mapToSavingAccountDTO(savedEntity);
            savedDto.setMessage(Message.INSTALLMENT_SAVING_HAS_BEEN_SUCCESSFULLY_CREATED.label);
            return savedDto;
        } catch (Exception e) {
            throw new Exception(Message.CANNOT_CREATE_INSTALLMENT_SAVING.label);
        }
    }

    @Override
    public List<SavingAccountDTO> getAllSavings() {
        Iterable<InstallmentSavingEntity> iterable = savingAccountDAO.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .map(SavingAccountMapper::mapToSavingAccountDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SavingAccountDTO> getSavingDetails(Integer savingAccountId)  {
        return savingAccountDAO.findById(savingAccountId).map(SavingAccountMapper::mapToSavingAccountDTO);
    }
}
