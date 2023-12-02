package com.example.appfirstproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerProductAdaptor extends RecyclerView.Adapter<recyclerProductAdaptor.ViewHolder> {


    Context context;
    ArrayList<productModel> product;
    recyclerProductAdaptor(Context context , ArrayList<productModel> product){
        this.context = context;
        this.product = product;

    }



    @NonNull
    @Override
    public recyclerProductAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =LayoutInflater.from(context).inflate(R.layout.singleproductlayout, parent , false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerProductAdaptor.ViewHolder holder, int position) {
            holder.tvProductText.setText(product.get(position).tvProductText);
            holder.tvDiscountedPrice.setText(product.get(position).tvDiscountedPrice);
            holder.tvCurrentPrice.setText(product.get(position).tvCurrentPrice);
            holder.rbProductRatingBar.setRating(product.get(position).rbProductRatingBar);
            holder.ivProductImg.setImageResource(product.get(position).ivProductImg);
    }

    @Override
    public int getItemCount() {
        return product.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        ImageView ivProductImg;
        TextView tvProductText , tvDiscountedPrice , tvCurrentPrice;

        RatingBar rbProductRatingBar;
        public  ViewHolder(View itemView){
            super(itemView);
            ivProductImg=  itemView.findViewById(R.id.ivProductImg);
            tvProductText=  itemView.findViewById(R.id.tvProductText);
            tvDiscountedPrice=  itemView.findViewById(R.id.tvDiscountedPrice);
            tvCurrentPrice=  itemView.findViewById(R.id.tvCurrentPrice);
            rbProductRatingBar=  itemView.findViewById(R.id.rbProductRatingBar);

        }
    }
}
