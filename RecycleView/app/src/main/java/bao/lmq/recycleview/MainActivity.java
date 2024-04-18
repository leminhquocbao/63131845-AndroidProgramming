package bao.lmq.recycleview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ExanAdapter examAdapter;
    ArrayList<ExamView> recycleViewData;
    RecyclerView recyclerViewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleViewData = getDataFor();
        recyclerViewData= findViewById(R.id.recycleExam);

    RecyclerView.LayoutManager layoutLiner = new LinearLayoutManager(this);

        recyclerViewData.setLayoutManager(layoutLiner);
        examAdapter = new ExanAdapter(this,recycleViewData);

        recyclerViewData.setAdapter(examAdapter);
    }
    ArrayList<ExamView> getDataFor(){
        ArrayList<ExamView> dsDuLieu = new ArrayList<ExamView>();
        ExamView exam1=new ExamView("Fist Exam","May 23,2015","Best of luck");
        ExamView exam2=new ExamView("Second Exam","June 09,2015","b of l");
        ExamView exam3=new ExamView("My Test Exam","April 27,2017","This is testing exam .. ");

        dsDuLieu.add(exam1);
        dsDuLieu.add(exam2);
        dsDuLieu.add(exam3);
        return  dsDuLieu;
    }
}