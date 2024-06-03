package thi.LeMinhQuocBao63131845.DeThi2;

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


public class SubjectsFragment extends Fragment {
    public class Book {
        private int idSach;
        private String mamonhoc;
        private String tenmonhoc;

        public Book(int idSach, String mamonhoc, String tenmonhoc) {
            this.idSach = idSach;
            this.mamonhoc = mamonhoc;
            this.tenmonhoc = tenmonhoc;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SQLiteDatabase db = getActivity().openOrCreateDatabase("Subjects.db",
                Context.MODE_PRIVATE,
                null);

        String sqlXoa = "DROP TABLE IF EXISTS Books;";
        String sqlTao = "CREATE TABLE Books(BookID interger PRIMARY KEY," +
                "BookName text, " +
                "Description text);";
        db.execSQL(sqlXoa);
        db.execSQL(sqlTao);

        String sql1 = "INSERT INTO Books VALUES(1,'ST3042','Lập Trình thiết bị android');";
        String sql2 = "INSERT INTO Books VALUES(2,'CD3942','Kiểm toán');";
        String sql3 = "INSERT INTO Books VALUES(3,'FR0324','Tiếng anh chuyên ngành');";
        String sql4 = "INSERT INTO Books VALUES(4,'LR8733','Ngôn Ngữ Học Thuật');";
        String sql5 = "INSERT INTO Books VALUES(5,'GR4324','Thiết kế Web');";
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
            String mota = cs.getString(2);
            Book b = new Book(idSach, tenSach, mota);
            dsSach.add(b);
        }

        View view = inflater.inflate(R.layout.fragment_subjects, container, false);
        TableLayout table = view.findViewById(R.id.table);

        for (final Book b : dsSach) {
            TableRow row = new TableRow(getContext());
            TextView tvId = new TextView(getContext());
            tvId.setText(String.valueOf(b.idSach));
            TextView tvma = new TextView(getContext());
            tvma.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            tvma.setText(b.mamonhoc);
            TextView tvMota = new TextView(getContext());
            tvMota.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            tvMota.setText(b.tenmonhoc);
            tvMota.setPadding(5, 5, 5, 5); // Đặt padding nếu cần

            row.addView(tvId);
            row.addView(tvma);
            row.addView(tvMota);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "You clicked on: " + b.mamonhoc, Toast.LENGTH_SHORT).show();
                }
            });

            table.addView(row);
        }

        return view;
    }
}
