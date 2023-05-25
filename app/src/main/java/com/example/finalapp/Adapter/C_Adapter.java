package com.example.finalapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalapp.HomeCryptoData;
import com.example.finalapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class C_Adapter extends RecyclerView.Adapter<C_Adapter.MyViewHolder> {
    Context context;
    ArrayList<HomeCryptoData> homeCryptoData;

    public C_Adapter(Context context, ArrayList<HomeCryptoData> homeCryptoData){
        this.context=context;
        this.homeCryptoData = homeCryptoData;
    }

    @NonNull
    @Override
    public C_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_row,parent,false);
        return new C_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull C_Adapter.MyViewHolder holder, int position) {
        holder.tvName.setText(homeCryptoData.get(position).getCryptoname());
        holder.tvLP.setText(homeCryptoData.get(position).getLastprice());
        holder.tvChanges.setText(homeCryptoData.get(position).getChanges());
    }

    @Override
    public int getItemCount() {
        return homeCryptoData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvLP, tvChanges;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.txtCName);
            tvLP = itemView.findViewById(R.id.LP);
            tvChanges = itemView.findViewById(R.id.Changes);
        }
    }
}
