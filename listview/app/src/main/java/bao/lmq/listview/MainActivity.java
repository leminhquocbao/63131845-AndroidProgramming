package bao.lmq.listview;

import android.os.Bundle;
import android.view.View;
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
    ArrayList<String> dsTenTinhThanhVN; //khai báo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hiển thỉ dữ liệu lên ListView
        //B1+: Cần có dữ liệu

        dsTenTinhThanhVN = new ArrayList<String>(); //tạo thể hiện cụ thể,xin mới
        //Thêm dữ liệu ở đây
        dsTenTinhThanhVN.add("Hà Nội");
        dsTenTinhThanhVN.add("Thành phố Hồ Chí Minh");
        dsTenTinhThanhVN.add("Đồng Nai");
        dsTenTinhThanhVN.add("Bình Thuận");
        dsTenTinhThanhVN.add("Ninh Thuận");
        dsTenTinhThanhVN.add("Nha Trang");
        //Tạo adapter
        ArrayAdapter<String> adapterTinhThanh;
        adapterTinhThanh= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsTenTinhThanhVN);
        //B3. gắn vào điểu khiển hiện thị ListView
        //3.1 Tìm
        ListView lvTinhThanh= findViewById(R.id.lvDanhSachTT);
        //3.2 Gắn
        lvTinhThanh.setAdapter(adapterTinhThanh);
        //3.3 lắng nghe và xử ly sự kiện người dung tương tác
        lvTinhThanh.setOnItemClickListener(BoLangNgheVaXL);
    }
    //tạo bộ lắng nghe và sử lý sự kiện OnItemOnclick,đặt vào một biến
    //vd: BoLangNghevaXuLy
    AdapterView.OnItemClickListener BoLangNgheVaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
            //i là vị trí phần tử vừa được click
            //ví dụ xử lý ở đây là hiện lên màn hình 1 thông báo nhanh về cị trí bạn vừa chọn
            String strTenChuoi =dsTenTinhThanhVN.get(i);
            Toast.makeText(MainActivity.this,"Bạn vừa chọn: "+strTenChuoi,Toast.LENGTH_LONG).show();
            //ví dụ lấy giá trị của phần tử thứ i


        }
    };

}