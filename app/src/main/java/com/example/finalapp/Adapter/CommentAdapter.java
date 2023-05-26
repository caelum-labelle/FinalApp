package com.example.finalapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalapp.Domain.UserComment;
import com.example.finalapp.R;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> {
    List<UserComment> comment;

    private OnItemClickListener onItemClick;

    public interface OnItemClickListener {
        void onItemClick(UserComment data);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClick = listener;
    }

    public CommentAdapter(List<UserComment> comment){
        this.comment = comment;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView user,userComment;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            user = itemView.findViewById(R.id.txtHName);
            userComment = itemView.findViewById(R.id.txtHComment);

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
    public CommentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_row, parent, false);
        return new CommentAdapter.MyViewHolder(view);
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.recyclerview_row,parent,false);
//        return new C_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.MyViewHolder holder, int position) {
        UserComment comm = comment.get(position);
        holder.user.setText(comment.get(position).getUsername());
        holder.userComment.setText(comment.get(position).getComment());

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (onItemClick != null) {
                    onItemClick.onItemClick(comm);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return comment.size();
    }
}
