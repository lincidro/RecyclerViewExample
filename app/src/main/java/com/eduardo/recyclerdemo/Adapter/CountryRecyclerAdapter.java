package com.eduardo.recyclerdemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eduardo.recyclerdemo.R;

import java.util.LinkedList;

public class CountryRecyclerAdapter extends RecyclerView.Adapter<CountryRecyclerAdapter.CountryViewHolder> {
    private LinkedList<String> countryList;
    private LayoutInflater layoutInflater;

    class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView countryItemView;
        final CountryRecyclerAdapter countryAdapter;

        public CountryViewHolder(View itemView, CountryRecyclerAdapter adapter){
            super(itemView);
            countryItemView = itemView.findViewById(R.id.country);
            this.countryAdapter = adapter;
            countryItemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            String element = countryList.get(position);
            countryList.set(position,"Clicked "+element);
            countryAdapter.notifyDataSetChanged();
        }
    }

    public CountryRecyclerAdapter(Context context, LinkedList<String> countryList_) {
        layoutInflater  = LayoutInflater.from(context);
        this.countryList = countryList_;
    }

    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new CountryViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryRecyclerAdapter.CountryViewHolder holder, int i) {
        String current = countryList.get(i);
        holder.countryItemView.setText(current);
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }
}
