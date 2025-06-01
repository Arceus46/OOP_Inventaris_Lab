package il.BAB07;

class Barang extends inventaris_lab { // Child Class
    private int stokBarang;
    private String namaBarang, tanggalMasuk, id_barang;
    public Barang() {
    }
    public Barang(int stok, String id, String nama, String tanggal) {
        this.stokBarang = stok;
        setIdBarang(id);
        this.namaBarang = nama;
        this.tanggalMasuk = tanggal;
        //Overloading Method
    }
    public int getStokBarang() { return stokBarang; }
    public void setStokBarang(int stokBarang) { this.stokBarang = stokBarang; }

    public String getNamaBarang() { return namaBarang; }
    public void setNamaBarang(String namaBarang) { this.namaBarang = namaBarang; }

    public String getTanggalMasuk() { return tanggalMasuk; }
    public void setTanggalMasuk(String tanggalMasuk) { this.tanggalMasuk = tanggalMasuk; }
        
    public String getIdBarang() { return id_barang; }
    public void setIdBarang(String idBarang) { 
        this.id_barang = ("B00" + idBarang); 
        //Overriding Method
    }
    //get itu getter
    //set itu setter

    @Override
    String id() {
        return id_barang;
    }//Override method abstract

    @Override
    String nama() {
    return namaBarang;
    }//Override method abstract
}