
package view;

import controller.ControllArchivo;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Tabla;

public class Menu extends javax.swing.JFrame {


    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Stinky Pete");
        setResizable(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        contenedor = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuCargar = new javax.swing.JMenuItem();
        menuGuardar = new javax.swing.JMenuItem();
        menuGuardarComo = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(42, 118, 123));

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setForeground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuBar1.setBackground(java.awt.Color.lightGray);

        jMenu1.setBackground(new java.awt.Color(134, 56, 56));
        jMenu1.setForeground(java.awt.Color.orange);
        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Cabin", 1, 18)); // NOI18N

        menuCargar.setText("Cargar");
        menuCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCargarActionPerformed(evt);
            }
        });
        jMenu1.add(menuCargar);

        menuGuardar.setText("Guardar");
        menuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(menuGuardar);

        menuGuardarComo.setText("Guardar como");
        menuGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGuardarComoActionPerformed(evt);
            }
        });
        jMenu1.add(menuGuardarComo);

        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(menuSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGuardarActionPerformed
        
    }//GEN-LAST:event_menuGuardarActionPerformed

    private void menuGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGuardarComoActionPerformed
       
    }//GEN-LAST:event_menuGuardarComoActionPerformed

    private void menuCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCargarActionPerformed
        contenedor.removeAll();
        try{
            ControllArchivo miControl = new ControllArchivo();
            boolean estadoArch = miControl.cargarArchivo();
            if(estadoArch){
                Tabla miTabla = miControl.analizar();
                Grid miGrid = new Grid(miTabla);
                contenedor.add("Grid de Datos",miGrid);
            }
       }catch(Exception e){
           e.printStackTrace();
            //  JOptionPane.showMessageDialog(null,"Error al cargar archivo");
       }
    }//GEN-LAST:event_menuCargarActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
       
    }//GEN-LAST:event_menuSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTabbedPane contenedor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuCargar;
    private javax.swing.JMenuItem menuGuardar;
    private javax.swing.JMenuItem menuGuardarComo;
    private javax.swing.JMenuItem menuSalir;
    // End of variables declaration//GEN-END:variables
}
