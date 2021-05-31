package com.example.finalapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Fg2_Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fg2_2);

        Button btquit=(Button)findViewById(R.id.bt_quit);

        btquit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Fg2_Activity2.this, Activity_Main.class);
                startActivity(intent);
                Fg2_Activity2.this.finish();
            }
        });
    }
}