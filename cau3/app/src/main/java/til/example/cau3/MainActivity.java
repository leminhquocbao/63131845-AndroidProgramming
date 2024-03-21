package til.example.cau3;

import androidx.appcompat.app.AppCompatActivity;

import  java.util.*;

import android.os.*;
import android.view.*;
import android.widget.*;



public class MainActivity extends AppCompatActivity {

    ArrayList<String> items = new ArrayList<>();
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editTextIndex, editTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        editTextIndex = findViewById(R.id.editTextIndex);
        editTextValue = findViewById(R.id.editTextValue);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            editTextIndex.setText(String.valueOf(position));
            editTextValue.setText(items.get(position));
        });

        findViewById(R.id.buttonSave).setOnClickListener(v -> {
            int index = Integer.parseInt(editTextIndex.getText().toString());
            String value = editTextValue.getText().toString();
            items.set(index, value);
            adapter.notifyDataSetChanged();
        });

        findViewById(R.id.buttonAdd).setOnClickListener(v -> {
            String value = editTextValue.getText().toString();
            items.add(value);
            adapter.notifyDataSetChanged();
        });

        findViewById(R.id.buttonDelete).setOnClickListener(v -> {
            int index = Integer.parseInt(editTextIndex.getText().toString());
            items.remove(index);
            adapter.notifyDataSetChanged();
        });
    }

}