import java.util.Date;

public class ResiCheckIn {
    String nomorResi;
    Date tanggalCheckIn;
    Date tanggalCheckOut;

    public ResiCheckIn(String nomorResi, Date tanggalCheckIn, Date tanggalCheckOut) {
        this.nomorResi = nomorResi;
        this.tanggalCheckIn = tanggalCheckIn;
        this.tanggalCheckOut = tanggalCheckOut;
    }

    public void printResi() {
        System.out.println("Resi: " + nomorResi);
        System.out.println("Check-In: " + tanggalCheckIn);
        System.out.println("Check-Out: " + tanggalCheckOut);
    }
}
