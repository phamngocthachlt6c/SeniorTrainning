package com.game.thach.seniortrainning;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by phamn on 5/2/2017.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter <MyRecyclerViewAdapter.ItemHolder> {

    public static final String TAG = MyRecyclerViewAdapter.class.getSimpleName();
    private List<Comment> list;
    private LayoutInflater layoutInflater;

    public MyRecyclerViewAdapter(Context context, List<Comment> list){
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
        Log.d(TAG, "MyRecycler Constructure list.size = " + list.size());
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(layoutInflater.inflate(R.layout.item_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.setText(list.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, ""+list.size());
        return list.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        private TextView comment;

        public ItemHolder(View itemView) {
            super(itemView);
            comment = (TextView) itemView.findViewById(R.id.tv_comment);
        }

        public void setText(String text){
            comment.setText(text);
        }
    }
}
