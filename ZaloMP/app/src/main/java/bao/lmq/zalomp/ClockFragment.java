package bao.lmq.zalomp;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextClock;

import androidx.fragment.app.Fragment;

public class ClockFragment extends Fragment {

    private Handler handler = new Handler();
    private boolean timerRunning = false;
    private long timeInSeconds = 0; // Start from 0
    private TextClock txtclock;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clock, container, false);

        txtclock = view.findViewById(R.id.textClock);
        Button startButton = view.findViewById(R.id.button_start);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!timerRunning) {
                    startTimer();
                } else {
                    stopTimer();
                }
            }
        });

        return view;
    }

    private void startTimer() {
        timerRunning = true;
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (timerRunning) {
                    updateCountUpText();
                    handler.postDelayed(this, 1000);
                }
            }
        });
    }

    private void stopTimer() {
        timerRunning = false;
    }

    private void updateCountUpText() {
        int hours = (int) (timeInSeconds / 3600);
        int minutes = (int) ((timeInSeconds % 3600) / 60);
        int seconds = (int) (timeInSeconds % 60);

        String timeFormatted = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        txtclock.setText(timeFormatted);

        timeInSeconds++;
    }
}
