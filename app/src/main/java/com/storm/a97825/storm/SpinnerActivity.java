package com.storm.a97825.storm;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 97825 on 2018/1/20.
 * 说明文件
 * 在屏幕中显示下拉列表框
 */
public class SpinnerActivity extends Activity {

    private static final String[] mCountries = {"China" , "Russia" , "USA" , "Germany" ,"Japan"};
    //下拉对象
    private Spinner spinner;
    private List<String> list_contries;
    private ArrayAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置标题
        setTitle("SpinnerActivity");
        //先设置界面
        setContentView(R.layout.activity_spinner);
        //执行初始化改程序
        init();

    }

    private void init(){
        spinner = (Spinner) findViewById(R.id.spinner);
        list_contries = new ArrayList<String>();

        for(int i=0; i<mCountries.length ; i++){
            list_contries.add(mCountries[i]);
        }

        adapter = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item ,
                list_contries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //选中事件
        //spinner.setOnItemClickListener(SpinnerActivity.this);

    }
}