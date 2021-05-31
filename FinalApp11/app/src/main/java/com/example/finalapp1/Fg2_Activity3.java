package com.example.finalapp1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.StringTokenizer;

public class Fg2_Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fg2_3);

        Button bt_quit=(Button)findViewById(R.id.bt_quit);
        bt_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Fg2_Activity3.this, Fg1_Activity2.class);
                startActivity(intent);
            }
        });

        initinformationView();

    }
    private void initinformationView(){
        TextView textView=(TextView)findViewById(R.id.tv_information);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());

        String teststring=textView.getText().toString();
        int start=0;
        int end=0;
        int count=0;
        SpannableString spannablestring = new SpannableString(teststring);
        StringTokenizer tokenizer=new StringTokenizer(teststring);
        while(tokenizer.hasMoreElements()) {
            String str=tokenizer.nextToken();
            start=teststring.indexOf(str);
            end=start+str.length();
            if (count == 0) {
                spannablestring.setSpan(new BackgroundColorSpan(Color.rgb(213, 240, 248)), start,end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                count=1;
            }else if(count==1){
                spannablestring.setSpan(new BackgroundColorSpan(Color.rgb(109, 176, 196)), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                count=0;
            }
        }
        textView.setText(spannablestring);
    }
}