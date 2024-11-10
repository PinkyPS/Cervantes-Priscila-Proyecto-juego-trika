package trika;

import java.awt.*;
import java.awt.event.*;

public class Ventana extends Frame {
    private TrikaGame juego; 

    public Ventana() {
        super("Tic-Tac-Toe"); 
        juego = new TrikaGame(); 

        setLayout(new GridLayout(3, 3)); 

        for (int i = 0; i < 9; i++) {
            Casilla casilla = new Casilla();
            final int indice = i;  

            casilla.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (juego.hacerJugada(indice)) {
                        casilla.setSimbolo(juego.getTurno()); 
                    }

                    if (juego.haGanado()) {
                        System.out.println("¡" + juego.getTurno() + " ha ganado!");
                    } else if (juego.empate()) {
                        System.out.println("¡Empate!");
                    }
                }
            });
            add(casilla); 
        }

        setSize(300, 300); 
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);  
            }
        });
    }

    public static void main(String[] args) {
        new Ventana();  
    }
}