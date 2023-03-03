package com.example.client;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

public class Gestore {

    private AppCompatActivity activity;

    private BgTask runningTask = null;

    private Client client = null;

    public Gestore(AppCompatActivity aAppCompatActivity){
        this.activity = aAppCompatActivity;
    }

    public AppCompatActivity getActivity() {
        return activity;
    }

    public void createMsgActivity(){
        Button send = this.activity.findViewById(R.id.send);
        EditText msg = this.activity.findViewById(R.id.msg);
        Bundle extras = this.activity.getIntent().getExtras();
        this.startBgTask("client",extras.getString("username"));
        send.setOnClickListener(view -> {
            if (!msg.getText().toString().matches("")) {
                client.sendMsg(msg.getText().toString());
                msg.setText("");
            }
        });
    }

    public void startBgTask(String... params){
        if(runningTask != null){
            runningTask = null;
        }
        runningTask = new BgTask(this,params);
    }

    public void add(String aTesto, String card){
        LinearLayout layout = ((MsgActivity)this.activity).findViewById(R.id.messageArea);
        this.activity.runOnUiThread(() -> {
            Message m = new Message(aTesto,card, (MsgActivity) Gestore.this.activity);
            layout.addView(m.getView());
        });
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

