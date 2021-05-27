package ru.nedra.antufievsemen.clickercounter.entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClickCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    Integer counter;

    public ClickCounter() {
        counter = 0;
    }

    public ClickCounter(Long id, Integer counter) {
        this.id = id;
        this.counter = counter;
    }

    public ClickCounter(Integer counter) {
        this.counter = counter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public void incrementCounter() {
        this.counter++;
    }

    @Override
    public String toString() {
        return "ClickCounter{" +
                "id=" + id +
                ", counter=" + counter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClickCounter)) return false;
        ClickCounter counter1 = (ClickCounter) o;
        return id.equals(counter1.id) && counter.equals(counter1.counter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, counter);
    }
}
