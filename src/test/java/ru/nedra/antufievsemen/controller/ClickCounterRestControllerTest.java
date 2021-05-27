package ru.nedra.antufievsemen.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.nedra.antufievsemen.controller.ClickCounterRestController;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClickCounterRestController.class)
public class ClickCounterRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    /*
     * Сделать должны были быть тесты для RestController`а
     */

//    @Test
//    public void testReturn200() {
//        mockMvc.perform(post("/click-counter")
//                .andExpect(status().isOk())
//                .andExpect(content()
//                    .contentTypeCompatibleWith(MediaType.APPLICATION_JSON)));
//    }
}
