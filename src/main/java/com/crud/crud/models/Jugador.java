/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crud.crud.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author USER
 */
@Document(collection = "jugador")
public class Jugador {
    @Id
    String id;
    String nombre;
    int pase;
    int tiro;
    int velocidad;
    String Image;

    public Jugador() {
    }

    public Jugador(String nombre,int pase, int tiro, int velocidad, String Image) {
        this.nombre = nombre;
        this.pase = pase;
        this.tiro = tiro;
        this.velocidad = velocidad;
        this.Image = Image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPase() {
        return pase;
    }

    public void setPase(int pase) {
        this.pase = pase;
    }

    public int getTiro() {
        return tiro;
    }

    public void setTiro(int tiro) {
        this.tiro = tiro;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    
    
}