package com.njit.stusystem.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author ZJY
 * @version 1.0
 * @date 2019/5/8 20:16
 */
@Setter
@Getter
@Accessors(chain = true)
public class EtiquetteDTO {
    private Integer id;

    private String schoolYear;

    private String week;

    private String createTime;

    private Integer stuId;
    private String studentName;

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
}
