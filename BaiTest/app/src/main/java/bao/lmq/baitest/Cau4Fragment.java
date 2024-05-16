package bao.lmq.baitest;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Cau4Fragment extends Fragment {
    EditText SoA,SoB;
    Button btnCong,btnTru,btnNhan,btnChia;
    TextView txtDapAn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view1=inflater.inflate(R.layout.fragment_cau4, container, false);
        SoA=view1.findViewById(R.id.edtSoA);
        SoB=view1.findViewById(R.id.edtSoB);

        btnCong=view1.findViewById(R.id.btnCong);
        btnTru=view1.findViewById(R.id.btnTru);
        btnNhan=view1.findViewById(R.id.btnNhan);
        btnChia=view1.findViewById(R.id.btnChia);

        txtDapAn=view1.findViewById(R.id.txtDapAn);

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(SoA.getText().toString());
                double b = Double.parseDouble(SoB.getText().toString());
                double result = a + b;
                txtDapAn.setText(String.valueOf(result));
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(SoA.getText().toString());
                double b = Double.parseDouble(SoB.getText().toString());
                double result = a - b;
                txtDapAn.setText(String.valueOf(result));
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(SoA.getText().toString());
                double b = Double.parseDouble(SoB.getText().toString());
                double result = a * b;
                txtDapAn.setText(String.valueOf(result));
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(SoA.getText().toString());
                double b = Double.parseDouble(SoB.getText().toString());
                if (b != 0) {
                    double result = a / b;
                    txtDapAn.setText(String.valueOf(result));
                } else {
                    txtDapAn.setText("Không thể chia cho 0");
                }
            }
        });

        return view1;
    }
}
