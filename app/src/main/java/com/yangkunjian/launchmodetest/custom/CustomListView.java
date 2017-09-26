package com.yangkunjian.launchmodetest.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

import com.yangkunjian.launchmodetest.Constants;

/**
 * Created by yangkunjian on 2017/9/26.
 */

public class CustomListView extends ListView {
    private static final String TAG = "ListView     ---";

    public CustomListView(Context context) {
        super(context);
    }

    public CustomListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
//        boolean re = false;
        Log.d(Constants.EVENT_TAG, TAG + "dispatchTouchEvent: return: " + re);
        return re;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(Constants.EVENT_TAG, TAG + "onInterceptTouchEvent: Down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(Constants.EVENT_TAG, TAG + "onInterceptTouchEvent: Move");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(Constants.EVENT_TAG, TAG + "onInterceptTouchEvent: Up");
                break;
            default:
                Log.d(Constants.EVENT_TAG, TAG + "onInterceptTouchEvent: default");
                break;
        }

        boolean re = super.onInterceptTouchEvent(ev);//false
//        boolean re = true;
        Log.d(Constants.EVENT_TAG, TAG + "onInterceptTouchEvent: return: " + re);
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

        boolean re = super.onTouchEvent(event);//false
//        boolean re = true;
        Log.d(Constants.EVENT_TAG, TAG + "onTouchEvent: return: " + re);
        return re;
    }
}
