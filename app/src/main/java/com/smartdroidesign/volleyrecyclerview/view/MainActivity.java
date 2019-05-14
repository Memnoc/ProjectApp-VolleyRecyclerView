package com.smartdroidesign.volleyrecyclerview.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.smartdroidesign.volleyrecyclerview.presenter.Adapter;
import com.smartdroidesign.volleyrecyclerview.R;
import com.smartdroidesign.volleyrecyclerview.model.Item;
import com.smartdroidesign.volleyrecyclerview.presenter.OnItemClickListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_AUTHOR = "authorName";
    public static final String EXTRA_LIKES = "likesCount";

    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<Item> itemList;
    private RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.main_container);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);
        parseJson();
    }

    private void parseJson() {
        String apiKey = getString(R.string.pixabayKey);
        String url = "https://pixabay.com/api/?key=" + apiKey + "&q=sharks&image_type=photo&pretty=true";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hit = jsonArray.getJSONObject(i);

                                String authorName = hit.getString("user");
                                String imageUrl = hit.getString("webformatURL");
                                int likeCount = hit.getInt("likes");

                                itemList.add(new Item(imageUrl, authorName, likeCount));
                            }

                            adapter = new Adapter(MainActivity.this, itemList);
                            recyclerView.setAdapter(adapter);
                            adapter.setOnItemClickListener(MainActivity.this);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Intent galleryIntent = new Intent(this, GalleryActivity.class);
        Item clickedItem = itemList.get(position);

        galleryIntent.putExtra(EXTRA_URL, clickedItem.getImageUrls());
        galleryIntent.putExtra(EXTRA_AUTHOR, clickedItem.getAuthor());
        galleryIntent.putExtra(EXTRA_LIKES, clickedItem.getLikes());

        startActivity(galleryIntent);
    }
}
