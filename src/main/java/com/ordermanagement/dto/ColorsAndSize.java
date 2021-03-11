package com.ordermanagement.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ColorsAndSize {
    private Set<String> size;
    private Set<String> colors;
}
