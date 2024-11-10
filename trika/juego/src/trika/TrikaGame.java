package trika;

public class TrikaGame {
    private String[] tablero; 
    private String turno; 

    // Constructor
    public TrikaGame() {
        tablero = new String[9]; 
        for (int i = 0; i < 9; i++) {
            tablero[i] = ""; 
        }
        turno = "X"; 
    }

    public boolean hacerJugada(int indice) {
        if (indice >= 0 && indice < 9 && tablero[indice].equals("")) { 
            tablero[indice] = turno; 
            cambiarTurno(); 
            return true; 
        }
        return false; 
    }

    private void cambiarTurno() {
        if (turno.equals("X")) {
            turno = "O"; 
        } else {
            turno = "X"; 
        }
    }

    public String getTurno() {
        return turno;
    }

    public boolean haGanado() {
        int[][] combinacionesGanadoras = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},  
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},  
            {0, 4, 8}, {2, 4, 6}              
        };

        for (int[] combinacion : combinacionesGanadoras) {
            if (tablero[combinacion[0]].equals(tablero[combinacion[1]]) && 
                tablero[combinacion[0]].equals(tablero[combinacion[2]]) && 
                !tablero[combinacion[0]].equals("")) {
                return true; 
            }
        }
        return false; 
    }

    public boolean empate() {
        for (String casilla : tablero) {
            if (casilla.equals("")) {
                return false; 
            }
        }
        return true; 
    }
}
