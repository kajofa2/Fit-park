package com.example.jlcar.login.entidades;

public class Perfil {

    private String id_per;
    private String nombre;
    private String apellido;
    private int estatura;
    private int peso;

    public int getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(int usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    private int usuarios_id;


    public Perfil(String id_per, String nombre, String apellido, int estatura, int peso, int usuarios_id) {
        this.id_per = id_per;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estatura = estatura;
        this.peso = peso;
        this.usuarios_id = usuarios_id;
    }


    public Perfil() {
    }

    public String getId_per() {
        return id_per;
    }

    public void setId_per(String id_per) {
        this.id_per = id_per;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
