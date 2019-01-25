package com.adproject.android.storeclerk.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.adproject.android.storeclerk.R;

public class HomeFragment extends Fragment {
    FragmentManager fm ;
    String username;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fm = getFragmentManager();
        Button btnDispersement = (Button) getActivity().findViewById(R.id.buttonDispersement);
        Button btnManage = (Button) getActivity().findViewById(R.id.buttonManageInventory);
        Button btnRetrieval = (Button) getActivity().findViewById(R.id.buttonRetrieval);
        try{
            username = getActivity().getIntent().getExtras().getString("username");
        }
        catch (Exception e){
            username =null;
        }
        btnDispersement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DispersementFragment requestlist = new DispersementFragment();
//                Bundle args = new Bundle();
//                String userid = getActivity().getIntent().getExtras().getString("userid");
//                args.putSerializable("userid", userid);
//                requestlist.setArguments(args);
                fm.beginTransaction().replace(R.id.content_frame, requestlist,"Dispersement").addToBackStack("Dispersement").commit();
                NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.nav_view);
                navigationView.getMenu().getItem(1).setChecked(true);
            }
        });
        btnManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManageInventoryFragment deptRepFragment = new ManageInventoryFragment();
//                Bundle args = new Bundle();
//                String userid = getActivity().getIntent().getExtras().getString("userid");
//                args.putSerializable("userid", userid);
//                deptRepFragment.setArguments(args);
                fm.beginTransaction().replace(R.id.content_frame, deptRepFragment,"Manage").addToBackStack("Manage").commit();
                NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.nav_view);
                navigationView.getMenu().getItem(2).setChecked(true);
            }
        });
        btnRetrieval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrievalFragment depthead = new RetrievalFragment();
//                Bundle args = new Bundle();
//                String userid = getActivity().getIntent().getExtras().getString("userid");
//                args.putSerializable("userid",userid);
//                depthead.setArguments(args);
                fm.beginTransaction().replace(R.id.content_frame,depthead,"Retrieval").addToBackStack("Retrieval").commit();
                NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.nav_view);
                navigationView.getMenu().getItem(3).setChecked(true);
            }
        });
    }


}
