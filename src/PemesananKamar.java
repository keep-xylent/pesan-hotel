public class PemesananKamar {
    Kamar kamar;
    int jmlMalam;

    public PemesananKamar(Kamar kamar, int jmlMalam) {
        this.kamar = kamar;
        this.jmlMalam = jmlMalam;
    }

    public int hitungTotalHarga() {
        return kamar.hargaPerMalam * jmlMalam;
    }
}