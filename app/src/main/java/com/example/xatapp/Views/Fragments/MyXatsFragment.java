package com.example.xatapp.Views.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xatapp.R;
import com.example.xatapp.Views.Activities.MainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;


public class MyXatsFragment extends Fragment {

    RecyclerView recyclerView;

    FirebaseUser firebaseUser;
    DatabaseReference ref;



    public MyXatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_xats, container, false);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle("My Xats");

        recyclerView = view.findViewById(R.id.recyclerMyXats);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        return view;
    }
}