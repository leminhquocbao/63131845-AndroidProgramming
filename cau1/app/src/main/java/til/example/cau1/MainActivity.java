package til.example.cau1;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginButton = findViewById(R.id.btnlogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login(view); // Gọi phương thức xử lý đăng nhập khi nhấn nút
            }
        });
    }

    public void Login(View view){
        EditText editTextLogin=findViewById(R.id.edtuser);
        EditText editTextPass=findViewById(R.id.edtpasswd);

        String strA= editTextLogin.getText().toString();
        String strB= editTextPass.getText().toString();

        if(strA.equals("maicuongtho") && strB.equals("Cntt60ntu!")) {
            Toast toast = Toast.makeText(this, "User and Password is correct", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 100);
            toast.show();
        }else {
            Toast toast = Toast.makeText(this, "User and Password is wrong", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 100);
            toast.show();
        }
    }
}