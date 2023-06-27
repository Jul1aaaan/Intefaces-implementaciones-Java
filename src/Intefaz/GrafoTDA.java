package Intefaz;

public interface GrafoTDA {
    void inicializarGrafo();					// Sin precondiciones
    void agregarVertice(int v);					// Grafo inicializado y "v" no existe
    void eliminarVertice(int v);
    ConjuntoTDA vertices();
    void agregarArista(int o, int d, int p);	// Grafo inicializado y "o", "d" existen; "p" != 0
    void eliminarArista(int o, int d);			// Grafo inicializado y "o", "d" existen; "p" != 0
    boolean existeArista(int o, int d);			// Grafo inicializado y "o", "d" existen; "p" != 0
    int pesoArista(int o, int d);				// Grafo inicializado y "o", "d" existen; "p" != 0
}

