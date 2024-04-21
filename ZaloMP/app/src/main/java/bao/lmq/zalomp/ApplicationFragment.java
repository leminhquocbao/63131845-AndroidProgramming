package bao.lmq.zalomp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class ApplicationFragment extends Fragment {

    Button shopButton1, shopButton2, shopButton3, shopButton4, shopButton5, shopButton6, shopButton7, shopButton8;
    ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_application, container, false);

        // Initialize the buttons and image views
        shopButton1 = view.findViewById(R.id.btn1);
        imageView1 = view.findViewById(R.id.img1);
        shopButton2 = view.findViewById(R.id.btn2);
        imageView2 = view.findViewById(R.id.img2);
        shopButton3 = view.findViewById(R.id.btn3);
        imageView3 = view.findViewById(R.id.img3);
        shopButton4 = view.findViewById(R.id.btn4);
        imageView4 = view.findViewById(R.id.img4);
        shopButton5 = view.findViewById(R.id.btn5);
        imageView5 = view.findViewById(R.id.img5);
        shopButton6 = view.findViewById(R.id.btn6);
        imageView6 = view.findViewById(R.id.img6);
        shopButton7 = view.findViewById(R.id.btn7);
        imageView7 = view.findViewById(R.id.img7);
        shopButton8 = view.findViewById(R.id.btn8);
        imageView8 = view.findViewById(R.id.img8);

        // Set click listeners for each button
        shopButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView1.setImageResource(R.mipmap.anh1);
            }
        });
        shopButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView2.setImageResource(R.mipmap.anh2);
            }
        });
        shopButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView3.setImageResource(R.mipmap.anh3);
            }
        });
        shopButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView4.setImageResource(R.mipmap.anh4);
            }
        });
        shopButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView5.setImageResource(R.mipmap.anh5);
            }
        });
        shopButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView6.setImageResource(R.mipmap.anh6);
            }
        });
        shopButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView7.setImageResource(R.mipmap.anh7);
            }
        });
        shopButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView8.setImageResource(R.mipmap.anh8);
            }
        });
        // Repeat for the rest of the buttons...

        return view;
    }
}
