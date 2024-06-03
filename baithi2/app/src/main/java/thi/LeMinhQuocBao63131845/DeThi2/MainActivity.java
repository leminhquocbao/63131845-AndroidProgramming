package thi.LeMinhQuocBao63131845.DeThi2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
     BottomNavigationView bottomNavigationView;
     FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavView);
        frameLayout = findViewById(R.id.frameLayout);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String receivedData = intent.getStringExtra("key_name");

        // Tạo một Bundle và đặt dữ liệu vào đó
        Bundle bundle = new Bundle();
        bundle.putString("key_name", receivedData);

        // Tạo một thể hiện của PersonFragment và đặt đối số cho nó
        WelcomeFragment personFragment = new WelcomeFragment();
        personFragment.setArguments(bundle);

        // Load PersonFragment lên giao diện
        loadFragment(personFragment, true);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId=item.getItemId();

                if(itemId== R.id.cau5){
                    loadFragment(new MyCVFragment(),false);
                } else if (itemId==R.id.cau2) {
                    loadFragment(new UnitConverterFragment(),false);
                }else if (itemId==R.id.cau3) {
                    loadFragment(new WellknowCoffeeFragment(),false);
                }else if (itemId==R.id.cau4) {
                    loadFragment(new SubjectsFragment(),false);
                }else{
                    loadFragment(personFragment,false);
                }

                return true;
            }
        });

    }
    private void loadFragment(Fragment fragment, boolean isAppInitialized) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (!isAppInitialized && fragmentManager.findFragmentById(R.id.frameLayout) != null) {
            fragmentTransaction.replace(R.id.frameLayout, fragment);
        } else {
            fragmentTransaction.add(R.id.frameLayout, fragment);
        }

        fragmentTransaction.addToBackStack(null); // Đảm bảo Fragment được thêm vào BackStack
        fragmentTransaction.commit();
    }
}