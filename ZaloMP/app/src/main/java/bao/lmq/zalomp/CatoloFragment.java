package bao.lmq.zalomp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class CatoloFragment extends Fragment {

    landAdapter landScapeAdapter;
    ArrayList<land> recylerViewData;
    RecyclerView recyclerViewLandScape;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catolo, container, false);

        //3
        recylerViewData = getDataForRecyclerView();
        //4
        recyclerViewLandScape = view.findViewById(R.id.recyclerLand);
        //5
        RecyclerView.LayoutManager layoutLiner = new LinearLayoutManager(getActivity());
        recyclerViewLandScape.setLayoutManager(layoutLiner);
        // RecyclerView.LayoutManager layoutLinerHorizonal = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        //recyclerViewLandScape.setLayoutManager(layoutLinerHorizonal); dạng ngang
        //RecyclerView.LayoutManager layoutGrid = new GridLayoutManager(getActivity(),2);
        //recyclerViewLandScape.setLayoutManager(layoutGrid);
        //6
        landScapeAdapter = new landAdapter(getActivity(), recylerViewData);
        recyclerViewLandScape.setAdapter(landScapeAdapter);

        return view;
    }

    ArrayList<land> getDataForRecyclerView(){
        ArrayList<land> dsDuLieu = new ArrayList<land>();
        land landScape1= new land("anh5","Ảnh thư viện máy có sẵn");
        dsDuLieu.add(landScape1);
        dsDuLieu.add(new land("anh1","Tháp Effel"));
        dsDuLieu.add(new land("anh2","Ảnh thư viện "));
        dsDuLieu.add(new land("anh3","Ảnh thư viên á"));
        dsDuLieu.add(new land("anh4","Cũng là ảnh thư viện nhưng thứ 2"));
        dsDuLieu.add(new land("anh6","Tháp pa"));
        dsDuLieu.add(new land("anh7","Tháp phúc"));
        dsDuLieu.add(new land("anh8","cầu Effel"));
        dsDuLieu.add(new land("anh9","Ảnh thư viện "));
        dsDuLieu.add(new land("anh10","khóng Effel"));
        dsDuLieu.add(new land("anh11","Hông viết nữa"));
        dsDuLieu.add(new land("anh12","Khách sạn"));
        dsDuLieu.add(new land("anh13","Nhà hàng "));
        dsDuLieu.add(new land("anh14","Cơm trưa"));
        dsDuLieu.add(new land("anh15","Hồ bơi "));
        dsDuLieu.add(new land("anh16","Thiên Sờ slay"));

        return dsDuLieu;
    }
}
