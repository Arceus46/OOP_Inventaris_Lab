package il.BAB4;
public class inventaris_lab {
    private String id_peminjaman, id_user, id_barang, id_admin, tanggal_pinjam, tanggal_kembali;
    private int denda;

    public inventaris_lab() {
//        this.idPeminjaman = "P002";
//        this.idUser = "U002";
//        this.idBarang = "B002";
//        this.idAdmin = "A002";
//        this.tanggalPinjam = "24 Oktober 2006";
//        this.denda = 150000;
    }

    public String getIdPeminjaman() { return id_peminjaman; }
    public void setIdPeminjaman(String idPeminjaman) { this.id_peminjaman = idPeminjaman; }

    public String getIdUser() { return id_user; }
    public void setIdUser(String idUser) { this.id_user = idUser; }

    public String getIdBarang() { return id_barang; }
    public void setIdBarang(String idBarang) { this.id_barang = idBarang; }

    public String getIdAdmin() { return id_admin; }
    public void setIdAdmin(String idAdmin) { this.id_admin = idAdmin; }

    public String getTanggalPinjam() { return tanggal_pinjam; }
    public void setTanggalPinjam(String tanggalPinjam) { this.tanggal_pinjam = tanggalPinjam; }

    public String getTanggalKembali() { return tanggal_kembali; }
    public void setTanggalKembali(String tanggalKembali) { this.tanggal_kembali = tanggalKembali; }

    public int getDenda() { return denda; }
    public void setDenda(int denda) { this.denda = denda;
    
    }
}