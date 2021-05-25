package ru.nedra.antufievsemen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nedra.antufievsemen.clickercounter.entity.ClickCounter;

public interface ClickCounterRepository extends JpaRepository<ClickCounter, Long> {
}
