package com.iam_sid.festivalerp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iam_sid.festivalerp.R;
import com.iam_sid.festivalerp.model.Title;
import com.iam_sid.festivalerp.utils.TitleCollector ;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private ArrayList<TitleCollector> TitleList;
    private LayoutInflater mInflater;
    Context mCtx;


    public MyRecyclerViewAdapter(ArrayList<TitleCollector> TitleList, Context mCtx) {
        this.TitleList = TitleList;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mCtx);
        View view = layoutInflater.inflate(R.layout.recycler_row, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        TitleCollector titleCollector = TitleList.get(position);
        viewHolder.imgIcon.setImageDrawable(mCtx.getResources().getDrawable(titleCollector.titleImgId));
        viewHolder.txtName.setText(titleCollector.getTitleName());

    }

    @Override
    public int getItemCount() {
        return TitleList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon;
        TextView txtName;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.tvContentTitle);
            imgIcon = (ImageView) itemView.findViewById(R.id.ivContentIcon);
        }

    }
}


//    public MyRecyclerViewAdapter( Context context, ArrayList<TitleCollector> titleInfos) {
//        this.context = context;
//        this.titleInfos = titleInfos;
//        arrayList=new ArrayList<TitleCollector>();
//        arrayList.addAll(titleInfos);
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row,viewGroup,false);
//        return new ViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder holder, int i) {
//        TitleCollector title=titleInfos.get(i);
//        holder.txtName.setText(title.getTitleName());
//        holder.imgIcon.setImageResource(Integer.parseInt(title.getTitleImgId()));
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public int getItemCount() {
//        return titleInfos.size();
//    }
//
