package bao.lmq.viduvesqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText edtmaLop,edttenLop,edtsySo;
Button btnInsert,btnDelete,btnUpdate,btnQuery;
ListView lv;
ArrayList<String> mylist;
ArrayAdapter<String> myadapter;
SQLiteDatabase mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtmaLop=findViewById(R.id.edtMaLop);
        edttenLop=findViewById(R.id.edtTenLop);
        edtsySo=findViewById(R.id.edtSySo);

        btnInsert=findViewById(R.id.btnInsert);
        btnDelete=findViewById(R.id.btnDelete);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnQuery=findViewById(R.id.btnQuery);

        lv=findViewById(R.id.lv);
    mylist=new ArrayList<>();
    myadapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,mylist);
    mydatabase=openOrCreateDatabase("qlSinhVien.db",MODE_PRIVATE,null);
    try{
        String sql="CREATE TABLE tbllop(malop TEXT PRIMARY KEY,tenlop TEXT,syso INTERGER)";
        mydatabase.execSQL(sql);
    }
    catch (Exception e){
        Log.e("Error","Table đã tồn tại");
    }
btnInsert.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String malop=edtmaLop.getText().toString();
        String tenlop=edttenLop.getText().toString();
        int syso=Integer.parseInt(edtsySo.getText().toString());
        ContentValues myValues= new ContentValues();
        myValues.put("malop",malop);
        myValues.put("tenlop",tenlop);
        myValues.put("syso",syso);

        String msg="";
        if(mydatabase.insert("tbllop",null,myValues)==-1){
            msg="Fail to Insert Record!";
        }
        else {
            msg="Insert Record";
        }
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
    }
});
    btnDelete.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String malop=edtmaLop.getText().toString();
            int n=mydatabase.delete("tbllop","malop = ?",new String[]{malop});
            String msg="";
            if(n==0){
                msg="No record to Delete";

            }
            else {
                msg=n+" Record is deleted";
            }
            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        }
    });
    btnUpdate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int syso=Integer.parseInt(edtsySo.getText().toString());
            String malop=edtmaLop.getText().toString();
            ContentValues myValues= new ContentValues();
            myValues.put("syso",syso);

            int n =mydatabase.update("tbllop",myValues,"malop = ?",new String[]{malop});
            String msg="";
            if(n==0){
                msg="No record to Update";

            }
            else {
                msg=n+" Record is Update";
            }
            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        }
    });
    btnQuery.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mylist.clear();
            Cursor c=mydatabase.query("tbllop",null,null,null,null,null,null);
            c.moveToNext();
            String data="";
            while (c.isAfterLast()==false){
                data=c.getString(0)+" - "+c.getString(1)+" - "+c.getString(2);
                c.moveToNext();
                mylist.add(data);
            }
            c.close();
            myadapter.notifyDataSetChanged();
        }
    });
    }
}