package com.storm.a97825.storm;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

//使用应用系统菜单 OptionMenus 案例

public class FooterMenuActivity extends AppCompatActivity {


    public static final int MENU_RED_ID = 1;
    public static final  int MENU_GREEN_ID = 2;
    public static final int MENU_BLUE_ID = 3;

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footer_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        btn = (Button)findViewById(R.id.button_optionmenus);

    }

    //创建选项菜单

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,MENU_RED_ID ,0,"RED");
        menu.add(0, MENU_GREEN_ID , 0 , "GREEN");
        menu.add(0, MENU_BLUE_ID, 0, "BLUE");
        return true;
    }

    //创建项目菜单被选中获取菜单的ID
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_RED_ID:
                btn.setBackgroundColor(Color.RED);
                btn.setText("Red");
                return true;
            case MENU_GREEN_ID:
                btn.setBackgroundColor(Color.GREEN);
                btn.setText("GREEN");
                return true;
            case MENU_BLUE_ID:
                btn.setBackgroundColor(Color.BLUE);
                btn.setText("BLUE");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
