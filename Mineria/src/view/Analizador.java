package view;

import java.awt.Color;
import java.util.Hashtable;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.TipoDato;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.FastMath;

public class Analizador extends javax.swing.JFrame {
    
    private Object columna[][];
    private Object data[][];
    private String zscoreText;
    private String minmaxText;
    private double arreglo[];
    private Hashtable<Integer,Object> miHash;
    private String missing;
    private JTable tabla;
    
    public Analizador(Object columna[][],Object data[][], String missingValue, JTable tabla) { 
        this.columna = columna;
        this.data = data;
        this.tabla = tabla;
        this.missing = missingValue;
        initComponents();
        setCombo();
        setLocationRelativeTo(null);
        txtPanel.setDisabledTextColor(Color.BLACK);
        txtTipo.setDisabledTextColor(Color.BLACK);
        txtMedia.setDisabledTextColor(Color.BLACK);
        txtMediana.setDisabledTextColor(Color.BLACK);
        txtDE.setDisabledTextColor(Color.BLACK);
        
        btnDistancia.setEnabled(false);
        btnChiCuadrada.setEnabled(false);
        btnZscore.setEnabled(false);
        btnAplicar.setEnabled(false);
        btnMinMax.setEnabled(false);
        btnCorrelacion.setEnabled(false);
        
        setVisible(true);
    }
    
    private void setCombo(){
        for(int i = 0; i < columna.length; i++){
            Object dato = columna[i][0];
            cboDato.addItem(dato);
            cboAnalisis.addItem(dato);
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
        cboAnalisis = new javax.swing.JComboBox();

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
        btnDistancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistanciaActionPerformed(evt);
            }
        });

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
        btnCorrelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorrelacionActionPerformed(evt);
            }
        });

        jLabel1.setText("Sustituir Valores Faltantes ");

        btnAplicar.setText("Sustituir");
        btnAplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarActionPerformed(evt);
            }
        });

        jScrollPane1.setEnabled(false);

        txtPanel.setColumns(20);
        txtPanel.setRows(5);
        txtPanel.setEnabled(false);
        jScrollPane1.setViewportView(txtPanel);

        cboAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAnalisisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout miPanelLayout = new javax.swing.GroupLayout(miPanel);
        miPanel.setLayout(miPanelLayout);
        miPanelLayout.setHorizontalGroup(
            miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(miPanelLayout.createSequentialGroup()
                        .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, miPanelLayout.createSequentialGroup()
                                .addComponent(lblDato)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboDato, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, miPanelLayout.createSequentialGroup()
                                .addComponent(lbltipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblMediana)
                            .addComponent(lblMedia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMediana, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                            .addComponent(txtMedia))
                        .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(miPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(lblDesviacion))
                            .addGroup(miPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblModa)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboModa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDE)))
                    .addGroup(miPanelLayout.createSequentialGroup()
                        .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(miPanelLayout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDistancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(miPanelLayout.createSequentialGroup()
                                        .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnMinMax, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, miPanelLayout.createSequentialGroup()
                                        .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboFaltantes, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnChiCuadrada, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                        .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnAplicar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnCorrelacion, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, miPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnZscore, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(40, 40, 40))
        );
        miPanelLayout.setVerticalGroup(
            miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboDato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDato)
                    .addComponent(cboModa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModa)
                    .addComponent(txtMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMedia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltipo)
                    .addComponent(txtDE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDesviacion)
                    .addComponent(txtMediana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMediana))
                .addGap(18, 18, 18)
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnMinMax)
                    .addComponent(btnZscore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDistancia)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(miPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChiCuadrada)
                    .addComponent(btnCorrelacion))
                .addGap(12, 12, 12)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(miPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(miPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isNumeric(String str){
         return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
    }
    private void configNumerico(int i){
  
        cboFaltantes.addItem("Media");
        cboFaltantes.addItem("Mediana");
        cboFaltantes.addItem("Moda");
        cboFaltantes.addItem("Variable Global");
        
        btnDistancia.setEnabled(false);
        btnChiCuadrada.setEnabled(false);
        btnZscore.setEnabled(true);
        btnAplicar.setEnabled(true);
        btnMinMax.setEnabled(true);
        btnCorrelacion.setEnabled(true);
      
        arreglo = new double[data.length];
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
           minmaxText+="Dato : "+arreglo[j]+" Min-Max : "+num+"\n";
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
        txtMedia.setText("");
        txtMediana.setText("");
        txtDE.setText("");
        cboFaltantes.removeAllItems();
        cboModa.removeAllItems();
        TipoDato tipo = (TipoDato) columna[i][1];
        txtTipo.setText(tipo.toString());
        
        switch (tipo.name()) {
            case "NUMERICO":
                configNumerico(i+1);
                break;
            case "BOLEANO":
                configurarBoleano(i+1);
                break;
            case "ORDINAL":
               configurarOrdinal(i+1);
                break;
            case "NOMINAL":
                configurarNominal(i+1);
                break;
        }
    }//GEN-LAST:event_cboDatoActionPerformed
  
    private void configurarNominal(int i) {
        btnDistancia.setEnabled(true);
        btnChiCuadrada.setEnabled(true);
        btnZscore.setEnabled(false);
        btnAplicar.setEnabled(true);
        btnMinMax.setEnabled(false);
        btnCorrelacion.setEnabled(false);
        
        cboFaltantes.addItem("Mediana");
        cboFaltantes.addItem("Moda");
        cboFaltantes.addItem("Variable Global");

        miHash = new Hashtable<Integer, Object>();
        DescriptiveStatistics valores = new DescriptiveStatistics();
        double aux[] = new double[data.length];
        for (int j = 0; j < aux.length; j++) {
            String dato = String.valueOf(data[j][i]);
            if (!isNumeric(dato) && !dato.trim().isEmpty()) {
                aux[j] = dato.hashCode();
                miHash.put(dato.hashCode(), dato);
            } else {
                aux[j] = missing.hashCode();
            }
        }

        double moda[] = StatUtils.mode(aux);
        int index = 0;
        for (int j = 0; j < moda.length; j++) {
            int key = (int) moda[j];
            if (key != missing.hashCode()) {
                valores.addValue(key);
                String m = String.valueOf(miHash.get(key));
                index++;
                cboModa.addItem(m);
            }
        }

        if (index != 0) {
            int key = (int) valores.getElement(index / 2);
            String m = String.valueOf(miHash.get(key));
            txtMediana.setText(m);
        }
    }

    private void configurarBoleano(int i) {
        btnDistancia.setEnabled(true);
        btnChiCuadrada.setEnabled(false);
        btnZscore.setEnabled(false);
        btnAplicar.setEnabled(true);
        btnMinMax.setEnabled(false);
        btnCorrelacion.setEnabled(false);
        
        cboFaltantes.addItem("Mediana");
        cboFaltantes.addItem("Moda");
        cboFaltantes.addItem("Variable Global");

        miHash = new Hashtable<Integer, Object>();
        DescriptiveStatistics valores = new DescriptiveStatistics();
        double aux[] = new double[data.length];
        for (int j = 0; j < aux.length; j++) {
            String dato = String.valueOf(data[j][i]);
            if (!isNumeric(dato) && !dato.trim().isEmpty()) {
                aux[j] = dato.hashCode();
                miHash.put(dato.hashCode(), dato);
            } else {
                aux[j] = missing.hashCode();
            }
        }

        double moda[] = StatUtils.mode(aux);
        int index = 0;
        for (int j = 0; j < moda.length; j++) {
            int key = (int) moda[j];
            if (key != missing.hashCode()) {
                valores.addValue(key);
                String m = String.valueOf(miHash.get(key));
                index++;
                cboModa.addItem(m);
            }
        }
    if (index != 0) {
            int key = (int) valores.getElement(index / 2);
            String m = String.valueOf(miHash.get(key));
            txtMediana.setText(m);
        }
    }

    private void configurarOrdinal(int i) {
        btnDistancia.setEnabled(true);
        btnChiCuadrada.setEnabled(true);
        btnZscore.setEnabled(false);
        btnAplicar.setEnabled(true);
        btnMinMax.setEnabled(false);
        btnCorrelacion.setEnabled(false);
        
        cboFaltantes.addItem("Mediana");
        cboFaltantes.addItem("Moda");
        cboFaltantes.addItem("Variable Global");

        miHash = new Hashtable<Integer, Object>();
        DescriptiveStatistics valores = new DescriptiveStatistics();
        double aux[] = new double[data.length];
        for (int j = 0; j < aux.length; j++) {
            String dato = String.valueOf(data[j][i]);
            if (!isNumeric(dato) && !dato.trim().isEmpty()) {
                aux[j] = dato.hashCode();
                miHash.put(dato.hashCode(), dato);
            } else {
                aux[j] = missing.hashCode();
            }
        }

        double moda[] = StatUtils.mode(aux);
        int index = 0;
        for (int j = 0; j < moda.length; j++) {
            int key = (int) moda[j];
            if (key != missing.hashCode()) {
                valores.addValue(key);
                String m = String.valueOf(miHash.get(key));
                index++;
                cboModa.addItem(m);
            }
        }
        if (index != 0) {
            int key = (int) valores.getElement(index / 2);
            String m = String.valueOf(miHash.get(key));
            txtMediana.setText(m);
        }
    }


    private void btnZscoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZscoreActionPerformed
        txtPanel.setText(zscoreText);
    }//GEN-LAST:event_btnZscoreActionPerformed

    private void btnMinMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinMaxActionPerformed
        txtPanel.setText(minmaxText);
    }//GEN-LAST:event_btnMinMaxActionPerformed

    private void correlacionLineal(int i){
            double[] arreglo2 = new double[data.length];
            
            for (int j = 0; j < arreglo2.length; j++) {
                String dato = String.valueOf(data[j][i]);
                if (isNumeric(dato)) {
                    arreglo2[j] = Double.parseDouble(dato);
                } else {
                    arreglo2[j] = 0.0;
                }
            }
            
            PearsonsCorrelation correlacion = new PearsonsCorrelation();
            String s = "El Coeficiente de Correlación es : "+ correlacion.correlation(arreglo, arreglo2);
            txtPanel.setText(s);
    }
    private void btnCorrelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorrelacionActionPerformed
          int i = cboAnalisis.getSelectedIndex();
          TipoDato tipo = (TipoDato) columna[i][1];
 
        if (tipo.name().equals("NUMERICO")) {
            txtPanel.setText("");
            correlacionLineal(i+1);
        } else {
              JOptionPane.showMessageDialog(null,"Atributo No Númerico");
          }
    }//GEN-LAST:event_btnCorrelacionActionPerformed

    private void cboAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAnalisisActionPerformed
      
    }//GEN-LAST:event_cboAnalisisActionPerformed

    private void llenarTabla(String valor){
        int j = cboDato.getSelectedIndex();
        String s = "";
        for(int i = 0; i < tabla.getRowCount(); i++){
            s = String.valueOf(tabla.getValueAt(i, j+1));
            if(s.equals(missing)){
                  tabla.setValueAt(valor, i, j+1);
            }
        }
    }
    private void btnAplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarActionPerformed
       String dato = txtTipo.getText();
       if(!dato.trim().isEmpty()){
           if(dato.equals("NUMERICO")){
               int i = cboFaltantes.getSelectedIndex();
               String s = "";
               switch (i){
                   case 0:
                       s = txtMedia.getText();
                       llenarTabla(s);
                       break;
                   case 1:
                       s = txtMediana.getText();
                       llenarTabla(s);
                       break;
                   case 2: 
                       s = cboModa.getSelectedItem().toString();
                       llenarTabla(s);
                       break;
                   case 3:
                       s = JOptionPane.showInputDialog(null,"Ingrese Variable global");
                       if(s!=null && !s.trim().isEmpty()){
                            llenarTabla(s);
                       }
                       break;
               }
           }else{
               int i = cboFaltantes.getSelectedIndex();
               String s = "";
               switch (i){
                    case 0:
                       s = txtMediana.getText();
                       llenarTabla(s);
                       break;
                   case 1: 
                       s = cboModa.getSelectedItem().toString();
                       llenarTabla(s);
                       break;
                   case 2:
                       s = JOptionPane.showInputDialog(null,"Ingrese Variable global");
                       if(s!=null && !s.trim().isEmpty()){
                            llenarTabla(s);
                       }
                       break;
               }
           }
       }
    }//GEN-LAST:event_btnAplicarActionPerformed
    
     private int minimum(int a, int b, int c) {
        if(a<=b && a<=c){
            return a;
        } 
        if(b<=a && b<=c){
            return b;
        }
        return c;
    }

    public int computeLevenshteinDistance(String str1, String str2) {
        return computeLevenshteinDistance(str1.toCharArray(),
                                          str2.toCharArray());
    }

    private int computeLevenshteinDistance(char [] str1, char [] str2) {
        int [][]distance = new int[str1.length+1][str2.length+1];

        for(int i=0;i<=str1.length;i++){
                distance[i][0]=i;
        }
        for(int j=0;j<=str2.length;j++){
                distance[0][j]=j;
        }
        for(int i=1;i<=str1.length;i++){
            for(int j=1;j<=str2.length;j++){ 
                  distance[i][j]= minimum(distance[i-1][j]+1,
                                        distance[i][j-1]+1,
                                        distance[i-1][j-1]+
                                        ((str1[i-1]==str2[j-1])?0:1));
            }
        }
        return distance[str1.length][str2.length];
        
    }
    private void btnDistanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistanciaActionPerformed
        int i = cboDato.getSelectedIndex();
        String dominio = String.valueOf(columna[i][2]);
        
        StringTokenizer st = new StringTokenizer(dominio,"(|)");
        
        String mensaje = "Distancia Levenshtein : \n";
        String s = "";
        String dom = "";
        int dist =0;
        while (st.hasMoreElements()){
            dom = st.nextToken();
            for(int j = 0; j < data.length; j ++){
                s = String.valueOf(data[j][i+1]);
                dist = computeLevenshteinDistance(s, dom);
                mensaje+="Dato : "+s+"  Dominio : "+dom+" Distancia : "+dist+"\n";
            }
        }
        txtPanel.setText(mensaje);
    }//GEN-LAST:event_btnDistanciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAplicar;
    private javax.swing.JButton btnChiCuadrada;
    private javax.swing.JButton btnCorrelacion;
    private javax.swing.JButton btnDistancia;
    private javax.swing.JButton btnMinMax;
    private javax.swing.JButton btnZscore;
    private javax.swing.JComboBox cboAnalisis;
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
