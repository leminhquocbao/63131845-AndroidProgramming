package bao.lmq.exam1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Cau1Fragment extends Fragment {
    examAdapter examAdapter;
    ArrayList<exam> recycleViewData;
    RecyclerView recyclerViewData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cau1, container, false);
        recycleViewData = getDataFor();
        recyclerViewData= view.findViewById(R.id.recycleExam);

        RecyclerView.LayoutManager layoutLiner = new LinearLayoutManager(getActivity());

        recyclerViewData.setLayoutManager(layoutLiner);
        examAdapter = new examAdapter(getActivity(),recycleViewData);

        recyclerViewData.setAdapter(examAdapter);
        return view;
    }

    ArrayList<exam> getDataFor(){
        ArrayList<exam> dsDuLieu = new ArrayList<exam>();
        exam exam1=new exam("Fist Exam","May 23,2015","Best of luck","anh1");
        exam exam2=new exam("Second Exam","June 09,2015","b of l","anh4");
        exam exam3=new exam("Thirst Exam","April 27,2017","This is testing exam .. ","anh2");
        exam exam4=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh3");
        exam exam5=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh5");
        exam exam6=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh6");
        exam exam7=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh7");
        exam exam8=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh1");
        exam exam9=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh2");
        exam exam10=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh3");
        exam exam11=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh4");
        exam exam12=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh5");
        exam exam13=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh6");
        exam exam14=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh7");
        exam exam15=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh1");
        exam exam16=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh2");
        exam exam17=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh3");
        exam exam18=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh4");
        exam exam19=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh5");
        exam exam20=new exam("My Test Exam","April 27,2017","This is testing exam .. ","anh6");

        dsDuLieu.add(exam1);
        dsDuLieu.add(exam2);
        dsDuLieu.add(exam3);
        dsDuLieu.add(exam4);
        dsDuLieu.add(exam5);
        dsDuLieu.add(exam6);
        dsDuLieu.add(exam7);
        dsDuLieu.add(exam8);
        dsDuLieu.add(exam9);
        dsDuLieu.add(exam10);
        dsDuLieu.add(exam11);
        dsDuLieu.add(exam12);
        dsDuLieu.add(exam13);
        dsDuLieu.add(exam14);
        dsDuLieu.add(exam15);
        dsDuLieu.add(exam16);
        dsDuLieu.add(exam17);
        dsDuLieu.add(exam18);
        dsDuLieu.add(exam19);
        dsDuLieu.add(exam20);
        return  dsDuLieu;
    }
}