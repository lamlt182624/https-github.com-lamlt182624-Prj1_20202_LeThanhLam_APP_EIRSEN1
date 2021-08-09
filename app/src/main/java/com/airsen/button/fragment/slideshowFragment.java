package com.airsen.button.fragment;


import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airsen.button.R;
import com.airsen.button.Retrofit.APIretrofitclient;
import com.airsen.button.Retrofit.ApiUtils;
import com.airsen.button.Retrofit.datasevice;

import com.airsen.button.firebase.ImforUrl;
import com.airsen.button.firebase.MyAdapterpaper;
import com.airsen.button.firebase.UrlInformation;
import com.airsen.button.object.Node;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class slideshowFragment extends Fragment {

    private datasevice mService;
    List<Node> allNode;
    View view;

    TextView textView;

    private TextView tvid;
    private  TextView tvAQI;
    private  TextView tvlon;
    private  TextView tvlang;
    private  TextView tvcontent;

    private FirebaseAuth mAuth;
    private String curentUser;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    FirebaseDatabase mfirebaseDatabase;
    MyAdapterpaper myAdapter;
    List<ImforUrl> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);



//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        tvid = view.findViewById(R.id.tv_id);
        tvAQI = view.findViewById(R.id.tv_AQI);
        tvlon = view.findViewById(R.id.tv_lon);
        tvlang = view.findViewById(R.id.tv_lang);
        tvcontent = view.findViewById(R.id.tv_content);
        allNode = new ArrayList<>();
        mService = ApiUtils.getService();
        loadData();
        return view;
    }

    private void loadData() {
        mService.Getaqicurrentday().enqueue(new Callback<List<Node>>() {
            @Override
            public void onResponse(Call<List<Node>> call, Response<List<Node>> response) {

                allNode = (ArrayList<Node>) response.body();
                for (int i = 0; i < allNode.size(); i++) {
//                int i=10;
                    Log.d("checkkkkkkk", String.valueOf(allNode.get(i)));
                    tvid.setText(String.valueOf(allNode.get(i).getStationId()));
                    tvAQI.setText(String.valueOf(allNode.get(i).getAqi()));
                    tvlon.setText(String.valueOf(allNode.get(i).getLon()));
                    tvlang.setText(String.valueOf(allNode.get(i).getLat()));
                    tvcontent.setText(allNode.get(i).getContent());
                }

            }

            @Override
            public void onFailure(Call<List<Node>> call, Throwable t) {
                Log.d("checkkkkkkk", "errorrrrr");
            }
        });
    }
    }
//        recyclerView = (RecyclerView) view.findViewById(R.id.list_view);
//        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        mAuth = FirebaseAuth.getInstance();


//        list = new ArrayList<>();
//        myAdapter = new MyAdapterpaper(slideshowFragment.this,list);
//        recyclerView.setAdapter(myAdapter);
//
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                list.clear();
//
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//
//                    ImforUrl imforUrl = dataSnapshot.getValue(ImforUrl.class);
//                    list.add(imforUrl);
//
//
//                }
//                myAdapter.notifyDataSetChanged();
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


//    FirebaseRecyclerOptions<ImforUrl> options =
//                new FirebaseRecyclerOptions.Builder<ImforUrl>()
//                        .setQuery(databaseReference,ImforUrl.class)
//                        .build();
//    myAdapter = new MyAdapterpaper(options);
//    recyclerView.setAdapter(myAdapter);
//


//    return view;
//    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        myAdapter.startListening();
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        myAdapter.stopListening();
//    }
//}


