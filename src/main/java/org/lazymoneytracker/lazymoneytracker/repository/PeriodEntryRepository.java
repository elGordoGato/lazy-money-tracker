package org.lazymoneytracker.lazymoneytracker.repository;

import org.lazymoneytracker.lazymoneytracker.controller.entity.PeriodEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodEntryRepository extends JpaRepository<PeriodEntry, Long> {
}
