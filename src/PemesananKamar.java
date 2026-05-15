import java.util.Date;
import java.text.NumberFormat;
import java.util.Locale;

public class PemesananKamar {
    private Kamar kamar;
    private Date checkIn;
    private Date checkOut;
    private ResiCheckIn resiCheckIn;
    private int jumlahMalam;
    private static final NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));

    public PemesananKamar(Kamar kamar, Date checkIn, Date checkOut, String nomorResi) {
        this.kamar = kamar;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.resiCheckIn = new ResiCheckIn(nomorResi, checkIn, checkOut);
        
        long diff = checkOut.getTime() - checkIn.getTime();
        this.jumlahMalam = (int) (diff / (1000 * 60 * 60 * 24));
        if (this.jumlahMalam == 0) this.jumlahMalam = 1; // Minimal 1 malam
    }

    public void tampilkanResi() {
        resiCheckIn.printResi();
        System.out.printf(" | Kamar      : %-31s |\n", kamar.getTipe());
        System.out.printf(" | Durasi     : %-31d malam |\n", jumlahMalam);
        System.out.println(" +----------------------------------------------+");
        System.out.printf(" | TOTAL      : %-31s |\n", rupiahFormat.format(kamar.hitungHarga(jumlahMalam)));
        System.out.println(" +----------------------------------------------+");
        System.out.println(" |      Terima kasih telah memesan di LUXE      |");
        System.out.println(" +----------------------------------------------+");
    }
}

