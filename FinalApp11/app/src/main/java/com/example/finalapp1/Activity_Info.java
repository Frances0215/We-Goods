package com.example.finalapp1;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Connection;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_Info extends AppCompatActivity {

    Bundle outState;
    EditText etName, etSex, etAge, etSign, etJob, etHeight, etWeight;
    //RadioButton man, woman;
    String name, age, job, sex, weight, height, sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        SaveEnabled();
        if(savedInstanceState != null) {
            ArrayList<String> tempData = savedInstanceState.getStringArrayList("data_key");
            etName.setText(tempData.get(0));
            etSex.setText(tempData.get(1));
            etAge.setText(tempData.get(2));
            etSign.setText(tempData.get(3));
            etJob.setText(tempData.get(4));
            etHeight.setText(tempData.get(5));
            etWeight.setText(tempData.get(6));
        }

        findViewById(R.id.id_tv_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tips(initTabView());
                //实现跳转和传值
                /*ArrayList<String> massage = new ArrayList<String>();
                massage.add(name);
                massage.add(age+"/"+job);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("massage",massage);
                Fragment_3 fragment3 = new Fragment_3();
                fragment3.setArguments(bundle);
                replaceFragment(fragment3);*/

/*                Intent intent = new Intent(Activity_Info.this,Activity_Main.class);
                intent.putExtra("id",1);
                startActivity(intent);*/
            }
        });

        findViewById(R.id.id_img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Info.this,Activity_Main.class);
                intent.putExtra("id",1);
                startActivity(intent);
                onSaveInstanceState(outState);
            }
        });
    }
    public void SaveEnabled(){
        outState = new Bundle();
        etName = findViewById(R.id.id_et_name);
        etSex = findViewById(R.id.id_et_sex);
        etAge = findViewById(R.id.id_et_age);
        etSign = findViewById(R.id.id_et_sign);
        etHeight = findViewById(R.id.id_et_height);
        etWeight = findViewById(R.id.id_et_weight);
        etJob = findViewById(R.id.id_et_job);
        etSex.setSaveEnabled(false);
        etName.setSaveEnabled(false);
        etWeight.setSaveEnabled(false);
        etHeight.setSaveEnabled(false);
        etSign.setSaveEnabled(false);
        etJob.setSaveEnabled(false);
        etAge.setSaveEnabled(false);
    }

    public void tips(int ifError) {
        //跳出提示
        String ok = "资料更改成功";
        String error = "没有填写完整奥！";
        Toast toastCenter;
        if(ifError == 0) {
            toastCenter = Toast.makeText(getApplicationContext(), ok, Toast.LENGTH_SHORT);
        } else {
            toastCenter = Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT);
        }
        toastCenter.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toastCenter.show();
    }

    private int initTabView() {
        int ifError = 0;
        name = etName.getText().toString();
        etName.setText(name);

        age = etAge.getText().toString();
        etAge.setText(age);

        job = etJob.getText().toString();
        etJob.setText(job);

        sex = etSex.getText().toString();
        etSex.setText(sex);

        sign = etSign.getText().toString();
        etSign.setText(sign);

        height = etHeight.getText().toString();
        etHeight.setText(height);

        weight = etWeight.getText().toString();
        etWeight.setText(weight);

        if(name.equals("")||age.equals("")||job.equals("")||
                sex.equals("")||height.equals("")||weight.equals("")||sign.equals("")) {
            ifError = 1;
        }
        return ifError;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        ArrayList<String> tempDate = new ArrayList<String>();
        if(initTabView() == 0) {
            tempDate.add(name);
            tempDate.add(sex);
            tempDate.add(age);
            tempDate.add(sign);
            tempDate.add(job);
            tempDate.add(height);
            tempDate.add(weight);
            outState.putStringArrayList("data_key",tempDate);
        }
    }
}
