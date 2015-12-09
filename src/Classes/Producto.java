/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author Memo
 */
public class Producto {
    String nombre;
    int precio, prep_time = 0;
    ArrayList<Ingrediente> ingredientes = new ArrayList();
    Destino destino = new Destino();

    public Producto() {
    }

    public Producto(String nombre, int precio, int prep_time, Destino destino) {
        this.nombre = nombre;
        this.precio = precio;
        this.prep_time = prep_time;
        this.destino = destino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPrep_time() {
        return prep_time;
    }

    public void setPrep_time(int prep_time) {
        this.prep_time = prep_time;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void Add_Ingrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }
    public void setIngredientes(ArrayList<Ingrediente> ingredientes){
        this.ingredientes = ingredientes;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }
    

    @Override
    public String toString() {
        return nombre;
    }


    
    
}
