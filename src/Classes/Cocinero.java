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

public class Cocinero implements Runnable {

    Producto producto;
    ArrayList<Stack<Ingrediente>> bodega;
    ArrayList<Stack<Ingrediente>> cocina;
    Stack<Ingrediente> stack = new Stack();
    ArrayList<Ingrediente> ingredientes;
    JProgressBar barra = new JProgressBar();
    boolean create = false;
    int cant_ingredientes = 0;

    public Cocinero(Producto producto, ArrayList<Stack<Ingrediente>> bodega, JProgressBar barra) {
        this.producto = producto;
        this.bodega = bodega;
        this.barra = barra;
        ingredientes = producto.getIngredientes();
        for (int i = 0; i < ingredientes.size(); i++) {
            for (int j = 0; j < bodega.size(); j++) {
                if (ingredientes.get(i).getNombre().equals(bodega.get(j).peek())) {
                    if (bodega.get(j).isEmpty()) {
                        break;
                    }else{
                        while(!bodega.get(j).isEmpty()){
                            stack.add(bodega.get(j).pop());
                        }
                    }                   
                }
            }
            cocina.add(stack);
            stack = new Stack();
        }
        
    }

    public void run() {
        try {
            while (true) {
                synchronized (stack) {
                    stack = new Stack();
                    for (int i = 0; i < ingredientes.size(); i++) {
                        for (int j = 0; j < cocina.size(); j++) {
                            if (ingredientes.get(i).getNombre().equals(cocina.get(j).peek().getNombre())) {
                                stack.add(cocina.get(j).pop());
                            }
                        }
                    }
                    

                    if (stack.isEmpty()) {
                        stack.notify();
                        stack.wait();
                    }

                }
            }
        } catch (InterruptedException ex) {
        }
    }
}
