package view;

import controller.MiRender;
import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;
import model.Columna;
import model.Datos;
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
        btnEliminarColumna.setVisible(false);
        btnEliminarInstancia.setVisible(false);
        tablaDatos.getTableHeader().setReorderingAllowed(false);
        tblColumnas.getTableHeader().setReorderingAllowed(false);
        cargar();
        
        tablaDatos.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent e){
                    btnEliminarInstancia.setVisible(true);
            }
        });
        
        tblColumnas.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent e){
                    btnEliminarColumna.setVisible(true);
            }
        });
        
    }
    
    private void setColumnas(){
        LinkedList<Columna>columnas = miTabla.getAtributtes();
        Iterator<Columna> iterador = columnas.iterator();
        Columna miColumna;
        columnaDatos = new String[columnas.size()+1];
        columnaDatos[0] = "id";
        int i = 1;
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
        
        int elemento = miTabla.getData().size();
        txtInstancia.setDisabledTextColor(Color.black);
        txtInstancia.setText(String.valueOf(elemento));
        setFilas();
        setFilasDatos();
        setComentarios();
        tablaDatos.setDefaultRenderer(Object.class, new MiRender(miTabla.getAtributtes()));
    }
    
    private void setFilasDatos(){
        LinkedList<Datos> data = miTabla.getData();
        Iterator<Datos> iterador = data.iterator();
        int e = columnaDatos.length;
        Object[] datos = new Object[e];
        Datos miDato;
        
        while(iterador.hasNext()){
            
            miDato = iterador.next();
            String s[] = miDato.getDatos();
            datos[0] = miDato.getIndex();
            for(int i = 1; i < e; i++){
                if(s[i-1].isEmpty()){
                    datos[i] = miTabla.getMissingValue();
                    s[i-1] = miTabla.getMissingValue();
                }else{
                    datos[i] = s[i-1];
                }
                
            }
            miDato.setDatos(s);
            modeloTablaDatos.addRow(datos);
        }
        
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
        lblInstancias = new javax.swing.JLabel();
        txtInstancia = new javax.swing.JTextField();
        btnAgregarColumna = new javax.swing.JButton();
        btnEliminarColumna = new javax.swing.JButton();
        btnEliminarInstancia = new javax.swing.JButton();
        btnAgregarInstancia = new javax.swing.JButton();

        lblConjunto.setText("Nombre del Conjunto : ");

        lblValue.setText("Missing Value : ");

        tblColumnas.setModel(modeloTabla);
        jScrollPane1.setViewportView(tblColumnas);

        txtComentarios.setColumns(20);
        txtComentarios.setRows(5);
        jScrollPane2.setViewportView(txtComentarios);

        tablaDatos.setModel(modeloTablaDatos);
        jScrollPane3.setViewportView(tablaDatos);

        lblInstancias.setText("Instancias :");

        txtInstancia.setEnabled(false);

        btnAgregarColumna.setText("Agregar Columna");
        btnAgregarColumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarColumnaActionPerformed(evt);
            }
        });

        btnEliminarColumna.setText("Eliminar Columna");
        btnEliminarColumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarColumnaActionPerformed(evt);
            }
        });

        btnEliminarInstancia.setText("Eliminar instancia");
        btnEliminarInstancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarInstanciaActionPerformed(evt);
            }
        });

        btnAgregarInstancia.setText("Agregar Instancia");
        btnAgregarInstancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarInstanciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addComponent(lblValue)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtMissing))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblInstancias)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtInstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblConjunto)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtRelation, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregarColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminarColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregarInstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarInstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblConjunto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRelation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblValue)
                            .addComponent(txtMissing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtInstancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInstancias))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarColumna)
                            .addComponent(btnEliminarColumna)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarInstancia)
                    .addComponent(btnEliminarInstancia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarColumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarColumnaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarColumnaActionPerformed

    private void btnEliminarColumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarColumnaActionPerformed
        modeloTabla = (DefaultTableModel) tblColumnas.getModel();
        int index = tblColumnas.getSelectedRow()+1;
        modeloTabla.removeRow(tblColumnas.getSelectedRow());
        modeloTabla = null;
        
        tablaDatos.removeColumn(tablaDatos.getColumnModel().getColumn(index));
        LinkedList<Columna>columnas = miTabla.getAtributtes();
        columnas.remove(index-1);
        miTabla.setAtributtes(columnas);
        
        tablaDatos.setDefaultRenderer(Object.class, new MiRender(miTabla.getAtributtes()));
        btnEliminarColumna.setVisible(false);
    }//GEN-LAST:event_btnEliminarColumnaActionPerformed

    private void btnAgregarInstanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarInstanciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarInstanciaActionPerformed

    private void btnEliminarInstanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInstanciaActionPerformed
        modeloTablaDatos = (DefaultTableModel) tablaDatos.getModel();
        modeloTablaDatos.removeRow(tablaDatos.getSelectedRow());
        modeloTablaDatos = null;
        btnEliminarInstancia.setVisible(false);
    }//GEN-LAST:event_btnEliminarInstanciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarColumna;
    private javax.swing.JButton btnAgregarInstancia;
    private javax.swing.JButton btnEliminarColumna;
    private javax.swing.JButton btnEliminarInstancia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblConjunto;
    private javax.swing.JLabel lblInstancias;
    private javax.swing.JLabel lblValue;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JTable tblColumnas;
    private javax.swing.JTextArea txtComentarios;
    private javax.swing.JTextField txtInstancia;
    private javax.swing.JTextField txtMissing;
    private javax.swing.JTextField txtRelation;
    // End of variables declaration//GEN-END:variables

}
