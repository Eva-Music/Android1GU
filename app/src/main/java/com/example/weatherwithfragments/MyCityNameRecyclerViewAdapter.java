package com.example.weatherwithfragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.weatherwithfragments.CityNameFragment.OnListFragmentInteractionListener;
import com.example.weatherwithfragments.cityrepository.CityRepository.TheCity;

import java.util.List;


/**
 * {@link RecyclerView.Adapter} that can display a {@link TheCity} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyCityNameRecyclerViewAdapter extends RecyclerView.Adapter<MyCityNameRecyclerViewAdapter.ViewHolder> {

    private final List<TheCity> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyCityNameRecyclerViewAdapter(List<TheCity> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_cityname, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener((View v) -> {
                if (null != mListener) {
//                    if(holder.checkWind.isChecked()) {
//
//                    }

                    if (holder.checkWind.isChecked()) {
                        holder.mItem.setWind(true);
                    }
                    if (holder.checkHum.isChecked()) {
                        holder.mItem.setHumid(true);
                    }

                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        );
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         final View mView;
         final TextView mIdView;
         final TextView mContentView;
         TheCity mItem;
        CheckBox checkHum;
        CheckBox checkWind;


        ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.item_number);
            mContentView = view.findViewById(R.id.content);
            checkHum = view.findViewById(R.id.checkbox_humidity);
            checkWind = view.findViewById(R.id.checkbox_wind);
        }

        @NonNull
        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
