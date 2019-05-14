package com.smartdroidesign.volleyrecyclerview.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartdroidesign.volleyrecyclerview.R;
import com.squareup.picasso.Picasso;

import java.util.Locale;

import static com.smartdroidesign.volleyrecyclerview.view.MainActivity.EXTRA_AUTHOR;
import static com.smartdroidesign.volleyrecyclerview.view.MainActivity.EXTRA_LIKES;
import static com.smartdroidesign.volleyrecyclerview.view.MainActivity.EXTRA_URL;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String authorName = intent.getStringExtra(EXTRA_AUTHOR);
        int likeCount = intent.getIntExtra(EXTRA_LIKES, 0);

        ImageView galleryImage = findViewById(R.id.gallery_image);
        TextView galleryAuthor = findViewById(R.id.gallery_author);
        TextView galleryLikes = findViewById(R.id.gallery_likes);

        Picasso.with(this)
                .load(imageUrl)
                .fit()
                .centerInside()
                .into(galleryImage);
        galleryAuthor.setText(authorName);
        galleryLikes.setText(String.format(Locale.ENGLISH, "Likes: %d", likeCount));
    }
}
