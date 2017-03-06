package model;

public class Columna {
    private String expresion;
    private String nombre;
    private TipoDato tipo;

    public Columna(String expresion, String nombre, TipoDato tipo) {
        this.expresion = expresion;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Columna() {
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoDato getTipo() {
        return tipo;
    }

    public void setTipo(TipoDato tipo) {
        this.tipo = tipo;
    }

}
