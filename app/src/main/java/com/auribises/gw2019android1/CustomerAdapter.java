package com.auribises.gw2019android1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
class Point{

    int x, y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

}
 */

public class CustomerAdapter extends ArrayAdapter<Customer> {

    Context context;
    int resource;
    ArrayList<Customer> objects;

    public CustomerAdapter(Context context, int resource, ArrayList<Customer> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    // getView will execute n number of times from 0 to n-1 automatically
    // where n is size of objects ArrayList

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //1.  Create the View
        // view represent Object in Java File for list_item
        View view = LayoutInflater.from(context).inflate(resource, parent, false);

        ImageView image = view.findViewById(R.id.imageView);
        TextView txtName = view.findViewById(R.id.textViewName);
        TextView txtPhone = view.findViewById(R.id.textViewPhone);

        //2. Fetch the Object from ArrayList
        Customer customer = objects.get(position);

        //3. Set Data on View
        image.setBackgroundResource(customer.image);
        txtName.setText(customer.name);
        txtPhone.setText(customer.phone);

        //4. Return the View
        return view;
    }
}


