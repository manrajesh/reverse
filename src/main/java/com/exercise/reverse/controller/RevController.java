package com.exercise.reverse.controller;

import com.exercise.reverse.service.RevService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@Validated
@Slf4j
@RequestMapping("/reverse")
public class RevController {

    @Autowired
    RevService revService;

    @GetMapping(produces = MediaType.ALL_VALUE)
    public Object getReverseString(@RequestParam @NotBlank(message = "Param value is required.") String value) {
        log.info("++++++ In getReverseString Controller ++++++++");
        return revService.reverseString(value);
    }
}
