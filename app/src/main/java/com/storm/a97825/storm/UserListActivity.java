package com.storm.a97825.storm;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 97825 on 2018/1/21.
 */
public class UserListActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_list_view);
        //初始化函数
        init_listview(this);

    }

    //使用SimpleAdaper适配器实现ListView组件的效果
    public void init_listview(Context mContext){
        ArrayList<HashMap<String , Object>> users =
                new ArrayList<HashMap<String, Object>>();
        for(int i=0;i<10 ; i++){
            HashMap<String , Object> user = new HashMap<String ,Object>();
            user.put("img" , R.drawable.icon_address);
            user.put("username" , "姓名"+i);
            user.put("age" , (20+i)+"");

            users.add(user);
        }

        //数据适配
        SimpleAdapter sampleItems = new SimpleAdapter(
                mContext ,  //上下文环境设置
                users , //数据源
                R.layout.user_item, //每个user_item
                new String[]{ "img" , "username" ,"age"} , //字段映射
                new int[]{ R.id.img , R.id.username , R.id.age}
        ); //view分别对应的元素
        //获取listView
        ((ListView)findViewById(R.id.users)).setAdapter(sampleItems);

    }
}