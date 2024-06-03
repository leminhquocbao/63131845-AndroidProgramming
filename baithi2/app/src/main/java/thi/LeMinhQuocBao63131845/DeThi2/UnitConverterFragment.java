package thi.LeMinhQuocBao63131845.DeThi2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class UnitConverterFragment extends Fragment {
    EditText edtdonvi;
    TextView txtketqua;
    Button btntinhtoan;
    RadioButton rdbtn1, rdbtn2, rdbtn3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_unit_converter, container, false);
        edtdonvi = view.findViewById(R.id.edtdonvi);
        txtketqua = view.findViewById(R.id.txtketqua);
        btntinhtoan = view.findViewById(R.id.btntinhtoan);
        rdbtn1 = view.findViewById(R.id.rdbtn1);
        rdbtn2 = view.findViewById(R.id.rdbtn2);
        rdbtn3 = view.findViewById(R.id.rdbtn3);

        btntinhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double value = Double.parseDouble(edtdonvi.getText().toString());
                if (rdbtn1.isChecked()) {
                    // Chuyển đổi km sang m
                    value *= 1000;
                } else if (rdbtn2.isChecked()) {
                    // Chuyển đổi kg sang g
                    value *= 1000;
                } else if (rdbtn3.isChecked()) {
                    // Chuyển đổi byte sang bit
                    value *= 8;
                }
                txtketqua.setText(String.valueOf(value));
            }
        });

        return view;
    }
}
