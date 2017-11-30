
package gameoflife;

import java.util.Random;

public class Proceso {
    int [][] automata;    
    public Proceso(int width, int height){
       this.automata = new int [width][height];
       this.random(width, height);
    }
    
    public void random (int width, int height){
    Random rd = new Random();
    double alive = 0.15;//cantidad de celulas iniciales que aparecen con vida
            for(int i = 0; i< height;i++)
                for(int j = 0; j< width; j++)
                    this.automata[i][j]= rd.nextDouble() < alive ? 1 : 0;
            /*
            Se asigna valores de 1 o 0 depende si es mayor menor a la cantidad de celulas vivas iniciales
            si es menor se colocara uno o aparecera la celula viva
            si no, si es mayor se dejara la celula muerta
            */
    }
       
    public void ciclos(){
        int cont;
        int n1 = this.automata.length;
        int n2 = this.automata[0].length;
        for(int i =0; i< this.automata.length;i++){
            for(int j =0; j<this.automata[0].length;j++){
                cont = this.automata[(i-1+n1)%n1][(j-1+n2)%n2] +
                       this.automata[(i-1+n1)%n1][j] + 
                       this.automata[(i-1+n1)%n1][(j+1)%n2] + 
                       this.automata[i][(j-1+n2)%n2]+
                       this.automata[i][(j+1)%n2]+
                       this.automata[(i+1)%n1][(j-1+n2)%n2]+
                       this.automata[(i+1)%n1][j]+
                       this.automata[(i+1)%n1][(j+1)%n2];

            if (this.automata[i][j] == 1)
                this.automata[i][j] = (cont < 2 || cont > 3) ? 0: 1;
            
            else
                this.automata[i][j] = cont == 3 ? 1 : 0;
        }
    }
    }
}
