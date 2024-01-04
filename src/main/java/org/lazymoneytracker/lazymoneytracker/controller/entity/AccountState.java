package org.lazymoneytracker.lazymoneytracker.controller.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AccountState extends PeriodEntry {
    @ManyToOne
    @JoinColumn(name = "period_entry_id")
    private PeriodEntry periodEntry;

    private String currency;

    private int value;

}