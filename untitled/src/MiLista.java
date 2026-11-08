import java.util.Iterator;

public class MiLista implements ListInterface{
    ListNode cabeza;


    @Override
    public boolean isEmpty() {
        return cabeza == null;
    }

    @Override
    public int getSize() {
        int contador = 0;
        ListNode iterador = cabeza;

        while (iterador != null) {
            contador++;
            iterador = iterador.siguiente;
        }
        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;

    }
    @Override
    public Object getHead() {
        if (isEmpty()) {
            return null;
        }
        return cabeza.dato;
    }
    @Override
    public Object getTail() {
        if (isEmpty()) {
            return null;
        }
        ListNode iterador = cabeza;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
        }
        return iterador.dato;
    }

    @Override
    public Object get(ListNode node) {
        if (node == null) {
            return null;
        }
        return node.dato;
    }

    @Override
    public Object search(Object object) {
        ListNode iterador = cabeza;
        while (iterador != null) {
            if (object == null) {
                if (iterador.dato == null) {
                    return iterador.dato;
                }
            } else if (object.equals(iterador.dato)) {
                return iterador.dato;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {

        return insertTail(object);
    }

    @Override
    public boolean insert(ListNode node, Object object) {

        if (node == null) {
            return false;
        }

        ListNode iterador = cabeza;

        // Verify that the node belongs to this list

        while (iterador != null && iterador != node) {
            iterador = iterador.siguiente;
        }

        if (iterador == null) {
            return false;
        }

        ListNode nuevoNodo = new ListNode(object);
        nuevoNodo.siguiente = iterador.siguiente;
        iterador.siguiente = nuevoNodo;

        return true;
    }

    @Override
    public boolean insert(Object ob, Object object) {

            ListNode iterador = cabeza;

            while (iterador != null) {
                boolean encontrado =
                        (ob == null && iterador.dato == null)
                                || (ob != null && ob.equals(iterador.dato));

                if (encontrado) {
                    return insert(iterador, object);
                }

                iterador = iterador.siguiente;
            }

            return false;
    }

    @Override
    public boolean insertHead(Object object) {
        try {
            // 1er paso: Crear el nuevo nodo con la información recibida
            ListNode nuevaCabeza = new ListNode(object);
            //2do paso: Conectar el nodo a la cabeza
            nuevaCabeza.siguiente = this.cabeza;
            //3er paso: redefinir la cabeza
            this.cabeza = nuevaCabeza;
            return true;
        } catch (Exception e){
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insertTail(Object object) {
        if(this.cabeza == null){
            ListNode nuevaCabeza = new ListNode(object);
            this.cabeza = nuevaCabeza;
        }else {
            ListNode nuevaCola = new ListNode(object);
            ListNode iterador = this.cabeza;
            while (iterador.siguiente != null) {
                iterador = iterador.siguiente;

            }
            iterador.siguiente = nuevaCola;
        }
        return true;

    }

    @Override
    public boolean set(ListNode node, Object object) {

        if (node == null) {
            return false;
        }
        ListNode iterador = cabeza;

        while (iterador != null) {
            if (iterador == node) {
                iterador.dato = object;
                return true;
            }

            iterador = iterador.siguiente;
        }

        return false;
    }

    @Override
    public boolean remove(ListNode node) {
        if (node == null || cabeza == null) {
            return false;
        }

        // Remove the head
        if (cabeza == node) {
            cabeza = cabeza.siguiente;
            return true;
        }

        ListNode iterador = cabeza;

        // Find the node immediately before the target
        while (iterador.siguiente != null
                && iterador.siguiente != node) {
            iterador = iterador.siguiente;
        }

        // The target node does not belong to this list
        if (iterador.siguiente == null) {
            return false;
        }

        iterador.siguiente = node.siguiente;
        node.siguiente = null;

        return true;
    }

    @Override
    public boolean contains(Object object) {
        ListNode iterador = cabeza;

        while (iterador != null) {
            if (object == null) {
                if (iterador.dato == null) {
                    return true;
                }
            } else if (object.equals(iterador.dato)) {
                return true;
            }

            iterador = iterador.siguiente;
        }

        return false;
    }

    @Override
    public Iterator<ListNode> iterator() {
        return new Iterator<ListNode>() {
            private ListNode actual = cabeza;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public ListNode next() {
                ListNode nodoActual = actual;
                actual = actual.siguiente;
                return nodoActual;
            }
        };
    }

    @Override
    public Object[] toArray() {

        Object[] arreglo = new Object[getSize()];
        ListNode iterador = cabeza;
        int indice = 0;

        while (iterador != null) {
            arreglo[indice] = iterador.dato;
            indice++;
            iterador = iterador.siguiente;
        }

        return arreglo;

    }

    @Override
    public Object[] toArray(Object[] object) {

        int size = getSize();

        Object[] resultado =
                object.length >= size ? object : new Object[size];

        ListNode iterador = cabeza;
        int indice = 0;

        while (iterador != null) {
            resultado[indice] = iterador.dato;
            indice++;
            iterador = iterador.siguiente;
        }

        if (resultado.length > size) {
            resultado[size] = null;
        }

        return resultado;
    }

    @Override
    public Object getBeforeTo() {

        if (cabeza == null || cabeza.siguiente == null) {
            return null;
        }

        ListNode iterador = cabeza;

        while (iterador.siguiente.siguiente != null) {
            iterador = iterador.siguiente;
        }

        return iterador.dato;
    }

    @Override
    public Object getBeforeTo(ListNode node) {
        if (node == null || cabeza == null || cabeza == node) {
            return null;
        }

        ListNode iterador = cabeza;

        while (iterador.siguiente != null) {
            if (iterador.siguiente == node) {
                return iterador.dato;
            }

            iterador = iterador.siguiente;
        }

        return null;
    }

    @Override
    public Object getNextTo() {
        if (cabeza == null || cabeza.siguiente == null) {
            return null;
        }

        return cabeza.siguiente.dato;
    }

    @Override
    public Object getNextTo(ListNode node) {
        if (node == null || cabeza == null) {
            return null;
        }

        ListNode iterador = cabeza;

        while (iterador != null) {
            if (iterador == node) {
                if (iterador.siguiente == null) {
                    return null;
                }

                return iterador.siguiente.dato;
            }

            iterador = iterador.siguiente;
        }

        return null;
    }

    @Override
    public MiLista subList(ListNode from, ListNode to) {

        if (from == null || to == null) {
            return null;
        }

        // Find the starting node in the original list
        ListNode iterador = cabeza;

        while (iterador != null && iterador != from) {
            iterador = iterador.siguiente;
        }

        // The starting node does not belong to the list
        if (iterador == null) {
            return null;
        }

        MiLista nuevaLista = new MiLista();

        // Copy from "from" to "to", including both nodes
        while (iterador != null) {
            nuevaLista.insertTail(iterador.dato);

            if (iterador == to) {
                return nuevaLista;
            }

            iterador = iterador.siguiente;
        }

        // "to" was not found after "from"
        return null;
    }

    @Override
    public MiLista sortList() {
        MiLista listaOrdenada = new MiLista();
        ListNode iterador = cabeza;

        while (iterador != null) {
            listaOrdenada.insertTail(iterador.dato);
            iterador = iterador.siguiente;
        }

        if (listaOrdenada.cabeza == null) {
            return listaOrdenada;
        }

        boolean huboCambio;

        do {
            huboCambio = false;
            ListNode actual = listaOrdenada.cabeza;

            while (actual.siguiente != null) {
                if (comparar(actual.dato, actual.siguiente.dato) > 0) {
                    Object temporal = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temporal;

                    huboCambio = true;
                }

                actual = actual.siguiente;
            }
        } while (huboCambio);

        return listaOrdenada;
    } // End of sortList()

    private int comparar(Object primero, Object segundo) {
        if (primero == null && segundo == null) {
            return 0;
        }

        if (primero == null) {
            return 1;
        }

        if (segundo == null) {
            return -1;
        }

        if (primero instanceof Number && segundo instanceof Number) {
            double numero1 = ((Number) primero).doubleValue();
            double numero2 = ((Number) segundo).doubleValue();

            return Double.compare(numero1, numero2);
        }
        if (primero instanceof Comparable<?>
                && primero.getClass().isInstance(segundo)) {
            @SuppressWarnings("unchecked")
            Comparable<Object> comparable = (Comparable<Object>) primero;

            return comparable.compareTo(segundo);
        }

        return primero.toString().compareToIgnoreCase(
                segundo.toString()
        );
    }
    @Override
    public void shuffle() {
        int cantidad = 0;
        ListNode actual = cabeza;

        // Count the nodes
        while (actual != null) {
            cantidad++;
            actual = actual.siguiente;
        }

        // Shuffle the data stored in the nodes
        for (int i = cantidad - 1; i > 0; i--) {
            int posicionAleatoria = (int) (Math.random() * (i + 1));

            ListNode nodoActual = cabeza;
            ListNode nodoAleatorio = cabeza;

            for (int posicion = 0; posicion < i; posicion++) {
                nodoActual = nodoActual.siguiente;
            }

            for (int posicion = 0;
                 posicion < posicionAleatoria;
                 posicion++) {

                nodoAleatorio = nodoAleatorio.siguiente;
            }

            Object temporal = nodoActual.dato;
            nodoActual.dato = nodoAleatorio.dato;
            nodoAleatorio.dato = temporal;
        }
    }
    @Override
    public String toString() {
        return "MiLista{" +
                "cabeza=" + cabeza +
                '}';
    }
}
