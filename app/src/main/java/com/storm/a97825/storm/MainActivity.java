package com.storm.a97825.storm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*

        //按钮点击之后切换  界面
        Button button  = (Button)findViewById(R.id.btn_network);
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(MainActivity.this , LinearActivity.class);

                startActivity(intent);

            }
        });
        //线性布局按钮
        Button button_linear = (Button)findViewById(R.id.btn_linear);

        //相对布局按钮
        Button button_relative = (Button)findViewById(R.id.btn_relative);
        //点击按钮打开相对布局Activity
        button_relative.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , RelativeActivity.class);
                startActivity(intent);
            }
        });

*/
        Button btn_layout_table = (Button) findViewById(R.id.btn_layout_table);
        btn_layout_table.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , TableActivity.class);
                startActivity(intent);
            }
        });

        //点击下拉列表 跳转到下拉列表组件
        Button btn_spinner = (Button) findViewById(R.id.btn_layout_spinner);
        btn_spinner.setOnClickListener(go_activity_spinner);


        //使用simpleAdapter 构建ListView案例

        Button btn_listview = (Button) findViewById(R.id.btn_example_list_view);
        btn_listview.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , UserListActivity.class);
                startActivity(intent);
            }
        });


        //实现抽屉式的列表效果

        //自定义组件设置

        Button btn_self_view = (Button) findViewById(R.id.btn_self_view);
        btn_self_view.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , SelfViewActivity.class);
                startActivity(intent);
            }
        });

        //自定义组件 进度 百分比展示
        Button btn_view_percent = (Button) findViewById(R.id.btn_view_percent);
        btn_view_percent.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , PercentActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.fade_in , R.anim.fade_out);
            }
        });


        //获取mainActivity按钮btn_support_activity
        Button btn_main_support = (Button) findViewById(R.id.btn_main_support);

        btn_main_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , SupportActivity.class);
                startActivity(intent);
            }
        });


        Button main_btn_optionmenus = (Button) findViewById(R.id.main_btn_optionmenus);
        main_btn_optionmenus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this , FooterMenuActivity.class);
                startActivity(intent);
            }

        });



    }



    //先定义按钮相应事件 ，然后把事件附加到按钮上
    private Button.OnClickListener get_edit_views_listener  = new Button.OnClickListener(){
        @Override
        public void onClick(View v) {
            //响应代码，显示EditText中的值
            EditText edit_text = (EditText) findViewById(R.id.entry);
            CharSequence edit_text_value = edit_text.getText();
            setTitle("EditText value:"+edit_text_value);

        }
    };

    //点击按钮，前往下拉列表Activity

    private Button.OnClickListener go_activity_spinner = new Button.OnClickListener(){
        @Override
        public void onClick(View v){

            Intent intent = new Intent();
            intent.setClass(MainActivity.this , SpinnerActivity.class);
            startActivity(intent);

        }

    };




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
