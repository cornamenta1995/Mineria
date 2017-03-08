package controller;

import java.awt.Color;
import java.awt.Component;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Columna;


public class MiRender extends DefaultTableCellRenderer {
    private LinkedList<Columna> atributtes;
    private String missingValue;
   
    public MiRender(LinkedList<Columna> atributtes,String missingValue) {
        this.atributtes = atributtes;
        this.missingValue = missingValue;
    }
    
    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {
        JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        cell.setForeground(Color.BLACK);
        cell.setBackground(Color.WHITE);
        if (column != 0) {
            String expresion = atributtes.get(column - 1).getExpresion();

            Matcher mat;
            Pattern pat1 = Pattern.compile(expresion);

            mat = pat1.matcher(String.valueOf(value));

            if (!mat.matches()) {
                cell.setForeground(Color.WHITE);
                cell.setBackground(Color.RED);
                cell.setText(missingValue);
            }
        }

        return cell;
    }
    
}
