package com.auribises.gw2019android1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerRecyclerAdapter extends RecyclerView.Adapter<CustomerRecyclerAdapter.ViewHolder>{

    Context context;
    int resource;
    ArrayList<Customer> objects;

    public CustomerRecyclerAdapter(Context context, int resource, ArrayList<Customer> objects) {
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //1.  Create the View
        // view represent Object in Java File for list_item
        View view = LayoutInflater.from(context).inflate(resource, parent, false);
        ViewHolder holder = new ViewHolder(view);

        /*
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

        return holder;

    }

    // onBindViewHolder will be executed automatically n number of times from 0 to n-1
    // n is returned by getItemCount
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //2. Fetch the Object from ArrayList
        Customer customer = objects.get(position);

        //3. Set Data on View
        holder.image.setBackgroundResource(customer.image);
        holder.txtName.setText(customer.name);
        holder.txtPhone.setText(customer.phone);
    }

    @Override
    public int getItemCount() { // Return how many list items we want to display in RecyclerView
        return objects.size();
    }


    // Nested Class
    // Will Hold the Views of list item
    // Initialization of Views is taken care with OOPS Design Pattern
    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView txtName;
        TextView txtPhone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            txtName = itemView.findViewById(R.id.textViewName);
            txtPhone = itemView.findViewById(R.id.textViewPhone);
        }
    }

}
