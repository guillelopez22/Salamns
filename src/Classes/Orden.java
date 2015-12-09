/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Memo
 */
public class Orden {
    Producto producto = new Producto();
    Destino destino = new Destino();

    public Orden() {
    }
    
    public Orden(Producto producto, Destino destino){
        this.producto = producto;
        this.destino = destino;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }
    
}
