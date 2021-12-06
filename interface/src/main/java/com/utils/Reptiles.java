package com.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Reptiles {
    private String url="http://1.192.88.18:18111/release/getMaxTwoDayDate?cityCode=410400";

    public Reptiles() {
    }

    public Reptiles(String url) {
        this.url = url;
    }

    public String get_html(){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response=null;
        String html=new String("");
        HttpGet request = new HttpGet(this.url);
        try{
            response=httpClient.execute(request);
            if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                //获取相应界面
                HttpEntity entity = response.getEntity();
                html= EntityUtils.toString(entity,"UTF-8");
            }else{
//                System.out.println("网页返回值："+response.getStatusLine().getStatusCode());
                html="网页返回值："+response.getStatusLine().getStatusCode();
            }
        }catch(Exception e){
            System.out.println("爬取失败："+this.url);
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
            html="爬取失败："+this.url;
        }
        return html;
    }

   /* public static void main(String[] args) {
        Reptiles reptiles=new Reptiles();
        String html= reptiles.get_html();
        System.out.println(html);
    }*/

}
