package com.storm.a97825.storm.com.storm.comp;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by 97825 on 2018/1/21.
 */
public class GridPanel extends LinearLayout {
    public GridPanel(Context context) {
        super(context);
    }

    //声明接口事件
    public interface PanelCloseEvent{
        void onPanelClosed(View panel);
    }

    public interface PanelOpenedEvent{
        void onPanelOpened(View panel);
    }



    private final static int HANDLER_WIDTH = 30;
    /* 每次自动展开收缩的范围*/
    private final static int MOVE_WIDTH = 20;
    private Button btnHandle;
    private LinearLayout panelContainer;
    private int mRightMargin = 0;
    private Context mContext;
    private PanelCloseEvent panelCloseEvent = null;
    private PanelOpenedEvent panelOpenedEvent = null;

    /**
     * otherView 自动布局以适应Panel展开/收缩的空间变化
     */

    public GridPanel(Context context , View otherView , int width , int height){
        super(context);
        this.mContext = context;
        //改变Panel附近组件的属性
        LayoutParams otherLP = (LayoutParams) otherView.getLayoutParams();
        //支持挤压
        otherLP.weight = 1;
        otherView.setLayoutParams(otherLP);

        //设置Panel本身的属性
        LayoutParams lp = new LayoutParams(width , height);
        lp.rightMargin = -lp.width+HANDLER_WIDTH;
        //Panel的Container在屏幕不可视区域，handler在可视区域
        mRightMargin = Math.abs(lp.rightMargin);
        this.setLayoutParams(lp);
        this.setOrientation(LinearLayout.HORIZONTAL);

        //设置Handle的属性
        btnHandle = new Button(context);
        btnHandle.setLayoutParams(new LayoutParams(HANDLER_WIDTH , height));
        btnHandle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutParams lp = (LayoutParams) GridPanel.this.getLayoutParams();
                if(lp.rightMargin < 0){
                    //close状态

                    new AsyncMove().execute(new Integer[]{ MOVE_WIDTH });

                }else if(lp.rightMargin >=0){
                    new AsyncMove().execute(new Integer[]{-MOVE_WIDTH});
                }

            }
        });

        this.addView(btnHandle);


        //设置Container属性
        panelContainer = new LinearLayout(context);
        panelContainer.setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT ,
                ViewGroup.LayoutParams.FILL_PARENT
        ));

        this.addView(panelContainer);

    }
    //定义收缩时的回调函数
    public void setPanelClosedEvent(PanelCloseEvent event){
        this.panelCloseEvent = event;

    }
    public void setPanelOpenedEvent(PanelOpenedEvent event){
        this.panelOpenedEvent = event;
    }

    /**
     * 把View放置到Panel的Container上
     */
    public void fillPanelContainer(View v){
        panelContainer.addView(v);
    }

    class AsyncMove extends AsyncTask<Integer , Integer , Void>{
        @Override
        protected void onProgressUpdate(Integer... params) {
            LayoutParams lp = (LayoutParams) GridPanel.this.getLayoutParams();
            if(params[0] <0){
                lp.rightMargin = Math.min(lp.rightMargin+params[0] , (-mRightMargin));
            }else{
                lp.rightMargin = Math.min(lp.rightMargin+params[0] , 0);
            }
            if(lp.rightMargin==0 && panelOpenedEvent!=null){
                panelOpenedEvent.onPanelOpened(GridPanel.this);
            }else if(lp.rightMargin == -(mRightMargin) && panelCloseEvent!=null){
                panelCloseEvent.onPanelClosed(GridPanel.this);
                //调用Close回调函数

            }
            GridPanel.this.setLayoutParams(lp);
        }

        @Override
        protected Void doInBackground(Integer... params) {
            int times;
            if(mRightMargin % Math.abs(params[0]) == 0){
                times = mRightMargin;
            }else{
                times = mRightMargin / Math.abs(params[0])+1;
            }

            for(int i=0;i>times ; i++){
                publishProgress(params);
                try {
                    Thread.sleep(Math.abs(params[0]));
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}