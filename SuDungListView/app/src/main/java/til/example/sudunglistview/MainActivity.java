package til.example.sudunglistview;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> dsTinhThanhVN;
        dsTinhThanhVN = new ArrayList<String>();

        dsTinhThanhVN.add("Thủ đô Hà Nội");
        dsTinhThanhVN.add("Thành Phố Hồ Chí Minh");
        dsTinhThanhVN.add("Tỉnh Khách Hòa");
        dsTinhThanhVN.add("Tính Thừa Thiên Huế");
        dsTinhThanhVN.add("Tính Ninh Thuận");
        dsTinhThanhVN.add("Tỉnh Quảng Bình");
        dsTinhThanhVN.add("Tỉnh Nghệ An");
        dsTinhThanhVN.add("Tính Đồng Nai");

        ArrayAdapter<String> adapterTinhThanhVN;
        adapterTinhThanhVN = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dsTinhThanhVN);
        ListView lvTinhThanh =findViewById(R.id.lvDanhSach);
        lvTinhThanh.setAdapter(adapterTinhThanhVN);
        lvTinhThanh.setOnItemClickListener(BoLangNgheVaXL);
    }
    AdapterView.OnItemClickListener BoLangNgheVaXL= new AdapterView.OnItemClickListener(){
        ArrayList<String> dsTinhThanhVN;
        @Override
        public  void onItemClick(AdapterView<?> adapterView ,View view, int i, long l){
            String strTenTinh = dsTinhThanhVN.get(i);

            Toast.makeText(MainActivity.this, strTenTinh,Toast.LENGTH_LONG).show();
        }
    };
}