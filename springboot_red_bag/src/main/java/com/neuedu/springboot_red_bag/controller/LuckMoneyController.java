package com.neuedu.springboot_red_bag.controller;

import com.neuedu.springboot_red_bag.dao.LuckyMoneyRepository;
import com.neuedu.springboot_red_bag.domain.LuckyMoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ Author     ：Eric Lee
 * @ Date       ：Created in 14:50 2021/9/1
 * @ Description：
 * @ Modified By：
 * @ Version    : 1.0
 */
@RestController
@RequestMapping("/bag")
public class LuckMoneyController {
    @Autowired
    private LuckyMoneyRepository repository;

    @GetMapping("/list")
    public List<LuckyMoney> listAll(){
        return repository.findAll();
    }
    @PostMapping("/post")
    public LuckyMoney postRedBag(@RequestParam(value = "producer", required = true) String producer,
                                 @RequestParam(value = "money", required = true) BigDecimal money){
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setMoney(money);
        luckyMoney.setProducer(producer);
        return repository.save(luckyMoney);
    }
    @GetMapping("/find/{id}")
    public LuckyMoney findById(@PathVariable("id") Integer id){
        return repository.findOne(id);
    }

    @PutMapping("/put/{id}")
    public LuckyMoney put(@PathVariable("id")Integer id,
                          @RequestParam(value = "consumer", required = true)String consumer){
        LuckyMoney luckyMoney = repository.findOne(id);
        if (luckyMoney!=null){
            luckyMoney.setConsumer(consumer);
            return repository.save(luckyMoney);
        }
        return null;
    }













}
