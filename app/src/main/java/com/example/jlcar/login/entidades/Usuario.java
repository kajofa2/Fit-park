package com.example.jlcar.login.entidades;

public class Usuario {

    private String usuario;
    private String password;
    private int id_us;


    public Usuario(String usuario, String password, int id_us) {
        this.usuario = usuario;
        this.password = password;
        this.id_us = id_us;
    }

    public Usuario() {
    }

    public int getId_us() {
        return id_us;
    }

    public void setId_us(int id_us) {
        this.id_us = id_us;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}



