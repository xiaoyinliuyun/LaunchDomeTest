package com.yangkunjian.launchmodetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class OneService extends Service {
    public OneService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent intent1 = new Intent(this, FirstDActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
        return super.onStartCommand(intent, flags, startId);
    }
}
