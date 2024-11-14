public class PemesananKamar {
    Kamar kamar;
    Date checkIn;
    Date checkOut;

    public PemesananKamar(Kamar kamar, Date checkIn, Date checkOut) {
        this.kamar = kamar;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public int hitungTotalHarga() {
        int jmlMalam = checkOut - checkIn;
        return kamar.hargaPerMalam * jmlMalam;
    }
}