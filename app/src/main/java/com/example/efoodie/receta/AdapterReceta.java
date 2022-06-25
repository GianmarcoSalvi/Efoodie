package com.example.efoodie.receta;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.efoodie.R;

import java.util.ArrayList;

public class AdapterReceta extends RecyclerView.Adapter<AdapterReceta.ViewHolderReceta> implements View.OnClickListener {

    ArrayList<RecetaCard> lista_recetas;
    private View.OnClickListener listener;
    private Toast toast = null;

    public AdapterReceta(ArrayList<RecetaCard> recetas) {
        this.lista_recetas = recetas;
    }

    @NonNull
    @Override
    public AdapterReceta.ViewHolderReceta onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.receta_card, null, false);

        view.setOnClickListener(listener);
        return new ViewHolderReceta(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterReceta.ViewHolderReceta holder, int position) {
        holder.chef_name.setText(lista_recetas.get(position).getChef_name());
        holder.nombre_receta.setText(lista_recetas.get(position).getNombre_receta());
        holder.receta_time.setText(lista_recetas.get(position).getTime());
        holder.receta_personas.setText(lista_recetas.get(position).getPara_cuantos());
        holder.receta_dificultad.setText(lista_recetas.get(position).getDificultad());

        holder.user_icon.setImageResource(lista_recetas.get(position).getUser_icon());
        holder.foto_receta.setImageResource(lista_recetas.get(position).getFoto_receta());
        holder.clock_icon.setImageResource(lista_recetas.get(position).getClock_icon());
        holder.flatware_icon.setImageResource(lista_recetas.get(position).getFlatware_icon());
        holder.chef_icon.setImageResource(lista_recetas.get(position).getChef_icon());

        holder.favorite_btn.setChecked(lista_recetas.get(position).getFavoriteActivated());

        // FAVORITE BTN COLOR CORRESPONDING TO ITS STATE
        if(lista_recetas.get(position).getFavoriteActivated()){
            holder.favorite_btn.setBackgroundResource(R.drawable.ic_favorites_filled);
        } else holder.favorite_btn.setBackgroundResource(R.drawable.ic_favorites_card);


        holder.ratingbar.setRating(lista_recetas.get(position).getRatingValue());


        // favorite btn behaviour
        holder.favorite_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton favorite_btn, boolean isChecked) {
                if(favorite_btn.isPressed()){
                    if (isChecked) {
                        favorite_btn.setBackgroundResource(R.drawable.ic_favorites_filled);
                        if (toast != null) toast.cancel();
                        toast = Toast.makeText(holder.favorite_btn.getContext(), "Receta guardada", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        favorite_btn.setBackgroundResource(R.drawable.ic_favorites_card);
                        if (toast != null) toast.cancel();
                        toast = Toast.makeText(holder.favorite_btn.getContext(), "Receta borrada", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return lista_recetas.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public class ViewHolderReceta extends RecyclerView.ViewHolder {

        ImageView user_icon, foto_receta, clock_icon, flatware_icon, chef_icon;
        TextView chef_name, nombre_receta, receta_time, receta_personas, receta_dificultad;
        ToggleButton favorite_btn;
        RatingBar ratingbar;

        public ViewHolderReceta(@NonNull View itemView) {
            super(itemView);
            user_icon = (ImageView) itemView.findViewById(R.id.ic_user);
            foto_receta = (ImageView) itemView.findViewById(R.id.foto_receta);
            clock_icon = (ImageView) itemView.findViewById(R.id.ic_clock);
            flatware_icon = (ImageView) itemView.findViewById(R.id.ic_flatware);
            chef_icon = (ImageView) itemView.findViewById(R.id.ic_chef);

            chef_name = (TextView) itemView.findViewById(R.id.chef_name);
            nombre_receta = (TextView) itemView.findViewById(R.id.nombre_receta);
            receta_time = (TextView) itemView.findViewById(R.id.receta_time);
            receta_personas = (TextView) itemView.findViewById(R.id.receta_personas);
            receta_dificultad = (TextView) itemView.findViewById(R.id.receta_dificultad);

            favorite_btn = (ToggleButton) itemView.findViewById(R.id.favorite_btn);
            ratingbar = (RatingBar) itemView.findViewById(R.id.rating_bar);


        }

        public void removeAt(int position) {
            lista_recetas.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, lista_recetas.size());
        }

    }
}
