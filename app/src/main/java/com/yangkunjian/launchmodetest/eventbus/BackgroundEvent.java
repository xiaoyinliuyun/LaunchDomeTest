package com.yangkunjian.launchmodetest.eventbus;

/**
 * Created by yangkunjian on 2017/9/20.
 */

public class BackgroundEvent {

    public final String threadName;

    public BackgroundEvent(String threadName) {
        this.threadName = threadName;
    }
}
