package com.hex.test.accounting.adapters;

import com.hex.test.accounting.AccountingApplication;
import com.hex.test.accounting.adapters.persistance.BankAccountRepository;
import com.hex.test.accounting.adapters.persistance.SpringBankAccountRepository;
import com.hex.test.accounting.application.domain.BankAccount;
import com.hex.test.accounting.application.services.BankAccountService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = {"com.hex.test.accounting.application.domain"})
public class BeanConfiguration {

    @Bean
    public BankAccountService bankAccountService(BankAccountRepository bankAccountRepository) {
        return new BankAccountService(bankAccountRepository, bankAccountRepository);
    }
}
