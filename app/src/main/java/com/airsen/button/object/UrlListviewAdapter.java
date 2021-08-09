package com.airsen.button.object;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.airsen.button.R;
import com.airsen.button.firebase.UrlInformation;

import java.util.List;



public class UrlListviewAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<UrlInformation> listUrl;

    public UrlListviewAdapter(Context context, int layout, List<UrlInformation> listUrl) {
        this.context = context;
        this.layout = layout;
        this.listUrl = listUrl;
    }

    @Override
    public int getCount() {
        return listUrl.size(); // tra ra rat quan trong
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LvHolder1 holder = null;

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
            //row = inflater.inflate(R.layout.listview_component, parent, false);
            row = inflater.inflate (layout, null);
            holder = new LvHolder1(row);
            row.setTag(holder);
        } else {
            holder = (LvHolder1) row.getTag();
        }
      //  holder.populateFrom(slideshowFragment.arrayListurl.get(position));
        return (row);
    }


    static class LvHolder1 {
        private TextView title = null;
        private TextView time = null;
        private TextView content = null;
        private ImageView type = null;

        LvHolder1(View row) {
            title = row.findViewById(R.id.tv_tittle_url);
            time = row.findViewById(R.id.tv_time_url);
            content = row.findViewById(R.id.tv_content_url);
            type = row.findViewById(R.id.iv_type_url);
        }

//        void populateFrom(UrlInformation r) {
//            title.setText(r.getTittle());
//            time.setText(r.getTime());
//            content.setText(r.getContent());
//
//            if (r.getType() == 1) {
//                type.setImageResource(R.drawable.ic_announcement_black_24dp_information);
//            }
//            if (r.getType() == 2) {
//                type.setImageResource(R.drawable.ic_local_florist_black_24dp_information);
//            }
//            if (r.getType() == 3) {
//                type.setImageResource(R.drawable.ic_fiber_new_black_24dp_information);
//            }
//        }
    }
}
