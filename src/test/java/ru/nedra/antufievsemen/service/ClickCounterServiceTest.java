package ru.nedra.antufievsemen.service;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nedra.antufievsemen.clickercounter.entity.ClickCounter;
import ru.nedra.antufievsemen.repository.ClickCounterRepository;
import ru.nedra.antufievsemen.service.ClickCounterService;

@SpringBootTest
public class ClickCounterServiceTest {

    @Autowired
    private ClickCounterService clickCounterService;

    @Autowired
    private ClickCounterRepository clickCounterRepository;

    @Test
    public void clickCounterServiceGetOneTest() {
        ClickCounter counter = clickCounterService.getCounter();
        Optional<ClickCounter> counterTest = clickCounterRepository.findById(counter.getId());
        Assertions.assertTrue(counterTest.isPresent());
        Assertions.assertEquals(counterTest.get(), counter);
    }

    @Test
    public void clickCounterServiceGetTheSameTest() {
        ClickCounter counter1 = clickCounterService.getCounter();
        ClickCounter counter2 = clickCounterService.getCounter();
        Assertions.assertEquals(counter1, counter2);
    }

    @Test
    public void incrementClickCounterServiceTest() {
        ClickCounter counter = clickCounterService.getCounter();
        int number = counter.getCounter();
        clickCounterService.incrementCounter();
        Assertions.assertEquals(number + 1, counter.getCounter());
    }
}
