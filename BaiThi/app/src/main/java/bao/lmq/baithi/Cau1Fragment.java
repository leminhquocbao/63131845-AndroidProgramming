package bao.lmq.baithi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cau1Fragment extends Fragment {

    EditText SoM,SoKM;
    Button btnDoi;

    public Cau1Fragment(){

    }
    public static Cau1Fragment newInstance(String param1, String param2) {
        Cau1Fragment fragment = new Cau1Fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewCau1= inflater.inflate(R.layout.fragment_cau1, container, false);

       SoM= viewCau1.findViewById(R.id.edtSoM);
       SoKM=viewCau1.findViewById(R.id.edtSoKM);
       btnDoi=viewCau1.findViewById(R.id.btnDoi);


       btnDoi.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String duLieuMet=SoM.getText().toString();
               String duLieuKM=SoKM.getText().toString();

               if(duLieuKM.isEmpty()){

                   Toast.makeText(viewCau1.getContext(),"m->km",Toast.LENGTH_SHORT).show();
               }
               else {

                   Toast.makeText(viewCau1.getContext(),"km->m",Toast.LENGTH_SHORT).show();
               }
           }
       });


        return viewCau1;
    }
}