package bao.lmq.examfinal;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Navigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        BottomNavigationView bottomNav=findViewById(R.id.bottomNavigationView);
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFrament=null;
                int itemId=item.getItemId();
                if (itemId==R.id.nav_home){
                    selectedFrament =new HomeFragment();
                } else if(itemId==R.id.nav_cau1){
                    selectedFrament =new Cau1Fragment();
                } else if(itemId==R.id.nav_cau2){
                    selectedFrament =new Cau2Fragment();
                } else if(itemId==R.id.nav_cau3){
                    selectedFrament =new Cau3Fragment();
                } else if(itemId==R.id.nav_cau4){
                    selectedFrament =new Cau4Fragment();
                }

                if (selectedFrament !=null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentSpace,selectedFrament).commit();
                }
                return true;
            }
        });
    }
}