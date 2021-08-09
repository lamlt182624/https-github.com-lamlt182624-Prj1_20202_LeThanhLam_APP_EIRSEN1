package com.airsen.button.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.airsen.button.R;
import com.airsen.button.object.Node;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Node> {


    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<Node> objects) {
        super(context, resource, objects);
    }
    class ViewHolder12{
        TextView textView;
        TextView textView1;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder12 viewHolder12 = null;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.listview_component, null);
            viewHolder12 = new ViewHolder12();
            viewHolder12.textView = convertView.findViewById(R.id.tv_address);
            viewHolder12.textView1 = convertView.findViewById(R.id.tv_warning);
//            viewHolder12.imageView = convertView.findViewById(R.id.iv_aqiColor);
            convertView.setTag(viewHolder12);

        }else {
            viewHolder12 = (ViewHolder12) convertView.getTag();
        }
        Node node = getItem(position);
        viewHolder12.textView.setText(node.getContent());
        viewHolder12.textView1.setText(node.getAqi());

        return convertView;
    }
}
