package Implementacion;

import Intefaz.ColaTDA;

public class ColaLD implements ColaTDA {

    class Nodo {
        int info;
        Nodo sig;
    }

    //Primer elemento en la cola
    Nodo primero;

    //Ultimo elemento en la cola, es decir, el ultimo agregado
    Nodo ultimo;

    @Override
    public void InicializarCola() {
        primero = null;
        ultimo = null;

    }

    @Override
    public void Acolar(int x) {
        Nodo aux = new Nodo();
        aux.info = x;
        aux.sig = null;
        //si la cola no esta vacia
        if (ultimo != null) {
            ultimo.sig = aux;
        }
        ultimo = aux;

        //Si la cola estaba vacia
        if (primero == null) {
            primero = ultimo;
        }

    }

    @Override
    public void Desacolar() {
        primero = primero.sig;

        //Si la cola queda vacia
        if (primero == null) {
            ultimo = null;
        }
    }

    @Override
    public boolean ColaVacia() {
        return (ultimo == null);
    }

    @Override
    public int Primero() {
        return primero.info;
    }

}