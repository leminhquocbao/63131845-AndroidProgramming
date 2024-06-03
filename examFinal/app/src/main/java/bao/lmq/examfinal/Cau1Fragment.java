package bao.lmq.examfinal;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class Cau1Fragment extends Fragment {
    cau1Adapter examAdapter;
    ArrayList<cau1> recycleViewData;
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
        examAdapter = new cau1Adapter(getActivity(),recycleViewData);

        recyclerViewData.setAdapter(examAdapter);
        return view;
    }

    ArrayList<cau1> getDataFor(){
        ArrayList<cau1> dsDuLieu = new ArrayList<cau1>();
        cau1 exam1=new cau1("Fist Exam","May 23,2015","Best of luck");
        cau1 exam2=new cau1("Second Exam","June 09,2015","b of l");
        cau1 exam3=new cau1("Thirst Exam","April 27,2017","This is testing exam .. ");
        cau1 exam4=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");
        cau1 exam5=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");
        cau1 exam6=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");
        cau1 exam7=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");
        cau1 exam8=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");
        cau1 exam9=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");
        cau1 exam10=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");
        cau1 exam11=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");
        cau1 exam12=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");
        cau1 exam13=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");
        cau1 exam14=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");
        cau1 exam15=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");
        cau1 exam16=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");
        cau1 exam17=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");
        cau1 exam18=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");
        cau1 exam19=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");
        cau1 exam20=new cau1("My Test Exam","April 27,2017","This is testing exam .. ");

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