from datetime import datetime
from abc import ABC, abstractmethod

class KamarBase(ABC):
    def __init__(self, tipe, harga_per_malam):
        self.tipe = tipe
        self.harga_per_malam = harga_per_malam

    @abstractmethod
    def hitung_harga(self, jumlah_malam):
        pass

class Kamar(KamarBase):
    def hitung_harga(self, jumlah_malam):
        return self.harga_per_malam * jumlah_malam

class PemesananKamar:
    def __init__(self, kamar, check_in, check_out, nama_pemesan):
        self.kamar = kamar
        self.check_in = datetime.strptime(check_in, '%Y-%m-%d')
        self.check_out = datetime.strptime(check_out, '%Y-%m-%d')
        self.nama_pemesan = nama_pemesan
        
        diff = self.check_out - self.check_in
        self.jumlah_malam = max(1, diff.days)

    def get_total_harga(self):
        return self.kamar.hitung_harga(self.jumlah_malam)
