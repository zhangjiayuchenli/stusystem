package com.njit.stusystem.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Echarts {
    private String x;
    private Integer y;
    private Integer income;
}