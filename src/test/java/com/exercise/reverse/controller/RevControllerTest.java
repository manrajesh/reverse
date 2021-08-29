package com.exercise.reverse.controller;

import com.exercise.reverse.ReverseApplicationTests;
import com.exercise.reverse.error.CustomErrorResponse;
import com.exercise.reverse.service.RevService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class RevControllerTest extends ReverseApplicationTests {
    @MockBean
    RevService revService;

    @Test
    public void whenGetReverseString_validArguments_shouldReturnOk() throws Exception {
        //AAA concept
        //ARRANGE

        Mockito.when(revService.reverseString("canada")).thenReturn("adanac");
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse/")
                .param("value", "canada")
                .contentType(MediaType.ALL_VALUE))
                .andExpect(status().isOk()).andDo(print());

        Mockito.verify(revService, Mockito.times(1)).reverseString("canada");
    }

    @Test
    public void whenGetReverseString_InValidArguments_shouldReturnException() throws Exception {
        //AAA concept
        //ARRANGE

        CustomErrorResponse customErrorResponse = new CustomErrorResponse("ERROR", "getReverseString.value: Param value is required.");
        String expectedApiResponseJson = objectWriter.writeValueAsString(customErrorResponse);

        mockMvc.perform(MockMvcRequestBuilders.get("/reverse/")
                .param("value", " ")
                .contentType(MediaType.ALL_VALUE))
                .andExpect(status().is4xxClientError()).andDo(print())
                .andExpect(jsonPath("$", notNullValue())).andExpect(MockMvcResultMatchers.content().json(expectedApiResponseJson));

        Mockito.verify(revService, Mockito.times(0)).reverseString(" ");
    }

}
