package com.example.regularinstallmentsaving;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SavingAccountServiceTest {

    @Autowired
    private SavingAccountService savingAccountService;
    @MockBean
    private SavingAccountDAO savingAccountDAO;
    @MockBean
    private SavingAccountDTO savingAccountDTO;
    @MockBean
    private InstallmentSavingEntity installmentSavingEntity;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void calculateSavingAccount_tenorIsZero_throwException() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage(Message.TENOR_SHOULD_BE_GREATER_THAN_ZERO.label);
        savingAccountService.calculateSavingAccount(0, BigDecimal.valueOf(1000),
                BigDecimal.valueOf(1000)).getEstimatedFinalAmount();
    }

    @Test
    public void calculateSavingAccount_mandatoryFieldsFilled_returnCorrectResult() throws Exception  {
        BigDecimal result = savingAccountService.calculateSavingAccount(3, BigDecimal.valueOf(1000),
                BigDecimal.valueOf(1000)).getEstimatedFinalAmount();
        assertTrue(result.compareTo(BigDecimal.valueOf(3045)) == 0);
    }

    @Test
    public void createSavingAccount_mandatoryFieldsFilled_returnSuccessMessage() throws Exception {
        SavingAccountDTO dto = new SavingAccountDTO();
        dto.setTenor(3);
        dto.setFirstAmount(BigDecimal.valueOf(500));
        dto.setMonthlyAmount(BigDecimal.valueOf(200));
        InstallmentSavingEntity entity = new InstallmentSavingEntity();
        when(savingAccountDAO.save(any(InstallmentSavingEntity.class))).thenReturn(entity);
        SavingAccountDTO savedDto = savingAccountService.createSavingAccount(dto);
        assertTrue(savedDto.getMessage().equals(Message.INSTALLMENT_SAVING_HAS_BEEN_SUCCESSFULLY_CREATED.label));
    }

    @Test
    public void createSavingAccount_mandatoryFieldsNotFilled_throwException() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage(Message.CANNOT_CREATE_INSTALLMENT_SAVING.label);
        savingAccountService.createSavingAccount(savingAccountDTO);
    }

    @Test
    public void getSavingDetails_idPresent_returnNotNull() throws Exception {
        InstallmentSavingEntity entity = setEntity(0);
        when(savingAccountDAO.findById(0)).thenReturn(Optional.of(entity));
        assertNotNull(savingAccountService.getSavingDetails(0));
    }

    @Test
    public void getAllSavings_dataExist_returnNotNull() throws Exception {
        List<InstallmentSavingEntity> entityList = setEntityList();
        when(savingAccountDAO.findAll()).thenReturn(entityList);
        assertNotNull(savingAccountService.getAllSavings());
        assertTrue(entityList.size() == 3);
    }

    private InstallmentSavingEntity setEntity(Integer i){
        InstallmentSavingEntity entity = new InstallmentSavingEntity();
        entity.setId(i);
        entity.setPurpose("Holiday");
        entity.setFirstDepositAmount(BigDecimal.TEN);
        entity.setMonthlyDepositAmount(BigDecimal.TEN);
        entity.setTenor(3);
        return entity;
    }

    private List<InstallmentSavingEntity> setEntityList(){
        List<InstallmentSavingEntity> list = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            list.add(setEntity(i));
        }
        return list;
    }
}
