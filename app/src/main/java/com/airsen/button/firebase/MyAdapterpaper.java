package com.airsen.button.firebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airsen.button.R;
import com.airsen.button.fragment.slideshowFragment;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterpaper extends FirebaseRecyclerAdapter<ImforUrl,MyAdapterpaper.MyViewHoder> {
   Context context;
   List<ImforUrl> list;

    public MyAdapterpaper(@NonNull FirebaseRecyclerOptions<ImforUrl> options) {
        super(options);
    }


    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listpaper,parent,false);

       return new MyViewHoder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHoder holder, int position, @NonNull ImforUrl model) {
        ImforUrl imforUrl = list.get(position);
        holder.mtittle.setText(imforUrl.getMtittle());
        holder.mtype.setText(imforUrl.getMtype());
        holder.mtime.setText(imforUrl.getMtime());
        holder.murl.setText(imforUrl.getMurl());
    }

    public static class MyViewHoder extends RecyclerView.ViewHolder{
       TextView mtittle, mtime, mtype, murl;


    public MyViewHoder(@NonNull View itemView) {
        super(itemView);

        mtittle = itemView.findViewById(R.id.tv_tittle);
        mtype = itemView.findViewById(R.id.tv_type);
        mtime = itemView.findViewById(R.id.tv_time);
        murl = itemView.findViewById(R.id.tv_url);
    }
}
}
