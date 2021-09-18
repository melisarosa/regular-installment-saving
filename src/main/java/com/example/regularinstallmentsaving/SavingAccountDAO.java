package com.example.regularinstallmentsaving;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingAccountDAO extends CrudRepository<InstallmentSavingEntity, Integer> {

}
