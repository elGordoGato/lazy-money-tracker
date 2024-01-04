package org.lazymoneytracker.lazymoneytracker.controller;

import lombok.RequiredArgsConstructor;
import org.lazymoneytracker.lazymoneytracker.dto.AccountDto;
import org.lazymoneytracker.lazymoneytracker.dto.BalanceStat;
import org.lazymoneytracker.lazymoneytracker.service.BalanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class WalletController {
    private final BalanceService balanceService;


    @PostMapping
    public void addBalance(@RequestBody List<AccountDto> accountsEntry){
        balanceService.addBalance(accountsEntry);
    }

    @GetMapping
    public BalanceStat getStat(@PathVariable String currency){
        return balanceService.getStat(currency);
    }
}
