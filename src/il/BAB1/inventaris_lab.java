package il;
public class inventaris_lab {//Class Inventaris Lab
        String id_peminjaman, id_user, id_barang, id_admin, tanggal_pinjam; //Atribut
        int denda; //Atribut   
        void datauser(String user){
        this.id_user = user;
    }    
    void dataadmin(String atmin){
        this.id_admin = atmin;
    }
    void databarang(String barang){
        this.id_barang = barang;
    }  
    void datapinjam(String pinjam){
        this.id_peminjaman = pinjam;
    }
    void datadenda(int sanksi){
        this.denda = sanksi;
    }
    void datatglpinjam(String tgl){
        this.tanggal_pinjam = tgl;
    }
    String user(){
        return id_user;
    }
    String admin(){
        return id_admin;
    }
    String pinjam(){
        return id_peminjaman;
    }
    String barang(){
        return id_barang;
    }
    int dendaa(){
        return denda;
    }
    String tanggal(){
        return tanggal_pinjam;
    }
//    
}