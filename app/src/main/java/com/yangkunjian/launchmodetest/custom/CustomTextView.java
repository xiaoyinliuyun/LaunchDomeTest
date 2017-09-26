package com.yangkunjian.launchmodetest.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import com.yangkunjian.launchmodetest.Constants;

/**
 * Created by yangkunjian on 2017/9/26.
 */

public class CustomTextView extends AppCompatTextView {

    private static final String TAG = "View            ---";

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
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
        boolean re = super.dispatchTouchEvent(event);
//        boolean re = false;
        Log.d(Constants.EVENT_TAG, TAG + "dispatchTouchEvent: return: " + re);
        return re;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d(Constants.EVENT_TAG, TAG + "onTouchEvent: Down");
//                getParent().requestDisallowInterceptTouchEvent(true);
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
        boolean re = super.onTouchEvent(event);//true
//        boolean re = false;
        Log.d(Constants.EVENT_TAG, TAG + "onTouchEvent: return: " + re);
        return re;
    }
}
