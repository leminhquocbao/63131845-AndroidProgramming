package bao.lmq.recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
LandScapeAdapter landScapeAdapter;
ArrayList<LandScape> recylerViewData;
RecyclerView recyclerViewLandScape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3
        recylerViewData=getDataForRecyclerView();
        //4
        recyclerViewLandScape=findViewById(R.id.recyclerLand);
        //5
       // RecyclerView.LayoutManager layoutLiner = new LinearLayoutManager(this); dạng dọc
      //  recyclerViewLandScape.setLayoutManager(layoutLiner);
       // RecyclerView.LayoutManager layoutLinerHorizonal = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //recyclerViewLandScape.setLayoutManager(layoutLinerHorizonal); dạng ngang
        RecyclerView.LayoutManager layoutGrid = new GridLayoutManager(this,2);
        recyclerViewLandScape.setLayoutManager(layoutGrid);
        //6
        landScapeAdapter = new LandScapeAdapter(this, recylerViewData);
        recyclerViewLandScape.setAdapter(landScapeAdapter);

    }


    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
        LandScape landScape1= new LandScape("anh5","Ảnh thư viện");
        dsDuLieu.add(landScape1);
        dsDuLieu.add(new LandScape("anh1","Tháp Effel"));
        dsDuLieu.add(new LandScape("anh2","Ảnh thư viện "));
        dsDuLieu.add(new LandScape("anh3","Tháp Effel"));
        dsDuLieu.add(new LandScape("anh4","Tháp Effel"));
        dsDuLieu.add(new LandScape("anh6","Tháp Effel"));
        dsDuLieu.add(new LandScape("anh7","Tháp Effel"));
return dsDuLieu;
    };
}