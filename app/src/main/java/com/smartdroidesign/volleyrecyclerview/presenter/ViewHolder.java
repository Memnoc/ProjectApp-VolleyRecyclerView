package com.smartdroidesign.volleyrecyclerview.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartdroidesign.volleyrecyclerview.R;

class ViewHolder extends RecyclerView.ViewHolder {
    ImageView images;
    TextView authors;
    TextView likes;

    ViewHolder(@NonNull View itemView) {
        super(itemView);
        this.images = itemView.findViewById(R.id.images);
        this.authors = itemView.findViewById(R.id.author);
        this.likes = itemView.findViewById(R.id.likes);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Adapter.getInterfaceListener() != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Adapter.getInterfaceListener().onItemClick(position);
                    }
                }
            }
        });
    }
}
