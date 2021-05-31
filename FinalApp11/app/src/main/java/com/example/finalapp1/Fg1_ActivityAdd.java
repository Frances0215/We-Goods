package com.example.finalapp1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.zip.Inflater;

public class Fg1_ActivityAdd extends AppCompatActivity {

    EditText etgoodname, etgoodvalue, etgooddate, etgoodapply, etgoodcode, etgoodhigh,
            etgoodlow, etgoodweather, etgoodcolor, etgoodfrabic;
    private LinearLayout ibaddpic;
    private ImageView displayPic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fg1__add);

        Button btquitadd=(Button)findViewById(R.id.bt_quitadd);
        Button btsubmit=(Button)findViewById(R.id.id_bt_submit);
        LinearLayout ibaddpic=(LinearLayout) findViewById(R.id.addpic);
        ImageView displayPic = (ImageView) findViewById(R.id.display_pic);
        etgoodname=(EditText)findViewById(R.id.id_et_goodname);
        etgoodvalue=(EditText)findViewById(R.id.id_et_goodvalue);
        etgooddate=(EditText)findViewById(R.id.id_et_gooddate);
        etgoodapply=(EditText)findViewById(R.id.id_et_goodapply);
        etgoodcode=(EditText)findViewById(R.id.id_et_goodcode);
        etgoodhigh=(EditText)findViewById(R.id.id_et_goodhigh);
        etgoodlow=(EditText)findViewById(R.id.id_et_goodlow);
        etgoodweather=(EditText)findViewById(R.id.id_et_goodweather);
        etgoodcolor=(EditText)findViewById(R.id.id_et_goodcolor);
        etgoodfrabic=(EditText)findViewById(R.id.id_et_goodfrabic);

        displayPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,1);
            }
        });


        btquitadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fg1_ActivityAdd.this, Fg1_Activity2.class);
                startActivity(intent);
            }
        });

        btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(initTabView() == 1) {
                    tips();
                } else {
                    try {
                        Jacket tsn = new Jacket(etgoodcode.getText().toString(),
                                etgooddate.getText().toString(),
                                etgoodname.getText().toString(),
                                Double.parseDouble(etgoodvalue.getText().toString()),
                                etgoodapply.getText().toString(),
                                Integer.parseInt(etgoodhigh.getText().toString()),
                                Integer.parseInt(etgoodlow.getText().toString()),
                                etgoodweather.getText().toString(),
                                etgoodcolor.getText().toString(),
                                etgoodfrabic.getText().toString());

                        Intent intent = new Intent(Fg1_ActivityAdd.this, Fg1_Activity2.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("jacket", tsn);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }catch (NumberFormatException e){
                        Intent intent=new Intent();
                        intent.setClass(Fg1_ActivityAdd.this, Fg1_Activity2.class);
                        startActivity(intent);
                    }
                }

            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            Toast.makeText(Fg1_ActivityAdd.this, data.getData().toString(), Toast.LENGTH_SHORT).show();
            Log.e("Activity_Main",data.getData().toString());
            displayPic = (ImageView) findViewById(R.id.display_pic);
            displayPic.setImageURI(data.getData());
        }
    }

    private int initTabView() {
        int ifError = 0;
        String name = etgoodname.getText().toString();
        String date = etgooddate.getText().toString();
        String apply = etgoodapply.getText().toString();
        String code = etgoodcode.getText().toString();
        String high = etgoodhigh.getText().toString();
        String low = etgoodlow.getText().toString();
        String weather = etgoodweather.getText().toString();
        String color = etgoodcolor.getText().toString();
        String frabic = etgoodfrabic.getText().toString();

        if(name.equals("")||date.equals("")||apply.equals("")||
                code.equals("")||high.equals("")||low.equals("")||
                weather.equals("")||color.equals("")||frabic.equals("")) {
            ifError = 1;
        }
        return ifError;
    }

    public void tips() {
        //跳出提示
        String error = "没有填写完整奥！";
        Toast toastCenter;
        toastCenter = Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT);
        toastCenter.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toastCenter.show();
    }
}