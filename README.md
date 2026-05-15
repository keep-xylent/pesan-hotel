# LUXE Hotel Booking System
>
> **Premium Hotel Reservation Management System**

Tugas Pemrograman Berorientasi Objek (PBO) - Sistem Manajemen Reservasi Hotel dengan antarmuka CLI dan versi Web Modern menggunakan Flask.

---

### Anggota Kelompok

- **Muhammad Iqbal Habibi** — `06.2023.1.07698`
- **Muhammad Naufal Rizky Alvianto** — `06.2023.1.07674`

---

## Fitur Utama

Aplikasi ini memiliki dua versi:

### Versi Console (Java)

- **Polished UI**: Menggunakan ASCII Art dan Box-drawing untuk tampilan terminal yang premium.
- **Robust Logic**: Penanganan error input dan validasi tanggal.
- **Receipt System**: Mencetak struk pemesanan langsung di terminal.

### Versi Web (Python Flask)

- **Modern Dashboard**: Antarmuka berbasis web dengan desain Luxe & Glassmorphism.
- **Interactive Booking**: Formulir pemesanan dengan date picker.
- **Digital Receipt**: Struk digital yang dapat dicetak langsung dari browser.
- **Responsive**: Mendukung tampilan Mobile dan Desktop.

---

## Tech Stack

- **Backend (Console)**: Java (JDK 17+)
- **Backend (Web)**: Python 3.x, Flask
- **Frontend**: HTML5, CSS3 (Vanilla), Google Fonts (Outfit)

---

## Cara Menjalankan

### 1. Versi Java (Console)

Masuk direktori `src`:

```powershell
cd src
javac *.java
java Hotel
```

### 2. Versi Web (Flask)

Masuk direktori `web` dan memiliki Flask terinstall:

```powershell
cd web
python app.py
```

#### Install Flask jika belum ada

```powershell
pip install flask
```

Akses di browser melalui: `http://localhost:5000`

---

## Struktur Project (OOP)

Proyek ini menerapkan prinsip dasar PBO:

- **Encapsulation**: Data disembunyikan dalam atribut private dengan getter/setter.
- **Inheritance**: Kamar mewarisi properti dari KamarBase.
- **Abstraction**: Penggunaan abstract class untuk template kamar.
- **Polymorphism**: Metode hitungHarga yang diimplementasikan secara spesifik.
