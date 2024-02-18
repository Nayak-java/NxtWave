package com.nxtwave.assignment.dto;

import lombok.Builder;
import lombok.Data;

@Builder(builderMethodName = "of")
@Data
public class TodoDto {
    private int id;
    private String todo;
    private String status;
    private String priority;
}
