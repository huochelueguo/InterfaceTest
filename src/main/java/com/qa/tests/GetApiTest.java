package com.qa.tests;


import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.TestWeather;
import com.qa.restclient.RestClient;

public class GetApiTest extends TestWeather{
    TestWeather testBase;
    String host;
    String url;
    RestClient restClient;


    @BeforeClass
    public void setUp() {
        testBase = new TestWeather();
        host = prop.getProperty("HOST");
        url = host + "/weather/now.json?key=wnp0hx8rrkty8dte&location=beijing&language=zh-Hans&unit=c";

    }

    @Test
    public void getAPITest() throws ClientProtocolException, IOException {
        restClient = new RestClient();
        restClient.get(url);
    }
}
