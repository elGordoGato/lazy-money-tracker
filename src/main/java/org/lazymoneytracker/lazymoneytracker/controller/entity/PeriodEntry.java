package org.lazymoneytracker.lazymoneytracker.controller.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.Currency;
import java.util.List;
import java.util.Map;

@Entity
public class PeriodEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate timestamp;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "periodEntry")
    private List<AccountState> entries;

    public List<AccountState> getEntries() {
        return entries;
    }

    public void setEntries(List<AccountState> entries) {
        this.entries = entries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
