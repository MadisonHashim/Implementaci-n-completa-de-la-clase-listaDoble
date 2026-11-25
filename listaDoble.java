/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listas.Unidad2;

/**
 *
 * @author Thinkval
 */
public class listaDoble {

    private int tamanio;
    private nodoDoble cabeza;
    private nodoDoble cola;

    public listaDoble(){
        tamanio=0;
        cabeza=null;
        cola=null;
    }

    public boolean estaVacia(){
        if(cabeza==null && cola==null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @return the tamanio
     */
    public int getTamanio(){
        return tamanio;
    }

    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(int tamanio){
        this.tamanio=tamanio;
    }

    public boolean buscar(int dato){
        nodoDoble aux=cabeza;

        while(aux!=null){
            if(aux.getDato()==dato){
                return true;
            }
            aux=aux.getSiguiente();
        }

        return false;
    }

    @Override
    public String toString(){
        String res="";
        nodoDoble aux=cabeza;

        while(aux!=null){
            res=res+"["+aux.getDato()+"]->";
            aux=aux.getSiguiente();
        }

        res=res+"null";
        return res;
    }

    public nodoDoble obtenerNodo(int pos){

        //Validamos que la posicion este dentro del rango
        if(pos<=0 || pos>tamanio){
            throw new IllegalStateException("El valor que esta insertando esta fuera del rango");
        }

        nodoDoble aux=cabeza;

        for(int i=1;i<pos;i++){
            aux=aux.getSiguiente();
        }

        return aux;
    }

    public void actualizar(int pos, int valor){
        nodoDoble val=obtenerNodo(pos);
        val.setDato(valor);
    }

    public void insertarInicio(int valor){
        nodoDoble nuevo=new nodoDoble(valor);

        if(estaVacia()){
            cola=nuevo;
        }else{
            cabeza.setAnterior(nuevo);
            nuevo.setSiguiente(cabeza);
        }

        cabeza=nuevo;
        tamanio++;
    }

    public void insertarFinal(int valor){
        nodoDoble nuevo=new nodoDoble(valor);

        if(estaVacia()){
            cabeza=nuevo;
        }else{
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
        }

        tamanio++;
        cola=nuevo;
    }

    public int eliminarInicio(){

        if(estaVacia()){
            throw new IllegalStateException("No se puede eliminar porque la lista esta vacia");
        }

        int dato=cabeza.getDato();

        //Caso de que solamente exista un nodo
        if(cabeza==cola){
            cabeza=null;
            cola=null;
        }else{
            cabeza=cabeza.getSiguiente();
            cabeza.getAnterior().setSiguiente(null);
            cabeza.setAnterior(null);
        }

        tamanio--;
        return dato;
    }

    //Insertar un nodo en una posicion
    public void insertarEnPosicion(int pos, int dato){

        //Validamos la posicion
        if(pos<=0 || pos>tamanio+1){
            throw new IllegalStateException("Posicion fuera del rango");
        }

        //Insertar en la primera posicion
        if(pos==1){
            insertarInicio(dato);
            return;
        }

        //Insertar en la ultima posicion
        if(pos==tamanio+1){
            insertarFinal(dato);
            return;
        }

        //Insertar en medio de la lista
        nodoDoble aux=obtenerNodo(pos-1);
        nodoDoble nuevo=new nodoDoble(dato);

        nuevo.setSiguiente(aux.getSiguiente());
        nuevo.setAnterior(aux);

        aux.getSiguiente().setAnterior(nuevo);
        aux.setSiguiente(nuevo);

        tamanio++;
    }

    //Eliminar la primera aparicion de un valor
    public boolean eliminarPorValor(int x){

        //Caso de lista vacia
        if(estaVacia()){
            return false;
        }

        //Caso de que el valor este en la cabeza
        if(cabeza.getDato()==x){
            eliminarInicio();
            return true;
        }

        nodoDoble aux=cabeza.getSiguiente();

        while(aux!=null){

            if(aux.getDato()==x){

                //Caso de que el valor este en la cola
                if(aux==cola){
                    return eliminarUltimo();
                }

                //Eliminar un nodo de en medio
                aux.getAnterior().setSiguiente(aux.getSiguiente());
                aux.getSiguiente().setAnterior(aux.getAnterior());

                aux.setAnterior(null);
                aux.setSiguiente(null);

                tamanio--;
                return true;
            }

            aux=aux.getSiguiente();
        }

        return false;
    }

    //Eliminar un nodo en una posicion
    public int eliminarEnPosicion(int pos){

        //Validamos la posicion
        if(pos<=0 || pos>tamanio){
            throw new IllegalStateException("Posicion fuera del rango");
        }

        //Eliminar el primer nodo
        if(pos==1){
            return eliminarInicio();
        }

        //Eliminar el ultimo nodo
        if(pos==tamanio){
            int dato=cola.getDato();
            eliminarUltimo();
            return dato;
        }

        //Eliminar un nodo de en medio
        nodoDoble aux=obtenerNodo(pos);
        int dato=aux.getDato();

        aux.getAnterior().setSiguiente(aux.getSiguiente());
        aux.getSiguiente().setAnterior(aux.getAnterior());

        aux.setAnterior(null);
        aux.setSiguiente(null);

        tamanio--;
        return dato;
    }

    //Eliminar el ultimo nodo de la lista
    public boolean eliminarUltimo(){

        //Caso de lista vacia
        if(estaVacia()){
            return false;
        }

        //Caso de que solamente exista un nodo
        if(cabeza==cola){
            cabeza=null;
            cola=null;
        }else{

            //La cola pasa al nodo anterior
            nodoDoble aux=cola;
            cola=cola.getAnterior();

            cola.setSiguiente(null);
            aux.setAnterior(null);
        }

        tamanio--;
        return true;
    }

    //Insertar un dato de forma ordenada
    public void insertarOrdenado(int dato){

        //La lista esta vacia
        if(estaVacia()){
            insertarInicio(dato);
            return;
        }

        //El dato es menor o igual que la cabeza
        if(dato<=cabeza.getDato()){
            insertarInicio(dato);
            return;
        }

        //l dato es mayor o igual que la cola
        if(dato>=cola.getDato()){
            insertarFinal(dato);
            return;
        }

        nodoDoble actual=cabeza;

        //Buscamos la posicion donde se insertara el dato
        while(actual.getSiguiente()!=null &&
              actual.getSiguiente().getDato()<dato){

            actual=actual.getSiguiente();
        }

        //El dato va en medio de dos nodos
        nodoDoble nuevo=new nodoDoble(dato);

        //Conservamos los enlaces de la lista
        nuevo.setSiguiente(actual.getSiguiente());
        nuevo.setAnterior(actual);

        //Conectamos los nodos con el nuevo
        actual.getSiguiente().setAnterior(nuevo);
        actual.setSiguiente(nuevo);

        tamanio++;
    }

    //Mostrar la lista desde la cola hasta la cabeza
    public String mostrarInverso(){

        String res="";
        nodoDoble aux=cola;

        while(aux!=null){
            res=res+"["+aux.getDato()+"]->";
            aux=aux.getAnterior();
        }

        res=res+"null";
        return res;
    }
}