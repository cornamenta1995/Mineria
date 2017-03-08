package view;

import controller.MiRender;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Columna;
import model.Datos;
import model.Tabla;
import model.TipoDato;

public class Grid extends javax.swing.JPanel {
    
    private DefaultTableModel modeloTabla;
    private DefaultTableModel modeloTablaDatos;
    private String columnaDatos[];
    private Tabla miTabla;
    private MiRender render;
    private String rutaArchivo;
    
    public Grid(Tabla miTabla, String rutaArchivo) {
        this.miTabla = miTabla;
        this.rutaArchivo = rutaArchivo;
        setColumnas();
        modeloTabla = new DefaultTableModel(null,getColumnasAtributos());
        modeloTablaDatos = new DefaultTableModel(null,getColumnasDatos());
        initComponents();
        btnEliminarColumna.setVisible(false);
        btnEliminarInstancia.setVisible(false);
        tablaDatos.getTableHeader().setReorderingAllowed(false);
        tblColumnas.getTableHeader().setReorderingAllowed(false);
        cargar();
        txtComentarios.setLineWrap(true); 
        txtComentarios.setWrapStyleWord(true);
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
    
    private void setColumnas() {
        LinkedList<Columna> columnas = miTabla.getAtributtes();
        Iterator<Columna> iterador = columnas.iterator();
        Columna miColumna;
        columnaDatos = new String[columnas.size() + 1];
        columnaDatos[0] = "id";
        int i = 1;
        while (iterador.hasNext()) {
            miColumna = iterador.next();
            columnaDatos[i] = miColumna.getNombre();
            i++;
        }

    }

    private String[] getColumnasDatos() {
        return columnaDatos;
    }

    private String[] getColumnasAtributos() {
        String columna[] = new String[]{"Nombre", "Tipo", "Expresión Regular"};
        return columna;
    }

    private void cargar() {
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
        render = new MiRender(miTabla.getAtributtes(),txtMissing.getText());
        tablaDatos.setDefaultRenderer(Object.class, render);
    }

    private void setFilasDatos() {
        LinkedList<Datos> data = miTabla.getData();
        Iterator<Datos> iterador = data.iterator();
        int e = columnaDatos.length;
        Object[] datos = new Object[e];
        Datos miDato;

        while (iterador.hasNext()) {

            miDato = iterador.next();
            String s[] = miDato.getDatos();
            datos[0] = miDato.getIndex();
            for (int i = 1; i < e; i++) {
                if (s[i - 1].isEmpty()) {
                    datos[i] = miTabla.getMissingValue();
                    s[i - 1] = miTabla.getMissingValue();
                } else {
                    datos[i] = s[i - 1];
                }

            }
            miDato.setDatos(s);
            modeloTablaDatos.addRow(datos);
        }

    }

    private void setComentarios() {
        LinkedList<String> comentarios = miTabla.getComentarios();
        Iterator<String> iterador = comentarios.iterator();
        String cadena = "";
        while (iterador.hasNext()) {
            String linea = iterador.next();
            cadena += linea + "\n";
        }
        txtComentarios.setText(cadena);
    }

    private void setFilas() {
        LinkedList<Columna> columnas = miTabla.getAtributtes();
        Iterator<Columna> iterador = columnas.iterator();
        Object[] datos = new Object[3];
        Columna miColumna;

        while (iterador.hasNext()) {

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
        btnEliminarColumna = new javax.swing.JButton();
        btnEliminarInstancia = new javax.swing.JButton();
        btnErrores = new javax.swing.JButton();
        btnAplicar = new javax.swing.JButton();

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

        btnErrores.setText("Mostrar Errores");
        btnErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnErroresActionPerformed(evt);
            }
        });

        btnAplicar.setText("Aplicar Cambios");
        btnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(btnEliminarColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnErrores, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnEliminarInstancia, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
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
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarColumna))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarInstancia)
                    .addComponent(btnErrores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btnAplicar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarColumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarColumnaActionPerformed
        modeloTabla = (DefaultTableModel) tblColumnas.getModel();
        int index = tblColumnas.getSelectedRow() + 1;
        modeloTabla.removeRow(tblColumnas.getSelectedRow());
        modeloTabla = null;

        tablaDatos.removeColumn(tablaDatos.getColumnModel().getColumn(index));
        LinkedList<Columna> columnas = miTabla.getAtributtes();
        columnas.remove(index - 1);
        miTabla.setAtributtes(columnas);
        render = new MiRender(miTabla.getAtributtes(),txtMissing.getText());
        tablaDatos.setDefaultRenderer(Object.class, render);
        btnEliminarColumna.setVisible(false);
    }//GEN-LAST:event_btnEliminarColumnaActionPerformed

    private void btnEliminarInstanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInstanciaActionPerformed
        modeloTablaDatos = (DefaultTableModel) tablaDatos.getModel();
        modeloTablaDatos.removeRow(tablaDatos.getSelectedRow());
        modeloTablaDatos = null;
        btnEliminarInstancia.setVisible(false);
        txtInstancia.setText(String.valueOf(tablaDatos.getRowCount()));
    }//GEN-LAST:event_btnEliminarInstanciaActionPerformed

    private void btnErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnErroresActionPerformed
        String mensaje = "";
        Matcher mat;
        LinkedList<Columna> columnas = miTabla.getAtributtes();
        Pattern pat1;
        Columna columna;
        int error = 0;
        for (int i = 1; i < tablaDatos.getColumnCount(); i++) {

            columna = columnas.get(i - 1);
            String expresion = columna.getExpresion();
            TipoDato tipo = columna.getTipo();
            pat1 = Pattern.compile(expresion);

            for (int j = 0; j < tablaDatos.getRowCount(); j++) {
                String value = String.valueOf(tablaDatos.getValueAt(j, i));
                mat = pat1.matcher(value);

                if (!mat.matches()) {
                    mensaje += "Instancia " + (j + 1) + " Tipo : " + tipo.name() + " Columna " + tablaDatos.getColumnName(i) + " valor " + value + "\n";
                    error++;
                }
            }
        }
        int datos = tablaDatos.getRowCount() * (tablaDatos.getColumnCount() - 1);
        float porcentaje = (error * 100 / datos);
        mensaje += "Total de datos : " + datos + "\nErrores : " + error + "\nPorcentaje  de error : %" + porcentaje;

        JOptionPane.showMessageDialog(null, mensaje);
    }//GEN-LAST:event_btnErroresActionPerformed

    private void btnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarActionPerformed
        render = new MiRender(miTabla.getAtributtes(),txtMissing.getText());
        tablaDatos.setDefaultRenderer(Object.class, render);
    }//GEN-LAST:event_btnAplicarActionPerformed

    public void generarArchivo() {
        File miArchivo = new File(rutaArchivo);

        FileWriter fw;
        try {
            fw = new FileWriter(miArchivo);
            BufferedWriter bw = new BufferedWriter(fw);

            String comentario[] = txtComentarios.getText().split("\n");

            for (String s : comentario) {
                bw.append(s);
                bw.newLine();
            }
            bw.append("@relation " + txtRelation.getText());
            bw.newLine();

            LinkedList<Columna> atributos = miTabla.getAtributtes();
            Iterator<Columna> iterador = atributos.iterator();

            String s = "";
            while (iterador.hasNext()) {
                Columna columna = iterador.next();
                s = "@atributte " + columna.getNombre() + " " + columna.getTipo().name() + " " + columna.getExpresion();
                bw.append(s);
                bw.newLine();
            }

            bw.append("@missingValue " + miTabla.getMissingValue());
            bw.newLine();
            bw.append("@data");
            bw.newLine();

            for (int i = 0; i < tablaDatos.getRowCount(); i++) {
                String dato = "";
                for (int j = 1; j < tablaDatos.getColumnCount(); j++) {
                     dato += String.valueOf(tablaDatos.getValueAt(i, j))+",";
                }
                dato = dato.substring(0, dato.length()-1);
                bw.append(dato);
                bw.newLine();
            }
             bw.close();
             fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicar;
    private javax.swing.JButton btnEliminarColumna;
    private javax.swing.JButton btnEliminarInstancia;
    private javax.swing.JButton btnErrores;
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
