import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tambahkan dua tipe kamar
        ArrayList<Kamar> kamarList = new ArrayList<>();
        kamarList.add(new Kamar("Deluxe", 500000));
        kamarList.add(new Kamar("Superior", 300000));

        System.out.println("Tipe Kamar yang Tersedia:");
        for (int i = 0; i < kamarList.size(); i++) {
            Kamar kamar = kamarList.get(i);
            System.out.println((i + 1) + ". " + kamar.getTipe() + " - Rp" + kamar.getHargaPerMalam() + "/malam");
        }

        System.out.print("Pilih tipe kamar (1/2): ");
        int pilihanKamar = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (pilihanKamar < 1 || pilihanKamar > kamarList.size()) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        Kamar kamarTerpilih = kamarList.get(pilihanKamar - 1);

        try {
            System.out.print("Masukkan tanggal check-in (YYYY-MM-DD): ");
            String checkInInput = scanner.nextLine();
            System.out.print("Masukkan tanggal check-out (YYYY-MM-DD): ");
            String checkOutInput = scanner.nextLine();
            System.out.print("Masukkan nomor resi: ");
            String nomorResi = scanner.nextLine();

            Date checkIn = java.sql.Date.valueOf(checkInInput);
            Date checkOut = java.sql.Date.valueOf(checkOutInput);

            PemesananKamar pemesanan = new PemesananKamar(kamarTerpilih, checkIn, checkOut, nomorResi);
            pemesanan.tampilkanResi();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: Format tanggal tidak valid. Silakan gunakan format YYYY-MM-DD.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }

        scanner.close();
    }
}
