package bao.lmq.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ExanAdapter extends RecyclerView.Adapter<ExanAdapter.ExamViewHolder> {
    Context context;
    public static ArrayList<ExamView> lstData;
    public ExanAdapter(Context context, ArrayList<ExamView> lstData) {
        this.context = context;
        this.lstData = lstData;
    }
    @NonNull
    @Override
    public ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vItem = inflater.inflate(R.layout.exam_card, parent, false);
        return new ExamViewHolder(vItem);
    }
    @Override
    public void onBindViewHolder(@NonNull ExamViewHolder holder, int position) {
        ExamView examViewHienThi = lstData.get(position);

        String name = examViewHienThi.name;
        String date = examViewHienThi.date;
        String message = examViewHienThi.message;

        holder.examName.setText(name);
        holder.examDate.setText(date);
        holder.examMessage.setText(message);
    }
    @Override
    public int getItemCount() {
        return lstData.size(); // Thay đổi trả về số lượng mục trong danh sách dữ liệu
    }
    static class ExamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView examName;
        TextView examMessage;
        TextView examDate;

        public ExamViewHolder(@NonNull View itemView) {
            super(itemView);
            examName = itemView.findViewById(R.id.examName);
            examMessage = itemView.findViewById(R.id.examMessage);
            examDate = itemView.findViewById(R.id.examDate);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int vitriDuocClick = getAdapterPosition();
            ExamView phanTuDuocChon = lstData.get(vitriDuocClick);
            String ten = phanTuDuocChon.name;
            String date = phanTuDuocChon.date;
            String message = phanTuDuocChon.message;

            String chuoiThongBao = "Bạn vừa click: " + ten;
            Toast.makeText(v.getContext(), chuoiThongBao, Toast.LENGTH_SHORT).show();
        }

    }
}
