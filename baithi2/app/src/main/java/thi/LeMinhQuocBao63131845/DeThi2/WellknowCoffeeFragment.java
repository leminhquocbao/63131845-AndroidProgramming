package thi.LeMinhQuocBao63131845.DeThi2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class WellknowCoffeeFragment extends Fragment {
    cau1Adapter examAdapter;
    ArrayList<cau1> recycleViewData;
    RecyclerView recyclerViewData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wellknow_coffee, container, false);
        recycleViewData = getDataFor();
        recyclerViewData= view.findViewById(R.id.recycleExam);

        RecyclerView.LayoutManager layoutLiner = new LinearLayoutManager(getActivity());

        recyclerViewData.setLayoutManager(layoutLiner);
        examAdapter = new cau1Adapter(getActivity(),recycleViewData);

        recyclerViewData.setAdapter(examAdapter);
        return view;
    }

    ArrayList<cau1> getDataFor(){
        ArrayList<cau1> dsDuLieu = new ArrayList<cau1>();
        cau1 exam1=new cau1("Blu:m Coffee  "," Số 9 Nguyễn Hữu Huân, Phước Tiến, Nha Trang, Khánh Hòa","Best of luck","anh1");
        cau1 exam2=new cau1("The Sol Coffee","124 Nhị Hà, Nha Trang","b of l","anh2");
        cau1 exam3=new cau1("Gác de.art ","44 Phong Châu, Nha Trang","This is testing exam .. ","anh3");
        cau1 exam4=new cau1("I Am Cake Cafe & Brunch  ","17 Hát Giang, Phước Hòa, Nha Trang","This is testing exam .. ","anh4");
        cau1 exam5=new cau1("April's House","55 Trương Hán Siêu, Phước long, Nha Trang","This is testing exam .. ","anh5");
        cau1 exam6=new cau1("The Busan Park    ","69 Phạm Văn Đồng, Nha Trang","This is testing exam .. ","anh6");
        cau1 exam7=new cau1("Mokuzo Cafe ","112 Đường Phong Châu, Đất Lành, Vĩnh Thái, Nha Trang","This is testing exam .. ","anh7");


        dsDuLieu.add(exam1);
        dsDuLieu.add(exam2);
        dsDuLieu.add(exam3);
        dsDuLieu.add(exam4);
        dsDuLieu.add(exam5);
        dsDuLieu.add(exam6);
        dsDuLieu.add(exam7);

        return  dsDuLieu;
    }
}