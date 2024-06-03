package thi.LeMinhQuocBao63131845.DeThi2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class MyCVFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_c_v, container, false);


        Button facebookButton = view.findViewById(R.id.btnlk);

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getActivity().getPackageManager().getPackageInfo("com.facebook.katana", 0);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/<id_here>"));
                    startActivity(intent);
                } catch (Exception e) {
                    // Nếu chưa cài đặt ứng dụng Facebook, mở trang web Facebook
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/laokao223/"));
                    startActivity(intent);
                }
            }
        });

        return view;
    }
}
