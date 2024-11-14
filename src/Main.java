import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date checkIn = new Date(2024 - 1900, 0, 1);
        Date checkOut = new Date(2024 - 1900, 0, 5);

        Kamar kamarReguler = new KamarReguler(500000);
        PemesananKamar pemesananReguler = new PemesananKamar(kamarReguler, checkIn, checkOut, "R001");

        pemesananReguler.tampilkanResi();
        int totalHargaReguler = pemesananReguler.hitungTotalHarga();
        System.out.println("Total Harga untuk Pemesanan Kamar Reguler: " + totalHargaReguler);

        Kamar kamarVIP = new KamarVIP(500000);
        PemesananKamar pemesananVIP = new PemesananKamar(kamarVIP, checkIn, checkOut, "V001");

        pemesananVIP.tampilkanResi();
        int totalHargaVIP = pemesananVIP.hitungTotalHarga();
        System.out.println("Total Harga untuk Pemesanan Kamar VIP: " + totalHargaVIP);
    }
}
