package com.exercise.reverse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest(classes = {ReverseApplication.class})
@AutoConfigureMockMvc
public abstract class ReverseApplicationTests {

    protected ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
    protected MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
}
