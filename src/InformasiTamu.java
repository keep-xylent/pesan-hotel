import java.util.Date;

public class InformasiTamu {
    String nama;
    Date checkIn;
    Date checkOut;
    int jumlahTamu;

    public InformasiTamu(String nama, Date checkIn, Date checkOut, int jumlahTamu) {
        this.nama = nama;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.jumlahTamu = jumlahTamu;
    }
}