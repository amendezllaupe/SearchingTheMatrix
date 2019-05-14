/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchtomatrix;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Esteban
 */
public class Busqueda {

    private ArrayList<Numero> registro;
    
    public Busqueda(){
        registro = new ArrayList<>();
        System.out.println("Ingrese el número de filas, columnas, y los números a guardar");
        int[][] matriz = generarMatriz(ingresoInt(),ingresoInt());
        System.out.println("Cantidad de números a buscar");
        int nBuscar = ingresoInt();
        mostrarMatriz(matriz);
        for (int i = 0; i < nBuscar; i++) {
            System.out.println("Ingrese el número a buscar");
            int num = ingresoInt();
            buscar(matriz,num);
        }
        mostrarRegistro();
    }
    
    public int ingresoInt(){
        Scanner sc = new Scanner(System.in);
        int num = 0;
        try {
            num = sc.nextInt();
        } catch (Exception e) {
            num = ingresoInt();
        }
        return num;
    }
    
    public int[][] generarMatriz(int nFilas, int nColumnas){
        int[][] matriz = new int[nFilas][nColumnas];
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                matriz[f][c] = ingresoInt();
            }
        }
        return matriz;
    }
    
    public boolean buscar(int [][]matriz , int numero){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j]==numero){
                    registro.add(new Numero(numero,true,i,j));
                    return true;
                }
            }
        }
        registro.add(new Numero(numero,false,-1,-1));
        return false;
    }
    
    public void mostrarMatriz(int [][]matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" [ " + matriz[i][j] +" ] ");
            }
            System.out.println("");
        }
    }
    
    public void mostrarRegistro() {
        for (int i = 0; i < this.registro.size(); i++) {
            //System.out.println("Numero" + (i + 1) + ":");
            System.out.print("numero: " + this.registro.get(i).getNumero()+", ");
            System.out.print("estado: " + this.registro.get(i).getEstado()+", ");
            System.out.print("Fila: " + this.registro.get(i).getFila()+", ");
            System.out.print("Columna: " + this.registro.get(i).getColumna()+", ");
            
            System.out.println();
        }
    }
}
