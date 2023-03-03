package com.example.client;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BgTask {
    private Executor executor = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler(Looper.getMainLooper());
    private String action = null;

    public BgTask(Gestore g, String... params){
        executor.execute(() -> {
            switch (params[0]) {
                case "client":
                    BgTask.this.action = params[0];
                    g.setClient(new Client(params[1], g));
                    break;
                default:
                    break;
            }

            handler.post(() ->{
               switch (action){
                   default:
                       break;
               }
            });
        });
    }
}