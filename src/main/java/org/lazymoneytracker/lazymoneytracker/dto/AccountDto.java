package org.lazymoneytracker.lazymoneytracker.dto;

import lombok.Data;

@Data
public class AccountDto {
    private String currency;
    private int value;
}
