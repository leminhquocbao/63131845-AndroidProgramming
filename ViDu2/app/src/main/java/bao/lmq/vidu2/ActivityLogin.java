package bao.lmq.vidu2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import  android.widget.*;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    public void XacNhan(View v){
        EditText editTextLogin=findViewById(R.id.edtTenDangNhap);
        EditText editTextPass=findViewById(R.id.edtMatKhau);
        EditText editTextEmail=findViewById(R.id.edtEmail);

        String strA= editTextLogin.getText().toString();
        String strB= editTextPass.getText().toString();
        String strC= editTextEmail.getText().toString();
        Intent iManHinhDangNhap=new Intent(this, ActivityHome.class);

        if(strA.equals("leminhquocbao") && strB.equals("Cntt63ntu!") && strC.equals("bao.lmq.63cntt@ntu.edu.vn")) {
            Toast toast = Toast.makeText(this, "User and Password is correct", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 100);
            toast.show();
            iManHinhDangNhap.putExtra("key_name", strA);
            startActivity(iManHinhDangNhap);
        }else {
            Toast toast = Toast.makeText(this, "User and Password is wrong", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 100);
            toast.show();
        }

    }
}