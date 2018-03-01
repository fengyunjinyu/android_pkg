package com.storm.a97825.storm.com.example.network;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * Created by 97825 on 2018/1/17.
 * HttpClient 实现网络restAPI 接口访问
 * json解析
 */
public class HttpExample extends AsyncTask<HttpUriRequest, Void, Object>{

    public interface ResponseCallback{
        public void onRequestSuccess(String response);
        public void onRequestError(Exception e);
    }

    private AbstractHttpClient mClient;

    private WeakReference<ResponseCallback> mCallback;

    public HttpExample(){
        this(new DefaultHttpClient());
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected Object doInBackground(HttpUriRequest... params) {
        try {
            HttpUriRequest request = params[0];
            HttpResponse serverResponse = mClient.execute(request);

            BasicResponseHandler handler = new BasicResponseHandler();
            String response = handler.handleResponse(serverResponse);
            return response;
        }catch (Exception e){

            return e;

        }
    }

    @Override
    protected void onCancelled(Object o) {
        super.onCancelled(o);
    }

    @Override
    protected void onPostExecute(Object result) {
        if(mCallback != null && mCallback.get() !=null){
            if(result instanceof String){
                mCallback.get().onRequestSuccess((String)result);
            }else if(result instanceof Exception){
                mCallback.get().onRequestError((Exception)result);
            }else{
                mCallback.get().onRequestError(
                        new IOException("unkonw error connacting Host")
                );
            }
        }
        super.onPostExecute(result);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    public HttpExample(AbstractHttpClient client){
        mClient = client;
    }

    public void setResponseCallback(ResponseCallback callback){
        mCallback = new WeakReference<ResponseCallback>(callback);
    }

}