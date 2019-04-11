package com.njit.stusystem.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * tb_admin
 * @author 
 */
@Data
@Accessors(chain = true)
public class Admin implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private static final long serialVersionUID = 1L;

}