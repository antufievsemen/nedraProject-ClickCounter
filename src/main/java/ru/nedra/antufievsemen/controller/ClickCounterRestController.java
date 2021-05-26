package ru.nedra.antufievsemen.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nedra.antufievsemen.clickercounter.entity.ClickCounter;
import ru.nedra.antufievsemen.service.ClickCounterService;

@RestController
@RequestMapping("click-counter")
public class ClickCounterRestController {

    private final ClickCounterService clickCounterService;

    public ClickCounterRestController(ClickCounterService clickCounterService) {
        this.clickCounterService = clickCounterService;
    }

    @GetMapping
    public ClickCounter getCounter() {
        return clickCounterService.getCounter();
    }

    @PostMapping
    public ClickCounter incrementCounter() {
        return clickCounterService.incrementCounter();
    }

    @MessageMapping("/changeCounter")
    @SendTo("/topic/counter")
    public ClickCounter change(ClickCounter counter) {
        return clickCounterService.incrementCounter();
    }
}
