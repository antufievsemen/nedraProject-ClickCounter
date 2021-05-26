package ru.nedra.antufievsemen.clickercounter.factory;

import java.util.Optional;
import org.springframework.stereotype.Component;
import ru.nedra.antufievsemen.clickercounter.entity.ClickCounter;
import ru.nedra.antufievsemen.repository.ClickCounterRepository;

@Component
public class ClickCounterFactory {

    private final ClickCounterRepository clickCounterRepository;
    private ClickCounter counter;

    public ClickCounterFactory(ClickCounterRepository clickCounterRepository) {
        this.clickCounterRepository = clickCounterRepository;
    }

    public ClickCounter getClickCounter() {
        if (counter == null) {
            Optional<ClickCounter> counter = clickCounterRepository.findById(1L);
            if (counter.isEmpty()) {
                this.counter = new ClickCounter();
                return clickCounterRepository.saveAndFlush(this.counter);
            }
            this.counter = counter.get();
        }
        return this.counter;
    }

    public void incrementClickCounter() {
        counter.incrementCounter();
        clickCounterRepository.saveAndFlush(counter);
    }
}
