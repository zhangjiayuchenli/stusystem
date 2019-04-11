package com.njit.stusystem.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MessageDTO {
    private Integer id;

    private String avatar;

    private String title;

    private String datetime;

    private String type;

    private Integer userId;
}
