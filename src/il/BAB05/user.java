package il.BAB05;
class user extends inventaris_lab { // Child Class
    private String namaUser, tanggalLahir, alamat;
    public user() {
    }
    public user(String Idpengguna,String namaUser, String tanggalLahir, String alamat) {
        setIdUser(Idpengguna);
        this.namaUser = namaUser;
        this.tanggalLahir = tanggalLahir;
        this.alamat = alamat;
        //Overloading Method
    }
    public void setIdUser(String idUser) { 
        id_user = ("U00" + idUser);
        //Overriding Method
    }
    public String getIdUser() { return id_user; }
    
    public String getNamaUser() { return namaUser; }
    public void setNamaUser(String namaUser) { this.namaUser = namaUser; }

    public String getTanggalLahir() { return tanggalLahir; }
    public void setTanggalLahir(String tanggalLahir) { this.tanggalLahir = tanggalLahir; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
}