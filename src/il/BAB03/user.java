package il.BAB03;
import il.BAB02.inventaris_lab; //memanggil class inventaris_lab ke dalam class user
public class user extends inventaris_lab{ //Child Class atau Sub Class
    String nama_user, tanggal_lahir, alamat; //atribut
    public user() { //Constructor
        this.id_user = "P001"; //inisialisasi data
        this.nama_user = "Dani Aqila Rosyidi"; //inisialisasi data
        this.tanggal_lahir = "27 Maret 1987"; //inisialisasi data
        this.alamat = "Malang"; //inisialisasi data
    }
}