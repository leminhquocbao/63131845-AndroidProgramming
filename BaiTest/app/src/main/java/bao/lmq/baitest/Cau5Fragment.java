package bao.lmq.baitest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Cau5Fragment extends Fragment {

    public class Book {
        private int idSach;
        private String tenSach;
        private int soTrang;
        private float gia;
        private String mota;

        public Book(int idSach, String tenSach, int soTrang, float gia, String mota) {
            this.idSach = idSach;
            this.tenSach = tenSach;
            this.soTrang = soTrang;
            this.gia = gia;
            this.mota = mota;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SQLiteDatabase db = getActivity().openOrCreateDatabase("QLSach.db",
                Context.MODE_PRIVATE,
                null);

        String sqlXoa = "DROP TABLE IF EXISTS Books;";
        String sqlTao = "CREATE TABLE Books(BookID interger PRIMARY KEY," +
                "BookName text, " +
                "Page interger," +
                "Price Float," +
                "Description text);";
        db.execSQL(sqlXoa);
        db.execSQL(sqlTao);

        String sql1 = "INSERT INTO Books VALUES(1,'JAVA',100,9.99,'sách về Java');";
        String sql2 = "INSERT INTO Books VALUES(2,'Lập Trình Hướng đối tượng',200,95.99,'Lập trình hướng đối tượng');";
        String sql3 = "INSERT INTO Books VALUES(3,'Tán người yêu',300,9.99,'sách về cách tán crush');";
        String sql4 = "INSERT INTO Books VALUES(4,'Dạy con',400,9.99,'hết cứu chỉ có mô phật');";
        String sql5 = "INSERT INTO Books VALUES(5,'Yêu ems',500,9.99,':))))');";
        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);

        String sqlSelect = "Select * from Books";
        Cursor cs = db.rawQuery(sqlSelect, null);
        ArrayList<Book> dsSach = new ArrayList<Book>();

        while (cs.moveToNext()) {
            int idSach = cs.getInt(0);
            String tenSach = cs.getString(1);
            int soTrang = cs.getInt(2);
            float gia = cs.getFloat(3);
            String mota = cs.getString(4);
            Book b = new Book(idSach, tenSach, soTrang, gia, mota);
            dsSach.add(b);
        }

        View viewCau4 = inflater.inflate(R.layout.fragment_cau5, container, false);
        TableLayout table = viewCau4.findViewById(R.id.table);

        for (final Book b : dsSach) {
            TableRow row = new TableRow(getContext());
            TextView tvId = new TextView(getContext());
            tvId.setText(String.valueOf(b.idSach));
            TextView tvTen = new TextView(getContext());
            tvTen.setText(b.tenSach);
            TextView tvSoTrang = new TextView(getContext());
            tvSoTrang.setText(String.valueOf(b.soTrang));
            TextView tvGia = new TextView(getContext());
            tvGia.setText(String.valueOf(b.gia));
            TextView tvMota = new TextView(getContext());
            tvMota.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            tvMota.setText(b.mota);
            tvMota.setPadding(5, 5, 5, 5); // Đặt padding nếu cần

            row.addView(tvId);
            row.addView(tvTen);
            row.addView(tvSoTrang);
            row.addView(tvGia);
            row.addView(tvMota);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "You clicked on: " + b.tenSach, Toast.LENGTH_SHORT).show();
                }
            });

            table.addView(row);
        }


        return viewCau4;
    }
}
