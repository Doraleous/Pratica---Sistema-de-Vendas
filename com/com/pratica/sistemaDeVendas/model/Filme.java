/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemadevendas.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author emart
 */
public class Filme implements Serializable {
    private String titulo;
    private double notaMedia;
    private ArrayList<Double> notas;
    
    public Filme (String titulo){
        this.titulo = titulo;
    }

    public String toString(){
        this.calculaNotaMedia();
        return "titulo: " + this.titulo + "nota media: " + this.notaMedia;
    }

    private void calculaNotaMedia() {
        double somaNota = 0;
        if(notas.size()<=0){
            this.notaMedia = 0;
            return;
        }
        for (double nota : this.notas) {
            somaNota += nota;
        }
        this.notaMedia = somaNota/this.notas.size();
    }

    /**
     * @return String return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return double return the notaMedia
     */
    public double getNotaMedia() {
        return notaMedia;
    }

    /**
     * @param notaMedia the notaMedia to set
     */
    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    /**
     * @return ArrayList<Double> return the notas
     */
    public ArrayList<Double> getNotas() {
        return notas;
    }

    /**
     * @param notas the notas to set
     */
    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }

}
