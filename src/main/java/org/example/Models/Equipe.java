package org.example.Models;

import java.io.Serializable;

public class Equipe implements Serializable {
    private int code;
    private String nom;
    private String pays;

    public Equipe() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
