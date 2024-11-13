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

public class BurgerAdapter extends RecyclerView.Adapter<BurgerAdapter.ViewHolder>{

    ArrayList<FoodDomain> BurgerDomains;
    private List<FoodDomain> burgerlist;

    public BurgerAdapter(ArrayList<FoodDomain> BurgerDomains) {
        this.BurgerDomains = BurgerDomains;
        this.burgerlist = new ArrayList<>();
        burgerlist.addAll(BurgerDomains);

    }


    @NonNull
    @Override
    public BurgerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_burger,parent,false);

        return new BurgerAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BurgerAdapter.ViewHolder holder, int position) {

        holder.title.setText(BurgerDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(BurgerDomains.get(position).getFee()));

        int drawableReourceId=holder.itemView.getContext().getResources()
                .getIdentifier(BurgerDomains.get(position).getPic(),"drawable",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.pic);

        holder.addBtn.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
            intent.putExtra("object", BurgerDomains.get(position));
            holder.itemView.getContext().startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {return BurgerDomains.size();}

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
