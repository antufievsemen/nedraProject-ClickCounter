package ru.nedra.antufievsemen.clickercounter.factory;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.nedra.antufievsemen.clickercounter.entity.ClickCounter;
import ru.nedra.antufievsemen.repository.ClickCounterRepository;

@Component
public class ClickCounterFactory {

    @Autowired
    private ClickCounterRepository clickCounterRepository;
    private ClickCounter counter;

    private ClickCounterFactory(){}

    /*
    * Сделал данный метод для работы с одним инстансом ClickCounter`а.
    * После перезапуска сервера счетчик не сбрасывается, так как мы достаем его из бд.
    * При первом запуске сервера создается единственная запись в таблице и дальше используется только она.
     */

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

    public ClickCounter incrementClickCounter() {
        counter.incrementCounter();
        return clickCounterRepository.saveAndFlush(counter);
    }
}
