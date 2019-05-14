/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchtomatrix;

/**
 *
 * @author Esteban
 */
public class Numero {
    private int numero;
    private boolean estado;
    private int fila;
    private int columna;
    
    public Numero(int numero, boolean estado, int fila, int columna){
        this.numero=numero;
        this.estado = estado;
        this.fila= fila;
        this.columna=columna;
    }
    
    public void setNumero(int numero){
        this.numero= numero;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public void setEstado(boolean estado){
        this.estado=estado;
    }
    
    public boolean getEstado(){
        return this.estado;
    }
    
    public void setFila(int fila){
        this.fila = fila;
    }
    
    public int getFila(){
        return this.fila;
    }
    
    public void setColumna(int columna){
        this.columna=columna;
    }
    
    public int getColumna(){
        return this.columna;
    }
}
