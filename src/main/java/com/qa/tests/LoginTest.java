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
        HashMap<String,String> headermap = new HashMap<String,String>();
        headermap.put("Content-Type","application/json");
        headermap.put("ContentEncoding","UTF-8");
        Login login;
        login = new Login("121314","3.1.4","4cEZeSc81Fso@8jD4RnMR$ti7xM#ecM8","{\"mobile\":\"18500616906\",\"password\":\"123456\"}");
        String userLoginJson = JSON.toJSONString(login);
        System.out.println(url);
        System.out.println(userLoginJson);
        System.out.println(headermap);
        closeableHttpResponse = restClient.post(url,userLoginJson,headermap);
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode,RESPNSE_STATUS_CODE_200,"Wrong");

    }




}
