/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;


public class Cocina implements Runnable {

    int prep_time;
    ArrayList ingredientes;
    ArrayList<Stack<Ingrediente>> bodega;
    JProgressBar barra= new JProgressBar();
    int current_time=1;

    public Cocina(Producto producto, ArrayList<Stack<Ingrediente>> bodega,JProgressBar barra) {
        this.prep_time = producto.getPrep_time();
        this.ingredientes = producto.getIngredientes();
        this.bodega = bodega;
        this.barra = barra;
    }

    @Override
    public void run() {
        while (current_time != prep_time) {
            barra.setValue(current_time);
            barra.repaint();
            current_time++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            if(current_time==prep_time){
                barra.setValue(100);
                JOptionPane.showMessageDialog(null,"Se termino de cocinar!!!");
                barra.setValue(0);
                break;
            }
        }
    }

}
