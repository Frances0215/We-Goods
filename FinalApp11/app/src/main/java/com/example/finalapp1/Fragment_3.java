package com.example.finalapp1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragment_3 extends Fragment {

    private String name, info;
    private TextView tvName, tvInfo;
    private ImageView portrait;

    public Fragment_3() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static com.example.finalapp1.Fragment_3 newInstance(String param1) {
        com.example.finalapp1.Fragment_3 fragment = new com.example.finalapp1.Fragment_3();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //init();
       /* Bundle bundle = getArguments();
        ArrayList<String> massage;
        massage = bundle.getStringArrayList("massage");
        if (getArguments() != null) {
            name = massage.get(0).toString();
            info = massage.get(0).toString();
            tvName.setText(name);
            tvInfo.setText(info);
        }*/
    }

    private void init() {
        tvName = (TextView) getView().findViewById(R.id.id_tv_name);
        tvInfo = (TextView) getView().findViewById(R.id.id_tv_info);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        portrait = view.findViewById(R.id.id_iv_portrait);

        //跳转上传商品界面
        view.findViewById(R.id.id_ll_pick_portrait).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,1);
            }
        });
        view.findViewById(R.id.id_ll_forward).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Activity_Info.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.id_tv_adv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Activity_Advice.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.id_tv_setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Activity_Setting.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.id_tv_style).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Activity_Style.class);
                startActivity(intent);
            }
        });
        view.findViewById(R.id.id_tv_note).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Activity_Note.class);
                startActivity(intent);
            }
        });
       view.findViewById(R.id.id_tv_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            Toast.makeText(getActivity(), data.getData().toString(), Toast.LENGTH_SHORT).show();
            Log.e("Activity_Main",data.getData().toString());
            portrait.setImageURI(data.getData());
        }
    }

    public void Modify(String name, String Info) {
        TextView tvName = getView().findViewById(R.id.id_tv_name);
        TextView tvInfo = getView().findViewById(R.id.id_tv_info);
        tvName.setText(name);
        tvInfo.setText(Info);
    }
}