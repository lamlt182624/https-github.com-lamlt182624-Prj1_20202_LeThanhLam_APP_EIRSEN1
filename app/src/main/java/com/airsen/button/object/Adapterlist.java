package com.airsen.button.object;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.airsen.button.R;

import java.util.ArrayList;
import java.util.List;

public class Adapterlist extends RecyclerView.Adapter<Adapterlist.AdapterHoider>{

    private List<Node> mlist;

    public void  setdata(List<Node>list){
        this.mlist = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public AdapterHoider onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_component,parent,false);
        return new AdapterHoider(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHoider holder, int position) {

        Node node = mlist.get(position);
        if (node == null){
            return;
        }
      ///holder.imageView.setImageResource(node.);
        holder.address1.setText(node.getContent());
        holder.warning1.setText(node.getAqi());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AdapterHoider extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private  TextView address1;
        private  TextView warning1;

        public AdapterHoider(@NonNull View itemView) {
            super(itemView);
                    imageView = itemView.findViewById(R.id.iv_aqiColor);
                    address1 = imageView.findViewById(R.id.tv_address);
                    warning1 = imageView.findViewById(R.id.tv_warning);
        }
    }
}
//} {
//
//
//    public Adapterlist(Context context, ArrayList<paper> paperArrayList) {
//        super(context, R.layout.listview_component,paperArrayList);
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//        paper mpaper = getItem(position);
//
//
//        if (convertView == null){
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_component,parent, false);
//        }
//        ImageView imageView = convertView.findViewById(R.id.iv_aqiColor);
//        TextView address = convertView.findViewById(R.id.tv_address);
//        TextView warning = convertView.findViewById(R.id.tv_warning);
//
//        imageView.setImageResource(mpaper.image);
//        address.setText(mpaper.address);
//        warning.setText(mpaper.warnning);
//
//        return convertView;
//    }
//}
