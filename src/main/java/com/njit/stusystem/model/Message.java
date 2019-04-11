package com.njit.stusystem.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * tb_message
 * @author 
 */
@Data
@Accessors(chain = true)
public class Message implements Serializable {
    private Integer id;

    private String avatar;

    private String title;

    private String datetime;

    private String type;

    private Integer userId;

    /**
     * 默认为1未读，0为已读
     */
    private Integer status ;

    private static final long serialVersionUID = 1L;


}