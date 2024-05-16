package bao.lmq.baitest;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Cau3Fragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_cau3, container, false);

        Button btnChuyenDoi = view1.findViewById(R.id.btnChuyenDoi);
        btnChuyenDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DangNhap(v);
            }
        });

        return view1;
    }

    public void DangNhap(View v){
        Intent iManHinh= new Intent(getActivity(), DangNhap.class);

        startActivity(iManHinh);
    }
}