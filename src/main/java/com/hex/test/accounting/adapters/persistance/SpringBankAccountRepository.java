package com.hex.test.accounting.adapters.persistance;

import com.hex.test.accounting.application.domain.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringBankAccountRepository extends CrudRepository<BankAccount, Long> {

}
