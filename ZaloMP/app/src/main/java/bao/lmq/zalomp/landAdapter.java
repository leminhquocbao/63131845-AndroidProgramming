package bao.lmq.zalomp;

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

public class landAdapter extends RecyclerView.Adapter<landAdapter.ItemLandHolder> {
    Context context;
    ArrayList<land> lstData;

    public landAdapter(Context context, ArrayList<land> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom=LayoutInflater.from(context);
        View vItem=cai_bom.inflate(R.layout.item_land, parent, false);
        ItemLandHolder viewholderCreated = new ItemLandHolder(vItem);
        return viewholderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        //Lấy đối tượng hiển thị
        land landScapeHienthi = lstData.get(position);

        String caption=landScapeHienthi.getLandCation();
        String tenAnh=landScapeHienthi.getLandImageFileName();
        //Đặt và các trường thông tin của holder
        holder.tvCaption.setText(caption);
        //Đặt ảnh

        String packetName =holder.itemView.getContext().getPackageName();
        int imageID =holder.itemView.getResources().getIdentifier(tenAnh, "mipmap",packetName);
        holder.ivLandScape.setImageResource(imageID);

    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    class  ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvCaption;
        ImageView ivLandScape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.textViewCation);
            ivLandScape =itemView.findViewById(R.id.imageViewLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int vitriDuocClick=getAdapterPosition();
            land phanTuDuocClick= lstData.get(vitriDuocClick);
            //Bóc thông tin
            String ten = phanTuDuocClick.getLandCation();
            String tenFile=phanTuDuocClick.getLandImageFileName();
            //Toast Tên
            String chuoiThongBao= "Bạn vừa Click: " +ten;
            Toast.makeText(v.getContext(),chuoiThongBao,Toast.LENGTH_SHORT).show();

        }
    }
}
