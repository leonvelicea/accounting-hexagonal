package com.hex.test.accounting.application.port.incoming;

import java.math.BigDecimal;

public interface WithdrawUseCase {
    boolean withdraw(Long id, BigDecimal amount);

}
