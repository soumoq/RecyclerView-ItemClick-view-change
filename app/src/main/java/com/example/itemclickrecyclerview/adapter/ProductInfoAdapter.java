package com.example.itemclickrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itemclickrecyclerview.R;
import com.example.itemclickrecyclerview.activity.MainActivity;
import com.example.itemclickrecyclerview.model.ProductInfo;

import java.util.ArrayList;

public class ProductInfoAdapter extends RecyclerView.Adapter<ProductInfoAdapter.ViewHolder> {

    private ArrayList<ProductInfo> productInfoList = new ArrayList<>();
    private Context context;

    public ProductInfoAdapter(Context context) {
        this.context = context;
    }

    public void updateData(ArrayList<ProductInfo> productInfos) {
        productInfoList.clear();
        productInfoList.addAll(productInfos);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_product_info, parent, false);
        return (new ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(context, position, productInfoList.get(position));
    }

    @Override
    public int getItemCount() {
        return productInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, price;
        RelativeLayout root;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            root = itemView.findViewById(R.id.root);
            price = itemView.findViewById(R.id.price);
        }

        public void bind(final Context context, final int position, final ProductInfo productInfo) {
            name.setText(productInfo.getQty() + "");
            price.setText(productInfo.getPrice() + "");

            if (productInfo.getBackgroundChange()) {
                root.setBackgroundResource(R.drawable.boder_green);
            } else {
                root.setBackgroundResource(R.drawable.boder_gray);
            }

            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ((MainActivity) v.getContext()).toast(position + "");
                    ((MainActivity) v.getContext()).changeData(position);
                    ((MainActivity) v.getContext()).changeBackGround(position);
                }
            });
        }
    }

}
