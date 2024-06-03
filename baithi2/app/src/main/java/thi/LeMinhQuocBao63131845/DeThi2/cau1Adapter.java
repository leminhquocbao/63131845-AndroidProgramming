package thi.LeMinhQuocBao63131845.DeThi2;

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

public class cau1Adapter extends RecyclerView.Adapter<cau1Adapter.ExamViewHolder>{
    Context context;
    ArrayList<cau1> lstData;

    public cau1Adapter(Context context, ArrayList<cau1> lstData) {
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
        cau1 landScapeHienthi = lstData.get(position);
        cau1 examViewHienThi = lstData.get(position);
        String tenAnh=landScapeHienthi.getLandImageFileName();
        String name = examViewHienThi.name;
        String date = examViewHienThi.date;

        holder.examName.setText(name);
        holder.examDate.setText(date);
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
        TextView examDate;
        ImageView ivLandScape;
        public ExamViewHolder(@NonNull View itemView) {
            super(itemView);
            examName = itemView.findViewById(R.id.examName);
            examDate = itemView.findViewById(R.id.examDate);
            ivLandScape=itemView.findViewById(R.id.imageViewLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int vitriDuocClick = getAdapterPosition();
            cau1 phanTuDuocChon = cau1Adapter.this.lstData.get(vitriDuocClick);
            String ten = phanTuDuocChon.name;
            String date = phanTuDuocChon.date;
            String anh=phanTuDuocChon.landImageFileName;
            String chuoiThongBao = "Bạn vừa click: " + ten;
            Toast.makeText(v.getContext(), chuoiThongBao, Toast.LENGTH_SHORT).show();
        }

    }

}
