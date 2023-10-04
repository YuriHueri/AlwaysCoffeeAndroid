package com.example.alwayscoffee;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class StorageFragment extends Fragment {

    private Context mContext;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_storage, container, false);
        GridView gridView = view.findViewById(R.id.gridView);

        // Sample drawable resource IDs for grid items
        int[] imageResources = {R.drawable.coffeeglass, R.drawable.coffeeglass, R.drawable.coffeeglass, R.drawable.coffeeglass};

        ImageAdapter adapter = new ImageAdapter(mContext, imageResources);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Replace this fragment with DetailFragment when an image is clicked
                Fragment fragment = null;
                if (position == 0) {
                    fragment = new StorageOne();
                }else if(position == 1){
                    fragment = new StorageTwo();
                }else if(position == 2){
                    fragment = new StorageThree();
                }else if(position == 3){
                    fragment = new StorageFour();
                }

                Bundle args = new Bundle();
                args.putInt("imageResource", imageResources[position]);
                fragment.setArguments(args);

                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}