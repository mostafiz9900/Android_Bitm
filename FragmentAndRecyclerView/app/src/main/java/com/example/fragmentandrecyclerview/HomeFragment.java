package com.example.fragmentandrecyclerview;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
private List<Product> productList;
private RecyclerView recyclerViewLayout;
private ProductAdapter productAdapter;
private HomeFragment homeFragment;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        init(view);
        initRecyclerView();
        getProductList();
        return view;
    }

    private void initRecyclerView() {
        recyclerViewLayout.setLayoutManager(new LinearLayoutManager(homeFragment.getContext()));
        recyclerViewLayout.setAdapter(productAdapter);
    }

    private void getProductList() {
        Product product=new Product("Hu-007","Lenovo",500,R.drawable.clock);
        Product product2=new Product("HP-0055","Computer",5005225,R.drawable.clock);
        productList.add(product);
        productList.add(product2);

        productAdapter.notifyDataSetChanged();
    }

    private void init(View view) {
        productList=new ArrayList<>();
        recyclerViewLayout=view.findViewById(R.id.recycleViewLayout);
        productAdapter=new ProductAdapter(productList);
        homeFragment=new HomeFragment();
    }

}
