public class ListaAdyancencia {
    Arco primero;
    Arco ultimo;

    public ListaAdyancencia(){
        this.primero = null;
        this.ultimo = null;
    }

    public boolean listaVacia(){
        return this.primero == null;
    }
    public void nuevaAdyacencia(Object destino){
        if(!this.adyancente(destino)){
            Arco nodo = new Arco(destino);
            inserta(nodo,destino);
        }
    }

    public void nuevaAdyacencia(Object destino, float peso){
        if(!this.adyancente(destino)){
            Arco nodo = new Arco(destino, peso);
            inserta(nodo,destino);
        }
    }

    public void inserta(Arco nodo, Object destino){
        if(this.listaVacia()){
            this.primero = nodo;
            this.ultimo = nodo;
        }else{
            if(destino.toString().compareTo(this.primero.destino.toString()) <= 0){
                nodo.siguiente = this.primero;
                this.primero = nodo;
            }else{
                if(destino.toString().compareTo(this.ultimo.destino.toString()) >= 0){
                    this.ultimo.siguiente = nodo;
                    this.ultimo = nodo;
                }else{
                    Arco aux = this.primero;
                    while(destino.toString().compareTo(aux.siguiente.destino.toString()) > 0){
                        aux = aux.siguiente;
                    }
                    nodo.siguiente = aux.siguiente;
                    aux.siguiente = nodo;

                }
            }
        }
    }

    public boolean adyancente(Object dato){
        Arco aux = this.primero;
        while(aux != null){
            if(aux.destino.equals(dato)){
                return true;
            }
            aux = aux.siguiente;
        }
        return false;
    }

    public String toString(){
        StringBuilder lista = new StringBuilder();
        Arco aux = this.primero;
        while(aux != null){
            lista.append(aux.destino.toString()).append(" -> ");
            aux = aux.siguiente;
        }
        return lista.toString();
    }

}
