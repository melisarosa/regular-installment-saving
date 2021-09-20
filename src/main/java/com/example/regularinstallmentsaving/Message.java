package com.example.regularinstallmentsaving;

public enum Message {
    INSTALLMENT_SAVING_HAS_BEEN_SUCCESSFULLY_CREATED("Installment Saving has been successfully created."),
    CANNOT_CREATE_INSTALLMENT_SAVING("Cannot create Installment Saving."),
    TENOR_SHOULD_BE_GREATER_THAN_ZERO("Tenor should be greater than zero."),
    AMOUNT_SHOULD_BE_GREATER_THAN_ZERO("Amount should be greater than zero.");

    public final String label;

    Message(String label) {
        this.label = label;
    }
}
