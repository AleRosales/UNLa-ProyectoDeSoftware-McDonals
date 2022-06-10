package unla.ProyectoSoftware.modelo;


import com.google.gson.annotations.Expose;
import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;

public class Locales implements Serializable {

    public Locales(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    private String nombre;

    private String direccion;

    @DatabaseField
    private double latitud;

    @DatabaseField
    private double longitud;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
