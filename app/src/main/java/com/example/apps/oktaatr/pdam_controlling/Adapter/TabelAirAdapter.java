package com.example.apps.oktaatr.pdam_controlling.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.apps.oktaatr.pdam_controlling.DetailKirimRevisiActivity;
import com.example.apps.oktaatr.pdam_controlling.Model.Bonc;
import com.example.apps.oktaatr.pdam_controlling.Model.Pemakaianair;
import com.example.apps.oktaatr.pdam_controlling.R;

import java.util.List;

public class TabelAirAdapter extends RecyclerView.Adapter<TabelAirAdapter.TabelAirViewHolder> {
    Context context;
    List<Pemakaianair> pemakaianairList;

    public TabelAirAdapter(Context context, List<Pemakaianair> pemakaianairList){
        this.context = context;
        this.pemakaianairList = pemakaianairList;
    }

    public TabelAirViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.tabel_pemakaian_air, parent, false);
        return new TabelAirViewHolder(view);
    }

    public void onBindViewHolder (TabelAirAdapter.TabelAirViewHolder holder, int position){
        if (pemakaianairList != null){
            final Pemakaianair pemakaianair = pemakaianairList.get(position);
            holder.tanggalcatat.setText(pemakaianair.getTglcatat().toString());
            holder.mtlalu.setText(pemakaianair.getMtlalu().toString());
            holder.mtkini.setText(pemakaianair.getMtkini().toString());
            holder.mtair.setText(pemakaianair.getMair().toString());
        }
    }

    @Override
    public int getItemCount() {
        if (pemakaianairList == null)
            return 0;
        else {
            return pemakaianairList.size();
        }
    }

    public class TabelAirViewHolder extends RecyclerView.ViewHolder{
        TextView tanggalcatat, mtlalu, mtkini, mtair;
        public TabelAirViewHolder(View itemView){
            super(itemView);
            tanggalcatat = itemView.findViewById(R.id.tgl_air);
            mtlalu = itemView.findViewById((R.id.mtlalu));
            mtkini = itemView.findViewById(R.id.mtkini);
            mtair = itemView.findViewById(R.id.mtair);
        }
    }
}
