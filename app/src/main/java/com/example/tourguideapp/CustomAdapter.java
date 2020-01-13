package com.example.tourguideapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter <Product> {

    //constructor
    public CustomAdapter(@NonNull Context context, @NonNull ArrayList<Product> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //declare list item and inflate it if it is equal null
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        //det the current object(the the item that the user clicked on it from list) and store it in currentProduct
        Product currentProduct = getItem(position);

        //link the view with list item xml file
        ImageView productImage = (ImageView)listItem.findViewById(R.id.product_image);
        TextView productName = (TextView)listItem.findViewById(R.id.product_name);

        //set the data to views
        productImage.setImageResource(currentProduct.getmProductImage());
        productName.setText(currentProduct.getmProductName());

        //return list item
        return listItem;
    }
}
