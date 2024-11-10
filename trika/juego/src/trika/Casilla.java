package trika;

import javax.swing.*;
import java.awt.*;

public class Casilla extends JButton {
    private String simbolo = "";  

    public Casilla() {
        super(""); 
        setBackground(Color.WHITE); 
        setFocusPainted(false);    
        setFont(new Font("Arial", Font.BOLD, 40)); 
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo; 
        this.setText(simbolo);   
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void reset() {
        simbolo = "";  
        this.setText("");  
    }
}
