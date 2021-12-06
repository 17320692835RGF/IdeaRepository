package com.neuedu.springboot_red_bag.dao;

import com.neuedu.springboot_red_bag.domain.LuckyMoney;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ Author     ：Eric Lee
 * @ Date       ：Created in 14:34 2021/9/1
 * @ Description：
 * @ Modified By：
 * @ Version    : 1.0
 */
// JpaRepository<实体类, 主键类型>
public interface LuckyMoneyRepository extends JpaRepository<LuckyMoney, Integer> {
}
