package ntu.MSSV63131845.cau2;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtchieucao, edtcannang;
    TextView txtketqua;
    Button btntinhtoan;
    RadioButton rdbtn1, rdbtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtchieucao = findViewById(R.id.edtchieucao);
        edtcannang = findViewById(R.id.edtcannang);
        txtketqua = findViewById(R.id.txtketqua);
        btntinhtoan = findViewById(R.id.btntinhtoan);
        rdbtn1 = findViewById(R.id.rdbtn1);
        rdbtn2 = findViewById(R.id.rdbtn2);

        btntinhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float chieucao, cannang;

                if (rdbtn2.isChecked()) {
                    cannang = Float.parseFloat(edtcannang.getText().toString()) * 0.453592f;
                    chieucao = Float.parseFloat(edtchieucao.getText().toString()) * 0.0254f;
                } else {
                    chieucao = Float.parseFloat(edtchieucao.getText().toString()) / 100;
                    cannang = Float.parseFloat(edtcannang.getText().toString())/1000;
                }

                float bmi = cannang / (chieucao * chieucao);
                float min = 18.5f;
                float max = 25f;
                String ketqua;

                // Xử lý kết quả BMI
                if (bmi < 18.5) {
                    float candoi = min - bmi;
                    ketqua = "Bạn bị suy dinh dưỡng" + "\nBạn cần tăng thêm " + String.format("%.2f", candoi);
                } else if (bmi < 25) {
                    ketqua = "Chỉ số BMI của bạn đang cân đối";
                } else if (bmi >= 25 && bmi <= 30) {
                    float candoi = bmi - max;
                    ketqua = "Bạn đang bị thừa cân" + "\nBạn cần giảm " + String.format("%.2f", candoi);
                } else if (bmi > 30 && bmi < 35) {
                    float candoi = bmi - max;
                    ketqua = "Bạn đang bị thừa cân cấp II" + "\nBạn cần giảm " + String.format("%.2f", candoi);
                } else {
                    float candoi = bmi - max;
                    ketqua = "Bạn đang bị thừa cân cấp III" + "\nBạn cần giảm " + String.format("%.2f", candoi);
                }

                txtketqua.setText("BMI: " + String.format("%.2f", bmi) + "\n" + ketqua);
            }
        });

        rdbtn1.setChecked(true);
    }
}
