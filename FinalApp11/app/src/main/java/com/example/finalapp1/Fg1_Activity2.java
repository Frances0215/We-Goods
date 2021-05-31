package com.example.finalapp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Fg1_Activity2 extends AppCompatActivity {
    public Box jacket_box;
    private Jacket jacket;


    private List<Button> buttonlist=new ArrayList<Button>();
    private RelativeLayout rLayout;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fg1_2);
        Button btgood1=(Button)findViewById(R.id.bt_good1);
        Button btgood2=(Button)findViewById(R.id.bt_good2);
        Button btgood3=(Button)findViewById(R.id.bt_good3);
        Button btgood4=(Button)findViewById(R.id.bt_good4);
        ImageButton btadd=(ImageButton)findViewById(R.id.add);

        Button btquit=(Button)findViewById(R.id.bt_quit);
        buttonlist.add(btgood1);
        buttonlist.add(btgood2);
        buttonlist.add(btgood3);

        getBox();
        init();
        //Read();
        //Show();

        btquit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Fg1_Activity2.this, Activity_Main.class);
                startActivity(intent);
                Fg1_Activity2.this.finish();
            }
        });
        btgood1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Fg1_Activity2.this,Fg2_Activity3.class);
                startActivity(intent);
                Fg1_Activity2.this.finish();
            }
        });
        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Fg1_Activity2.this,Fg1_ActivityAdd.class);

                startActivity(intent);
            }
        });

    }

    private void getBox() {
        jacket_box=(Box)getIntent().getSerializableExtra("jacket_box");

    }

    private void init() {
        jacket=(Jacket) getIntent().getSerializableExtra("jacket");
        if(jacket!=null){
            BulitButton(0,jacket);
        }
    }

    /*private void Read(){
        TrouInfoDao dao=new TrouInfoDao(Fg1_Activity2.this);
        list.clear();//清空list集合
        list=dao.search();//查询数据库，将数据填充到list
    }
    private void Show(){
        if(list.size()<=0||list.isEmpty())
            return;
        else{
            if(buttonlist.size()<list.size()){
                for(int j=0;j<(list.size()-buttonlist.size());j++){
                    BulitButton(j);
                }
            }
            for(int i=0;i<list.size();i++){
                (buttonlist.get(i)).setText((list.get(i)).toString());
            }
        }
    }*/

    private void BulitButton(int i,Jacket jk) {
        rLayout=(RelativeLayout)findViewById(R.id.relativelayout_3);

        Button btn=new Button(this);
        btn.setId(i);
        btn.setBackgroundResource(R.drawable.goodbackground);
        btn.setText(jk.todisplayeasyString());
        RelativeLayout.LayoutParams btParams=new RelativeLayout.LayoutParams(1340,620);
        if(i==0){
            btParams.addRule(RelativeLayout.BELOW, R.id.bt_good4);

        }else{
            btParams.addRule(RelativeLayout.BELOW,i-1);
        }
        btParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        btParams.topMargin=40;
        rLayout.addView(btn,btParams);
    }
}