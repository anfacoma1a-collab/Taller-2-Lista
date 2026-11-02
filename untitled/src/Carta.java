

    public class Carta implements Comparable<Carta> {

        private final int numero;
        private final char palo;

        public Carta(int numero, char palo) {
            this.numero = numero;
            this.palo = Character.toUpperCase(palo);
        }

        public int getNumero() {
            return numero;
        }

        public char getPalo() {
            return palo;
        }

        private String obtenerFigura() {
            return switch (numero) {
                case 1 -> "A";
                case 11 -> "J";
                case 12 -> "Q";
                case 13 -> "K";
                default -> String.valueOf(numero);
            };
        }

        private String obtenerSimbolo() {
            return switch (palo) {
                case 'C' -> "♥";
                case 'D' -> "♦";
                case 'P' -> "♠";
                case 'T' -> "♣";
                default -> "?";
            };
        }

        @Override
        public int compareTo(Carta otraCarta) {
            return Integer.compare(this.numero, otraCarta.numero);
        }

        @Override
        public String toString() {
            return obtenerFigura() + obtenerSimbolo();
        }
    }

