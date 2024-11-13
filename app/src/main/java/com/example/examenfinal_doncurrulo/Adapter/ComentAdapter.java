package com.example.examenfinal_doncurrulo.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.examenfinal_doncurrulo.Activity.ShowDetailActivity;
import com.example.examenfinal_doncurrulo.Domain.ComentDomain;
import com.example.examenfinal_doncurrulo.Domain.FoodDomain;
import com.example.examenfinal_doncurrulo.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ComentAdapter extends RecyclerView.Adapter<ComentAdapter.ViewHolder>{

    ArrayList<ComentDomain> comentDomains;

    public ComentAdapter(ArrayList<ComentDomain>comentDomains){
        this.comentDomains = comentDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_comentary,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(comentDomains.get(position).getName());
        holder.coments.setText(comentDomains.get(position).getComents());
        holder.score.setText(comentDomains.get(position).getScore());
        holder.rating.setRating(comentDomains.get(position).getRating());

        // Cargar la imagen con Picasso
        Picasso.get()
                .load(comentDomains.get(position).getImg())
                .placeholder(R.drawable.view_bg)
                .into(holder.img);

    }

    @Override
    public int getItemCount() {return comentDomains.size();}

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,coments,score;
        ImageView img;
        RatingBar rating;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            name=itemView.findViewById(R.id.nameuser);
            coments=itemView.findViewById(R.id.comentuser);
            score=itemView.findViewById(R.id.puntajeuser);
            img=itemView.findViewById(R.id.user);
            rating=itemView.findViewById(R.id.calificacionuser);
        }
    }
}
