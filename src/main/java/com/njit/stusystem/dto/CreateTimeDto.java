package com.njit.stusystem.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author ZJY
 * @version 1.0
 * @date 2019/5/10 22:27
 */
@Data
@Accessors(chain = true)
public class CreateTimeDto {
    private String time;
}
