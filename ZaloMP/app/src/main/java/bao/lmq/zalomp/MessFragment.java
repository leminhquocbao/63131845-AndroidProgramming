package bao.lmq.zalomp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MessFragment extends Fragment {

        ExamAdapter examAdapter;
        ArrayList<Exam> recycleViewData;
        RecyclerView recyclerViewData;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_mess, container, false);
            recycleViewData = getDataFor();
            recyclerViewData= view.findViewById(R.id.recycleExam);

            RecyclerView.LayoutManager layoutLiner = new LinearLayoutManager(getActivity());

            recyclerViewData.setLayoutManager(layoutLiner);
            examAdapter = new ExamAdapter(getActivity(),recycleViewData);

            recyclerViewData.setAdapter(examAdapter);
            return view;
        }

        ArrayList<Exam> getDataFor(){
            ArrayList<Exam> dsDuLieu = new ArrayList<Exam>();
            Exam exam1=new Exam("Fist Exam","May 23,2015","Best of luck");
            Exam exam2=new Exam("Second Exam","June 09,2015","b of l");
            Exam exam3=new Exam("Thirst Exam","April 27,2017","This is testing exam .. ");
            Exam exam4=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");
            Exam exam5=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");
            Exam exam6=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");
            Exam exam7=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");
            Exam exam8=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");
            Exam exam9=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");
            Exam exam10=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");
            Exam exam11=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");
            Exam exam12=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");
            Exam exam13=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");
            Exam exam14=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");
            Exam exam15=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");
            Exam exam16=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");
            Exam exam17=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");
            Exam exam18=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");
            Exam exam19=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");
            Exam exam20=new Exam("My Test Exam","April 27,2017","This is testing exam .. ");

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
