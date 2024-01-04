package org.lazymoneytracker.lazymoneytracker.service;

import lombok.RequiredArgsConstructor;
import org.lazymoneytracker.lazymoneytracker.controller.entity.AccountState;
import org.lazymoneytracker.lazymoneytracker.controller.entity.PeriodEntry;
import org.lazymoneytracker.lazymoneytracker.dto.AccountDto;
import org.lazymoneytracker.lazymoneytracker.dto.BalanceStat;
import org.lazymoneytracker.lazymoneytracker.repository.PeriodEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {
    private final PeriodEntryRepository periodEntryRepository;

    @Override
    public void addBalance(List<AccountDto> accountsEntry) {
        PeriodEntry entry = new PeriodEntry();
        List<AccountState> accounts = accountsEntry.stream()
                .collect(Collectors.groupingBy(AccountDto::getCurrency))
                .entrySet().stream()
                .map(e -> new AccountState(
                        entry,
                        e.getKey(),
                        e.getValue().stream()
                                .mapToInt(AccountDto::getValue)
                                .sum())
                )
                // Collect the result into a list
                .toList();

        entry.setEntries(accounts);
        periodEntryRepository.save(entry);
    }

    @Override
    public BalanceStat getStat(String currency) {
        return null;
    }
}
