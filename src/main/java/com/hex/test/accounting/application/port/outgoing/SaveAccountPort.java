package com.hex.test.accounting.application.port.outgoing;

import com.hex.test.accounting.application.domain.BankAccount;

import java.util.Optional;

public interface SaveAccountPort {

    void save(BankAccount bankAccount);
}
