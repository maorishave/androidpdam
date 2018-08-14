package com.example.apps.oktaatr.pdam_controlling.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apps.oktaatr.pdam_controlling.DetailKirimBaruActivity;
import com.example.apps.oktaatr.pdam_controlling.DetailTugasBaruActivity;
import com.example.apps.oktaatr.pdam_controlling.FormHasilKontrolActivity;
import com.example.apps.oktaatr.pdam_controlling.FormKontrolActivity;
import com.example.apps.oktaatr.pdam_controlling.Model.Bonc;
import com.example.apps.oktaatr.pdam_controlling.Model.ListBoncModel;
import com.example.apps.oktaatr.pdam_controlling.R;

import java.util.List;

public class KBaruAdapter extends RecyclerView.Adapter<KBaruAdapter.KBaruViewHolder> {
    Context context;
    List<Bonc> boncList;

    public KBaruAdapter(Context context, List<Bonc> boncList){
        this.context = context;
        this.boncList = boncList;
    }

    public KBaruViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_cardview_kirimbaru, parent, false);
        return new KBaruViewHolder (view);
    }

    public void onBindViewHolder (KBaruViewHolder holder, int position){
        if (boncList != null){
            final Bonc bonc = boncList.get(position);
            holder.no_bon_kirim_baru.setText(bonc.getNomerbon());
            holder.tgl_bon_kirim_baru.setText(bonc.getTglbon());
            holder.nama_plg_kirim_baru.setText(bonc.getNamapel());
            holder.no_plg_kirim_baru.setText(bonc.getNopel());
            holder.alm_plg_kirim_baru.setText(bonc.getAlamatpel());
            holder.msl_plg_kirim_baru.setText(bonc.getMasalah());
            holder.klikdetail_bkirim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailKirimBaruActivity.class);
                    intent.putExtra("id", bonc.getId().toString());
                    intent.putExtra("nobonc", bonc.getNomerbon());
                    context.startActivity(intent);
                }
            });
            holder.klikform_bkirim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FormHasilKontrolActivity.class);
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

    public class KBaruViewHolder extends RecyclerView.ViewHolder{
        Button klikdetail_bkirim, klikform_bkirim;
        TextView no_bon_kirim_baru, tgl_bon_kirim_baru, nama_plg_kirim_baru, no_plg_kirim_baru, alm_plg_kirim_baru, msl_plg_kirim_baru;
        public KBaruViewHolder(View itemView){
            super(itemView);
            no_bon_kirim_baru = itemView.findViewById(R.id.no_bon_kirim_baru);
            tgl_bon_kirim_baru = itemView.findViewById((R.id.tgl_bon_kirim_baru));
            nama_plg_kirim_baru = itemView.findViewById(R.id.nama_plg_kirim_baru);
            no_plg_kirim_baru = itemView.findViewById(R.id.no_plg_kirim_baru);
            alm_plg_kirim_baru = itemView.findViewById(R.id.alm_plg_kirim_baru);
            msl_plg_kirim_baru = itemView.findViewById(R.id.msl_plg_kirim_baru);
            klikdetail_bkirim = itemView.findViewById(R.id.btnDetail_KB);
            klikform_bkirim = itemView.findViewById(R.id.btnForm_KB);
        }
    }
}
