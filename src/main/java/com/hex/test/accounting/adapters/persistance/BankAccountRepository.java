package com.hex.test.accounting.adapters.persistance;

import com.hex.test.accounting.application.domain.BankAccount;
import com.hex.test.accounting.application.port.outgoing.LoadAccountPort;
import com.hex.test.accounting.application.port.outgoing.SaveAccountPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BankAccountRepository implements LoadAccountPort, SaveAccountPort {

    private final SpringBankAccountRepository bankAccountRepository;

    public BankAccountRepository(SpringBankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public Optional<BankAccount> load(Long id) {
        return this.bankAccountRepository.findById(id);
    }

    @Override
    public void save(BankAccount bankAccount) {
        this.bankAccountRepository.save(bankAccount);
    }
}
