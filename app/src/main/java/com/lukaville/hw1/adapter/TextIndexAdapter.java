package com.lukaville.hw1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lukaville.hw1.R;
import com.lukaville.hw1.util.NumberUtils;

/**
 * Created by nickolay on 08.10.15.
 */
public class TextIndexAdapter extends RecyclerView.Adapter<TextIndexAdapter.ItemHolder> {
    private final int mItemNumber;

    public TextIndexAdapter(int itemNumber) {
        mItemNumber = itemNumber;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.mTextView.setText(NumberUtils.numberToText(position + 1));
    }

    @Override
    public int getItemCount() {
        return mItemNumber;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private final TextView mTextView;

        public ItemHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text);
        }
    }
}
