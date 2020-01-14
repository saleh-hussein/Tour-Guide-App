package com.example.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetail extends AppCompatActivity {

    //declare views (product mame, image, description, currentObject, phone button,website button and location button)
    TextView mProductName;
    ImageView mDetailsProductImage;
    TextView mProductDescriptionText;
    Product mProductCurrentObject;
    ImageView phoneButton;
    ImageView webSiteButton;
    ImageView locationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        //link views with its xml
        mProductName = (TextView) findViewById(R.id.details_product_name);
        mDetailsProductImage = (ImageView)findViewById(R.id.details_product_image);
        mProductDescriptionText = (TextView) findViewById(R.id.details_description_text);
        phoneButton = (ImageView)findViewById(R.id.details_phone_icon);
        webSiteButton = (ImageView)findViewById(R.id.details_website_icon);
        locationButton = (ImageView)findViewById(R.id.details_location_icon);

        //declare Bundle to get the fragmentTwoData from other activities or other fragments
        Bundle bundle = getIntent().getExtras();

        //get the object  (the list item theat the user clicked on it)
        mProductCurrentObject = (Product)bundle.getSerializable("currentObject");

        //set the views with its fragmentTwoData
        mProductName.setText(mProductCurrentObject.getmProductName());
        mDetailsProductImage.setImageResource(mProductCurrentObject.getmProductImage());
        mProductDescriptionText.setText(mProductCurrentObject.getmProductDetails());

        //when clicking on phone button, make call to the number
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+ mProductCurrentObject.getmProductPhone()));
                startActivity(intent);
            }
        });

        //when clicking on website button, go to the browser to open the link
        webSiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(mProductCurrentObject.getmProductWebsite()));
                startActivity(intent);
            }
        });

        //when clicking on location button, show the location on google map app
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(mProductCurrentObject.getmProductLocation()));
            startActivity(intent);
            }
        });

    }
}
