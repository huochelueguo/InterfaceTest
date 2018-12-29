package com.qa.tests;

import com.alibaba.fastjson.JSON;
import com.qa.base.TestBase;
import com.qa.data.Login;
import com.qa.restclient.RestClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class LoginTest extends TestBase {
    TestBase testBase;
    String host;
    String url;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;

    @BeforeClass
    public void setUp() {
        testBase = new TestBase();
        host = prop.getProperty("HOST_QddTest");
        url = host + "/public/user/logon.do";
    }

    @Test
    public void loginTest() throws IOException {
        restClient = new RestClient();
//        请求头内容
        HashMap<String,String> headermap = new HashMap<String,String>();
        headermap.put("Content-Type","application/json");
        headermap.put("ContentEncoding","UTF-8");
//        请求体内容，转换为JSON字符串
        Login login;
        login = new Login("121314","3.1.4","4cEZeSc81Fso@8jD4RnMR$ti7xM#ecM8","{\"mobile\":\"18500616906\",\"password\":\"123456\"}");
        String userLoginJson = JSON.toJSONString(login);
        System.out.println(url);
        System.out.println(userLoginJson);
        System.out.println(headermap);
//        调用restClient中的post方法，并接收返回值
        closeableHttpResponse = restClient.post(url, userLoginJson, headermap);
//        判断语句
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,RESPNSE_STATUS_CODE_200,"Wrong");

    }




}
