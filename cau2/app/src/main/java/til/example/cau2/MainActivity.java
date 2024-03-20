package til.example.cau2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextAmount;
    private RadioGroup radioGroup;
    private TextView textViewTipAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAmount = findViewById(R.id.edtNumber);
        radioGroup = findViewById(R.id.radiangroup);
        textViewTipAmount = findViewById(R.id.txtketqua);

        Button loginButton = findViewById(R.id.btnTinhToan);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TiepTips(v);
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String text = radioButton.getText().toString();
                Toast.makeText(MainActivity.this, "Bạn đã chọn: " + text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void TiepTips(View view){
            double amount = Double.parseDouble(editTextAmount.getText().toString());

            int radioButtonId = radioGroup.getCheckedRadioButtonId();
            RadioButton radioButton = findViewById(radioButtonId);
            double tipPercentage = Double.parseDouble(radioButton.getText().toString().replace("%", "")) / 100;

            double tipAmount = amount * tipPercentage;

            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String formattedTipAmount = decimalFormat.format(tipAmount);
            textViewTipAmount.setText("Số tiền tip cần đưa: $" + formattedTipAmount);

    }
}
