package com.storm.a97825.storm.com.example.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by 97825 on 2018/1/18.
 * 关于网络请求获取数据
 */
public class GetData {
    //从字节流中读取数据
    public static byte[] read(InputStream inStream) throws Exception{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = inStream.read(buffer))!=-1){
            outputStream.write(buffer , 0 , len);
        }
        inStream.close();
        return outputStream.toByteArray();
    }

    //定义一个获取网络图片数据的方法:
    public static byte[] getImage(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();

        connection.setConnectTimeout(5000);
        connection.setRequestMethod("GET");
        if(connection.getResponseCode() != 200){
            throw new RuntimeException("请求url失败");
        }

        InputStream inStream = connection.getInputStream();
        byte[] bt = read(inStream);
        inStream.close();

        return bt;
    }

    //获取网页的html源码
    public static String getHtml(String path) throws Exception{
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        if(conn.getResponseCode() != 200){
            InputStream in = conn.getInputStream();
            byte[] data = read(in);
            String html = new String(data , "UTF-8");
            return html;
        }

        return null;
    }

    //执行Post请求
    public static String doPost(String url ,String[] params){
        String msg = "";

        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            //设置运行输入输出
            conn.setDoInput(true);
            conn.setDoOutput(true);

            //Post方式不缓存
            conn.setUseCaches(false);
            //参数编码格式
            //URLEncoder.encode("zhangge" ,"UTF-8");
            String data = "password="+ URLEncoder.encode("zhangge" ,"UTF-8")+"&number=12";


            //获取输出流
            OutputStream out = conn.getOutputStream();
            out.write(data.getBytes());
            out.flush();

            if(conn.getResponseCode() == 200){
                //获取响应的输入流对象
                InputStream is = conn.getInputStream();
                //创建字节流兑现
                ByteArrayOutputStream message = new ByteArrayOutputStream();

                int len = 0;
                byte buffer[] = new byte[1024];

                while((len = is.read(buffer)) !=-1){
                    message.write(buffer , 0 , len);

                }
                //释放资源
                is.close();
                message.close();
                //返回字符串
                msg = new String(message.toByteArray());
                return msg;
            }
        }catch (Exception e){
            e.printStackTrace();

        }
        return msg;

    }
}