package com.example.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText username = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        Button connect = findViewById(R.id.connect);

        connect.setOnClickListener(view -> startMsgActivity());
    }

    private void startMsgActivity() {
        Intent msg = new Intent(this, MsgActivity.class);
        msg.putExtra("username",username.getText().toString());
        startActivity(msg);
    }
}