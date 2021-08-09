package com.airsen.button.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.airsen.button.MainActivity;
import com.airsen.button.R;
import com.airsen.button.ui.AQI_US;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;

public class ChartFragment extends Fragment {
    private BarChart mChart1, mChart2;
    BarData data;
    TextView mTvRecommend, mTvName, mTvValue, mTvLocation, mTvTarget, mTvTime, mTvAqi, mTvPm2p5, mTvPm1, mTvPm10, mTvCo, mTvTem, mTvHumi;


    public ChartFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e("lam", "Fragmnetchart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("lam", "Fragmnetchart");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chart, container, false);


        mTvName = view.findViewById(R.id.tv_name_chart_fragment);
        mTvValue = view.findViewById(R.id.tv_value_chart_fragment);
        mTvLocation = view.findViewById(R.id.tv_location_chart_fragment);
        mTvTarget = view.findViewById(R.id.tv_target_chart_fragment);
        mTvTime = view.findViewById(R.id.tv_realtime_chart_fragment);
        mTvAqi = view.findViewById(R.id.tv_AQI_chart_fragment);
        mTvPm2p5 = view.findViewById(R.id.tv_pm2p5_chart_fragment);
        mTvPm1 = view.findViewById(R.id.tv_pm1_chart_fragment);
        mTvPm10 = view.findViewById(R.id.tv_pm10_chart_fragment);
        mTvCo = view.findViewById(R.id.tv_co_chart_fragment);
        mTvTem = view.findViewById(R.id.tv_tem_chart_fragment);
        mTvHumi = view.findViewById(R.id.tv_humi_chart_fragment);
        mTvRecommend = view.findViewById(R.id.tv_recommend_chart_fragment);


//        mTvName.setText(MainActivity.allNode.get(MainActivity.currentNode).getmId() + " ");
//        mTvLocation.setText(MainActivity.allNode.get(MainActivity.currentNode).getmAddress() + " ");
//        mTvTarget.setText(MainActivity.allNode.get(MainActivity.currentNode).getmDescription() + " ");
//        for (int i = 0; i < MainActivity.arrayListTakeRecord.size(); i++) {
//            if (MainActivity.arrayListTakeRecord.get(i).getmId().equals(MainActivity.allNode.get(MainActivity.currentNode).getmId())) {
//                mTvTime.setText(MainActivity.arrayListTakeRecord.get(i).getmTimeStamp() + " ");
//                mTvAqi.setText((int) MainActivity.arrayListTakeRecord.get(i).getmAQI() + " ");
//                mTvPm2p5.setText(MainActivity.arrayListTakeRecord.get(i).getmPM2_5() + " ");
//                mTvPm1.setText(MainActivity.arrayListTakeRecord.get(i).getmPM1() + " ");
//                mTvPm10.setText(MainActivity.arrayListTakeRecord.get(i).getmPM10() + " ");
//                mTvTem.setText(MainActivity.arrayListTakeRecord.get(i).getTemprature() + " ");
//                mTvHumi.setText(MainActivity.arrayListTakeRecord.get(i).getHumidity() + " ");
//                mTvValue.setText(AQI_US.getMessage(MainActivity.arrayListTakeRecord.get(i).getmAQI()));
//                break;
//            }
//        }

        mChart1 = view.findViewById(R.id.chart1);
        mChart1.getDescription().setEnabled(false);
        //setData(24);
        mChart1.setData(data);
        mChart1.invalidate();
        mChart1.animateY(500);
        mChart1.setFitBars(true);


        mChart2 = view.findViewById(R.id.chart2);
        //mChart2.getDescription().setEnabled(false);

        //setData(24);
        mChart2.setData(data);
        // mChart2.invalidate();
        // mChart2.animateY(500);
        // mChart2.setFitBars(true);
        return view;

    }
}