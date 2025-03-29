package il.BAB4;
class user extends inventaris_lab { // Child Class
    private String id, namaUser, tanggalLahir, alamat;

    public user(String IdUser,String namaUser, String tanggalLahir, String alamat) {
        this.id = IdUser;
        this.namaUser = namaUser;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
    }
    
    public String getId() { return id; }
    public void setId(String ID) { this.id = ID; }
    
    public String getNamaUser() { return namaUser; }
    public void setNamaUser(String namaUser) { this.namaUser = namaUser; }

    public String getTanggalLahir() { return tanggalLahir; }
    public void setTanggalLahir(String tanggalLahir) { this.tanggalLahir = tanggalLahir; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
}