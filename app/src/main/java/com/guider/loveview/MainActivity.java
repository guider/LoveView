package com.guider.loveview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.guider.lib.LoveLayout;

public class MainActivity extends AppCompatActivity {
    private LoveLayout mLoveLayout;
    private Handler handler=new Handler(){
        public void handleMessage(android.os.Message msg) {
            if (msg.what==0x123) {
                mLoveLayout.addLove();
            }
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mLoveLayout=(LoveLayout)findViewById(R.id.love_layout);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        Thread.sleep(400);
                        handler.sendEmptyMessage(0x123);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
