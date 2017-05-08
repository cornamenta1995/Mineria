package view;

import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import model.Columna;
import model.Tabla;
import model.TipoDato;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.FastMath;

public class Analizador extends javax.swing.JFrame {
    
    private Object columna[][];
    private Object data[][];
    private String zscoreText;
    private String minmaxText;
    
    public Analizador(Object columna[][],Object data[][]) { 
        this.columna = columna;
        this.data = data;
        initComponents();
        setCombo();
        setLocationRelativeTo(null);
        txtPanel.setDisabledTextColor(Color.BLACK);
        txtTipo.setDisabledTextColor(Color.BLACK);
        txtMedia.setDisabledTextColor(Color.BLACK);
        txtMediana.setDisabledTextColor(Color.BLACK);
        txtDE.setDisabledTextColor(Color.BLACK);
        setVisible(true);
    }
    
    private void setCombo(){
        for(int i = 0; i < columna.length; i++){
            Object dato = columna[i][0];
            cboDato.addItem(dato);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        miPanel = new javax.swing.JPanel();
        cboDato = new javax.swing.JComboBox();
        lblDato = new javax.swing.JLabel();
        lbltipo = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        lblMedia = new javax.swing.JLabel();
        txtMedia = new javax.swing.JTextField();
        lblMediana = new javax.swing.JLabel();
        txtMediana = new javax.swing.JTextField();
        lblModa = new javax.swing.JLabel();
        lblDesviacion = new javax.swing.JLabel();
        txtDE = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnDistancia = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnMinMax = new javax.swing.JButton();
        btnZscore = new javax.swing.JButton();
        btnChiCuadrada = new javax.swing.JButton();
        btnCorrelacion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cboFaltantes = new javax.swing.JComboBox();
        btnAplicar = new javax.swing.JButton();
        cboModa = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPanel = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cboDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDatoActionPerformed(evt);
            }
        });

        lblDato.setText("Dato");

        lbltipo.setText("Tipo ");

        txtTipo.setToolTipText("");
        txtTipo.setEnabled(false);

        lblMedia.setText("Media");

        txtMedia.setToolTipText("");
        txtMedia.setEnabled(false);

        lblMediana.setText("Mediana");
        lblMediana.setToolTipText("");

        txtMediana.setEnabled(false);

        lblModa.setText("Moda");

        lblDesviacion.setText("DE");

        txtDE.setEnabled(false);

        jLabel2.setText("Normalización (Sólo numéricos)");

        jLabel3.setText("Distancia Levenshtein");

        btnDistancia.setText("Aplicar Distancia Levenshtein");
        btnDistancia.setToolTipText("");

        jLabel4.setText("Análisis Bivariable");

        btnMinMax.setText("Min-Max");
        btnMinMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinMaxActionPerformed(evt);
            }
        });

        btnZscore.setText("Z-Score");
        btnZscore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZscoreActionPerformed(evt);
            }
        });

        btnChiCuadrada.setText("Chi Cuadrada");

        btnCorrelacion.setText("Correlacion Lineal");

        jLabel1.setText("Sustituir Valores Faltantes ");

        cboFaltantes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Media", "Mediana", "Moda", "Variable Global" }));

        btnAplicar.setText("Sustituir");

        jScrollPane1.setEnabled(false);

        txtPanel.setColumns(20);
        txtPanel.setRows(5);
        txtPanel.setEnabled(false);
        jScrollPane1.setViewportView(txtPanel);

        javax.swing.GroupLayout miPanelLayout = new javax.swing.GroupLayout(miPanel);
        miPanel.setLayout(miPanelLayout);
        miPanelLayout.setHorizontalGroup(
            miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(miPanelLayout.createSequentialGroup()
                        .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, miPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDistancia, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addGroup(miPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(miPanelLayout.createSequentialGroup()
                                        .addComponent(btnChiCuadrada, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                        .addComponent(btnCorrelacion, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(miPanelLayout.createSequentialGroup()
                                        .addComponent(btnMinMax, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnZscore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(miPanelLayout.createSequentialGroup()
                                        .addComponent(cboFaltantes, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAplicar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(miPanelLayout.createSequentialGroup()
                        .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, miPanelLayout.createSequentialGroup()
                                    .addComponent(lblDato)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cboDato, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, miPanelLayout.createSequentialGroup()
                                    .addComponent(lbltipo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(miPanelLayout.createSequentialGroup()
                                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMediana)
                                    .addComponent(lblMedia))
                                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(miPanelLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(txtMediana))
                                    .addGroup(miPanelLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(txtMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34)
                                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblModa)
                                    .addComponent(lblDesviacion))
                                .addGap(18, 18, 18)
                                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboModa, 0, 95, Short.MAX_VALUE)
                                    .addComponent(txtDE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        miPanelLayout.setVerticalGroup(
            miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltipo))
                .addGap(18, 18, 18)
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMedia)
                    .addComponent(txtMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModa)
                    .addComponent(cboModa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMediana)
                    .addComponent(txtMediana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDesviacion))
                .addGap(18, 18, 18)
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnMinMax)
                    .addComponent(btnZscore))
                .addGap(18, 18, 18)
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnDistancia))
                .addGap(18, 18, 18)
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnChiCuadrada)
                    .addComponent(btnCorrelacion))
                .addGap(18, 18, 18)
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboFaltantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAplicar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(miPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(miPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isNumeric(String str){
         return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
    }
    private void configNumerico(int i){
        cboModa.removeAllItems();
        btnDistancia.setEnabled(false);
        double arreglo[] = new double[data.length];
        DescriptiveStatistics valores = new DescriptiveStatistics();
        for(int j = 0; j < arreglo.length; j++){
            String dato = String.valueOf(data[j][i]); 
            if(isNumeric(dato)){
                arreglo[j] = Double.parseDouble(dato);
                valores.addValue(arreglo[j]);
            }else{
                arreglo[j] = 0.0;
                valores.addValue(0.0);
            }
        }
       
       arreglo = valores.getSortedValues();
       double moda[] = StatUtils.mode(arreglo);
       double promedio = StatUtils.mean(arreglo);
       double mediana = StatUtils.percentile(arreglo, 50);
       double desviacion = FastMath.sqrt(StatUtils.variance(arreglo));
       
       txtDE.setText(String.valueOf(desviacion));
       txtMediana.setText(String.valueOf(mediana));
       txtMedia.setText(String.valueOf(promedio));
       
       for(int j = 0; j < moda.length; j++){
           cboModa.addItem(moda[j]);
       }
      
       double max = StatUtils.max(arreglo);
       double min = StatUtils.min(arreglo);
       double num = 0.0;
       minmaxText = "";
       
       for(int j = 0; j < arreglo.length; j++){
           num = ((arreglo[j] - min)/(max-min));
           minmaxText+="Dato : "+arreglo[0]+" Min-Max : "+num+"\n";
       }
       
       
       double zscore [] = StatUtils.normalize(arreglo);
       zscoreText="";
       for(int j = 0; j < zscore.length; j++){
           zscoreText+="Dato: "+arreglo[j]+ "   Z-Score : "+zscore[j]+"\n";
       }       
    }
    private void cboDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDatoActionPerformed
        int i = cboDato.getSelectedIndex();
        txtPanel.setText("");
        TipoDato tipo = (TipoDato) columna[i][1];
        txtTipo.setText(tipo.toString());
        
        switch (tipo.name()) {
            case "NUMERICO":
                configNumerico(i+1);
                break;
            case "BOLEANO":
                  
                break;
            case "ORDINAL":
               
                break;
            case "FECHA":
                break;
            case "NOMINAL":
                break;
        }

    }//GEN-LAST:event_cboDatoActionPerformed

    private void btnZscoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZscoreActionPerformed
        txtPanel.setText(zscoreText);
    }//GEN-LAST:event_btnZscoreActionPerformed

    private void btnMinMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinMaxActionPerformed
        txtPanel.setText(minmaxText);
    }//GEN-LAST:event_btnMinMaxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicar;
    private javax.swing.JButton btnChiCuadrada;
    private javax.swing.JButton btnCorrelacion;
    private javax.swing.JButton btnDistancia;
    private javax.swing.JButton btnMinMax;
    private javax.swing.JButton btnZscore;
    private javax.swing.JComboBox cboDato;
    private javax.swing.JComboBox cboFaltantes;
    private javax.swing.JComboBox cboModa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDato;
    private javax.swing.JLabel lblDesviacion;
    private javax.swing.JLabel lblMedia;
    private javax.swing.JLabel lblMediana;
    private javax.swing.JLabel lblModa;
    private javax.swing.JLabel lbltipo;
    private javax.swing.JPanel miPanel;
    private javax.swing.JTextField txtDE;
    private javax.swing.JTextField txtMedia;
    private javax.swing.JTextField txtMediana;
    private javax.swing.JTextArea txtPanel;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
