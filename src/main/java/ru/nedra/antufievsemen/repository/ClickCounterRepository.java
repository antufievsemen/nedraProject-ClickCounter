package ru.nedra.antufievsemen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nedra.antufievsemen.entity.ClickCounter;

public interface ClickCounterRepository extends JpaRepository<Long, ClickCounter> {

}
