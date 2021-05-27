package ru.nedra.antufievsemen;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nedra.antufievsemen.clickercounter.entity.ClickCounter;
import ru.nedra.antufievsemen.repository.ClickCounterRepository;

@SpringBootTest
public class ClickCounterRepositoryTest {

    @Autowired
    private ClickCounterRepository clickCounterRepository;

    @Test
    public void saveEntityClickCounterTest() {
        ClickCounter counter = new ClickCounter(10);
        clickCounterRepository.saveAndFlush(counter);
        Optional<ClickCounter> testCounter = clickCounterRepository.findById(counter.getId());
        Assertions.assertTrue(testCounter.isPresent());
        Assertions.assertEquals(testCounter.get(), counter);
    }

    @Test
    public void updateEntityClickCounterTest() {
        ClickCounter counter = new ClickCounter(2L, 10);
        clickCounterRepository.saveAndFlush(counter);
        counter.setCounter(15);
        clickCounterRepository.saveAndFlush(counter);
        Optional<ClickCounter> testCounter = clickCounterRepository.findById(2L);
        Assertions.assertTrue(testCounter.isPresent());
        Assertions.assertEquals(counter, testCounter.get());
    }
}
