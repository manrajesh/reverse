package com.exercise.reverse.service;

import com.exercise.reverse.ReverseApplicationTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RevServiceTest extends ReverseApplicationTests {

    @Autowired
    RevService revService;

    @Test
    public void whenReverseString_validArguments_shouldReturnOk() throws Exception {
        String result = revService.reverseString("developer");
        Assertions.assertEquals("repoleved", result);
    }

}
