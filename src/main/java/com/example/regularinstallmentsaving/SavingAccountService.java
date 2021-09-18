package com.example.regularinstallmentsaving;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface SavingAccountService {
    SavingAccountDTO calculateSavingAccount(Integer tenor, BigDecimal firstAmount, BigDecimal monthlyAmount);

    SavingAccountDTO createSavingAccount(SavingAccountDTO dto);

    List<SavingAccountDTO> getAllSavings();

    Optional<SavingAccountDTO> getSavingDetails(Integer savingAccountId);
}
