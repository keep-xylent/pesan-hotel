public abstract class KamarBase {
    private String tipe;
    private int hargaPerMalam;

    public KamarBase(String tipe, int hargaPerMalam) {
        this.tipe = tipe;
        this.hargaPerMalam = hargaPerMalam;
    }

    public String getTipe() {
        return tipe;
    }

    public int getHargaPerMalam() {
        return hargaPerMalam;
    }

    public abstract int hitungHarga(int jumlahMalam);
}
