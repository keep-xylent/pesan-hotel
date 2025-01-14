public class Kamar extends KamarBase {

    public Kamar(String tipe, int hargaPerMalam) {
        super(tipe, hargaPerMalam);
    }

    @Override
    public int hitungHarga(int jumlahMalam) {
        return getHargaPerMalam() * jumlahMalam;
    }
}
