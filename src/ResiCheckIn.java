import java.util.Date;
import java.text.SimpleDateFormat;

public class ResiCheckIn {
    private String nomorResi;
    private Date checkIn;
    private Date checkOut;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMM yyyy");

    public ResiCheckIn(String nomorResi, Date checkIn, Date checkOut) {
        this.nomorResi = nomorResi;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public void printResi() {
        System.out.println("\n +----------------------------------------------+");
        System.out.println(" |               RESI PEMESANAN                 |");
        System.out.println(" +----------------------------------------------+");
        System.out.printf(" | No. Resi   : %-31s |\n", nomorResi);
        System.out.printf(" | Check-In   : %-31s |\n", dateFormat.format(checkIn));
        System.out.printf(" | Check-Out  : %-31s |\n", dateFormat.format(checkOut));
    }
}

