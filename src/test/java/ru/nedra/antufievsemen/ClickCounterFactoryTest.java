package ru.nedra.antufievsemen;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ru.nedra.antufievsemen.clickercounter.entity.ClickCounter;
import ru.nedra.antufievsemen.clickercounter.factory.ClickCounterFactory;
import ru.nedra.antufievsemen.repository.ClickCounterRepository;

@SpringBootTest
public class ClickCounterFactoryTest {

    @Autowired
    private ClickCounterFactory clickCounterFactory;

    @Autowired
    private ClickCounterRepository clickCounterRepository;

    @Test
    public void getClickerCounterCreateTest() {
        ClickCounter counter = clickCounterFactory.getClickCounter();
        Optional<ClickCounter> counterEntity = clickCounterRepository.findById(counter.getId());
        Assertions.assertTrue(counterEntity.isPresent());
        Assertions.assertEquals(counterEntity.get(), counter);
    }
    @Test
    public void getClickCounterOnlyOneTest() {
        ClickCounter counter1 = clickCounterFactory.getClickCounter();
        ClickCounter counter2 = clickCounterFactory.getClickCounter();
        Assertions.assertEquals(counter1, counter2);
    }

    @Test
    public void incrementClickCounterTest() {
        ClickCounter counter = clickCounterFactory.getClickCounter();
        int number = counter.getCounter();
        clickCounterFactory.incrementClickCounter();
        Assertions.assertEquals(number + 1, counter.getCounter());
    }
}
