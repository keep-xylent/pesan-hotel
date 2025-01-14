import java.util.Date;

public class PemesananKamar {
    private Kamar kamar;
    private Date checkIn;
    private Date checkOut;
    private ResiCheckIn resiCheckIn;
    private int jumlahMalam;

    public PemesananKamar(Kamar kamar, Date checkIn, Date checkOut, String nomorResi) {
        this.kamar = kamar;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.resiCheckIn = new ResiCheckIn(nomorResi, checkIn, checkOut);
        this.jumlahMalam = (int) ((checkOut.getTime() - checkIn.getTime()) / (1000 * 60 * 60 * 24));
    }

    public void tampilkanResi() {
        resiCheckIn.printResi();
        System.out.println("Jumlah Malam: " + jumlahMalam);
        System.out.println("Total Harga: " + kamar.hitungHarga(jumlahMalam));
    }
}
