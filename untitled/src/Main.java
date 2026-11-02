
import java.util.Iterator;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MiLista miLista = new MiLista();
        System.out.println(miLista.toString());

        miLista.insertHead(0);

//    System.out.println(miLista.toString());
        miLista.insertHead("Juan");
        miLista.insertHead(true);

//    System.out.println(miLista.toString());

        miLista.insertTail("Angela");

        System.out.println(miLista.toString());
        System.out.println(miLista.getSize());

       // miLista.clear();

        System.out.println(miLista.toString());

      //  miLista.insertTail(5);
        System.out.println(miLista.toString());
        miLista.getSize();
        System.out.println(miLista.getSize());

        miLista.insertTail(5);
        miLista.insertTail(6);
        miLista.insertTail(7);

        miLista.getTail();
        System.out.println(miLista.getTail());

        System.out.println(miLista.toString());

        System.out.println(miLista.get(miLista.cabeza.siguiente.siguiente));

        MiLista listaVacia = new MiLista();

        System.out.println("Empty head: " + listaVacia.getHead());
        System.out.println("Empty tail: " + listaVacia.getTail());

        System.out.println("Current head: " + miLista.getHead());
        System.out.println("Current tail: " + miLista.getTail());

        System.out.println("Add 8: " + miLista.add(8));
        System.out.println("New tail: " + miLista.getTail());
        System.out.println("New size: " + miLista.getSize());

        System.out.println("Insert 25 after head: "
                + miLista.insert(miLista.cabeza, 25));

        System.out.println("New size: " + miLista.getSize());
        System.out.println("Value after head: "
                + miLista.get(miLista.cabeza.siguiente));

        System.out.println("Insert 30 after 25: "
                + miLista.insert(25, 30));

        System.out.println("New size: " + miLista.getSize());

        System.out.println("Value after 25: "
                + miLista.get(miLista.cabeza.siguiente.siguiente));

        System.out.println("Insert after nonexistent value: "
                + miLista.insert(999, 40));

        ListNode nodoParaCambiar = miLista.cabeza.siguiente;

        System.out.println("Value before set: "
                + miLista.get(nodoParaCambiar));

        System.out.println("Set result: "
                + miLista.set(nodoParaCambiar, 100));

        System.out.println("Value after set: "
                + miLista.get(nodoParaCambiar));

        System.out.println("Size after set: "
                + miLista.getSize());

        ListNode nodoParaEliminar = miLista.cabeza.siguiente;

        System.out.println("Value to remove: "
                + miLista.get(nodoParaEliminar));

        System.out.println("Remove result: "
                + miLista.remove(nodoParaEliminar));

        System.out.println("New value after head: "
                + miLista.get(miLista.cabeza.siguiente));

        System.out.println("Size after removal: "
                + miLista.getSize());

        System.out.println("Contains 30: "
                + miLista.contains(30));

        System.out.println("Contains 100: "
                + miLista.contains(100));

        System.out.println("Contains 999: "
                + miLista.contains(999));

        System.out.println("List elements:");

        Iterator<ListNode> iterador = miLista.iterator();

        System.out.println("List elements:");

        while (iterador.hasNext()) {
            ListNode nodo = iterador.next();
            System.out.println(miLista.get(nodo));
        } // The iterator loop finishes here

        Object[] arreglo = miLista.toArray();

        System.out.println("Array: "
                + Arrays.toString(arreglo));

        System.out.println("Array length: "
                + arreglo.length);

        Object[] arregloPequeno = new Object[3];
        Object[] resultadoPequeno = miLista.toArray(arregloPequeno);

        System.out.println(
                "Small array: " + Arrays.toString(resultadoPequeno)
        );
        System.out.println(
                "Small array result length: " + resultadoPequeno.length
        );

        Object[] arregloGrande = new Object[12];
        Object[] resultadoGrande = miLista.toArray(arregloGrande);

        System.out.println(
                "Large array: " + Arrays.toString(resultadoGrande)
        );
        System.out.println(
                "Large array result length: " + resultadoGrande.length
        );


        System.out.println(
                "Value before tail: " + miLista.getBeforeTo()
        );

        System.out.println(
                "Value before the second node: "
                        + miLista.getBeforeTo(miLista.cabeza.siguiente)
        );

        System.out.println(
                "Value before head: "
                        + miLista.getBeforeTo(miLista.cabeza)
        );

        ListNode nodoExterno = new ListNode(500);

        System.out.println(
                "Value before an external node: "
                        + miLista.getBeforeTo(nodoExterno)
        );



        System.out.println(
                "Value after head: " + miLista.getNextTo()
        );

        System.out.println(
                "Value after the second node: "
                        + miLista.getNextTo(miLista.cabeza.siguiente)
        );

        ListNode nodoCola = miLista.cabeza;

        while (nodoCola.siguiente != null) {
            nodoCola = nodoCola.siguiente;
        }

        System.out.println(
                "Value after tail: " + miLista.getNextTo(nodoCola)
        );

        ListNode nodoExterno2 = new ListNode(600);

        System.out.println(
                "Value after an external node: "
                        + miLista.getNextTo(nodoExterno2)
        );


        ListNode desde = miLista.cabeza.siguiente;
        ListNode hasta = desde.siguiente.siguiente;

        MiLista subLista = miLista.subList(desde, hasta);

        System.out.println(
                "Sublist: " + Arrays.toString(subLista.toArray())
        );
        System.out.println(
                "Sublist size: " + subLista.getSize()
        );

        MiLista listaNumerica = new MiLista();

        listaNumerica.add(8);
        listaNumerica.add(3);
        listaNumerica.add(12);
        listaNumerica.add(5);
        listaNumerica.add(1);

        MiLista listaOrdenada = listaNumerica.sortList();

        System.out.println(
                "Original list: "
                        + Arrays.toString(listaNumerica.toArray())
        );

        System.out.println(
                "Sorted list: "
                        + Arrays.toString(listaOrdenada.toArray())
        );


        System.out.println("\n--- toString test ---");

        System.out.println("Numeric list:");
        System.out.println(listaNumerica);

        System.out.println("Sorted numeric list:");
        System.out.println(listaOrdenada);

        MiLista listaVaciaFinal = new MiLista();

        System.out.println("Empty list:");
        System.out.println(listaVaciaFinal);

        }

    }

