package com.storm.a97825.storm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by 97825 on 2018/1/20.
 * exp 2.7.8
 * 在屏幕中实现自动输入文本
 *
 *
 */
public class AutoCompleteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    private String[] normalString = new String[]{
            "Android" , "Android Blog" , "Android SDK" ,"Android AVD"
    };

    //声明元素

    private TextView show;
    private AutoCompleteTextView autoTextView;
    private Button clean;
    private ArrayAdapter<String> arrayAdapter;

    //初始化元素事件

    public void init(){
        arrayAdapter = new ArrayAdapter<String>(this ,
                android.R.layout.simple_dropdown_item_1line , normalString);

        autoTextView.setAdapter(arrayAdapter);

        clean.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                autoTextView.setText("");

            }
        });
    }
    //单选框组件 管理器
    private RadioGroup mradioGroup;
    //声明单选框按钮
    private RadioButton mRadio1 , mRadio2;

    private RadioGroup.OnCheckedChangeListener mChange =
            new RadioGroup.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if(checkedId == mRadio1.getId()){

                        autoTextView.setText(mRadio1.getText());
                    }else if(checkedId == mRadio2.getId()){
                        autoTextView.setText(mRadio2.getText());
                    }
                }
            };
    //设置radio点击事件
    public void set_Radio_selected_event(){
        //....实例化元素

        /* 向RadioGroup用OnCheckedChangeListener来运行  */
        mradioGroup.setOnCheckedChangeListener(mChange);

    }


    //复选框使用案例
    //使用复选框模拟一个购物车

    private TextView textView;
    private CheckBox mCheckbox1 ,mCheckbox2 , mCheckbx3;



    //checkbox选择事件
    private CheckBox.OnCheckedChangeListener mCheckBoxChanged =
            new CheckBox.OnCheckedChangeListener(){
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String str0 = "所选的项目";
                    String str1 = "checkbox_1";
                    String str2 ="checkbox_2";
                    String str3 = "checkbox_3";

                    if(mCheckbox1.isChecked() == true ){
                        str0+=str1;
                    }
                    if(mCheckbox2.isChecked()==true){
                        str0+=str2;
                    }

                    textView.setText(str0);

                }
            };

    public void init_checkbox_event(){
        //实例化元素
        //类似如下
        //mChectbox1 = (CheckBox)findViewById(R.id.checkbox);

        //向checkbox元素添加onCheckedChangeListener事件
        mCheckbox1.setOnCheckedChangeListener(mCheckBoxChanged);

    }


    //




}