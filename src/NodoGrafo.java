public class NodoGrafo {
    Object dato;
    ListaAdyancencia listaAdyacencia;
    NodoGrafo siguiente;

    public NodoGrafo(Object dato) {
        this.dato = dato;
        this.listaAdyacencia = new ListaAdyancencia();
        this.siguiente = null;
    }
}
