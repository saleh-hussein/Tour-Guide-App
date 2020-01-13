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
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFour extends Fragment {

    //declare arrayList list to store the data
    ArrayList<Product> data = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_four,container,false);

        //add data to arrayList
        data.add(new Product("name4",R.drawable.bird,"056391640","website","location","details"));
        data.add(new Product("name4",R.drawable.bird,"056391640","website","location","details"));
        data.add(new Product("name4",R.drawable.bird,"056391640","website","location","details"));
        data.add(new Product("name4",R.drawable.bird,"056391640","website","location","details"));
        data.add(new Product("name4",R.drawable.bird,"056391640","website","location","details"));

        //declare custom adapter
        CustomAdapter adapter = new CustomAdapter(getActivity(),data);

        //link listViw and set the adapter
        ListView listView = (ListView)view.findViewById(R.id.fragment_4_list_view);
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
