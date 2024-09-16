public class Arco {
    Object destino;
    float peso;
    Arco siguiente;

    public Arco(Object destino){
        this.destino = destino;
        this.peso = 0;
        this.siguiente = null;
    }

    public Arco(Object destino, float peso){
        this.destino = destino;
        this.peso = peso;
        this.siguiente = null;
    }
}
