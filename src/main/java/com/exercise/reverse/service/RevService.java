package com.exercise.reverse.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RevService {

    public String reverseString(String reverse) {
        log.info("++++++ In RevService Service ++++++++");
        char ch[] = reverse.toCharArray();
        String rev = "";
        for (int i = ch.length - 1; i >= 0; i--) {
            rev += ch[i];
        }
        return rev;
    }
}
