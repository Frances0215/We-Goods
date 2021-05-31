package com.example.finalapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //声明控件
    private Button btLogin;
    private EditText mEtUser;
    private EditText mEtPassword;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        mEtUser = (EditText)findViewById(R.id.id_et_user);
        mEtPassword = (EditText)findViewById(R.id.id_et_pw);
        btLogin = (Button) findViewById(R.id.id_bt_login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mEtUser.getText().toString();
                String userPassword = mEtPassword.getText().toString();
                String ok = "登陆成功";
                String fail = "密码或账号有误";

                if(userName.equals("we")&&userPassword.equals("123456")){
                    //正确进行跳转
                    //toast下方显示
                    Toast.makeText(getApplicationContext(),ok,Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent();
                    intent.setClass(MainActivity.this, Activity_Main.class);
                    startActivity(intent);
                } else{
                    //wrong弹出失败toast居中显示
                    Toast toastCenter = Toast.makeText(getApplicationContext(),fail,Toast.LENGTH_SHORT);
                    toastCenter.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toastCenter.show();
                }
            }
        });
    }
}