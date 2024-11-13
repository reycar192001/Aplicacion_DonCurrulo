package com.example.examenfinal_doncurrulo.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.examenfinal_doncurrulo.Activity.ShowDetailActivity;
import com.example.examenfinal_doncurrulo.Domain.FoodDomain;
import com.example.examenfinal_doncurrulo.R;

import java.util.ArrayList;
import java.util.List;

public class EnsaladaAdapter extends RecyclerView.Adapter<EnsaladaAdapter.ViewHolder>{

    ArrayList<FoodDomain> EnsaladaDomains;
    private List<FoodDomain> ensaladalist;

    public EnsaladaAdapter(ArrayList<FoodDomain> EnsaladaDomains) {
        this.EnsaladaDomains = EnsaladaDomains;
        this.ensaladalist = new ArrayList<>();
        ensaladalist.addAll(EnsaladaDomains);

    }

    @NonNull
    @Override
    public EnsaladaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_ensalada,parent,false);

        return new EnsaladaAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull EnsaladaAdapter.ViewHolder holder, int position) {
        holder.title.setText(EnsaladaDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(EnsaladaDomains.get(position).getFee()));

        int drawableReourceId=holder.itemView.getContext().getResources()
                .getIdentifier(EnsaladaDomains.get(position).getPic(),"drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.pic);

        holder.addBtn.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
            intent.putExtra("object", EnsaladaDomains.get(position));
            holder.itemView.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {return EnsaladaDomains.size();}

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
