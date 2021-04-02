package com.bsy.apiservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.niws.client.http.HttpClientLoadBalancerErrorHandler;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "hystrixGet")
public class RemoteController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/remote/ok")
    @HystrixCommand
    public String Ok(){
        return "ok";
    }

    @GetMapping("/remote/lazy")
    @HystrixCommand
    public String LazyHello(int times) {


        String url = "https://www.autohome.com.cn/use/202006/1008011-all.html?pvareaid=3311689";
        for(int i = 0; i < times; i++){
            try {
                CloseableHttpClient client = HttpClients.createDefault();
                String real = url;
                if(url.contains("?"))
                    real = real + "&";
                else
                    real = real + "?";
                real = real + "t=" + i;

                HttpGet httpGet = new HttpGet(real);
                CloseableHttpResponse httpResponse = client.execute(httpGet);
                String result3 = httpResponse.getStatusLine().toString();

            }
            catch (Exception e){

            }
        }

        return "[dev] " + port + " run " + times + " times for [" + url + "]";
    }

    public String hystrixGet() {
        return "error";
    }
}
