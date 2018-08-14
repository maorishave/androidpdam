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
import com.example.apps.oktaatr.pdam_controlling.DetailTugasRevisiActivity;
import com.example.apps.oktaatr.pdam_controlling.FormHasilKontrolActivity;
import com.example.apps.oktaatr.pdam_controlling.FormRevisiActivity;
import com.example.apps.oktaatr.pdam_controlling.Model.Bonc;
import com.example.apps.oktaatr.pdam_controlling.R;

import java.util.List;

public class KRevisiAdapter extends RecyclerView.Adapter<KRevisiAdapter.KRevisiViewHolder> {
    Context context;
    List<Bonc> boncList;

    public KRevisiAdapter(Context context, List<Bonc> boncList){
        this.context = context;
        this.boncList = boncList;
    }

    public KRevisiViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_kirimrevisi, parent, false);
        return new KRevisiViewHolder(view);
    }

    public void onBindViewHolder (KRevisiViewHolder holder, int position){
        if (boncList != null){
            final Bonc bonc = boncList.get(position);
            holder.no_bon_kirim_revisi.setText(bonc.getNomerbon());
            holder.tgl_bon_kirim_revisi.setText(bonc.getTglbon());
            holder.nama_plg_kirim_revisi.setText(bonc.getNamapel());
            holder.no_plg_kirim_revisi.setText(bonc.getNopel());
            holder.alm_plg_kirim_revisi.setText(bonc.getAlamatpel());
            holder.msl_plg_kirim_revisi.setText(bonc.getMasalah());
            holder.ket_revisi_kirim.setText(bonc.getKet_realisasi());
            holder.klikdetail_krevisi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailKirimRevisiActivity.class);
                    intent.putExtra("id", bonc.getId().toString());
                    intent.putExtra("nobonc", bonc.getNomerbon());
                    context.startActivity(intent);
                }
            });
            holder.klikliatform_krevisi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FormHasilKontrolActivity.class);
                    intent.putExtra("id", bonc.getId().toString());
//                    intent.putExtra("nobonc", bonc.getNomerbon());
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

    public class KRevisiViewHolder extends RecyclerView.ViewHolder{
        Button klikdetail_krevisi, klikliatform_krevisi;
        TextView no_bon_kirim_revisi, tgl_bon_kirim_revisi, nama_plg_kirim_revisi, no_plg_kirim_revisi, alm_plg_kirim_revisi, msl_plg_kirim_revisi, ket_revisi_kirim;
        public KRevisiViewHolder(View itemView){
            super(itemView);
            no_bon_kirim_revisi = itemView.findViewById(R.id.no_bon_kirim_revisi);
            tgl_bon_kirim_revisi = itemView.findViewById((R.id.tgl_bon_kirim_revisi));
            nama_plg_kirim_revisi = itemView.findViewById(R.id.nama_plg_kirim_revisi);
            no_plg_kirim_revisi = itemView.findViewById(R.id.no_plg_kirim_revisi);
            alm_plg_kirim_revisi = itemView.findViewById(R.id.alm_plg_kirim_revisi);
            msl_plg_kirim_revisi = itemView.findViewById(R.id.msl_plg_kirim_revisi);
            ket_revisi_kirim = itemView.findViewById(R.id.ket_revisi_kirim);
            klikdetail_krevisi = itemView.findViewById(R.id.btnDetail_KR);
            klikliatform_krevisi = itemView.findViewById(R.id.btnForm_KR);
        }
    }
}




