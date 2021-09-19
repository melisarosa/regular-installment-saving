package com.example.regularinstallmentsaving;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface SavingAccountService {
    SavingAccountDTO calculateSavingAccount(Integer tenor, BigDecimal firstAmount, BigDecimal monthlyAmount) throws Exception;

    SavingAccountDTO createSavingAccount(SavingAccountDTO dto) throws Exception;

    List<SavingAccountDTO> getAllSavings();

    Optional<SavingAccountDTO> getSavingDetails(Integer savingAccountId) throws Exception;
}
