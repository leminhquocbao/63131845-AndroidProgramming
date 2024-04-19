package bao.lmq.vidu2;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.content.*;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityHome extends AppCompatActivity {
    TextView txtketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtketqua = findViewById(R.id.txtketqua);

        Intent intent = getIntent();
        String receivedData = intent.getStringExtra("key_name"); // Thay "key_name" bằng tên khóa đã sử dụng để gửi dữ liệu từ trang 2

        txtketqua.setText(receivedData);
    }
}
