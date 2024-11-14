import java.util.Date;

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
        int diffInMillis = (int)(checkOut.getTime() - checkIn.getTime());
        int jmlMalam = diffInMillis / (1000 * 60 * 60 * 24);
        
        return kamar.hargaPerMalam * jmlMalam;
    }
}
