public class Grafo {
    private NodoGrafo primero;
    private NodoGrafo ultimo;

    public Grafo(){
        this.primero = null;
        this.ultimo = null;
    }

    public boolean grafoVacio(){
        return this.primero == null;
    }

    public boolean existeVertice(Object dato){
        boolean existe = false;
        if(!this.grafoVacio()){
            NodoGrafo aux = this.primero;
            while(aux != null){
                if(aux.dato.equals(dato)){
                    existe = true;
                    break;
                }
                aux = aux.siguiente;
            }
        }
        return existe;
    }

    public  boolean nuevaArista(Object origen, Object destino){
        if(this.existeVertice(origen) && this.existeVertice(destino)){
            NodoGrafo aux = this.primero;
            while(!aux.dato.equals(origen)){
                aux = aux.siguiente;
            }
            aux.listaAdyacencia.nuevaAdyacencia(destino);
            return true;
        }
        return false;
    }

    public boolean nuevaArista(Object origen, Object destino, float peso){
        if(this.existeVertice(origen) && this.existeVertice(destino)){
            NodoGrafo aux = this.primero;
            while(!aux.dato.equals(origen)){
                aux = aux.siguiente;
            }
            aux.listaAdyacencia.nuevaAdyacencia(destino, peso);
            return true;
        }
        return false;
    }

    public void nuevoNodo(Object dato){
        if(!this.existeVertice(dato)){
            NodoGrafo nodo = new NodoGrafo(dato);
            if(this.grafoVacio()){
                this.primero = nodo;
                this.ultimo = nodo;
            }else{
                if(dato.toString().compareTo(this.primero.dato.toString()) <= 0){
                    nodo.siguiente = this.primero;
                    this.primero = nodo;
                }else{
                    if(dato.toString().compareTo(this.ultimo.dato.toString()) >= 0){
                        this.ultimo.siguiente = nodo;
                        this.ultimo = nodo;
                    }else{
                        NodoGrafo aux = this.primero;
                        while(dato.toString().compareTo(aux.siguiente.dato.toString()) > 0){
                            aux = aux.siguiente;
                        }
                        nodo.siguiente = aux.siguiente;
                        aux.siguiente = nodo;
                    }
                }
            }
        }
    }
    
    public String toString(){
        StringBuilder grafo = new StringBuilder();
        if(!this.grafoVacio()){
            NodoGrafo aux = this.primero;
            while(aux != null){
                grafo.append(aux.dato.toString()).append(" -> ");
                Arco auxA = aux.listaAdyacencia.primero;
                while(auxA != null){
                    grafo.append(auxA.destino.toString()).append(" ");
                    auxA = auxA.siguiente;
                }
                grafo.append("\n");
                aux = aux.siguiente;
            }
        }
        return grafo.toString();
    }
}
