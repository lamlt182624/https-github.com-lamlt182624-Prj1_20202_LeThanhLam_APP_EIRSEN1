package com.airsen.button.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airsen.button.R;
import com.airsen.button.Retrofit.ApiUtils;
import com.airsen.button.Retrofit.datasevice;
import com.airsen.button.object.Node;
import com.airsen.button.ui.AQI_US;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home2Fragment extends Fragment implements OnMapReadyCallback,GoogleMap.OnInfoWindowClickListener{
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    List<Node> allNode;
    private static final int DEFAULT_ZOOM = 13;
    public ArrayList<Marker> markerArrayList = null;
    private datasevice mService;

    Integer war;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home2, container, false);
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment == null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            fragmentTransaction.replace(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mMap = googleMap;
        markerArrayList = new ArrayList<>();
        allNode = new ArrayList<>();
        mService = ApiUtils.getService();

        mService.Getaqicurrentday().enqueue(new Callback<List<Node>>() {

            @Override
            public void onResponse(Call<List<Node>> call, Response<List<Node>> response) {
                allNode = response.body();
                intmarker(allNode);

            }

            @Override
            public void onFailure(Call<List<Node>> call, Throwable t) {

            }
        });
        mMap.setOnInfoWindowClickListener(this);
    }

    @Override
    public void onInfoWindowClick(@NonNull Marker marker) {
        float a= marker.getZIndex();
        Log.d("checkkkkkkk321", String.valueOf(a));
        DialogMapFragment((int) a, this.getContext());
        Toast.makeText(getContext(),"trạm" + marker.getTitle(),Toast.LENGTH_SHORT).show();

    }

    private void intmarker (List<Node> allNode){
        for (int i = 0; i < allNode.size(); i++) {
            Log.d("checkkkkkkk12", "acb");
            int bt = (int) allNode.get(i).getAqi();
            Marker marker = mMap.addMarker(new MarkerOptions().position(new LatLng(allNode.get(i).getLat(), allNode.get(i).getLon()))
                    .title(String.valueOf(allNode.get(i).getContent()))
                    .icon(BitmapDescriptorFactory.fromBitmap(createCustomMarkerOutDoor(getContext(), String.valueOf(bt) , i)))
                    .zIndex(i));
            markerArrayList.add(marker);

            if (allNode.size() != 0){
                TestInforWidowAdapter testInforWidowAdapter = new TestInforWidowAdapter(getContext());
            mMap.setInfoWindowAdapter(testInforWidowAdapter);
            }
        }
    }

    public Bitmap createCustomMarkerOutDoor(Context context, String _name, int i) {

        View marker = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.marker, null);
        TextView txt_name = marker.findViewById(R.id.tv_marker);
        txt_name.setText(_name);
        txt_name.setBackground(ContextCompat.getDrawable(context, AQI_US.getStyleColorMarker(allNode.get(i).getAqi())));

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        marker.setLayoutParams(new ViewGroup.LayoutParams(52, ViewGroup.LayoutParams.WRAP_CONTENT));
        marker.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        marker.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        marker.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(marker.getMeasuredWidth(), marker.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        marker.draw(canvas);

        return bitmap;
    }



    public void DialogMapFragment(final int a, Context context) {
        TextView mTvPlaceDialogAQIMap, mTvAQIDialogAQIMap, mTvWarningDialogAQIMap, mTvDetailDialogAQIMap;
        ImageView mImvStatusDialogAQIMap;
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_aqi_map);
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        mTvPlaceDialogAQIMap = dialog.findViewById(R.id.tv_place_small_notification);
        mTvAQIDialogAQIMap = dialog.findViewById(R.id.tv_AQI_small_notification);
        mTvWarningDialogAQIMap = dialog.findViewById(R.id.tv_warning_small_notification);
        mTvDetailDialogAQIMap = dialog.findViewById(R.id.tv_detail_small_notification);
        mImvStatusDialogAQIMap = dialog.findViewById(R.id.imv_status_AQI_small_notification);


        mTvPlaceDialogAQIMap.setText(allNode.get(a).getContent());
        mTvAQIDialogAQIMap.setText((int) allNode.get(a).getAqi() + "");
        mTvWarningDialogAQIMap.setText(AQI_US.getMessage(allNode.get(a).getAqi()));
        mImvStatusDialogAQIMap.setImageResource(AQI_US.getAqiIcon(allNode.get(a).getAqi()));

        mTvDetailDialogAQIMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.map,new ChartFragment()).commit();

                dialog.cancel();
            }
        });
       dialog.show();

//    }
    }



private class TestInforWidowAdapter implements GoogleMap.InfoWindowAdapter{
        private Home2Fragment home2Fragment;
        private  Context context;

        public TestInforWidowAdapter(Context context){
            this.context = context;
        }



        @Nullable
        @Override
        public View getInfoWindow(@NonNull Marker marker) {
            return null;
        }

        @Nullable
        @Override
        public View getInfoContents(@NonNull Marker marker) {

            View view = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.listview_component, null);
            TextView content = view.findViewById(R.id.tv_address);
            TextView warning = view.findViewById(R.id.tv_warning);



            content.setText(marker.getTitle());
            warning.setText(marker.getSnippet());


            return view;
        }
    }


}