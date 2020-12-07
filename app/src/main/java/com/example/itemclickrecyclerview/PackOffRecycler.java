package com.example.itemclickrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class PackOffRecycler extends RecyclerView.Adapter<PackOffRecycler.ViewHolder> {

    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private ArrayList<ProductInfo> proInfo;
    private ProductInfo productInfo;
    private int selectedPos = RecyclerView.NO_POSITION;

    // data is passed into the constructor
    public PackOffRecycler(Context context, ArrayList<ProductInfo> proInfo) {
        this.mInflater = LayoutInflater.from(context);
        this.proInfo = proInfo;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycler_pack_off, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each cell
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        productInfo = proInfo.get(position);
        holder.name.setText(productInfo.getPrice());
        holder.price.setText(productInfo.getQty());


        //holder.itemView.setBackgroundColor(selectedPos == position ? Color.GREEN : Color.TRANSPARENT);
        if (selectedPos == position) {
            holder.root.setBackgroundResource(R.drawable.boder_green);
        } else {
            holder.root.setBackgroundResource(R.drawable.boder_gray);
        }


    }

    // total number of cells
    @Override
    public int getItemCount() {
        return proInfo.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name, price;
        RelativeLayout root;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            root = itemView.findViewById(R.id.root);
            price = itemView.findViewById(R.id.price);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {
                mClickListener.onItemClick(view, getAdapterPosition());
                //orangeLine.setVisibility(View.VISIBLE);
                notifyItemChanged(selectedPos);
                selectedPos = getLayoutPosition();
                notifyItemChanged(selectedPos);
            }
        }
    }

    // convenience method for getting data at click position
    public ProductInfo getItem(int id) {
        return proInfo.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
