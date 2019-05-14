package com.njit.stusystem.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * tb_etiquettecheck
 * @author 
 */
@Setter
@Getter
@Accessors(chain = true)
public class Etiquettecheck implements Serializable {
    private Integer id;

    private String schoolYear;

    private String week;

    private String createTime;

    private Integer stuId;

    /**
     * 尊敬师长爱护同学
     */
    private Integer respect;

    /**
     * 守学校纪律
     */
    private Integer keepRules;

    /**
     * 文明礼貌用语
     */
    private Integer civilized;

    /**
     * 衣着整洁讲卫生
     */
    private Integer health;

    /**
     * 升旗认真端正
     */
    private Integer flag;

    private static final long serialVersionUID = 1L;

}