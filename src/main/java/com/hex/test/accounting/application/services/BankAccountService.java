package com.hex.test.accounting.application.services;

import com.hex.test.accounting.application.domain.BankAccount;
import com.hex.test.accounting.application.port.incoming.DepositUseCase;
import com.hex.test.accounting.application.port.outgoing.LoadAccountPort;
import com.hex.test.accounting.application.port.outgoing.SaveAccountPort;
import com.hex.test.accounting.application.port.incoming.WithdrawUseCase;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

public class BankAccountService implements DepositUseCase, WithdrawUseCase {

    private final LoadAccountPort loadAccountPort;
    private final SaveAccountPort saveAccountPort;

    public BankAccountService(LoadAccountPort loadAccountPort, SaveAccountPort saveAccountPort) {
        this.loadAccountPort = loadAccountPort;
        this.saveAccountPort = saveAccountPort;
    }

    @Override
    public void deposit(Long id, BigDecimal amount) {
        BankAccount account = loadAccountPort.load(id)
                .orElseThrow(NoSuchElementException::new);
        account.deposit(amount);

        saveAccountPort.save(account);
    }

    @Override
    public boolean withdraw(Long id, BigDecimal amount) {
        BankAccount account = loadAccountPort.load(id)
                .orElseThrow(NoSuchElementException::new);
        boolean hasWithdrawn = account.withdraw(amount);

        if(hasWithdrawn) {
            saveAccountPort.save(account);
        }
        return hasWithdrawn;
    }
}
