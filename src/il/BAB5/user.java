package il.BAB5;

import il.BAB4.*;

class user extends inventaris_lab { // Child Class
    private String id, namaUser, tanggalLahir, alamat;
    public user(String Idpengguna,String namaUser, String tanggalLahir, String alamat) {
        setIdUser(Idpengguna);
        this.namaUser = namaUser;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
    }
    
    public String getNamaUser() { return namaUser; }
    public void setNamaUser(String namaUser) { this.namaUser = namaUser; }

    public String getTanggalLahir() { return tanggalLahir; }
    public void setTanggalLahir(String tanggalLahir) { this.tanggalLahir = tanggalLahir; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
}