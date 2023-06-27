package Intefaz;

public interface ABBTDA {
    int valor();
    ABBTDA HijoIzq();
    ABBTDA HijoDer();
    void InicializarArbol();
    void AgregarElemento(int x);
    void EliminarElemento(int x);
    boolean ArbolVacio();
}
