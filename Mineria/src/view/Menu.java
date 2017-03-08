
package view;

import controller.ControllArchivo;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Tabla;

public class Menu extends javax.swing.JFrame {
    
    private ControllArchivo miControl;
    private Grid miGrid;
    
    public Menu() {
        initComponents();
        miControl = new ControllArchivo();
        setLocationRelativeTo(null);
        setTitle("Stinky Pete");
        setResizable(false);
        contenedor.add(new Presentacion());
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
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenuBar1.setBackground(java.awt.Color.lightGray);

        jMenu1.setBackground(new java.awt.Color(134, 56, 56));
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

    private void menuCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCargarActionPerformed
        contenedor.removeAll();
        try{
            
            boolean estadoArch = miControl.cargarArchivo();
            if(estadoArch){
                String name = miControl.getNombre();
                String ruta = miControl.getRuta();
                Tabla miTabla = miControl.analizar();
                miGrid = new Grid(miTabla,ruta);
                contenedor.add("Grid de Datos",miGrid);
            }else{
                contenedor.add(new Presentacion());
            }
       }catch(Exception e){
           e.printStackTrace();
            //  JOptionPane.showMessageDialog(null,"Error al cargar archivo");
       }
    }//GEN-LAST:event_menuCargarActionPerformed

    private void menuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGuardarActionPerformed
        String name = miControl.getNombre();
        String ruta = miControl.getRuta();
      
        if (name != null && ruta != null) {
            miGrid.generarArchivo();
        }
    }//GEN-LAST:event_menuGuardarActionPerformed

    private void menuGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGuardarComoActionPerformed
        String name = miControl.getNombre();
        String ruta = miControl.getRuta();
      
        if (name != null && ruta != null) {
            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
            fc.addChoosableFileFilter(filtro);
            String nombre = "";
            try {
                fc.showSaveDialog(this);
           
                File guardar = fc.getSelectedFile();
                if (guardar != null) {
                    miGrid.setName(guardar.getName());
                    miGrid.setRutaArchivo(guardar.getAbsolutePath());
                    miGrid.generarArchivo();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Algo ocurrió");
            }
        }
    }//GEN-LAST:event_menuGuardarComoActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        String name = miControl.getNombre();
        String ruta = miControl.getRuta();

        if (name != null && ruta != null) {
            int resp = JOptionPane.showConfirmDialog(null, "Deseas Guardar los cambios?");
            if (JOptionPane.OK_OPTION == resp) {
                miGrid.generarArchivo();
                contenedor.removeAll();
                contenedor.add(new Presentacion());
            } else if (JOptionPane.NO_OPTION == resp) {
                contenedor.add(new Presentacion());
                contenedor.add(new Presentacion());
            }
        }

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
