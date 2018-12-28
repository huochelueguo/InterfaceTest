//所有接口请求测试的父类，都要继承这个类，实现加载读取properties文件
package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public Properties prop;
    public int RESPNSE_STATUS_CODE_200 = 200;
    public int RESPNSE_STATUS_CODE_201 = 201;
    public int RESPNSE_STATUS_CODE_404 = 404;
    public int RESPNSE_STATUS_CODE_500 = 500;

    public TestBase() {

        try {
            prop = new Properties();
            //读取Property文件
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
                    "/src/main/java/com/qa/config/config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
