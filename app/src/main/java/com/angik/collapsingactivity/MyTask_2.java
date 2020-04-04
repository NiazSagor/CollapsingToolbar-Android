package com.angik.collapsingactivity;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;

import static android.os.SystemClock.sleep;

public class MyTask_2 extends AsyncTask<Void, Void, Void> {

    Handler handler = new Handler();

    Callback mCallback;

    private static final String TAG = "MyTask_2";

    String message = null;

    MyTask_2(Callback callback){
        mCallback = callback;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        handler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    Log.d(TAG, "doInBackground: " + i);
                    //sleep(SystemClock.currentThreadTimeMillis() + 1000);
                }
                mCallback.onFinisCallback("Finished from " + TAG);
            }
        });

        return null;
    }
}
