package com.example.fragmentandrecyclerview;

import android.content.Context;
import android.content.Intent;
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
    private Context context;

    public ProductAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Product curruntProduct = productList.get(position);
        holder.pIdTV.setText(curruntProduct.getpId());
        holder.pNameTV.setText(curruntProduct.getpName());
        holder.pPriceTV.setText(Double.toString(curruntProduct.getpPrice()));
        holder.pIV.setImageResource(curruntProduct.getpImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("image",curruntProduct.getpImage());
                intent.putExtra("name",curruntProduct.getpName());
                context.startActivity(intent);
            }
        });
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
            pIV = itemView.findViewById(R.id.pIV);
        }
    }
}
