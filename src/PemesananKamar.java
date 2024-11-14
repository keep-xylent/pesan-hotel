import java.util.Date;

public class PemesananKamar {
    Kamar kamar;
    Date checkIn;
    Date checkOut;
    ResiCheckIn resiCheckIn;

    public PemesananKamar(Kamar kamar, Date checkIn, Date checkOut, String nomorResi) {
        this.kamar = kamar;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.resiCheckIn = new ResiCheckIn(nomorResi, checkIn, checkOut);
    }

    public int hitungTotalHarga() {
        int diffInMillis = (int)(checkOut.getTime() - checkIn.getTime());
        int jmlMalam = diffInMillis / (1000 * 60 * 60 * 24);
        System.out.println("Jumlah malam: " + jmlMalam);
        return kamar.hitungHarga(jmlMalam);
    }

    public void tampilkanResi() {
        resiCheckIn.printResi();
    }

}
