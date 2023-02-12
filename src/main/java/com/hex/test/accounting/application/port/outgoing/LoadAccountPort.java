package com.hex.test.accounting.application.port.outgoing;

import com.hex.test.accounting.application.domain.BankAccount;

import java.util.Optional;

public interface LoadAccountPort {

    Optional<BankAccount> load(Long id);
}
