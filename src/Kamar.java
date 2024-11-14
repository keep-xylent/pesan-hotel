public class Kamar {
    String jenisKamar;
    int hargaPerMalam;

    public Kamar(String jenisKamar, int hargaPerMalam) {
        this.jenisKamar = jenisKamar;
        this.hargaPerMalam = hargaPerMalam;
    }
    
    public String getJenisKamar() {
        return jenisKamar;
    }

    public int getHargaPerMalam() {
        return hargaPerMalam;
    }
}

public class VIP extends Kamar {
    public VIP(int hargaPerMalam) {
        super("VIP", hargaPerMalam);
    }
}

public class Reguler extends Kamar {
    public Reguler(int hargaPerMalam) {
        super("Reguler", hargaPerMalam);
    }
}
