package com.storm.a97825.storm;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.storm.a97825.storm.com.storm.comp.GridPanel;

/**
 * Created by 97825 on 2018/1/21.
 * 文件说明：
 * 实现列表抽屉组件的源码
 * 从右往左弹出  ，
 * 从左往右收缩
 * 关联应用GridPanel.java 文件
 * 具体实现细节
 */
public class ExampleGridActivity extends Activity{
    public GridView gridView;
    public LinearLayout container;
    public GridPanel panel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        setTitle("抽屉组件");
        gridView = (GridView) findViewById(R.id.gridView);

        //container = (LinearLayout)findViewById(R.id.)

    }
}