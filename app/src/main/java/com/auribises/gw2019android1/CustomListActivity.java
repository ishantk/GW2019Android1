package com.auribises.gw2019android1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //ListView listView;
    GridView listView;
    ArrayList<Customer> customers;
    CustomerAdapter adapter;


    void initViews(){
        listView = findViewById(R.id.listView);

        Customer c1 = new Customer(R.drawable.p1, "John", "+91 99999 88888");
        Customer c2 = new Customer(R.drawable.p2, "Jennie", "+91 89999 88888");
        Customer c3 = new Customer(R.drawable.p3, "Jim", "+91 78999 88888");
        Customer c4 = new Customer(R.drawable.p4, "Jack", "+91 95999 88888");
        Customer c5 = new Customer(R.drawable.p5, "Joe", "+91 98009 88888");
        //Customer c6 = new Customer(R.drawable.p6, "Jai", "+91 89991 88888");

        customers = new ArrayList<>();
        customers.add(c1); // 0
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);
        customers.add(new Customer(R.drawable.p6, "Jai", "+91 89991 88888")); // 5

        adapter = new CustomerAdapter(this, R.layout.list_item, customers);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        initViews();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
        Customer customer = customers.get(pos);
        Toast.makeText(this, "You Selected:"+customer, Toast.LENGTH_LONG).show();
    }
}
