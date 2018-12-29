package com.qa.tests;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qa.base.TestBase;
import com.qa.util.TestUtil;
import com.qa.restclient.RestClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetApiTest extends TestBase {
    private TestBase testBase;
    private String host;
    private String url;
    private RestClient restClient;
    private CloseableHttpResponse closeableHttpResponse;


    @BeforeClass
    public void setUp() {
        testBase = new TestBase();
        host = prop.getProperty("HOST_Weather");
        url = host + "/weather/now.json?key=wnp0hx8rrkty8dte&location=beijing&language=zh-Hans&unit=c";

    }

    @Test
    public void getAPITest() throws  IOException {
        restClient = new RestClient();
        closeableHttpResponse = restClient.get(url);

        int code = closeableHttpResponse.getStatusLine().getStatusCode();
//        断言Assert.assertEquals(“现实结果”, "期待结果","断言失败时候打印日志消息");
        Assert.assertEquals(code,RESPNSE_STATUS_CODE_200,"response status code is not 200");

//        响应内容装到字符串中
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
//        字符串转为json对象
        JSONObject responseJson = JSON.parseObject(responseString);
//        字符串解析
        String s = TestUtil.getValueByJPath(responseJson, "results[0]/location/name");
        Assert.assertEquals(s,"北京","城市应该为北京");
        System.out.println(s);
        //测试测试测试

    }
}
