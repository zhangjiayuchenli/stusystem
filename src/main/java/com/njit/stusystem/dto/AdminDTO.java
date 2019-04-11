package com.njit.stusystem.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true )
public class AdminDTO {
    private Integer id;
    private String username;
    private String password;
}
