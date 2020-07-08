package com.example.hotstagram.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotstagram.MainActivity;
import com.example.hotstagram.RecycleAdapter;
import com.example.hotstagram.PostInfo;
import com.example.hotstagram.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    Toolbar toolbar;
    ActionBar actionBar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        //추가
        ArrayList<PostInfo> postInfoArrayList = new ArrayList<>();
        postInfoArrayList.add(new PostInfo(R.drawable.eximg,R.drawable.eximg,"nickname", "letter"));
        RecycleAdapter recycleAdapter = new RecycleAdapter(postInfoArrayList);
        mRecyclerView.setAdapter(recycleAdapter);


        //툴바
        View view = (View) inflater.inflate(R.layout.fragment_home, container, false);
        MainActivity activity = (MainActivity) getActivity();
        toolbar = view.findViewById(R.id.toolbar);
        activity.setSupportActionBar(toolbar);
        actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);

        //카메라
        ImageView camera = rootView.findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);

            }
        });


        return rootView;

    }

}