package bao.lmq.baitest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Cau2Fragment extends Fragment {
    Button btn;
    EditText edtTinh;
    TextView txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_cau2, container, false);
        btn = view1.findViewById(R.id.button);
        edtTinh = view1.findViewById(R.id.edtSo);
        txt = view1.findViewById(R.id.txtHien);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number;
                try {
                    number = Integer.parseInt(edtTinh.getText().toString());
                } catch (NumberFormatException e) {
                    txt.setText("Vui lòng nhập một số hợp lệ");
                    return;
                }

                StringBuilder multiplicationTable = new StringBuilder();
                for (int i = 1; i <= 9; i++) {
                    multiplicationTable.append(number).append(" x ").append(i).append(" = ").append(number * i).append("\n");
                }
                txt.setText(multiplicationTable.toString());
            }
        });

        return view1;
    }
}
