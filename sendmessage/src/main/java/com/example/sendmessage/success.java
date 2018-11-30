package com.example.sendmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class success extends AppCompatActivity {
    TextView tv_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
        tv_show = (TextView)findViewById(R.id.show);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        tv_show.setText(message);



    }
}
