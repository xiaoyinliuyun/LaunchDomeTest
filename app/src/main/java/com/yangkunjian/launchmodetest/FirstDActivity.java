package com.yangkunjian.launchmodetest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yangkunjian.launchmodetest.eventbus.MessageEvent;
import com.yangkunjian.launchmodetest.eventbus.SomeOtherEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstDActivity extends AppCompatActivity {

    private static final String TAG = "FirstActivity";

    @BindView(R.id.tvHello)
    TextView tvHello;
    @BindView(R.id.tvEvent)
    TextView tvEvent;
    @BindView(R.id.tvIntent)
    TextView tvIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @OnClick({R.id.tvHello, R.id.tvEvent, R.id.tvIntent})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvHello:
                Intent intent = new Intent(this, SecondAActivity.class);
                startActivity(intent);
                break;
            case R.id.tvEvent:
                EventBus.getDefault().postSticky(new MessageEvent("event"));
//                EventBus.getDefault().post(new SomeOtherEvent());
//                EventBus.getDefault().post(new BackgroundEvent(Thread.currentThread().getName()));
                break;
            case R.id.tvIntent:
//                showAlarms();
//                capturePhoto();
//                capturePhotoVideo();
                capturePhoto("");
                break;
        }
    }

    public void showAlarms() {
        Intent intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void capturePhoto() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent,0);
        }
    }

    public void capturePhotoVideo() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent,0);
        }
    }

    public void capturePhoto(String targetFilename) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent,0);
        }
    }

}
