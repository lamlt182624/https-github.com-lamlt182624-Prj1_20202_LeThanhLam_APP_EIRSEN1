package com.airsen.button.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.airsen.button.MainActivity;
import com.airsen.button.R;
import com.airsen.button.Retrofit.ApiUtils;
import com.airsen.button.Retrofit.datasevice;
import com.airsen.button.activity.TakeDataActivity;
import com.airsen.button.object.Node;
import com.airsen.button.ui.AQI_US;
import com.airsen.button.ui.Dialogs;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class gelleryFragment extends Fragment {

    ArrayList<Node> allNode;
    PlaylistAdapter playlistAdapter;
    ListView listView;
    datasevice mService;
    RecyclerView recyclerView;
    public static SharedPreferences mSaveFavoritePlace;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        listView = view.findViewById(R.id.lv_position);
        mService = ApiUtils.getService();
        allNode = new ArrayList<>();
        loadData();

        return view;
    }

    private void loadData() {
        mService.Getaqicurrentday().enqueue(new Callback<List<Node>>() {
            @Override
            public void onResponse(Call<List<Node>> call, Response<List<Node>> response) {

                allNode = (ArrayList<Node>) response.body();

//                playlistAdapter = new PlaylistAdapter(getActivity(), android.R.layout.simple_list_item_1,allNode);
//                listView.setAdapter(playlistAdapter);
                ArrayAdapter<Node> nodeArrayList = new ArrayAdapter<Node>(
                        getActivity(), android.R.layout.simple_list_item_1, allNode
                );
                listView.setAdapter(nodeArrayList);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(getContext(), "trạm", Toast.LENGTH_SHORT).show();
                        dialogChoiceFavaritePlace(position,gelleryFragment.this.getContext());
                    }
                });



            }

            @Override
            public void onFailure(Call<List<Node>> call, Throwable t) {
                Log.d("checkkkkkkk1234", "errorrrrr");
            }
        });
    }
    public void dialogChoiceFavaritePlace(final int position,Context context) {
        TextView mTvplaceFavorite;
        Button mBtnChoiceFavorite, mBtnCancel;
        ImageView mimageView;
        loadData();

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_choice_favorite_place);
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        mimageView = dialog.findViewById(R.id.imageView2);
        mTvplaceFavorite = dialog.findViewById(R.id.tv_place_favotite_place);
        mBtnChoiceFavorite = dialog.findViewById(R.id.btn_choice_dialog_favotite_place);
        mBtnCancel = dialog.findViewById(R.id.btn_cancle_dialog_favotite_place);

        //mTvplaceFavorite.setText(MainActivity.allNode.get(position).getmAddress());
        mTvplaceFavorite.setTextColor(context.getResources().getColor(R.color.colorAccent));

        mBtnChoiceFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SharedPreferences.Editor editor = mSaveFavoritePlace.edit();
//                editor.putInt("number_favorite", position);
//                editor.putString("place", allNode.get(position).getContent());
//                editor.commit();
                getFragmentManager().beginTransaction().replace(R.id.list1,new ChartFragment()).commit();

                dialog.cancel();
            }
        });
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.cancel();
            }
        });

        dialog.show();
    }
}