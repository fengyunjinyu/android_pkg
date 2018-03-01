package com.storm.a97825.storm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by 97825 on 2018/1/20.
 * 案例说明：
 * 使用checkbox ，点击按钮，获取checkbox选中项的数值重新组合新的数据
 */
public class CheckBoxActivity extends Activity {

    private CheckBox cb_plain ;
    private CheckBox cb_bold ;
    private CheckBox cb_serif;
    private CheckBox cb_italic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("CheckBox Activity");
        setContentView(R.layout.activity_checkbox);

        init();
    }
    //界面参数初始化函数
    private void init(){
        cb_plain = (CheckBox)findViewById(R.id.cb_plain);
        cb_bold = (CheckBox)findViewById(R.id.cb_bold);
        cb_serif = (CheckBox)findViewById(R.id.cb_serif);
        cb_italic = (CheckBox) findViewById(R.id.cb_italic);


        Button btn_get_value = (Button) findViewById(R.id.get_checkbox_value);



    }

    private Button.OnClickListener get_checkbox_value = new Button.OnClickListener(){
        @Override
        public void onClick(View v){
            String r = "";
            if(cb_plain.isChecked()){
                r = r+","+cb_plain.getText();
            }
            if(cb_serif.isChecked()){
                r+=","+cb_serif.getText();
            }

            setTitle("checked:"+r);


        }

    };

}