package bao.lmq.zalomp;

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

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
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
        PersonFragment personFragment = new PersonFragment();
        personFragment.setArguments(bundle);

        // Load PersonFragment lên giao diện
        loadFragment(personFragment, true);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId=item.getItemId();

                if(itemId== R.id.navMess){
                    loadFragment(new MessFragment(),false);
                } else if (itemId==R.id.navCatolo) {
                    loadFragment(new CatoloFragment(),false);
                }else if (itemId==R.id.navApplication) {
                    loadFragment(new ApplicationFragment(),false);
                }else if (itemId==R.id.navClock) {
                    loadFragment(new ClockFragment(),false);
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
