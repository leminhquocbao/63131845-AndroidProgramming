package bao.lmq.exam1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class examAdapter extends RecyclerView.Adapter<examAdapter.ExamViewHolder>{
    Context context;
    ArrayList<exam> lstData;

    public examAdapter(Context context, ArrayList<exam> lstData) {
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
        exam landScapeHienthi = lstData.get(position);
        exam examViewHienThi = lstData.get(position);
        String tenAnh=landScapeHienthi.getLandImageFileName();
        String name = examViewHienThi.name;
        String date = examViewHienThi.date;
        String message = examViewHienThi.message;

        holder.examName.setText(name);
        holder.examDate.setText(date);
        holder.examMessage.setText(message);
        String packetName =holder.itemView.getContext().getPackageName();
        int imageID =holder.itemView.getResources().getIdentifier(tenAnh, "mipmap",packetName);
        holder.ivLandScape.setImageResource(imageID);
    }
    @Override
    public int getItemCount() {
        return lstData.size();
    }

    class ExamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView examName;
        TextView examMessage;
        TextView examDate;

        ImageView ivLandScape;
        public ExamViewHolder(@NonNull View itemView) {
            super(itemView);
            examName = itemView.findViewById(R.id.examName);
            examMessage = itemView.findViewById(R.id.examMessage);
            examDate = itemView.findViewById(R.id.examDate);
            ivLandScape=itemView.findViewById(R.id.imageViewLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int vitriDuocClick = getAdapterPosition();
            exam phanTuDuocChon = examAdapter.this.lstData.get(vitriDuocClick);
            String ten = phanTuDuocChon.name;
            String date = phanTuDuocChon.date;
            String message = phanTuDuocChon.message;
            String anh=phanTuDuocChon.landImageFileName;
            String chuoiThongBao = "Bạn vừa click: " + ten;
            Toast.makeText(v.getContext(), chuoiThongBao, Toast.LENGTH_SHORT).show();
        }

    }

}