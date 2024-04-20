package bao.lmq.buttonnavigation;

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
        loadFragment(new HomeFragment(),true);

    bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            
            int itemId=item.getItemId();
            
            if(itemId== R.id.navHome){
                loadFragment(new HomeFragment(),false);
            } else if (itemId==R.id.navSearch) {
                loadFragment(new SearchFragment(),false);
            }else if (itemId==R.id.navNotification) {
                    loadFragment(new NotificationFragment(),false);
            }else if (itemId==R.id.navProfile) {
                loadFragment(new ProfileFragment(),false);
            }


            return true;
        }
    });

    }
    private void loadFragment(Fragment fragment,boolean isAppInitialized){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialized){
            fragmentTransaction.add(R.id.frameLayout,fragment);
        }else {
            fragmentTransaction.replace(R.id.frameLayout,fragment);
        }


        fragmentTransaction.commit();
    }
}