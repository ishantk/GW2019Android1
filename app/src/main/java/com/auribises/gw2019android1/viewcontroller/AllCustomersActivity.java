package com.auribises.gw2019android1.viewcontroller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.auribises.gw2019android1.R;
import com.auribises.gw2019android1.Util;
import com.auribises.gw2019android1.adapter.CustomerAdapter;
import com.auribises.gw2019android1.model.Customer;

import java.util.ArrayList;

public class AllCustomersActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    CustomerAdapter adapter;
    ContentResolver resolver;

    ArrayList<Customer> customers;

    Customer customer;

    int idx;

    void initViews() {

        listView = findViewById(R.id.listView);

        resolver = getContentResolver(); // To Access ContentProvider

        fetchCustomersFromDB();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_customers); // ListView
        initViews();
    }

    void fetchCustomersFromDB() {

        // names of Columns of your table which you wish to fetch
        String[] projection = {"_ID", "name", "phone", "email"};

        Cursor cursor = resolver.query(Util.uri, projection, null, null, null);
        if (cursor != null) {

            customers = new ArrayList<>();

            while (cursor.moveToNext()) { // Iterate in Fetched Data Row by Row

                Customer customer = new Customer();
                customer.id = cursor.getInt(0);
                customer.name = cursor.getString(1);
                customer.phone = cursor.getString(2);
                customer.email = cursor.getString(3);

                Log.i("AllCustomersActivity", customer.toString());

                customers.add(customer);

            }

            adapter = new CustomerAdapter(this, R.layout.list_item, customers);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
            // Java Collections : APIs Comaparator and Comparable (Sorting)

        } else {
            Toast.makeText(this, "No Records Found", Toast.LENGTH_LONG).show();
        }
    }

    void deleteCustomerFromDB() {

        String where = "_ID = " + customer.id; // Condition to Delete
        int i = resolver.delete(Util.uri, where, null);

        if (i > 0) {
            customers.remove(idx); // Deletion from ArrayList
            adapter.notifyDataSetChanged(); // Refresh ListView from new ArrayList
            Toast.makeText(this, customer.name + " Deleted", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, customer.name + " Not Deleted", Toast.LENGTH_LONG).show();
        }

        // Explore Swipe to Delete :)

    }

    void showCustomer() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(customer.name + " Details:");
        builder.setMessage(customer.toString());
        builder.setPositiveButton("Done", null);

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    void askForDeletion() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + customer.name);
        builder.setMessage("Are You Sure to Delete ?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteCustomerFromDB();
            }
        });
        builder.setNegativeButton("Cancel", null);

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    void showOptions() {

        String[] options = {"View", "Delete", "Update", "Call", "Message"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {

                if (position == 0) {
                    showCustomer();
                } else if (position == 1) {
                    askForDeletion();
                } else if (position == 2) {
                    Intent intent = new Intent(AllCustomersActivity.this, AddCustomerActivity.class);
                    intent.putExtra("keyCustomer", customer);
                    startActivity(intent);
                } else if (position == 3) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + customer.phone));
                    startActivity(intent);
                }else {
                    String message = "Hello "+ customer.name+" This is Awesome";
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(customer.phone, null, message, null, null);
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        customer = customers.get(position);
        //Toast.makeText(this,customer.toString(), Toast.LENGTH_LONG).show();

        idx = position;

        showOptions();

    }
}
