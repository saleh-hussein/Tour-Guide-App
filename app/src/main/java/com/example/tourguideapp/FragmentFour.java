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
public class FragmentFour extends Fragment {

    //declare arrayList list to store the fragmentTwoData
    ArrayList<Product> fragmentFourData = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_four,container,false);

        //add fragmentTwoData to arrayList
        fragmentFourData.add(new Product("SAHD CAFE",R.drawable.shahad_cafe,"0148354123652","https://cafe-12617.business.site/","https://maps.app.goo.gl/FhFnGcrHoBfw4b567",getResources().getString(R.string.welcome_massage)));
        fragmentFourData.add(new Product("Rotana Café",R.drawable.rotana_cafe,"014 818 8888","https://www.movenpick.com/en/middle-east/saudi-arabia/madinah/hotel-madinah-al-munawarah/restaurants/restaurants/rotana-cafe/?utm_source=google&utm_medium=local&utm_campaign=glocal+rotana-caf%C3%A9-rest","https://maps.app.goo.gl/1pVmtqYjNEUK572a6",getResources().getString(R.string.welcome_massage)));
        fragmentFourData.add(new Product("Lavena Cafe ",R.drawable.lavena_cafe,"014823652145","http://lavenacafe.com/","https://maps.app.goo.gl/EPQ8Ra78e7F2zq4LA",getResources().getString(R.string.welcome_massage)));
        fragmentFourData.add(new Product("Layalina cafe",R.drawable.lyalena_cafe,"058 090 0600","https://coffee-shop-3450.business.site/","https://maps.app.goo.gl/buMKip9Nn78A6Fyw5",getResources().getString(R.string.welcome_massage)));
        fragmentFourData.add(new Product("Mama Rotee cafe",R.drawable.mama_rotee_cafe,"011 406 1118","http://mammabunzcafe.com/language/en/","https://maps.app.goo.gl/QP1yL4GsJNAQgHnW6",getResources().getString(R.string.welcome_massage)));

        //declare custom adapter
        CustomAdapter adapter = new CustomAdapter(getActivity(), fragmentFourData);

        //link listViw and set the adapter
        ListView listView = (ListView)view.findViewById(R.id.fragment_4_list_view);
        listView.setAdapter(adapter);

        //when item is clicked, go to the product details activity and pass fragmentTwoData for the current item to it.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //get the current item object
                Product currentObject = fragmentFourData.get(i);

                //declare bundle object to carry the fragmentTwoData from this fragment to productDetails Activity
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
