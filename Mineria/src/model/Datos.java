package model;

import java.util.LinkedList;

public class Datos<T> {
  
    private int index;
    private String datos [];

    public Datos() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String[] getDatos() {
        return datos;
    }

    public void setDatos(String[] datos) {
        this.datos = datos;
    }
}
