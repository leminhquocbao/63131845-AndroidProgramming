package bao.lmq.bottromnavigationdraw;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
ImageButton buttonDrawerToggle;
NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    drawerLayout = findViewById(R.id.drawerLayout);
    buttonDrawerToggle = findViewById(R.id.buttonDrawerToggle);
    navigationView =findViewById(R.id.navigationView);
    buttonDrawerToggle.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          drawerLayout.open();
        }
    });

View headerView= navigationView.getHeaderView(0);
        ImageView userImage=headerView.findViewById(R.id.userImage);
        TextView textUserName=headerView.findViewById(R.id.textUserName);

       userImage.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(MainActivity.this,textUserName.getText(),Toast.LENGTH_SHORT).show();
           }
       });


    navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int itemId = item.getItemId();
            if (itemId == R.id.navMenu){
                Toast.makeText(MainActivity.this, "Menu click",Toast.LENGTH_SHORT).show();
            }
            if (itemId == R.id.navCart){
                Toast.makeText(MainActivity.this, "Cart click",Toast.LENGTH_SHORT).show();
            }
            if (itemId == R.id.navFavorite){
                Toast.makeText(MainActivity.this, "Favorite click",Toast.LENGTH_SHORT).show();
            }
            if (itemId == R.id.navOrders){
                Toast.makeText(MainActivity.this, "Orders click",Toast.LENGTH_SHORT).show();
            }
            if (itemId == R.id.navHistory){
                Toast.makeText(MainActivity.this, "History click",Toast.LENGTH_SHORT).show();
            }
            if (itemId == R.id.navFeedback){
                Toast.makeText(MainActivity.this, "FeadBack click",Toast.LENGTH_SHORT).show();
            }
            if (itemId == R.id.navTerms){
                Toast.makeText(MainActivity.this, "Terms click",Toast.LENGTH_SHORT).show();
            }
            if (itemId == R.id.navContact){
                Toast.makeText(MainActivity.this, "Contacts click",Toast.LENGTH_SHORT).show();
            }
          if(itemId ==R.id.navShare) {
                Toast.makeText(MainActivity.this, "Share click",Toast.LENGTH_SHORT).show();
            }
        drawerLayout.close();
            return false;
        }
    });



    }
}