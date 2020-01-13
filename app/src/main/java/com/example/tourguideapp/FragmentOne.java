package com.example.tourguideapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {

    //declare arrayList to store the data
    private ArrayList<Product> data = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_one, container,false);

        //add data to arrayList
        data.add(new Product("Alromansiah ",R.drawable.alromansiah_restaurant,"920000144","https://alromansiah.com/","https://maps.app.goo.gl/Mp2ZHbGJdpt13LNg6",getResources().getString(R.string.product_1_details)));
        data.add(new Product("albik",R.drawable.albik,"800 244 2245","http://www.albaik.com/","https://maps.app.goo.gl/Z1H42LfpqXEKJt229",getResources().getString(R.string.product_2_details)));
        data.add(new Product("Applebees",R.drawable.apple_bees,"014 835 8659","http://applebeesme.com/saudi-arabia/","https://maps.app.goo.gl/EenFkeMDJefBotdN7",getResources().getString(R.string.product_3_description)));
        data.add(new Product("Alrokn Alshami",R.drawable.alrokn_alshami,"014 869 4014","https://www.instagram.com/jinan_sweets/?igshid=2e0ki2dlq9q4","https://maps.app.goo.gl/BMyjNX8M3M3mf8iq9",getResources().getString(R.string.product_4_details)));
        data.add(new Product("Al-Atbaq Restaurant",R.drawable.alatbaq,"014 838 8222","http:www.google.com","https://maps.app.goo.gl/QZykyWmnAXbtnnb17",getResources().getString(R.string.product_5_details)));

        //declare custom adapter
        CustomAdapter adapter = new CustomAdapter(getActivity(),data);

        //link listView and set the adapter
        ListView listView = (ListView)view.findViewById(R.id.fragment_1_list_view);
        listView.setAdapter(adapter);

        //when item is clicked, go to the product details activity and pass data for the current item to it.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //get the current item object
                Product currentObject = data.get(i);

                //declare bundle object to carry the data from this fragment to productDetails Activity
                Bundle bundle = new Bundle();
                bundle.putSerializable("currentObject",currentObject);

                //declare intent to go to productDetail activity, and put the bundle with it
                Intent intent = new Intent(getActivity(),ProductDetail.class);
                intent.putExtras(bundle);

                //go from this fragment to productDetails Activity
                startActivity(intent);

            }
        });

        //return view
        return view;

    }

}
