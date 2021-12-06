package com.neuedu.springboot_red_bag.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @ Author     ：Eric Lee
 * @ Date       ：Created in 14:30 2021/9/1
 * @ Description：
 * @ Modified By：
 * @ Version    : 1.
 * // @Data lombok插件的一个注解，标识此注解的实体类不用自己写get和set方法了
 * // @Entity 指定该类是实体类、
 */
@Entity
@Data
public class LuckyMoney {
    //@Id 代表主键 @GeneratedValue代表自增长
    @Id
    @GeneratedValue
    private Integer id;
    // 红包金额
    private BigDecimal money;
    // 发红包的人
    private String producer;
    // 收红包的人
    private String consumer;
    public LuckyMoney(){
    }
}
