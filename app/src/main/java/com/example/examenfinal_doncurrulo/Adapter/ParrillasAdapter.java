package com.example.examenfinal_doncurrulo.Adapter;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenfinal_doncurrulo.Activity.ShowDetailActivity;
import com.example.examenfinal_doncurrulo.Domain.FoodDomain;
import com.example.examenfinal_doncurrulo.R;

import java.util.ArrayList;
import java.util.List;

public class ParrillasAdapter extends RecyclerView.Adapter<ParrillasAdapter.ViewHolder> {
    ArrayList<FoodDomain> ParrillaDomains;
    private List<FoodDomain> parrillalist;

    public ParrillasAdapter(ArrayList<FoodDomain> ParrillaDomains) {
        this.ParrillaDomains = ParrillaDomains;
        this.parrillalist = new ArrayList<>();
        parrillalist.addAll(ParrillaDomains);

    }

    @NonNull
    @Override
    public ParrillasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_parrilla,parent,false);

        return new ParrillasAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ParrillasAdapter.ViewHolder holder, int position) {
        holder.title.setText(ParrillaDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(ParrillaDomains.get(position).getFee()));

        int drawableReourceId=holder.itemView.getContext().getResources()
                .getIdentifier(ParrillaDomains.get(position).getPic(),"drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.pic);

        holder.addBtn.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
            intent.putExtra("object", ParrillaDomains.get(position));
            holder.itemView.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {return ParrillaDomains.size();}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView pic;
        ImageView addBtn;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title=itemView.findViewById(R.id.title);
            pic=itemView.findViewById(R.id.pic);
            fee=itemView.findViewById(R.id.fee);
            addBtn=itemView.findViewById(R.id.addBtn);
        }
    }

}
