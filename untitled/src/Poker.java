import java.util.Scanner;

public class Poker {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        MiLista baraja = crearBaraja();
        int opcion;

        System.out.println("BARAJA ORIGINAL ORDENADA");
        mostrarLista(baraja);

        do {
            System.out.println("\n--- MENÚ DE PÓQUER ---");
            System.out.println("1. Barajar");
            System.out.println("2. Extraer y ordenar un palo");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            String entrada = teclado.nextLine();

            try {
                opcion = Integer.parseInt(entrada);
            } catch (NumberFormatException error) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    baraja.shuffle();

                    System.out.println("\nBaraja mezclada:");
                    mostrarLista(baraja);
                    break;

                case 2:
                    System.out.print(
                            "Ingrese el palo (C=Corazones, D=Diamantes, " +
                                    "P=Picas, T=Tréboles): "
                    );

                    String textoPalo = teclado.nextLine().toUpperCase();

                    if (textoPalo.length() != 1 ||
                            !esPaloValido(textoPalo.charAt(0))) {
                        System.out.println("Palo inválido.");
                        break;
                    }

                    char palo = textoPalo.charAt(0);

                    MiLista cartasDelPalo = extraerPalo(baraja, palo);
                    MiLista cartasOrdenadas = cartasDelPalo.sortList();

                    System.out.println("\nCartas del palo ordenadas:");
                    mostrarLista(cartasOrdenadas);
                    break;

                case 3:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 3);

        teclado.close();
    }

    private static MiLista crearBaraja() {
        MiLista baraja = new MiLista();

        agregarPalo(baraja, 'C');
        agregarPalo(baraja, 'D');
        agregarPalo(baraja, 'P');
        agregarPalo(baraja, 'T');

        return baraja;
    }

    private static void agregarPalo(MiLista baraja, char palo) {
        for (int numero = 1; numero <= 13; numero++) {
            baraja.insertTail(new Carta(numero, palo));
        }
    }

    private static MiLista extraerPalo(MiLista baraja, char palo) {
        MiLista resultado = new MiLista();
        ListNode actual = baraja.cabeza;

        while (actual != null) {
            Carta carta = (Carta) actual.dato;

            if (carta.getPalo() == palo) {
                resultado.insertTail(carta);
            }

            actual = actual.siguiente;
        }

        return resultado;
    }

    private static boolean esPaloValido(char palo) {
        return palo == 'C' ||
                palo == 'D' ||
                palo == 'P' ||
                palo == 'T';
    }

    private static void mostrarLista(MiLista lista) {
        ListNode actual = lista.cabeza;
        int contador = 0;

        while (actual != null) {
            System.out.print(actual.dato);

            if (actual.siguiente != null) {
                System.out.print("  ");
            }

            contador++;

            if (contador % 13 == 0) {
                System.out.println();
            }

            actual = actual.siguiente;
        }

        if (contador % 13 != 0) {
            System.out.println();
        }
    }
}