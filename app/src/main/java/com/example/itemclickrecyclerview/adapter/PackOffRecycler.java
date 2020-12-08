package com.example.itemclickrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.itemclickrecyclerview.model.ProductInfo;
import com.example.itemclickrecyclerview.R;

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

    public static class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
        private ArrayList<String> mExampleList;
        private OnItemClickListener mListener;

        public interface OnItemClickListener {
            void onItemClick(int position);
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            mListener = listener;
        }

        public static class ExampleViewHolder extends RecyclerView.ViewHolder {
            public TextView mTextView1;

            public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
                super(itemView);
                mTextView1 = itemView.findViewById(R.id.item_name);


                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION) {
                                listener.onItemClick(position);
                            }
                        }
                    }
                });
            }
        }

        public ExampleAdapter(ArrayList<String> exampleList) {
            mExampleList = exampleList;
        }

        @Override
        public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_pack_off, parent, false);
            ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
            return evh;
        }

        @Override
        public void onBindViewHolder(ExampleViewHolder holder, int position) {
            holder.mTextView1.setText(mExampleList.get(position));
        }

        @Override
        public int getItemCount() {
            return mExampleList.size();
        }
    }
}
