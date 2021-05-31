package com.example.finalapp1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.zip.DataFormatException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_1 extends Fragment {

    private static final String ARG_TEXT = "param1";

    // TODO: Rename and change types of parameters
    private String mTestString;
    View rootView;
    private BoxList boxlist;
    private Box jacket_box;
    private Box trousers_box;
    private Box shoes_box;
    private Box food_box;
    private Box bag_box;
    private Box others_box;

    private String fileNameOfBoxList;

    public Fragment_1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment Fragment_1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_1 newInstance(String param1) {
        Fragment_1 fragment = new Fragment_1();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mTestString = getArguments().getString(ARG_TEXT);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
/*        if(rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_1, container, false);
        }
        initView();
        return rootView;*/
        final View view=inflater.inflate(R.layout.fragment_1, container, false);
        Button btclothes=(Button)view.findViewById(R.id.bt_clothes);

        try {
            initBoxList();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DataFormatException e) {
            e.printStackTrace();
        }

        /*jacket_box=getBoxList().getBox(1);
        trousers_box=getBoxList().getBox(2);
        shoes_box=getBoxList().getBox(3);
        food_box=getBoxList().getBox(4);
        bag_box=getBoxList().getBox(5);
        others_box=getBoxList().getBox(6);*/


        btclothes.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent = new Intent(getActivity(), Fg1_Activity2.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("jacket_box", (Serializable) jacket_box);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        return view;
    }

/*
    private void initView() {
        TextView textView = rootView.findViewById(R.id.text);
        textView.setText(mTestString);
    }
*/

    public void initBoxList() throws IOException, DataFormatException {
       //Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        //intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
        //intent.setType(“audio/*”); //选择音频
        //intent.setType(“video/*”); //选择视频 （mp4 3gp 是android支持的视频格式）
        //intent.setType(“video/*;image/*”);//同时选择视频和图片
        /*intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, 1);*/

        fileNameOfBoxList= "/we's goods.txt";;
        boxlist=(new FileBoxListLoader()).loadBoxList((fileNameOfBoxList));

    }
    public BoxList getBoxList(){
        return boxlist;
    }
    /*protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {//是否选择，没选择就不会继续
            Uri uri = data.getData();//得到uri，后面就是将uri转化成file的过程。
            String[] proj = {MediaStore.Images.Media.DATA};

            Cursor actualimagecursor = managedQuery(uri, proj, null, null, null);
            int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            actualimagecursor.moveToFirst();
            String img_path = actualimagecursor.getString(actual_image_column_index);
            File file = new File(img_path);
            Toast.makeText(OpenFile.this, file.toString(), Toast.LENGTH_SHORT).show();
            String dd =file.toString();
            dizhi.setText(file.toString());
            readfilename=dizhi.getText().toString();
        }
    }*/
}