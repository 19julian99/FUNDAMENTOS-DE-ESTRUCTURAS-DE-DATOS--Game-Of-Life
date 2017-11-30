
package gameoflife;

import processing.core.PApplet;//importamos la libreria PApplet

/**
 * @author Harold Pedraza
 * @version 25/10/2017
 */

public class GameOfLife extends PApplet{

    public static void main(String[] args) {
            String[] a = {"MAIN"};
        PApplet.runSketch(a, new GameOfLife());//metodo papplet para llamar la funcion main
    }
    
    int width = 50;//largo
    int height = 50;//ancho
    int square_size = 5;//cantidad de pixeles
    
    Proceso llamada = new Proceso(width, height);
    
   
    
    @Override
    public void settings(){
        size(width * square_size,height * square_size);
    }
    
    @Override
    public void draw(){
        background(100);
        stroke(50);
        for(int i = 0;i< height;i++){
            for (int j = 0; j< width;j++){
                if (llamada.automata[i][j]==1){
                    fill(0);
                    rect(j * square_size, i * square_size, square_size, square_size,7);
                }else{
                    fill(100);
                    rect(j * square_size, i * square_size, square_size, square_size,7);
                    
                }
            }
        }
        
        try{//excepcion
        Thread.sleep(150);
        llamada.ciclos();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
