package ru.nedra.antufievsemen.service;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.nedra.antufievsemen.clickercounter.entity.ClickCounter;
import ru.nedra.antufievsemen.clickercounter.factory.ClickCounterFactory;

@Service
public class ClickCounterService {

    private final ClickCounterFactory clickCounterFactory;

    public ClickCounterService(ClickCounterFactory clickCounterFactory) {
        this.clickCounterFactory = clickCounterFactory;
    }

    @Transactional
    public ClickCounter incrementCounter() {
        return clickCounterFactory.incrementClickCounter();
    }

    @Transactional
    public ClickCounter getCounter() {
        return clickCounterFactory.getClickCounter();
    }
}
