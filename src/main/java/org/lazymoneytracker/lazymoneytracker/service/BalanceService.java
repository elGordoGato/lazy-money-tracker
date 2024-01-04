package org.lazymoneytracker.lazymoneytracker.service;

import org.lazymoneytracker.lazymoneytracker.dto.AccountDto;
import org.lazymoneytracker.lazymoneytracker.dto.BalanceStat;

import java.util.List;

public interface BalanceService {
    void addBalance(List<AccountDto> accounts);

    BalanceStat getStat(String currency);
}
