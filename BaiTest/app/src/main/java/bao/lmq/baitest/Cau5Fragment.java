package bao.lmq.baitest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class Cau5Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
                SQLiteDatabase db =getActivity().openOrCreateDatabase("QLSach.db",
                Context.MODE_PRIVATE,
                null);

//        String sqlXoa="DROP TABLE IF EXISTS Books;";
//        String sqlTao="CREATE TABLE Books(BookID interger PRIMARY KEY,"+
//                                                "BookName text, "+
//                                                "Page interger,"+
//                                                "Price Float,"+
//                                                "Description text);";
//        db.execSQL(sqlXoa);
//        db.execSQL(sqlTao);
//
//        String sql1="INSERT INTO Books VALUES(1,'JAVA',100,9.99,'sách về Java');";
//        String sql2="INSERT INTO Books VALUES(2,'Lập Trình Hướng đối tượng',200,95.99,'Lập trình hướng đối tượng');";
//        String sql3="INSERT INTO Books VALUES(3,'Tán người yêu',300,9.99,'sách về cách tán crush');";
//        String sql4="INSERT INTO Books VALUES(4,'Dạy con',400,9.99,'hết cứu chỉ có mô phật');";
//        String sql5="INSERT INTO Books VALUES(5,'Yêu ems',500,9.99,':))))');";
//        db.execSQL(sql1);
//        db.execSQL(sql2);
//        db.execSQL(sql3);
//        db.execSQL(sql4);
//        db.execSQL(sql5);
//
//        db.close();

        String sqlSelect="Select * from Books";
        Cursor cs =db.rawQuery(sqlSelect,null);
        cs.moveToNext();
        ArrayList<Book> dsSach=new ArrayList<Book>();

        while (cs.moveToNext()){
            int idSach=cs.getInt(0);
            String tenSach=cs.getString(1);
            int soTrang=cs.getInt(2);
            float gia =cs.getFloat(3);
            String mota=cs.getString(4);
            Book b=new Book(idSach,tenSach,soTrang,gia,mota);
            dsSach.add(b);
        }


        ArrayList<String> dsTenSach= new ArrayList<String>();
        for(int i=0;i<dsSach.size(); i++ )
            dsTenSach.add(dsSach.get(i).getBookName());

        View viewCau4 =inflater.inflate(R.layout.fragment_cau5, container, false);
       ListView listViewTenSach=viewCau4.findViewById(R.id.lvTenSach);
        ArrayAdapter<String> adapterTenSach= new ArrayAdapter<String>(
                getContext(), android.R.layout.simple_list_item_1,dsTenSach
        );
        listViewTenSach.setAdapter(adapterTenSach);


        return viewCau4;
    }
}