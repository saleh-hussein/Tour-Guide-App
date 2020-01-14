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
public class FragmentTwo extends Fragment {

    //declare arrayList to store the fragmentTwoData
    ArrayList<Product> fragmentTwoData = new ArrayList<>();
    public FragmentTwo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        //add fragmentTwoData to arrayList
        fragmentTwoData.add(new Product("Al-ansar golden tulip",R.drawable.alansar,"014 816 0116","https://al-ansar.goldentulip.com/","https://goo.gl/maps/s7HJovZTMUNmQgaH6",getResources().getString(R.string.welcome_massage)));
        fragmentTwoData.add(new Product("namMawaddah alsafwahe2",R.drawable.mawadah_alsafwah,"014 823 3131","https://mawaddah.com.sa/hotel/view/5","https://goo.gl/maps/gpsQZprw92VfJcZ19",getResources().getString(R.string.welcome_massage)));
        fragmentTwoData.add(new Product("Manazel Alaswaf",R.drawable.manazel_alaswaf,"014 823 3131","http://www.manazelalaswafhotel.info/","https://goo.gl/maps/XVL9GpxspVPfTTqT9",getResources().getString(R.string.welcome_massage)));
        fragmentTwoData.add(new Product("Movenpick",R.drawable.movenpic,"014 818 1000","https://www.movenpick.com/en/","https://g.page/movenpick-anwar-madinah?share",getResources().getString(R.string.welcome_massage)));
        fragmentTwoData.add(new Product("Dar Altaqwa",R.drawable.dar_altaqwa,"014 829 1111","https://www.taqwamadinah.com/","https://goo.gl/maps/2LQtp866pP8ibgAJ8",getResources().getString(R.string.welcome_massage)));

        //declare custom adapter
        CustomAdapter adapter = new CustomAdapter(getActivity(), fragmentTwoData);

        //link listView and set the adapter
        ListView listView = (ListView)view.findViewById(R.id.fragment_2_List_view);
        listView.setAdapter(adapter);

        //when item is clicked, go to the product details activity and pass fragmentTwoData for the current item to it.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //get the current item object
                Product currentObject = fragmentTwoData.get(i);

                //declare bundle object to carry the fragmentTwoData from this fragment to productDetails Activity
                Bundle bundle = new Bundle();
                bundle.putSerializable("currentObject", currentObject);

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
