package com.lukaville.hw1.ui;

import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by nickolay on 11.10.15.
 */

public class StripeBackgroundDecoration extends RecyclerView.ItemDecoration {
    private final int mOddBgColorResource;
    private final int mEvenBgColorResource;

    public StripeBackgroundDecoration(int oddBgColorResource, int evenBgColorResource) {
        mOddBgColorResource = oddBgColorResource;
        mEvenBgColorResource = evenBgColorResource;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int number = parent.getChildAdapterPosition(view) + 1;
        int backgroundColorResource = number % 2 == 0 ? mEvenBgColorResource : mOddBgColorResource;
        int backgroundColor = ContextCompat.getColor(view.getContext(), backgroundColorResource);

        view.setBackgroundColor(backgroundColor);
    }
}