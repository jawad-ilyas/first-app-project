package com.example.appfirstproject;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerProductAdaptor extends RecyclerView.Adapter<recyclerProductAdaptor.ViewHolder> {



    // this is used for the update form

    EditText etFormPname , etFormPnumber;
    TextView etformText ;
    Button btnSubmitForm;
    Context context; // main activity address
    ArrayList<productModel> product; // product list
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


            holder.Editllrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.add_update_layout);


                    btnSubmitForm = dialog.findViewById(R.id.btnSubmitForm);
                    etformText = dialog.findViewById(R.id.etformText);
                    etFormPnumber = dialog.findViewById(R.id.etFormPnumber);
                    etFormPname = dialog.findViewById(R.id.etFormPname);
                    etformText.setText("Update Product");
                    etFormPname.setText((product.get(position)).tvProductText);
                    etFormPnumber.setText((product.get(position)).tvCurrentPrice);
                    btnSubmitForm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String price = "" , name = "";
                            if(!etFormPname.getText().toString().equals("") && !etFormPnumber.getText().toString().equals("")) {
                                price = etFormPnumber.getText().toString();
                                name = etFormPname.getText().toString();
                            }
                            else
                            {
                                Toast.makeText(context, "Values are not present ", Toast.LENGTH_SHORT).show();
                            }


                            productModel currentProduct = product.get(position);
                            product.set(position, new productModel(
                                    currentProduct.ivProductImg,
                                    name,
                                    currentProduct.tvDiscountedPrice,
                                    price,
                                    currentProduct.rbProductRatingBar));


                            // we also need to notify the items
                            notifyItemChanged(position);



                            // import point need to nide the dialog button
                            dialog.dismiss();
                        }
                    });
                    //this step is important becuase we want to show the dialog to the screen
                    dialog.show();
                }
            });

        holder.Editllrow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Product")
                        .setMessage("Are Your Sure You Want To Delete Product")
                        .setIcon(R.drawable.baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                product.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Perform any action on "No" button click if needed
                            }
                        }); // This closing brace was missing

                // Show the dialog
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                // Return true to consume the long click event
                return true;
            }
        });

    }
    @Override
    public int getItemCount() {
        return product.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        ImageView ivProductImg;
        TextView tvProductText , tvDiscountedPrice , tvCurrentPrice;

        RatingBar rbProductRatingBar;

        // this id is used for the eidt
        LinearLayout Editllrow;
        public  ViewHolder(View itemView){
            super(itemView);
            ivProductImg=  itemView.findViewById(R.id.ivProductImg);
            tvProductText=  itemView.findViewById(R.id.tvProductText);
            tvDiscountedPrice=  itemView.findViewById(R.id.tvDiscountedPrice);
            tvDiscountedPrice.setPaintFlags(tvDiscountedPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            tvCurrentPrice=  itemView.findViewById(R.id.tvCurrentPrice);
            rbProductRatingBar=  itemView.findViewById(R.id.rbProductRatingBar);
            Editllrow=  itemView.findViewById(R.id.llrow);

        }
    }
}
