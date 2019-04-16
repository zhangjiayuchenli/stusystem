package com.njit.stusystem.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
/**
 * @author ZJY
 * @version 1.0
 * @date 2019/4/15 17:38
 */
@Getter
@Setter
@Accessors(chain = true )
public class AdminDTO {
    private Integer id;
    private String username;
    private String password;
}
