package bao.lmq.baithi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cau4Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        SQLiteDatabase db =getActivity().openOrCreateDatabase("QLSach.db",
//                Context.MODE_PRIVATE,
//                null);
//
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
//        String sql2="INSERT INTO Books VALUES(2,'JAVA',200,9.99,'sách về Java');";
//        String sql3="INSERT INTO Books VALUES(3,'JAVA',300,9.99,'sách về Java');";
//        String sql4="INSERT INTO Books VALUES(4,'JAVA',400,9.99,'sách về Java');";
//        String sql5="INSERT INTO Books VALUES(5,'JAVA',500,9.99,'sách về Java');";
//        db.execSQL(sql1);
//        db.execSQL(sql2);
//        db.execSQL(sql3);
//        db.execSQL(sql4);
//        db.execSQL(sql5);
//
//        db.close();
        // Inflate the layout for this fragment
        SQLiteDatabase db =getActivity().openOrCreateDatabase("QLSach.db",
                Context.MODE_PRIVATE,
                null);
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

        View viewCau4 =inflater.inflate(R.layout.fragment_cau4, container, false);
        ListView listViewTenSach = viewCau4.findViewById(R.id.lvTenSach);
        ArrayAdapter<String> adapterTenSach= new ArrayAdapter<String>(
                getContext(), android.R.layout.simple_list_item_1,dsTenSach
        );
        listViewTenSach.setAdapter(adapterTenSach);

        return viewCau4;
    }
}