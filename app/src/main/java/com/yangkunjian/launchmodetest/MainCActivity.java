package com.yangkunjian.launchmodetest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.yangkunjian.launchmodetest.eventbus.BackgroundEvent;
import com.yangkunjian.launchmodetest.eventbus.MessageEvent;
import com.yangkunjian.launchmodetest.eventbus.PhoneEvent;
import com.yangkunjian.launchmodetest.eventbus.SomeOtherEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainCActivity extends AppCompatActivity {

    private static final String TAG = "Activity         ---";

    @BindView(R.id.tvHello)
    TextView tvHello;
    //change 3
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            tvHello.invalidate();
            tvHello.post(new Runnable() {
                @Override
                public void run() {}
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tvHello)
    public void onViewClicked() {
        Intent intent = new Intent(this, FirstDActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onMessageEvent(MessageEvent event) {
        Toast.makeText(this, "消费MessageEvent事件线程:" + Thread.currentThread().getName(), Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onHandleOtherEvent(SomeOtherEvent event) {
        final String name = Thread.currentThread().getName();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
//        EventBus.getDefault().post(new PhoneEvent(name));
        EventBus.getDefault().post(new BackgroundEvent(Thread.currentThread().getName()));

//        mHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                Toast.makeText(MainCActivity.this, "消费SomeOtherEvent事件线程:" + name, Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPhoneEvent(PhoneEvent event) {
        Toast.makeText(this, "主线程收到线程" + event.threadName + "发送的事件", Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onBackgroundEvent(final BackgroundEvent event) {
        final String name = Thread.currentThread().getName();

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainCActivity.this, "发布线程名字:" + event.threadName + "\r\n" + "订阅线程名:" + name, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(Constants.EVENT_TAG, TAG + "dispatchTouchEvent: Down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(Constants.EVENT_TAG, TAG + "dispatchTouchEvent: Move");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(Constants.EVENT_TAG, TAG + "dispatchTouchEvent: Up");
                break;
            default:
                Log.d(Constants.EVENT_TAG, TAG + "dispatchTouchEvent: default");
                break;
        }

        boolean re = super.dispatchTouchEvent(ev);
        Log.d(Constants.EVENT_TAG, TAG + "dispatchTouchEvent: return: " + re);
        return re;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(Constants.EVENT_TAG, TAG + "onTouchEvent: Down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(Constants.EVENT_TAG, TAG + "onTouchEvent: Move");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(Constants.EVENT_TAG, TAG + "onTouchEvent: Up");
                break;
            default:
                Log.d(Constants.EVENT_TAG, TAG + "onTouchEvent: default");
                break;
        }

        boolean re = super.onTouchEvent(event);
        Log.d(Constants.EVENT_TAG, TAG + "onTouchEvent: return: " + re);
        return re;
    }
}
