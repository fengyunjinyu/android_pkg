package com.storm.a97825.storm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 97825 on 2018/1/20.
 */
public class PictireAlbumActivity extends Activity {
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        init();
    }
    //程序初始化
    public void init(){

        Gallery g; //= (Gallery) findViewById(R.id.mygallery);
        /*
        //添加一个ImageAdapter并设置给Gallery对象
        g.setAdapter(new ImageAdapter(this));

        //设置一个itemClickListener并toast点击图片的位置

        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = "helloworld";
                Toast.makeText(getApplicationContext(), "Helloworld" , Toast.LENGTH_SHORT).show();
            }
        });

        */
    }

    //改写BaseAdapter自定义一个ImageAdapter class
    public class ImageAdapter extends BaseAdapter{

        //变量声明
        int mGalleryItemBackground;
        private Context mContext;

        /* 构建一个Interger array 并取得预加载Drawable的图片id */
        private Integer[] myImageIds = {
                R.drawable.icon_address,
                R.drawable.icon_email,
                R.drawable.icon_home
        };

        @Override
        public int getCount() {
            return myImageIds.length;
            //return 0;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        /* 覆盖getView方法，返回一个View对象*/
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView i = new ImageView(mContext);
            i.setImageResource(myImageIds[position]);
            //重新设置图片的宽度和高度
            i.setScaleType(ImageView.ScaleType.FIT_XY);
            //重新设置layout的宽度和盖度
            i.setLayoutParams(new Gallery.LayoutParams(136 ,88));
            i.setBackgroundResource(mGalleryItemBackground);
            return i;
            //return null;
        }

        /**
         * Image Adapter 构造器
         */
        public ImageAdapter(Context c) {
            mContext = c;
            //使用res/value/attrs.xml 中定义的declare-styleable定义的Gallery属性
            TypedArray a ;//= obtainStyledAttributes(R.styleable.Gallery)
            /*
            mGalleryItemBackground =
                    a.getResourceId(R.styleable.Gallery_abdroud_galleryItemBackground , 0);
            //让对象styleable属性能够反复使用
            a.recycle();

            */
        }


    }
}