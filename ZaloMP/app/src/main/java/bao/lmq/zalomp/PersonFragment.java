package bao.lmq.zalomp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PersonFragment extends Fragment {
    TextView txtketqua;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        txtketqua = view.findViewById(R.id.txtketqua);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String receivedData = bundle.getString("key_name");
            txtketqua.setText(receivedData);
        }

        return view;
    }
    public void QuayVe(View v){
        Intent iManHinhChinh = new Intent(getActivity(), DangNhap.class);
        startActivity(iManHinhChinh);
    }

}
