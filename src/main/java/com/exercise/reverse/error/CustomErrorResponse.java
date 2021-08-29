package com.exercise.reverse.error;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CustomErrorResponse {

    private String statusType;
    private String message;
}