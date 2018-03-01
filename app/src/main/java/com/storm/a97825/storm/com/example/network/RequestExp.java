package com.storm.a97825.storm.com.example.network;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Created by 97825 on 2018/3/1.
 */
public class RequestExp {
    private String baseUrl ="http://www.baidu.com/";
    private void requestGet(String urls , HashMap<String , String> paramsMap){

        try{
            URL url = new URL(baseUrl+urls) ;
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setUseCaches(false);

            //httpURLConnection 默认使用GET请求
            conn.setRequestMethod("GET");
            //设置请求方式

            conn.setRequestProperty("Content-Type" , "application/json");
            conn.addRequestProperty("Connection" , "Keep-Alive");

            conn.connect();

            if(conn.getResponseCode() ==200){
                String result = streamToString(conn.getInputStream());

                System.out.println(result);

            }else{

            }


        }catch(MalformedURLException e){


        }catch(IOException e){
            e.printStackTrace();
        }

    }

    private void requestPost(HashMap<String, String> paramsMap) {
        try {
            String baseUrl = "https://xxx.com/getUsers";
            //合成参数
            StringBuilder tempParams = new StringBuilder();
            int pos = 0;
            for (String key : paramsMap.keySet()) {
                if (pos > 0) {
                    tempParams.append("&");
                }
                tempParams.append(String.format("%s=%s", key,  URLEncoder.encode(paramsMap.get(key),"utf-8")));
                pos++;
            }
            String params =tempParams.toString();
            // 请求的参数转换为byte数组
            byte[] postData = params.getBytes();
            // 新建一个URL对象
            URL url = new URL(baseUrl);
            // 打开一个HttpURLConnection连接
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            // 设置连接超时时间
            urlConn.setConnectTimeout(5 * 1000);
            //设置从主机读取数据超时
            urlConn.setReadTimeout(5 * 1000);
            // Post请求必须设置允许输出 默认false
            urlConn.setDoOutput(true);
            //设置请求允许输入 默认是true
            urlConn.setDoInput(true);
            // Post请求不能使用缓存
            urlConn.setUseCaches(false);
            // 设置为Post请求
            urlConn.setRequestMethod("POST");
            //设置本次连接是否自动处理重定向
            urlConn.setInstanceFollowRedirects(true);
            // 配置请求Content-Type
            urlConn.setRequestProperty("Content-Type", "application/json");
            // 开始连接
            urlConn.connect();
            // 发送请求参数
            DataOutputStream dos = new DataOutputStream(urlConn.getOutputStream());
            dos.write(postData);
            dos.flush();
            dos.close();
            // 判断请求是否成功
            if (urlConn.getResponseCode() == 200) {
                // 获取返回的数据
                String result = streamToString(urlConn.getInputStream());

            } else {

            }
            // 关闭连接
            urlConn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String streamToString(InputStream is){
        try{
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while( (len = is.read(buffer)) != -1){
                byteArrayOutputStream.write(buffer,0,len);
            }
            byteArrayOutputStream.close();
            is.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return new String(byteArray);

        }catch(IOException e){
            e.printStackTrace();
            return null;

        }
    }

    private void downloadFile(String fileUrl){
        try {
            // 新建一个URL对象
            URL url = new URL(fileUrl);
            // 打开一个HttpURLConnection连接
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            // 设置连接主机超时时间
            urlConn.setConnectTimeout(5 * 1000);
            //设置从主机读取数据超时
            urlConn.setReadTimeout(5 * 1000);
            // 设置是否使用缓存  默认是true
            urlConn.setUseCaches(true);
            // 设置为Post请求
            urlConn.setRequestMethod("GET");
            //urlConn设置请求头信息
            //设置请求中的媒体类型信息。
            urlConn.setRequestProperty("Content-Type", "application/json");
            //设置客户端与服务连接类型
            urlConn.addRequestProperty("Connection", "Keep-Alive");
            // 开始连接
            urlConn.connect();
            // 判断请求是否成功
            if (urlConn.getResponseCode() == 200) {
                String filePath="";
                File  descFile = new File(filePath);
                FileOutputStream fos = new FileOutputStream(descFile);;
                byte[] buffer = new byte[1024];
                int len;
                InputStream inputStream = urlConn.getInputStream();
                while ((len = inputStream.read(buffer)) != -1) {
                    // 写到本地
                    fos.write(buffer, 0, len);
                }
            } else {

            }
            // 关闭连接
            urlConn.disconnect();
        } catch (Exception e) {

        }
    }

    private void upLoadFile(String filePath, HashMap<String, String> paramsMap) {
        try {
            String baseUrl = "https://xxx.com/uploadFile";
            File file = new File(filePath);
            //新建url对象
            URL url = new URL(baseUrl);
            //通过HttpURLConnection对象,向网络地址发送请求
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            //设置该连接允许读取
            urlConn.setDoOutput(true);
            //设置该连接允许写入
            urlConn.setDoInput(true);
            //设置不能适用缓存
            urlConn.setUseCaches(false);
            //设置连接超时时间
            urlConn.setConnectTimeout(5 * 1000);   //设置连接超时时间
            //设置读取超时时间
            urlConn.setReadTimeout(5 * 1000);   //读取超时
            //设置连接方法post
            urlConn.setRequestMethod("POST");
            //设置维持长连接
            urlConn.setRequestProperty("connection", "Keep-Alive");
            //设置文件字符集
            urlConn.setRequestProperty("Accept-Charset", "UTF-8");
            //设置文件类型
            urlConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + "*****");
            String name = file.getName();
            DataOutputStream requestStream = new DataOutputStream(urlConn.getOutputStream());
            requestStream.writeBytes("--" + "*****" + "\r\n");
            //发送文件参数信息
            StringBuilder tempParams = new StringBuilder();
            tempParams.append("Content-Disposition: form-data; name=\"" + name + "\"; filename=\"" + name + "\"; ");
            int pos = 0;
            int size=paramsMap.size();
            for (String key : paramsMap.keySet()) {
                tempParams.append( String.format("%s=\"%s\"", key, paramsMap.get(key), "utf-8"));
                if (pos < size-1) {
                    tempParams.append("; ");
                }
                pos++;
            }
            tempParams.append("\r\n");
            tempParams.append("Content-Type: application/octet-stream\r\n");
            tempParams.append("\r\n");
            String params = tempParams.toString();
            requestStream.writeBytes(params);
            //发送文件数据
            FileInputStream fileInput = new FileInputStream(file);
            int bytesRead;
            byte[] buffer = new byte[1024];
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            while ((bytesRead = in.read(buffer)) != -1) {
                requestStream.write(buffer, 0, bytesRead);
            }
            requestStream.writeBytes("\r\n");
            requestStream.flush();
            requestStream.writeBytes("--" + "*****" + "--" + "\r\n");
            requestStream.flush();
            fileInput.close();
            int statusCode = urlConn.getResponseCode();
            if (statusCode == 200) {
                // 获取返回的数据
                String result = streamToString(urlConn.getInputStream());

            } else {

            }
        } catch (IOException e) {

        }
    }


}