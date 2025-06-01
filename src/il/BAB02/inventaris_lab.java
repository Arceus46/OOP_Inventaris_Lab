package il.BAB02;
public class inventaris_lab {//Class Inventaris Lab
        public String id_peminjaman, id_user, id_barang, id_admin, tanggal_pinjam, tanggal_kembali; //Atribut
        public int denda; //Atribut
    public inventaris_lab(){ // Constructor 
        this.id_peminjaman = "P002"; //Menyimpan data id_peminjaman
        this.id_user = "U002"; //Menyimpan data id_user
        this.id_barang = "B002"; //Menyimpan data id_barang
        this.id_admin = "A002"; //Menyimpan data id_admin
        this.tanggal_pinjam = "24 Oktober 2006"; //Menyimpan data tanggal_pinjam
        this.denda = 150000; //Menyimpan data denda
    } //Daerah Constructor
    public static void main(String[] args) { //Method Main untuk output
    inventaris_lab lu = new inventaris_lab();//membuat object baru untuk memanggil constructor
        System.out.println("ID Peminjaman           : " + lu.id_peminjaman);//memanggil constructor id_peminjaman
        System.out.println("ID User                 : " + lu.id_user); //memanggil constructor id_user
        System.out.println("ID Barang               : "+lu.id_barang);//memanggil constructor id_barang
        System.out.println("ID Admin                : "+lu.id_admin); //memanggil constructor id_admin
        System.out.println("Tanggal Peminjaman      : "+lu.tanggal_pinjam); //memanggil constructor tanggal_pinjam
        System.out.println("Denda Jika Terlambat    : Rp."+lu.denda); //memanggil constructor denda
}  
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
}