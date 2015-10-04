package com.example.roger.iamfree;

/**
 * Created by Roger on 10/4/2015.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Persona {


    private String freelancerId;
    private String nombre;
    private String correo;
    private String disponibilidad;
    private String rating;
    private String facebook;
    private String twitter;
    private String instagram;
    private String password;
    private String celular;
    private String competencias;
    private String profesionId;
    private String ciudadId;
    private List<Proyecto> proyectos = new ArrayList<Proyecto>();
    private Profesion profesion;
    private List<Idioma> idiomas = new ArrayList<Idioma>();
    private Ubicacion ubicacion;


    public String getFreelancerId() {
        return freelancerId;
    }


    public void setFreelancerId(String freelancerId) {
        this.freelancerId = freelancerId;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getDisponibilidad() {
        return disponibilidad;
    }


    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCompetencias() {
        return competencias;
    }

    public void setCompetencias(String competencias) {
        this.competencias = competencias;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

}