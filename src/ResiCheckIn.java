public class ResiCheckIn {
    PemesananKamar[] dataPemesananKamar = new PemesananKamar[10];
    InformasiTamu informasiTamu;
    int index = 0;

    public ResiCheckIn(InformasiTamu informasiTamu) {
        this.informasiTamu = informasiTamu;
    }

    public void tambahPemesanan(PemesananKamar pemesanan) {
        if (index < dataPemesananKamar.length) {
            dataPemesananKamar[index++] = pemesanan;
        } else {
            System.out.println("Data pemesanan penuh.");
        }
    }

    public int hitungHargaTotal() {
        int total = 0;
        for (PemesananKamar pemesanan : dataPemesananKamar) {
            if (pemesanan != null) {
                total += pemesanan.hitungTotalHarga();
            }
        }
        return total;
    }
}