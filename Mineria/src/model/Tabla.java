package model;

import model.Columna;
import java.util.LinkedList;

public class Tabla {
    
    private String relation;
    private LinkedList<String> comentarios;
    private String missingValue;
    private LinkedList<Columna> atributtes;
    private LinkedList<Datos> data;
    private int numeroError;
    
    public Tabla(String relation, String missingValue, LinkedList<Columna> atributtes) {
        this.relation = relation;
        this.missingValue = missingValue;
        this.atributtes = atributtes;
    }

    public Tabla() {
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getMissingValue() {
        return missingValue;
    }

    public void setMissingValue(String missingValue) {
        this.missingValue = missingValue;
    }

    public LinkedList<Columna> getAtributtes() {
        return atributtes;
    }

    public void setAtributtes(LinkedList<Columna> atributtes) {
        this.atributtes = atributtes;
    }

    public LinkedList<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(LinkedList<String> comentarios) {
        this.comentarios = comentarios;
    }

    public LinkedList<Datos> getData() {
        return data;
    }

    public void setData(LinkedList<Datos> data) {
        this.data = data;
    }

    public int getNumeroError() {
        return numeroError;
    }

    public void setNumeroError(int numeroError) {
        this.numeroError = numeroError;
    }
    
}
