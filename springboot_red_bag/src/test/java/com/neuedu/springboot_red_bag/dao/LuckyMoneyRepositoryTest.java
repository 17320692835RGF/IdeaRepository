package com.neuedu.springboot_red_bag.dao;

import com.neuedu.springboot_red_bag.domain.LuckyMoney;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuckyMoneyRepositoryTest {
    //注入Bean
    @Autowired
    private LuckyMoneyRepository repository;
    @Test
    public void listAll(){
        List<LuckyMoney> list = repository.findAll();
        for (LuckyMoney luckyMoney : list)
            System.out.println(luckyMoney);
    }

    @Test
    public void save(){
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setConsumer("李四");
        luckyMoney.setMoney(new BigDecimal(11));
        luckyMoney.setProducer("张三");
//        repository.save(luckyMoney);
        // save 正常的保存
        // saveAndFlush 是 在同一事物下提交前就保存
        repository.saveAndFlush(luckyMoney);
    }
    @Test
    public void save2(){
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setConsumer("李四");
        luckyMoney.setMoney(new BigDecimal(11));
        luckyMoney.setProducer("张三");
//        repository.save(luckyMoney);
        // save 正常的保存
        // saveAndFlush 是 在同一事物下提交前就保存
        repository.saveAndFlush(luckyMoney);
    }
    @Test
    public void update(){
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setConsumer("王五");
        luckyMoney.setMoney(new BigDecimal(21));
        luckyMoney.setProducer("赵六");
        luckyMoney.setId(2);
        repository.save(luckyMoney);
    }

    @Test
    public void getById(){
        LuckyMoney luckyMoney = repository.findOne(2);
        System.out.println(luckyMoney);
    }

    @Test
    public void delete(){
        repository.delete(3);
    }

}