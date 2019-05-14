package com.smartdroidesign.volleyrecyclerview.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.smartdroidesign.volleyrecyclerview.R;
import com.smartdroidesign.volleyrecyclerview.model.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {


    private Context context;
    private ArrayList<Item> items;
    // Interface interaction
    private static OnItemClickListener interfaceListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        interfaceListener = listener;
    }

    static OnItemClickListener getInterfaceListener() {
        return interfaceListener;
    }

    public Adapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_items, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Item currentItem = items.get(i);

        String imageURL = currentItem.getImageUrls();
        String authorName = currentItem.getAuthor();
        int likeCount = currentItem.getLikes();

        viewHolder.authors.setText(authorName);
        viewHolder.likes.setText(String.format(Locale.ENGLISH, "Likes: %d", likeCount));

        // Picasso
        Picasso.with(context)
                .load(imageURL)
                .fit()
                .centerInside()
                .into(viewHolder.images);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
