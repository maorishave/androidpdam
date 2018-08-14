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
import com.example.apps.oktaatr.pdam_controlling.DetailTugasRevisiActivity;
import com.example.apps.oktaatr.pdam_controlling.FormRevisiActivity;
import com.example.apps.oktaatr.pdam_controlling.Model.Bonc;
import com.example.apps.oktaatr.pdam_controlling.R;

import java.util.List;

public class TRevisiAdapter extends RecyclerView.Adapter<TRevisiAdapter.TRevisiViewHolder> {
    Context context;
    List<Bonc> boncList;

    public TRevisiAdapter(Context context, List<Bonc> boncList){
        this.context = context;
        this.boncList = boncList;
    }

    public TRevisiViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_tugasrevisi, parent, false);
        return new TRevisiViewHolder(view);
    }

    public void onBindViewHolder (TRevisiViewHolder holder, int position){
        if (boncList != null){
            final Bonc bonc = boncList.get(position);
            holder.no_bon_revisi.setText(bonc.getNomerbon());
            holder.tgl_bon_revisi.setText(bonc.getTglbon());
            holder.nama_plg_revisi.setText(bonc.getNamapel());
            holder.no_plg_revisi.setText(bonc.getNopel());
            holder.alm_plg_revisi.setText(bonc.getAlamatpel());
            holder.msl_plg_revisi.setText(bonc.getMasalah());
            holder.ket_revisi_tugas.setText(bonc.getKet_realisasi());
            holder.klikdetail_revisi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailTugasRevisiActivity.class);
                    intent.putExtra("id", bonc.getId().toString());
                    intent.putExtra("nobonc", bonc.getNomerbon());
                    context.startActivity(intent);
                }
            });
            holder.klikform_revisi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FormRevisiActivity.class);
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

    public class TRevisiViewHolder extends RecyclerView.ViewHolder{
        Button klikdetail_revisi, klikform_revisi;
        TextView no_bon_revisi, tgl_bon_revisi, nama_plg_revisi, no_plg_revisi, alm_plg_revisi, msl_plg_revisi, ket_revisi_tugas;
        public TRevisiViewHolder(View itemView){
            super(itemView);
            no_bon_revisi = itemView.findViewById(R.id.no_bon_revisi);
            tgl_bon_revisi = itemView.findViewById((R.id.tgl_bon_revisi));
            nama_plg_revisi = itemView.findViewById(R.id.nama_plg_revisi);
            no_plg_revisi = itemView.findViewById(R.id.no_plg_revisi);
            alm_plg_revisi = itemView.findViewById(R.id.alm_plg_revisi);
            msl_plg_revisi = itemView.findViewById(R.id.msl_plg_revisi);
            ket_revisi_tugas = itemView.findViewById(R.id.ket_revisi_tugas);
            klikdetail_revisi = itemView.findViewById(R.id.btnDetail_TR);
            klikform_revisi = itemView.findViewById(R.id.btnForm_TR);
        }
    }
}