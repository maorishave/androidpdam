package com.example.apps.oktaatr.pdam_controlling.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.apps.oktaatr.pdam_controlling.DetailTugasBaruActivity;
import com.example.apps.oktaatr.pdam_controlling.FormKontrolActivity;
import com.example.apps.oktaatr.pdam_controlling.Model.Bonc;
import com.example.apps.oktaatr.pdam_controlling.R;

import java.util.List;

public class TBaruAdapter extends RecyclerView.Adapter<TBaruAdapter.TBaruViewHolder>{
    Context context;
    List<Bonc> boncList;

    public TBaruAdapter(Context context, List<Bonc> boncList){
        this.context = context;
        this.boncList = boncList;
    }

    public TBaruViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_cardview_baru, parent, false);
        return new TBaruViewHolder (view);
    }

    public void onBindViewHolder (TBaruViewHolder holder, int position){
        if (boncList != null){
            final Bonc bonc = boncList.get(position);
            holder.no_bon_baru.setText(bonc.getNomerbon());
            holder.tgl_bon_baru.setText(bonc.getTglbon());
            holder.nama_plg_baru.setText(bonc.getNamapel());
            holder.no_plg_baru.setText(bonc.getNopel());
            holder.alm_plg_baru.setText(bonc.getAlamatpel());
            holder.msl_plg_baru.setText(bonc.getMasalah());
            holder.klikdetail_baru.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailTugasBaruActivity.class);
                    intent.putExtra("id", bonc.getId().toString());
                    intent.putExtra("nobonc", bonc.getNomerbon());
                    context.startActivity(intent);
                }
            });
            holder.klikform_baru.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FormKontrolActivity.class);
                    intent.putExtra("id", bonc.getId().toString());
                    intent.putExtra("nobonc", bonc.getNomerbon());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (boncList == null)
            return 0;
        else {
            return boncList.size();
        }
    }

    public class TBaruViewHolder extends RecyclerView.ViewHolder{
        Button klikdetail_baru, klikform_baru;
        TextView no_bon_baru, tgl_bon_baru, nama_plg_baru, no_plg_baru, alm_plg_baru, msl_plg_baru;
        public TBaruViewHolder(View itemView){
            super(itemView);
            no_bon_baru = itemView.findViewById(R.id.no_bon_baru);
            tgl_bon_baru = itemView.findViewById((R.id.tgl_bon_baru));
            nama_plg_baru = itemView.findViewById(R.id.nama_plg_baru);
            no_plg_baru = itemView.findViewById(R.id.no_plg_baru);
            alm_plg_baru = itemView.findViewById(R.id.alm_plg_baru);
            msl_plg_baru = itemView.findViewById(R.id.msl_plg_baru);
            klikdetail_baru = itemView.findViewById(R.id.btnDetail_TB);
            klikform_baru = itemView.findViewById(R.id.btnForm_TB);
        }
    }
}