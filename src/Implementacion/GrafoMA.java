package Implementacion;

import Intefaz.ConjuntoTDA;
import Intefaz.GrafoTDA;

public class GrafoMA implements GrafoTDA {

    int[][] mAdy;
    int[] etiqs;
    int cant;
    int tam = 20;

    @Override
    public void inicializarGrafo() {
        mAdy = new int[tam][tam];
        etiqs = new int[tam];
        cant = 0;
    }

    @Override
    public void agregarVertice(int v) {
        for(int i = 0; i <= cant; i++) {
            mAdy[i][cant] = 0;
            mAdy[cant][i] = 0;
        }
        etiqs[cant] = v;
        cant++;
    }

    @Override
    public void eliminarVertice(int v) {
        int inx = nodo2Indice(v);
        for(int j = 0; j < cant; j++)
            mAdy[inx][j] = mAdy[cant - 1][j];
        for(int i = 0; i < cant; i++)
            mAdy[i][inx] = mAdy[i][cant - 1];
        etiqs[inx] = etiqs[cant - 1];
        cant--;
    }

    @Override
    public ConjuntoTDA vertices() {
        ConjuntoTDA c = new ConjuntoTA();
        c.InicializarConjunto();
        for(int i = 0; i < cant; i++)
            c.Agregar(etiqs[i]);
        return c;
    }

    @Override
    public void agregarArista(int o, int d, int p) {
        int i = nodo2Indice(o);
        int j = nodo2Indice(d);
        mAdy[i][j] = p;
    }

    @Override
    public void eliminarArista(int o, int d) {
        int i = nodo2Indice(o);
        int j = nodo2Indice(d);
        mAdy[i][j] = 0;
    }

    @Override
    public boolean existeArista(int o, int d) {
        int i = nodo2Indice(o);
        int j = nodo2Indice(d);
        return (mAdy[i][j] != 0);
    }

    @Override
    public int pesoArista(int o, int d) {
        int i = nodo2Indice(o);
        int j = nodo2Indice(d);
        return mAdy[i][j];
    }

    private int nodo2Indice(int v) {
        int i = cant - 1;
        while(i >= 0 && etiqs[i] != v)
            i--;
        return i;
    }
}

