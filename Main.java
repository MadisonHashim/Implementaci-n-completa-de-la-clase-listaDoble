/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listas.Unidad2;
import java.util.Scanner;

/**
 *
 * @author Thinkval
 */
public class Main {
        public static void main(String[] args){
        Scanner teclado=new Scanner(System.in);
        listaDoble lista=new listaDoble();
        int opcion, dato, pos;
        do{
            System.out.println("\n===== LISTA DOBLEMENTE ENLAZADA =====");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Insertar en posicion");
            System.out.println("4. Insertar ordenado");
            System.out.println("5. Eliminar al inicio");
            System.out.println("6. Eliminar al final");
            System.out.println("7. Eliminar por valor");
            System.out.println("8. Eliminar en posicion");
            System.out.println("9. Buscar dato");
            System.out.println("10. Actualizar dato");
            System.out.println("11. Mostrar lista");
            System.out.println("12. Mostrar lista inversa");
            System.out.println("13. Mostrar tamanio");
            System.out.println("14. Verificar si esta vacia");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion=teclado.nextInt();

            try{

                switch(opcion){

                    case 1:

                        System.out.print("Ingrese el dato: ");
                        dato=teclado.nextInt();

                        lista.insertarInicio(dato);

                        System.out.println("Dato insertado correctamente");
                        System.out.println(lista);
                        break;

                    case 2:

                        System.out.print("Ingrese el dato: ");
                        dato=teclado.nextInt();

                        lista.insertarFinal(dato);

                        System.out.println("Dato insertado correctamente");
                        System.out.println(lista);
                        break;

                    case 3:

                        System.out.print("Ingrese la posicion: ");
                        pos=teclado.nextInt();

                        System.out.print("Ingrese el dato: ");
                        dato=teclado.nextInt();

                        lista.insertarEnPosicion(pos,dato);

                        System.out.println("Dato insertado correctamente");
                        System.out.println(lista);
                        break;

                    case 4:

                        System.out.print("Ingrese el dato: ");
                        dato=teclado.nextInt();

                        lista.insertarOrdenado(dato);

                        System.out.println("Dato insertado correctamente");
                        System.out.println(lista);
                        break;

                    case 5:

                        dato=lista.eliminarInicio();

                        System.out.println("Dato eliminado: "+dato);
                        System.out.println(lista);
                        break;

                    case 6:

                        if(lista.eliminarUltimo()){
                            System.out.println("Ultimo nodo eliminado");
                        }else{
                            System.out.println("La lista esta vacia");
                        }

                        System.out.println(lista);
                        break;

                    case 7:

                        System.out.print("Ingrese el dato a eliminar: ");
                        dato=teclado.nextInt();

                        if(lista.eliminarPorValor(dato)){
                            System.out.println("Dato eliminado correctamente");
                        }else{
                            System.out.println("El dato no existe");
                        }

                        System.out.println(lista);
                        break;

                    case 8:

                        System.out.print("Ingrese la posicion a eliminar: ");
                        pos=teclado.nextInt();

                        dato=lista.eliminarEnPosicion(pos);

                        System.out.println("Dato eliminado: "+dato);
                        System.out.println(lista);
                        break;

                    case 9:

                        System.out.print("Ingrese el dato a buscar: ");
                        dato=teclado.nextInt();

                        if(lista.buscar(dato)){
                            System.out.println("Dato encontrado");
                        }else{
                            System.out.println("Dato no encontrado");
                        }

                        break;

                    case 10:

                        System.out.print("Ingrese la posicion: ");
                        pos=teclado.nextInt();

                        System.out.print("Ingrese el nuevo dato: ");
                        dato=teclado.nextInt();

                        lista.actualizar(pos,dato);

                        System.out.println("Dato actualizado correctamente");
                        System.out.println(lista);
                        break;

                    case 11:

                        System.out.println("Lista desde la cabeza:");
                        System.out.println(lista);
                        break;

                    case 12:

                        System.out.println("Lista desde la cola:");
                        System.out.println(lista.mostrarInverso());
                        break;

                    case 13:

                        System.out.println("Tamanio: "+lista.getTamanio());
                        break;

                    case 14:

                        if(lista.estaVacia()){
                            System.out.println("La lista esta vacia");
                        }else{
                            System.out.println("La lista no esta vacia");
                        }

                        break;

                    case 0:

                        System.out.println("Saliendo del programa...");
                        break;

                    default:

                        System.out.println("Opcion no valida");
                        break;
                }

            }catch(IllegalStateException e){

                System.out.println(e.getMessage());
            }

        }while(opcion!=0);

        teclado.close();
    }
}