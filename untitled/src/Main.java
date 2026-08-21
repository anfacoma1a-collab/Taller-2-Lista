
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
    }

}
