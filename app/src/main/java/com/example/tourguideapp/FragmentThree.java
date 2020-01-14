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
public class FragmentThree extends Fragment {

    //declare arrayList to store the fragmentTwoData
    ArrayList<Product> fragmentThreeData = new ArrayList<>();
    public FragmentThree() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_three,container,false);

        //add fragmentTwoData to arrayList
        fragmentThreeData.add(new Product("Al Madinah International Mall",R.drawable.almadina_international,"014 823 3837","https://shopping-center-1543.business.site/","https://maps.app.goo.gl/nzs4k9xr7PnjHNgZ7",getResources().getString(R.string.welcome_massage)));
        fragmentThreeData.add(new Product("Alqarrat Mall",R.drawable.alqarrat,"014 828 2120","https://www.instagram.com/alqarat1111/","https://maps.app.goo.gl/oZi4AymCxYpkRE899",getResources().getString(R.string.welcome_massage)));
        fragmentThreeData.add(new Product("Al Rashid Mega Mall",R.drawable.alrashed,"014 835 8888","https://www.instagram.com/alrashidmallmed/","https://maps.app.goo.gl/6gDGh32wgvc1LSWA9",getResources().getString(R.string.welcome_massage)));
        fragmentThreeData.add(new Product("Carrefour",R.drawable.carrfour,"9200 00282","https://www.carrefourksa.com/mafsau/ar/","https://maps.app.goo.gl/HQT2hxL9Dcr2MP139",getResources().getString(R.string.welcome_massage)));
        fragmentThreeData.add(new Product("Al-Noor Mall",R.drawable.alnoor_mall,"9200 00262","https://www.arabiancentres.com/mall/index/ar/13/al-noor-mall/","https://maps.app.goo.gl/arsBm3XV4sCUMhDq6",getResources().getString(R.string.welcome_massage)));

        //declare custom adapter
        CustomAdapter adapter = new CustomAdapter(getActivity(), fragmentThreeData);

        //link listView and set the adapter
        ListView listView = (ListView)view.findViewById(R.id.fragment_3_list_view);
        listView.setAdapter(adapter);

        //when item is clicked, go to the product details activity and pass fragmentTwoData for the current item to it.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //get the current item object
                Product currentObject = fragmentThreeData.get(i);

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
