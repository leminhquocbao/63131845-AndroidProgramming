package til.example.cau4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CustomListAdapter extends BaseAdapter {

    private Context context;
    private List<String> titles;
    private List<String> descriptions;

    public CustomListAdapter(Context context, List<String> titles, List<String> descriptions) {
        this.context = context;
        this.titles = titles;
        this.descriptions = descriptions;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return titles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.custom_list_view, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.image_view);
            viewHolder.textViewTitle = convertView.findViewById(R.id.text_view_title);
            viewHolder.textViewDescription = convertView.findViewById(R.id.text_view_description);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Set data for each item
        viewHolder.imageView.setImageResource(R.drawable.ic_launcher);
        viewHolder.textViewTitle.setText(titles.get(position));
        viewHolder.textViewDescription.setText(descriptions.get(position));

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView textViewTitle;
        TextView textViewDescription;
    }
}

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> titles;
    private List<String> descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        // Initialize data
        titles = Arrays.asList("Octopus", "Pig", "Sheep", "Rabbit", "Snake");
        descriptions = Arrays.asList("8 tentacled monster", "Delicious in rolls", "Great for jumpers", "Nice in a stew", "Great for shoes");

        // Create adapter
        CustomListAdapter adapter = new CustomListAdapter(this, titles, descriptions);

        // Set adapter to ListView
        listView.setAdapter(adapter);
    }
}
