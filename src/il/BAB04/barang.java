package il.BAB04;
class Barang extends inventaris_lab { // Child Class
    private int stokBarang;
    private String namaBarang, tanggalMasuk;

    public Barang(int stok, String id, String nama, String tanggal) {
        this.stokBarang = stok;
        setIdBarang(id);
        this.namaBarang = nama;
        this.tanggalMasuk = tanggal;
    }
    public int getStokBarang() { return stokBarang; }
    public void setStokBarang(int stokBarang) { this.stokBarang = stokBarang; }

    public String getNamaBarang() { return namaBarang; }
    public void setNamaBarang(String namaBarang) { this.namaBarang = namaBarang; }

    public String getTanggalMasuk() { return tanggalMasuk; }
    public void setTanggalMasuk(String tanggalMasuk) { this.tanggalMasuk = tanggalMasuk; }
}