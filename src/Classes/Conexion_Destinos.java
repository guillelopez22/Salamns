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
public class Conexion_Destinos {
    int distancia;
    Destino d1 = new Destino();
    Destino d2 = new Destino();

    public Conexion_Destinos(int distancia, Destino d1, Destino d2) {
        this.distancia = distancia;
        this.d1 = d1;
        this.d2 = d2;
    }

    public Conexion_Destinos() {
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Destino getD1() {
        return d1;
    }

    public void setD1(Destino d1) {
        this.d1 = d1;
    }

    public Destino getD2() {
        return d2;
    }

    public void setD2(Destino d2) {
        this.d2 = d2;
    }

    @Override
    public String toString() {
        return "" + distancia;
    }
    
    
   
}
