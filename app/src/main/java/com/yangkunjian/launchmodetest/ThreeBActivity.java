package com.yangkunjian.launchmodetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.TextView;

import com.yangkunjian.launchmodetest.adapter.TestAdapter;
import com.yangkunjian.launchmodetest.custom.CustomListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThreeBActivity extends AppCompatActivity {

    private static final String TAG = "Activity         ---";

    @BindView(R.id.tvHello)
    TextView tvHello;

    @BindView(R.id.list_view)
    CustomListView listView;

    private TestAdapter adapter;

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("Item:" + i);
        }
        adapter = new TestAdapter(this, list);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.tvHello)
    public void onViewClicked() {
        Intent intent = new Intent(this, MainCActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
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
