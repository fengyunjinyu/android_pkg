package com.storm.a97825.storm.com.example.network;

import android.content.res.AssetManager;
import android.content.res.XmlResourceParser;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OptionalDataException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.lang.String;
import java.util.Objects;

/**
 * Created by 97825 on 2018/2/27.
 * android 使用HttpURLConnection 执行网络请求
 * 参考文件地址
 * http://blog.csdn.net/iispring/article/details/51474529
 * JsonParse 文件
 * https://www.jianshu.com/p/d5eee50c5e24
 */
public class NetUtils {

    protected Map<String , Object> doRequest(){

        Map<String ,Object> result = new HashMap<>();
        URL url = null;
        HttpURLConnection conn = null;

        String requestHeader = null;

        byte[] requestBody = null;

        String responseHeader = null;

        byte[] responseBody = null;

        try{
            url = new URL("http://192.168.1.51/demo/a");
            conn = (HttpURLConnection) url.openConnection();

            //httpURLConnection 默认使用GET请求

            conn.setRequestMethod("GET");
            //设置请求方式

            conn.setDoInput(true);
            ////HttpURLConnection默认也支持从服务端读取结果流，

            conn.setRequestProperty("action" ,"do_get");
            //用setRequestProperty方法设置一个自定义的请求头:action，由于后端判断

            conn.setUseCaches(false);
            requestHeader = getRequestHeader(conn);



        }catch( MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(conn!=null){
                conn.disconnect();
            }
        }

        return null;
    }

    //读取请求头
    private String getRequestHeader(HttpURLConnection conn){
        Map<String ,List<String>> requestHeaderMap = conn.getRequestProperties();
        Iterator<String> requestHeaderIterator = requestHeaderMap.keySet().iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (requestHeaderIterator.hasNext()){
            String requestHeaderKey = requestHeaderIterator.next();
            String requestHeaderValue = conn.getRequestProperty(requestHeaderKey);
            stringBuilder.append(requestHeaderKey);
            stringBuilder.append(":");
            stringBuilder.append(requestHeaderValue);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    //获取响应头信息
    private String getResponseHeader(HttpURLConnection conn){
        Map<String, List<String>> responseHeaderMap = conn.getHeaderFields();
        int size = responseHeaderMap.size();

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<size ; i++){
            String responseHeaderKey = conn.getHeaderFieldKey(i);
            String responseHeaderValue = conn.getHeaderField(i);
            stringBuilder.append(responseHeaderKey);
            stringBuilder.append(":");
            stringBuilder.append(responseHeaderValue);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    //根据字节数组构建utf-8字符串
    private String getStringByBytes(byte[] bytes){
        String str = "";
        try{
            str = new String(bytes , "utf-8");
        }catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }

        return str;
    }

    private byte[] getBytesByInputStream(InputStream is){
        byte[] bytes = null;

        BufferedInputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(baos);

        byte[] buffer = new byte[1024*8];
        int length = 0;
        try{
            while((length = bis.read(buffer))>0){
                bos.write(buffer , 0,length);
            }
            bos.flush();
            bytes = baos.toByteArray();
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                bos.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            try{
                bis.close();

            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return bytes;
    }

    //根据文件名，从asserts目录中读取文件的字节数组
    private byte[] getByteFromAssets(String fileName){
        byte[] bytes = null;
        AssetManager assetManager = null;
        InputStream inputStream = null;

        try{
            inputStream = assetManager.open(fileName);
            bytes = getBytesByInputStream(inputStream);
        }catch(IOException e){
            e.printStackTrace();
        }
        return bytes;
    }

    //将表示XML的字节数组进行解析
    private String parseXmlResultByBytes(byte[] bytes){
        InputStream is = new ByteArrayInputStream(bytes);
        StringBuilder sb = new StringBuilder();
        //List<Person> persons = XmlParser.parse(is);
        //for (Person person : persons) {
        //    sb.append(person.toString()).append("\n");
        //}
        return sb.toString();
    }



}