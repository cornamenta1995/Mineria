package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Columna;
import model.Datos;
import model.Tabla;
import model.TipoDato;

public class ControllArchivo {

    private LinkedList<String> sentencias;

    public ControllArchivo() {
    }

    public Tabla analizar() {
        /*Estructuras para el modelo*/
        LinkedList<String> comentarios = new LinkedList<String>();
        LinkedList<Columna> columna = new LinkedList<Columna>();
        LinkedList<Datos> data = new LinkedList<Datos>();
       
        int i = 0;
        
        Iterator<String> iterador = sentencias.iterator();
        
        Tabla miTabla = new Tabla();
        Columna miColumna;

        Matcher mat;
        /*Se encarga de leer comentarios*/
        Pattern pat1 = Pattern.compile("^%.*");

        while (iterador.hasNext()) {
            String linea = iterador.next();
            mat = pat1.matcher(linea);

            if (mat.find()) {
                comentarios.add(linea);
            }
        }

        iterador = sentencias.iterator();
        Pattern pat2 = Pattern.compile("^@[a-z]");
        /*Localizar los @ en las cadenas*/
        
        while (iterador.hasNext()) {
            String linea = iterador.next();
            mat = pat2.matcher(linea);

            if (mat.find()) {
                
                Pattern pat3 = Pattern.compile("%");
                Matcher aux1 = pat3.matcher(linea);
                
                /*Si existe un comentario en la línea lo va a borrar*/
                if (aux1.find()) {
                    linea = limpiar(linea);
                }
                /*Cuenta el número de segmentaciones*/
                StringTokenizer token = new StringTokenizer(linea);
                int index = token.countTokens();

                Character opc = linea.charAt(1);
                if (opc == 'r' && index > 1) {

                    String datos[] = linea.split(" ", 2);
                    miTabla.setRelation(datos[1]);

                } else if (opc == 'a' && index > 3) {

                    String datos[] = linea.split(" ", 4);

                    TipoDato dato = obtenerDato(datos[2]);

                    miColumna = new Columna();
                    miColumna.setNombre(datos[1]);
                    miColumna.setExpresion(datos[3]);
                    miColumna.setTipo(dato);
                    columna.add(miColumna);
                    
                } else if (opc == 'm' && index > 1) {

                    String datos[] = linea.split(" ", 2);
                    miTabla.setMissingValue(datos[1]);

                } else if (opc == 'm' && index == 1) {
                    miTabla.setMissingValue("NULL");
                }
            }
        }

        Pattern pat4 = Pattern.compile("^[a-zA-Z0-9]");
        iterador = sentencias.iterator();
        String aux[];
        int columnas = columna.size();
        
        while (iterador.hasNext()) {
            
            String line = iterador.next();
            mat = pat4.matcher(line);
            /*Busca los datos de el conjunto*/
            
            if (mat.find()) {
                Datos miDato = new Datos();
               
                String datos[] = line.split(",");
                
                if(datos.length < columnas){
                    
                    aux = new String[columnas];
                    
                    for(int a = 0; a < datos.length; a++){
                            aux[a] = datos[a];
                    }
                    
                    for(int a = 0; a < columnas; a++){
                        if(aux[a] == null ){
                            aux[a] = miTabla.getMissingValue();
                        }
                    }         
                    datos = aux;
                }
                
                miDato.setIndex(i);
                miDato.setDatos(datos);

                data.add(miDato);
                i++;
            }
        }

        miTabla.setData(data);
        miTabla.setAtributtes(columna);
        miTabla.setComentarios(comentarios);

        return miTabla;
    }
    
    public boolean cargarArchivo() {

        try {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(null);

            File archivo = file.getSelectedFile();
            FileReader fr = new FileReader(archivo);
            
            BufferedReader br = new BufferedReader(fr);
            sentencias = new LinkedList<String>();
            String linea = br.readLine();

            while (linea != null) {
                linea = linea.trim();
                sentencias.add(linea);
                linea = br.readLine();
            }

            br.close();
            fr.close();

            if (!sentencias.isEmpty()) {
                return true;
            } 
            

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se encontró archivo");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al procesar archivo");
        }
        return false;
    }

    private String limpiar(String vieja) {
        String nueva = "";
        int posicion = vieja.indexOf("%");
        nueva = vieja.substring(0, posicion);

        return nueva;
    }

    private TipoDato obtenerDato(String dato) {

        dato = dato.toUpperCase();
        switch (dato) {
            case "NUMERICO":
                return TipoDato.NUMERICO;
            case "BOLEANO":
                return TipoDato.BOLEANO;
            case "ORDINAL":
                return TipoDato.ORDINAL;
            case "FECHA":
                return TipoDato.FECHA;
            case "NOMINAL":
                return TipoDato.NOMINAL;
        }
        return TipoDato.NODEFINIDO;
    }
}
