package com.lukaville.hw1.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lukaville.hw1.R;
import com.lukaville.hw1.adapter.TextIndexAdapter;

public class ListActivity extends AppCompatActivity {
    private static final int ITEM_NUMBER = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // Create and set adapter
        TextIndexAdapter textIndexAdapter = new TextIndexAdapter(ITEM_NUMBER);
        recyclerView.setAdapter(textIndexAdapter);

        // Create and set linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        // Set stripe item decoration
        RecyclerView.ItemDecoration decoration = new StripeBackgroundDecoration(
                R.color.white,
                R.color.gray
        );
        recyclerView.addItemDecoration(decoration);
    }
}
