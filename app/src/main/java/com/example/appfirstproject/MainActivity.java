package com.example.appfirstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    recyclerProductAdaptor adaptor;
    ArrayList<productModel>  product = new ArrayList<>();



    FloatingActionButton fbProductFloatingButton;


     // this viarables used for the add update layout
        TextView etformText ;
        EditText etFormPname , etFormPnumber;

        Button btnSubmitForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 1-step  firstly i attached the layout design
        init();

        // 2-step then we need to select the layout which i want to used
        recyclerView.setLayoutManager(new GridLayoutManager(this , 2));



        // why we use this button because i want to insert , delete , update the button on click

        fbProductFloatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_layout);


                btnSubmitForm = dialog.findViewById(R.id.btnSubmitForm);
                etFormPnumber = dialog.findViewById(R.id.etFormPnumber);
                etFormPname = dialog.findViewById(R.id.etFormPname);

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
                            Toast.makeText(MainActivity.this, "Values are not present ", Toast.LENGTH_SHORT).show();
                        }


                        product.add(new productModel(name , price , R.drawable.a));


                        // we also need to notify the items
                        adaptor.notifyItemInserted(product.size()-1);

                        // this thing is the optional where we add the data and tell the user this postion our datda is add
                        recyclerView.scrollToPosition(product.size()-1);

                        // import point need to nide the dialog button
                        dialog.dismiss();
                    }
                });
                //this step is important becuase we want to show the dialog to the screen
                dialog.show();
            }
        });





        // Assuming product is an ArrayList or some collection to store productModel instances

        // Create productModel instances with random data and different drawables
        product.add(new productModel(R.drawable.a , "product 1" , "800", "300", 4.4F));
        product.add(new productModel(R.drawable.b , "product 2" , "600", "250", 4.0F));
        product.add(new productModel(R.drawable.c , "product 3" , "900", "400", 4.8F));
        product.add(new productModel(R.drawable.d , "product 4" , "700", "350", 4.2F));
        product.add(new productModel(R.drawable.e , "product 5" , "1000", "500", 4.5F));
        product.add(new productModel(R.drawable.f , "product 6" , "1200", "600", 4.6F));
        product.add(new productModel(R.drawable.g , "product 7" , "500", "200", 3.9F));
        product.add(new productModel(R.drawable.h , "product 8" , "1100", "450", 4.7F));
        product.add(new productModel(R.drawable.i , "product 9" , "850", "320", 4.3F));
        product.add(new productModel(R.drawable.j , "product 10", "950", "380", 4.1F));

        adaptor = new recyclerProductAdaptor(this , product);
        recyclerView.setAdapter(adaptor);

    }

    public void init(){

        recyclerView = findViewById(R.id.reProductRecycler);
        fbProductFloatingButton = findViewById(R.id.fbProductFloatingButton);


    }
}