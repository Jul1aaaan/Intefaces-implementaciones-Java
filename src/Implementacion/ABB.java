package Implementacion;

import Intefaz.ABBTDA;

public class ABB implements ABBTDA{

    public class NodoABB{
        int valor;
        ABBTDA HijoIzq;
        ABBTDA HijoDer;
    }

    NodoABB Arbol;

    @Override
    public int valor() {
        return Arbol.valor;
    }

    @Override
    public ABBTDA HijoIzq() {
        return Arbol.HijoIzq;
    }

    @Override
    public ABBTDA HijoDer() {
        return Arbol.HijoDer;
    }

    @Override
    public void InicializarArbol() {
        Arbol=null;
    }

    @Override
    public void AgregarElemento(int x) {
        if(Arbol==null){
            Arbol = new NodoABB();
            Arbol.valor=x;
            Arbol.HijoIzq = new ABB();
            Arbol.HijoIzq.InicializarArbol();
            Arbol.HijoDer = new ABB();
            Arbol.HijoDer.InicializarArbol();

        }else if(Arbol.valor > x){
            Arbol.HijoIzq.AgregarElemento(x);
        }else if(Arbol.valor < x){
            Arbol.HijoDer.AgregarElemento(x);
        }
    }

    @Override
    public void EliminarElemento(int x) {
        if(Arbol!=null){
            if(Arbol.valor==x && Arbol.HijoIzq.ArbolVacio() && Arbol.HijoDer.ArbolVacio()){
                Arbol=null;
            }else if(Arbol.valor==x && !Arbol.HijoIzq.ArbolVacio()){
                Arbol.valor = mayor(Arbol.HijoIzq);
                Arbol.HijoIzq.EliminarElemento(Arbol.valor);
            }else if(Arbol.valor==x){
                Arbol.valor = menor(Arbol.HijoDer);
                Arbol.HijoDer.EliminarElemento(Arbol.valor);
            }else if(Arbol.valor>x){
                Arbol.HijoIzq.EliminarElemento(x);
            }else{
                Arbol.HijoDer.EliminarElemento(x);
            }
        }
    }

    private int mayor(ABBTDA a){
        if(a.HijoDer().ArbolVacio())
            return a.valor();
        else{
            return mayor(a.HijoDer());
        }
    }

    private int menor(ABBTDA a){
        if(a.HijoIzq().ArbolVacio())
            return a.valor();
        else
            return menor(a.HijoIzq());
    }

    @Override
    public boolean ArbolVacio() {
        return (Arbol==null);
    }

}
