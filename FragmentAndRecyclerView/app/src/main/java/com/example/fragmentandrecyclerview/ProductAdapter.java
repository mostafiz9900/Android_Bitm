package com.example.fragmentandrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product curruntProduct = productList.get(position);
        holder.pIdTV.setText(curruntProduct.getpId());
        holder.pNameTV.setText(curruntProduct.getpName());
        holder.pPriceTV.setText(Double.toString(curruntProduct.getpPrice()));
        holder.pIV.setImageResource(curruntProduct.getpImage());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView pIdTV, pNameTV, pPriceTV;
        private ImageView pIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pIdTV = itemView.findViewById(R.id.pIdTV);
            pNameTV = itemView.findViewById(R.id.pNameTV);
            pPriceTV = itemView.findViewById(R.id.pPriceTV);
            pIV = itemView.findViewById(R.id.pIdTV);
        }
    }
}
