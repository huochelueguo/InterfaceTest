

//请求方法的封装


package com.qa.restclient;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class RestClient {

   /* //1. Get 请求方法
    public void get(String url) throws ClientProtocolException, IOException {

        //创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //创建一个HttpGet的请求对象
        HttpGet httpget = new HttpGet(url);
        //执行请求,相当于postman上点击发送按钮，然后赋值给HttpResponse对象接收
        CloseableHttpResponse httpResponse = httpclient.execute(httpget);
        //拿到Http响应状态码，例如和200,404,500去比较
        int responseStatusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println("response status code -->"+responseStatusCode);
        //把响应内容存储在字符串对象
        String responseString = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        //创建Json对象，把上面字符串序列化成Json对象
        JSONObject responseJson = JSON.parseObject(responseString);
        System.out.println("respon json from API-->" + responseJson);
        //获取响应头信息,返回是一个数组
        Header[] headerArray = httpResponse.getAllHeaders();
        //创建一个hashmap对象，通过postman可以看到请求响应头信息都是Key和value得形式，所以我们想起了HashMap
        HashMap<String, String> hm = new HashMap<String, String>();
        //增强for循环遍历headerArray数组，依次把元素添加到hashmap集合
        for(Header header : headerArray) {
            hm.put(header.getName(), header.getValue());
        }
        //打印hashmap
        System.out.println("response headers -->"+ hm);
    }*/
   //1. Get 请求方法
    public CloseableHttpResponse  get (String url) throws IOException {
//        （1）创建HttpClient对象。
        CloseableHttpClient HttpClient = HttpClients.createDefault();
//        （2）创建httpget请求对象
        HttpGet httpGet = new HttpGet(url);
//        （3）创建http请求，执行请求,相当于postman上点击发送按钮，然后赋值给HttpResponse对象接收
        CloseableHttpResponse httpResponse ;
        httpResponse   = HttpClient.execute(httpGet);
        return  httpResponse;
    }

//    2.Get请求，请求内容在map中
    public CloseableHttpResponse get(String url,HashMap<String,String> headermap) throws IOException {
//        创建一个可关闭的HttpClient对象
        CloseableHttpClient httpclient  = HttpClients.createDefault();
//        创建一个HttpGet的请求对象
        HttpGet httpGet = new HttpGet(url);
//        加载请求头到httpget对象
//        通过Map.Entry遍历headermap的key和value，并将遍历出来的值加到heepGet上
        for (Map.Entry<String,String>entry:headermap.entrySet()
             ) {
            httpGet.addHeader(entry.getKey(),entry.getValue());
        }
        //执行请求,相当于postman上点击发送按钮，然后赋值给HttpResponse对象接收
        CloseableHttpResponse httpResponse1;
        httpResponse1= httpclient.execute(httpGet);
        return httpResponse1;
    }

//    3.Post请求，参数为JSON，放在请求体中
    public CloseableHttpResponse post(String url,String entityString,HashMap<String,String>headermap) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
//        创建HttpPost对象
        HttpPost httpPost = new HttpPost(url);
//        请求头参数传入请求中
        for (Map.Entry<String,String>entry:headermap.entrySet()
             ) {
            httpPost.addHeader(entry.getKey(),entry.getValue());
        }
//        请求体传入参数，并且为JSON格式
        StringEntity entity = new StringEntity(entityString,Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
//        发送请求，并且接收返回值
        CloseableHttpResponse closeableHttpResponse ;
        closeableHttpResponse = httpClient.execute(httpPost);
        return  closeableHttpResponse;
    }

}
