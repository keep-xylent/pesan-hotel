public class Kamar {
    String jenisKamar;
    int hargaPerMalam;

    public Kamar(String jenisKamar, int hargaPerMalam) {
        this.jenisKamar = jenisKamar;
        this.hargaPerMalam = hargaPerMalam;
    }

    public int hitungHarga(int jmlMalam) {
        return hargaPerMalam * jmlMalam;
    }

    public static class KamarReguler extends Kamar {
        public KamarReguler(int hargaPerMalam) {
            super("Reguler", hargaPerMalam);
        }
    }

    public static class KamarVIP extends Kamar {
        public KamarVIP(int hargaPerMalam) {
            super("VIP", (int)(hargaPerMalam * 1.2));
        }
    }
}
