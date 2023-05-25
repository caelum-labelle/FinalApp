package com.example.finalapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalapp.HomeCryptoData;
import com.example.finalapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class C_Adapter extends RecyclerView.Adapter<C_Adapter.MyViewHolder> {
    Context context;
    List<HomeCryptoData> homeCryptoData;

    private OnItemClickListener onItemClick;

    public interface OnItemClickListener {
        void onItemClick(HomeCryptoData data);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClick = listener;
    }

    public C_Adapter(List<HomeCryptoData> homeCryptoData){
        this.homeCryptoData = homeCryptoData;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvLP, tvChanges;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.txtCName);
            tvLP = itemView.findViewById(R.id.LP);
            tvChanges = itemView.findViewById(R.id.Changes);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), "Image clicked!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @NonNull
    @Override
    public C_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row, parent, false);
        return new C_Adapter.MyViewHolder(view);
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.recyclerview_row,parent,false);
//        return new C_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull C_Adapter.MyViewHolder holder, int position) {
        HomeCryptoData data = homeCryptoData.get(position);

        holder.tvName.setText(homeCryptoData.get(position).getCryptoname());
        holder.tvLP.setText(homeCryptoData.get(position).getLastprice());
        holder.tvChanges.setText(homeCryptoData.get(position).getChanges());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick(data);
                    System.out.println("Clicked");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeCryptoData.size();
    }
}
