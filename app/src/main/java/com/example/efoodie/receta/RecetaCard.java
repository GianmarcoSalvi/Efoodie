package com.example.efoodie.receta;

public class RecetaCard {
    private int user_icon;
    private String chef_name;


    private int foto_receta;
    private String nombre_receta;

    private int clock_icon;
    private String time;

    private int flatware_icon;
    private String para_cuantos;

    private int chef_icon;
    private String dificultad;

    private float rating_value;
    private boolean favorite_activated;

    public RecetaCard() {
    }

    public RecetaCard(int user_icon, String chef_name, boolean favorite_activated, int foto_receta, String nombre_receta, int clock_icon, String time, int flatware_icon, String para_cuantos, int chef_icon, String dificultad, float rating_value) {
        this.user_icon = user_icon;
        this.chef_name = chef_name;
        this.favorite_activated = favorite_activated;
        this.foto_receta = foto_receta;
        this.nombre_receta = nombre_receta;
        this.clock_icon = clock_icon;
        this.time = time;
        this.flatware_icon = flatware_icon;
        this.para_cuantos = para_cuantos;
        this.chef_icon = chef_icon;
        this.dificultad = dificultad;
        this.rating_value = rating_value;
    }

    public int getUser_icon() {
        return user_icon;
    }

    public void setUser_icon(int user_icon) {
        this.user_icon = user_icon;
    }

    public String getChef_name() {
        return chef_name;
    }

    public void setChef_name(String chef_name) {
        this.chef_name = chef_name;
    }

    public boolean getFavoriteActivated() {
        return favorite_activated;
    }

    public void setFavoriteActivated(boolean favorite_activated) {
        this.favorite_activated = favorite_activated;
    }

    public int getFoto_receta() {
        return foto_receta;
    }

    public void setFoto_receta(int foto_receta) {
        this.foto_receta = foto_receta;
    }

    public String getNombre_receta() {
        return nombre_receta;
    }

    public void setNombre_receta(String nombre_receta) {
        this.nombre_receta = nombre_receta;
    }

    public int getClock_icon() {
        return clock_icon;
    }

    public void setClock_icon(int clock_icon) {
        this.clock_icon = clock_icon;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getFlatware_icon() {
        return flatware_icon;
    }

    public void setFlatware_icon(int flatware_icon) {
        this.flatware_icon = flatware_icon;
    }

    public String getPara_cuantos() {
        return para_cuantos;
    }

    public void setPara_cuantos(String para_cuantos) {
        this.para_cuantos = para_cuantos;
    }

    public int getChef_icon() {
        return chef_icon;
    }

    public void setChef_icon(int chef_icon) {
        this.chef_icon = chef_icon;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public float getRatingValue() {
        return rating_value;
    }

    public void setRatingValue(float rating) {
        this.rating_value = rating;
    }
}
