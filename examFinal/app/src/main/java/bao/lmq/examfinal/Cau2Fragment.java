package bao.lmq.examfinal;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Cau2Fragment extends Fragment {
    Button btnketqua;
    TextView txtketqua;
    EditText ngaynam, thangnam, namnam, ngaynu, thangnu, namnu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cau2, container, false);

        ngaynam = view.findViewById(R.id.edtNgayNam);
        thangnam = view.findViewById(R.id.edtThangNam);
        namnam = view.findViewById(R.id.edtNamNam);
        ngaynu = view.findViewById(R.id.edtNgayNu);
        thangnu = view.findViewById(R.id.edtThangNu);
        namnu = view.findViewById(R.id.edtNamNu);
        txtketqua = view.findViewById(R.id.txtHop);
        btnketqua = view.findViewById(R.id.btnTinhToan);

        btnketqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String birthDayMan = ngaynam.getText().toString();
                String birthMonthMan = thangnam.getText().toString();
                String birthYearMan = namnam.getText().toString();
                String birthDayWoman = ngaynu.getText().toString();
                String birthMonthWoman = thangnu.getText().toString();
                String birthYearWoman = namnu.getText().toString();

                if (TextUtils.isEmpty(birthDayMan) || TextUtils.isEmpty(birthMonthMan) || TextUtils.isEmpty(birthYearMan) ||
                        TextUtils.isEmpty(birthDayWoman) || TextUtils.isEmpty(birthMonthWoman) || TextUtils.isEmpty(birthYearWoman)) {
                    Toast.makeText(getActivity(), "Please enter both birth dates", Toast.LENGTH_SHORT).show();
                } else {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date dateMan = sdf.parse(birthDayMan + "/" + birthMonthMan + "/" + birthYearMan);
                        Date dateWoman = sdf.parse(birthDayWoman + "/" + birthMonthWoman + "/" + birthYearWoman);

                        // Now you can compare dateMan and dateWoman
                        // For example, let's compare the years as before:
                        Calendar calMan = Calendar.getInstance();
                        calMan.setTime(dateMan);
                        int yearMan = calMan.get(Calendar.YEAR);

                        Calendar calWoman = Calendar.getInstance();
                        calWoman.setTime(dateWoman);
                        int yearWoman = calWoman.get(Calendar.YEAR);

                        if ((yearMan % 2 == 0 && yearWoman % 2 == 0) || (yearMan % 2 != 0 && yearWoman % 2 != 0)) {
                            txtketqua.setText("Hợp");
                        } else {
                            txtketqua.setText("Không hợp");
                        }
                    } catch (ParseException e) {
                        Toast.makeText(getActivity(), "Invalid date format. Please use dd/MM/yyyy", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return view;
    }
}
