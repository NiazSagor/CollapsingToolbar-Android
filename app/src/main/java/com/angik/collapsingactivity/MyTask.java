package com.angik.collapsingactivity;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;

import static android.os.SystemClock.sleep;

public class MyTask extends AsyncTask<Void, Void, Callback> {

    Handler handler = new Handler();

    Callback mCallback;

    private static final String TAG = "MyTask";

    String message = null;

    MyTask(Callback callback){
        mCallback = callback;
    }

    @Override
    protected Callback doInBackground(Void... voids) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    Log.d(TAG, "doInBackground: " + i);
                }
                mCallback.onFinisCallback("Finished from " + TAG);
            }
        });

        return null;
    }
}
