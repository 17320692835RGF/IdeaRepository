package com.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.result.Result;
import com.utils.Reptiles;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class reptilesCon {
    private Result result=new Result();
    private Reptiles reptiles=new Reptiles();
    private String  pattern="\\{.*?}";

    @ResponseBody
    @RequestMapping(value="/getData",method={RequestMethod.GET})
    public Result get_Datas(){
        String html = reptiles.get_html();
        ObjectMapper mapper = new ObjectMapper();
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher=compile.matcher(html);
        List<HashMap> list1=new ArrayList<>();
        try{
            while(matcher.find()){
                String temp_group=matcher.group();
                HashMap hashMap = mapper.readValue(temp_group, HashMap.class);
                list1.add(hashMap);
            }
            result.setStatus(200);
            result.setData(list1);
        }catch(Exception e){
            result.setExcept("getData");
        }
        return result;
    }

   /* @Test
    public void getDatas_fun() throws IOException {
        String html = reptiles.get_html();
        ObjectMapper mapper = new ObjectMapper();
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher=compile.matcher(html);
        int count=0;
        List<HashMap> list1=new ArrayList<>();
        while(matcher.find()){
            count++;
            String temp_group=matcher.group();
            HashMap hashMap = mapper.readValue(temp_group, HashMap.class);
            list1.add(hashMap);
        }
        for (HashMap hashMap : list1) {
            System.out.println(hashMap);
        }
    }*/
}
