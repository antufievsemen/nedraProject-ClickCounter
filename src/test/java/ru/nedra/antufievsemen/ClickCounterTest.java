package ru.nedra.antufievsemen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.nedra.antufievsemen.clickercounter.entity.ClickCounter;

public class ClickCounterTest {

    @Test
    public void clickCounterTest() {
        ClickCounter counter = new ClickCounter();
        counter.setId(2L);
        counter.setCounter(20);
        Assertions.assertEquals(2L, counter.getId());
        Assertions.assertEquals(20, counter.getCounter());
    }

    @Test
    public void incrementCounterTest() {
        ClickCounter counter = new ClickCounter(2L, 1);
        int currentCount = counter.getCounter();
        counter.incrementCounter();
        Assertions.assertEquals(currentCount + 1, counter.getCounter());
    }
}
