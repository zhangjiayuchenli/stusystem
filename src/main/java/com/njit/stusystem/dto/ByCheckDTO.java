package com.njit.stusystem.dto;

import io.swagger.models.auth.In;
import lombok.Data;

import java.util.List;

/**
 * @author ZJY
 * @version 1.0
 * @date 2019/5/9 15:46
 */
@Data
public class ByCheckDTO {
    private List<String> year;
    private List<String> week;

    private List<Integer> list;
}
