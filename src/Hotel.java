import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class Hotel {
    private static final Scanner scanner = new Scanner(System.in);
    private static final NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));

    public static void main(String[] args) {
        ArrayList<Kamar> kamarList = new ArrayList<>();
        kamarList.add(new Kamar("Standard", 250000));
        kamarList.add(new Kamar("Superior", 450000));
        kamarList.add(new Kamar("Deluxe", 750000));
        kamarList.add(new Kamar("Suite", 1250000));
        kamarList.add(new Kamar("Penthouse", 3500000));

        boolean running = true;
        while (running) {
            tampilkanHeader();
            System.out.println(" 1. Lihat Daftar Kamar & Pesan");
            System.out.println(" 2. Informasi Hotel");
            System.out.println(" 0. Keluar");
            System.out.print("\n Pilih menu: ");
            
            String menuInput = scanner.nextLine();
            switch (menuInput) {
                case "1":
                    prosesPemesanan(kamarList);
                    break;
                case "2":
                    tampilkanInfoHotel();
                    break;
                case "0":
                    running = false;
                    System.out.println("\n Terima kasih telah menggunakan layanan LUXE HOTEL.");
                    break;
                default:
                    System.out.println("\n [!] Pilihan tidak valid.");
                    tekanEnter();
            }
        }
        scanner.close();
    }

    private static void tampilkanHeader() {
        System.out.println("\n====================================================");
        System.out.println("  _      _    _  __   __  ______   _    _   ____  ");
        System.out.println(" | |    | |  | | \\ \\ / / |  ____| | |  | | |___ \\ ");
        System.out.println(" | |    | |  | |  \\ V /  | |__    | |__| |   __) |");
        System.out.println(" | |    | |  | |   > <   |  __|   |  __  |  |__ < ");
        System.out.println(" | |____| |__| |  / . \\  | |____  | |  | |  ___) |");
        System.out.println(" |______|\\____/  /_/ \\_\\ |______| |_|  |_| |____/ ");
        System.out.println("                                                    ");
        System.out.println("           PREMIUM HOTEL BOOKING SYSTEM             ");
        System.out.println("====================================================");
    }

    private static void tampilkanInfoHotel() {
        System.out.println("\n----------------------------------------------------");
        System.out.println(" INFO LUXE HOTEL ");
        System.out.println("----------------------------------------------------");
        System.out.println(" Alamat   : Jl. Kemewahan No. 101, Jakarta");
        System.out.println(" Kontak   : (021) 1234-5678");
        System.out.println(" Fasilitas: WiFi, Kolam Renang, Spa, Gym, Restoran");
        System.out.println("----------------------------------------------------");
        tekanEnter();
    }

    private static void prosesPemesanan(ArrayList<Kamar> kamarList) {
        System.out.println("\n--- DAFTAR KAMAR TERSEDIA ---");
        for (int i = 0; i < kamarList.size(); i++) {
            Kamar kamar = kamarList.get(i);
            System.out.printf(" [%d] %-12s : %s/malam\n", (i + 1), kamar.getTipe(), rupiahFormat.format(kamar.getHargaPerMalam()));
        }

        System.out.print("\n Pilih nomor kamar (atau 0 untuk kembali): ");
        int pilihan;
        try {
            pilihan = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(" [!] Input harus berupa angka.");
            tekanEnter();
            return;
        }

        if (pilihan == 0) return;
        if (pilihan < 1 || pilihan > kamarList.size()) {
            System.out.println(" [!] Pilihan tidak valid.");
            tekanEnter();
            return;
        }

        Kamar kamarTerpilih = kamarList.get(pilihan - 1);

        try {
            System.out.println("\n--- DETAIL PEMESANAN ---");
            System.out.print(" Masukkan tanggal check-in  (YYYY-MM-DD): ");
            String checkInInput = scanner.nextLine();
            System.out.print(" Masukkan tanggal check-out (YYYY-MM-DD): ");
            String checkOutInput = scanner.nextLine();
            System.out.print(" Masukkan nomor resi/ID     : ");
            String nomorResi = scanner.nextLine();

            Date checkIn = java.sql.Date.valueOf(checkInInput);
            Date checkOut = java.sql.Date.valueOf(checkOutInput);

            if (checkOut.before(checkIn)) {
                System.out.println(" [!] Tanggal check-out tidak boleh sebelum check-in.");
                tekanEnter();
                return;
            }

            PemesananKamar pemesanan = new PemesananKamar(kamarTerpilih, checkIn, checkOut, nomorResi);
            pemesanan.tampilkanResi();

        } catch (IllegalArgumentException e) {
            System.out.println(" [!] Format tanggal tidak valid (Gunakan YYYY-MM-DD).");
        } catch (Exception e) {
            System.out.println(" [!] Terjadi kesalahan: " + e.getMessage());
        }
        tekanEnter();
    }

    private static void tekanEnter() {
        System.out.print("\n Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
    }
}

