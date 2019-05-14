/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchtomatrix;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author hypoc
 */
public class BusquedaNumero {
    public BusquedaNumero(){
        System.out.println("Ingrese el número de filas, columnas, y los números a guardar");
        int[][] matriz = generarMatriz(ingresoInt(),ingresoInt());
        System.out.println("Cantidad de números a buscar");
        int nBuscar = validacion();
        int[][] pos = busqueda(matriz,nBuscar);
        for (int i = 0; i < pos.length; i++) {
            System.out.println("Número: " + pos[i][0] + ", fila: " + pos[i][1] + ", columna: " + pos[i][2]);
        }
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
                int tempNum = ingresoInt();
            }
        }
        return matriz;
    }
    
    public int buscarFila(int[][] matriz, int num){
        int fila = 0;
        for (int f = 0; f < matriz.length; f++) {
            if (num>=matriz[f][0]&&num<=matriz[f][matriz.length-1]) {
                fila = f;
                break;
            }
        }
        return fila;
    }
    
    public int busquedaBinaria(int[] fila, int num, int low, int high){
        int mid = (low+high)/2;
        if (high<low) {
            return -1;
        }
        if (num==fila[mid]) {
            return mid;
        } else if (num<fila[mid]) {
            return busquedaBinaria(fila, num, low, mid-1);
        } else {
            return busquedaBinaria(fila,num,mid+1,high);
        }
    }
    
    public int[][] busqueda(int[][] matriz, int nBuscar){
        int[][] pos = new int[nBuscar][3];
        for (int i = 0; i < nBuscar; i++) {
            System.out.println("Ingrese el número a buscar");
            int num = ingresoInt();
            int fila = buscarFila(matriz,num);
            int columna = busquedaBinaria(matriz[fila],num,matriz[fila][0],matriz[fila][matriz.length-1]);
            pos[i][0] = num;
            pos[i][1] = fila;
            pos[i][2] = columna;
        }
        return pos;
    }
    public int validacion() {
        int dato = 0;
        boolean error;
        do {
            try {
                error = false;
                Scanner teclado = new Scanner(System.in);
                dato = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Numero ingresado no es valido, intente nuevamente ");
                error = true;
}
        } while (error);
        return dato;
    }
}
