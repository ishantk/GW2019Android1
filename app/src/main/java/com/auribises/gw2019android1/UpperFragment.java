package com.auribises.gw2019android1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;


public class UpperFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayAdapter<String> adapter;
    MyListener listener; // Create Reference of MyListener


    public UpperFragment() {
        // Required empty public constructor
    }

    // Initialize MyListener Reference
    public void setMyListener(MyListener listener){
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Returning the View which is Layout of Fragment | Kind of setContentView
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upper, container, false);
    }


    // onViewCreated is a built in method which is overrided and is solving the purpose of initializing the views :)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // view is a reference variables which refers to the layout of Fragment
        listView = view.findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);
        adapter.add("Zee News");
        adapter.add("CNN");
        adapter.add("BCC");
        adapter.add("IBN");
        adapter.add("AAJ TAK");
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
        String news = adapter.getItem(pos);
        //Toast.makeText(getContext(), "You Selected:"+news, Toast.LENGTH_LONG).show();

        String url="";
        if(pos == 0) {
            url = "https://zeenews.india.com/";
        }else if(pos == 1){
            url = "https://zeenews.india.com/";
        }

        listener.onClick(pos, url);
    }
}
