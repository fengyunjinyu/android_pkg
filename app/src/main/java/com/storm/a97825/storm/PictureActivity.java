package com.storm.a97825.storm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by 97825 on 2018/1/20.
 * 文件说明：
 * 手机屏幕中实现相框的效果
 * 三张图片 两张外框图 一张内狂徒，放在res/drawable目录下
 * png格式
 * layout布局添加两个ImageView  绝对坐标的方式布局在一起，
 * 下方增加两个按钮
 * 点击按钮 企鹅团图片
 */
public class PictureActivity  extends Activity{
    private ImageView imageView1;
    private ImageView imageView2;
    private Button mbutton1;
    private Button mbutton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        init();
    }

    private void init(){
        imageView1 = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        mbutton1 = (Button) findViewById(R.id.btn_img_1);
        mbutton2 = (Button) findViewById(R.id.btn_img_2);

        //设置imageView背景图
        imageView1.setImageDrawable(getResources().getDrawable(R.drawable.icon_email));
        imageView2.setImageDrawable(getResources().getDrawable(R.drawable.icon_address));

        //设置按钮点击事件 点击之后，imaeView 立即切换图片

        mbutton1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                imageView1.setImageDrawable(getResources().getDrawable(R.drawable.icon_home));
            }

        });

        //设置按钮点击事件 点击之后，imaeView 立即切换图片

        mbutton2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                imageView2.setImageDrawable(getResources().getDrawable(R.drawable.icon_home));
            }

        });

    }
}