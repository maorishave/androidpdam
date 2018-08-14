package com.example.apps.oktaatr.pdam_controlling.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.apps.oktaatr.pdam_controlling.DetailProsesRevisiActivity;
import com.example.apps.oktaatr.pdam_controlling.DetailTugasRevisiActivity;
import com.example.apps.oktaatr.pdam_controlling.FormRevisiActivity;
import com.example.apps.oktaatr.pdam_controlling.Model.Bonc;
import com.example.apps.oktaatr.pdam_controlling.R;

import java.util.List;

public class PRevisiAdapter extends RecyclerView.Adapter<PRevisiAdapter.PRevisiViewHolder> {
    Context context;
    List<Bonc> boncList;

    public PRevisiAdapter(Context context, List<Bonc> boncList){
        this.context = context;
        this.boncList = boncList;
    }

    public PRevisiViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_prosesrevisi, parent, false);
        return new PRevisiViewHolder(view);
    }

    public void onBindViewHolder (PRevisiViewHolder holder, int position){
        if (boncList != null){
            final Bonc bonc = boncList.get(position);
            holder.no_bon_proses_revisi.setText(bonc.getNomerbon());
            holder.tgl_bon_proses_revisi.setText(bonc.getTglbon());
            holder.nama_plg_proses_revisi.setText(bonc.getNamapel());
            holder.no_plg_proses_revisi.setText(bonc.getNopel());
            holder.alm_plg_proses_revisi.setText(bonc.getAlamatpel());
            holder.msl_plg_proses_revisi.setText(bonc.getMasalah());
            holder.ket_revisi_proses.setText(bonc.getKet_realisasi());
            holder.klikdetail_previsi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailProsesRevisiActivity.class);
                    intent.putExtra("id", bonc.getId().toString());
                    intent.putExtra("nobonc", bonc.getNomerbon());
                    context.startActivity(intent);
                }
            });
            holder.klikform_previsi.setOnClickListener(new View.OnClickListener() {
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

    public class PRevisiViewHolder extends RecyclerView.ViewHolder{
        Button klikdetail_previsi, klikform_previsi;
        TextView no_bon_proses_revisi, tgl_bon_proses_revisi, nama_plg_proses_revisi, no_plg_proses_revisi, alm_plg_proses_revisi, msl_plg_proses_revisi, ket_revisi_proses;
        public PRevisiViewHolder(View itemView){
            super(itemView);
            no_bon_proses_revisi = itemView.findViewById(R.id.no_bon_proses_revisi);
            tgl_bon_proses_revisi = itemView.findViewById((R.id.tgl_bon_proses_revisi));
            nama_plg_proses_revisi = itemView.findViewById(R.id.nama_plg_proses_revisi);
            no_plg_proses_revisi = itemView.findViewById(R.id.no_plg_proses_revisi);
            alm_plg_proses_revisi = itemView.findViewById(R.id.alm_plg_proses_revisi);
            msl_plg_proses_revisi = itemView.findViewById(R.id.msl_plg_proses_revisi);
            ket_revisi_proses = itemView.findViewById(R.id.ket_revisi_proses);
            klikdetail_previsi = itemView.findViewById(R.id.btnDetail_PR);
            klikform_previsi = itemView.findViewById(R.id.btnForm_PR);
        }
    }
}
