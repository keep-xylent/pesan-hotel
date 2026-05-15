from flask import Flask, render_template, request, redirect, url_for, session, flash
from models import Kamar, PemesananKamar
import locale

app = Flask(__name__)
app.secret_key = 'luxe_hotel_secret_key'

# Try to set locale for IDR formatting, fallback to manual if not available
try:
    locale.setlocale(locale.LC_ALL, 'id_ID')
except:
    pass

def format_rupiah(value):
    return f"Rp{value:,.0f}".replace(',', '.')

app.jinja_env.filters['rupiah'] = format_rupiah

KAMAR_LIST = {
    'standard': Kamar('Standard', 250000),
    'superior': Kamar('Superior', 450000),
    'deluxe': Kamar('Deluxe', 750000),
    'suite': Kamar('Suite', 1250000),
    'penthouse': Kamar('Penthouse', 3500000)
}

@app.route('/')
def index():
    return render_template('index.html', kamar_list=KAMAR_LIST)

@app.route('/info')
def info():
    return render_template('info.html')

@app.route('/book/<tipe>')
def book(tipe):
    kamar = KAMAR_LIST.get(tipe.lower())
    if not kamar:
        flash("Tipe kamar tidak ditemukan.", "error")
        return redirect(url_for('index'))
    return render_template('book.html', kamar=kamar)

@app.route('/process_booking', methods=['POST'])
def process_booking():
    tipe = request.form.get('tipe')
    check_in = request.form.get('check_in')
    check_out = request.form.get('check_out')
    nama = request.form.get('nama')
    
    kamar = KAMAR_LIST.get(tipe.lower())
    if not kamar or not check_in or not check_out or not nama:
        flash("Harap isi semua kolom data.", "error")
        return redirect(url_for('book', tipe=tipe))
    
    try:
        pemesanan = PemesananKamar(kamar, check_in, check_out, nama)
        
        # Validation: Check-out must be after Check-in
        if (pemesanan.check_out - pemesanan.check_in).days < 0:
            flash("Tanggal check-out tidak boleh sebelum check-in.", "error")
            return redirect(url_for('book', tipe=tipe))

        session['booking_data'] = {
            'tipe': kamar.tipe,
            'check_in': pemesanan.check_in.strftime('%A, %d %b %Y'),
            'check_out': pemesanan.check_out.strftime('%A, %d %b %Y'),
            'nama': nama,
            'durasi': pemesanan.jumlah_malam,
            'total': pemesanan.get_total_harga()
        }
        return redirect(url_for('receipt'))
    except Exception as e:
        flash(f"Terjadi kesalahan: {str(e)}", "error")
        return redirect(url_for('book', tipe=tipe))

@app.route('/receipt')
def receipt():
    data = session.get('booking_data')
    if not data:
        return redirect(url_for('index'))
    return render_template('receipt.html', data=data)

if __name__ == '__main__':
    app.run(debug=True)
