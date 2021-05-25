package ru.nedra.antufievsemen.clickercounter.entity;

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
}
