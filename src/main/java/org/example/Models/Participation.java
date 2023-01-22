package org.example.Models;

import java.io.Serializable;

public class Participation implements Serializable {

    private int id;
    private int code_equipe;
    private int id_compt;
    private int classement;

    public Participation() { }

    public int getCode_equipe() {
        return code_equipe;
    }

    public void setCode_equipe(int code_equipe) {
        this.code_equipe = code_equipe;
    }

    public int getId_compt() {
        return id_compt;
    }

    public void setId_compt(int id_compt) {
        this.id_compt = id_compt;
    }

    public int getClassement() {
        return classement;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
