package view;

import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import model.Columna;
import model.Tabla;

public class Grid extends javax.swing.JPanel {
    
    private DefaultTableModel modeloTabla;
    private DefaultTableModel modeloTablaDatos;
    private String columnaDatos[];
    private Tabla miTabla;
    
    public Grid(Tabla miTabla) {
        this.miTabla = miTabla;
        setColumnas();
        modeloTabla = new DefaultTableModel(null,getColumnasAtributos());
        modeloTablaDatos = new DefaultTableModel(null,getColumnasDatos());
        initComponents();
        cargar();
    }
    
    private void setColumnas(){
        LinkedList<Columna>columnas = miTabla.getAtributtes();
        Iterator<Columna> iterador = columnas.iterator();
        Columna miColumna;
        columnaDatos = new String[columnas.size()];
        int i = 0;
        while(iterador.hasNext()){
            miColumna = iterador.next();
            columnaDatos[i] = miColumna.getNombre();
            i++;
        }
        
    }
    
    private String [] getColumnasDatos(){
        return columnaDatos;
    }
    private String[]getColumnasAtributos(){
        String columna [] = new String []{"Nombre","Tipo","Expresión Regular"};
        return columna;
    }
    
    private void cargar(){
        String relation = miTabla.getRelation();
        String missing = miTabla.getMissingValue();
        txtMissing.setText(missing);
        txtRelation.setText(relation);
        setFilas();
        setComentarios();
    }
    
     private void setComentarios() {
        LinkedList<String>comentarios = miTabla.getComentarios();
        Iterator<String> iterador = comentarios.iterator();
        String cadena = "";
        while(iterador.hasNext()){
            String linea = iterador.next();
            cadena+=linea+"\n";
        }
        txtComentarios.setText(cadena);
    }
    
    private void setFilas(){
        LinkedList<Columna>columnas = miTabla.getAtributtes();
        Iterator<Columna> iterador = columnas.iterator();
        Object[] datos = new Object[3];
        Columna miColumna;

        while(iterador.hasNext()){
          
            miColumna = iterador.next();
            datos[0] = miColumna.getNombre();
            datos[1] = miColumna.getTipo();
            datos[2] = miColumna.getExpresion();
            modeloTabla.addRow(datos);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblConjunto = new javax.swing.JLabel();
        txtRelation = new javax.swing.JTextField();
        lblValue = new javax.swing.JLabel();
        txtMissing = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblColumnas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComentarios = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();

        lblConjunto.setText("Nombre del Conjunto : ");

        lblValue.setText("Missing Value : ");

        tblColumnas.setModel(modeloTabla);
        jScrollPane1.setViewportView(tblColumnas);

        txtComentarios.setColumns(20);
        txtComentarios.setRows(5);
        jScrollPane2.setViewportView(txtComentarios);

        tablaDatos.setModel(modeloTablaDatos);
        jScrollPane3.setViewportView(tablaDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 38, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblValue, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblConjunto, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMissing, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRelation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblConjunto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRelation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblValue)
                            .addComponent(txtMissing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblConjunto;
    private javax.swing.JLabel lblValue;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JTable tblColumnas;
    private javax.swing.JTextArea txtComentarios;
    private javax.swing.JTextField txtMissing;
    private javax.swing.JTextField txtRelation;
    // End of variables declaration//GEN-END:variables

}
