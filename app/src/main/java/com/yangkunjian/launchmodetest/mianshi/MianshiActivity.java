package com.yangkunjian.launchmodetest.mianshi;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ProgressBar;

import com.yangkunjian.launchmodetest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yangkunjian on 2017/9/21.
 */

public class MianshiActivity extends Activity {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mianshi);
        ButterKnife.bind(this);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int max = progressBar.getMax();
                try {
                    while (max != progressBar.getProgress()){
                        int step = max / 10;
                        int current = progressBar.getProgress();
                        progressBar.setProgress(current+step);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

}
