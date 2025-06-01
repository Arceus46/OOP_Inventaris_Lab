package il.BAB03;
import il.BAB02.inventaris_lab; //memanggil class inventaris_lab ke dalam class barang
public class barang extends inventaris_lab { //Child Class atau Sub Class
        int stok_barang; //atribut
        String Nama_Barang, tanggal_masuk; //atribut
    barang(int stok, String id, String nama, String tanggal){ //Constructor
        this.stok_barang = stok; //inisialisasi data
        this.id_barang = id; //inisialisasi data
        this.Nama_Barang = nama; //inisialisasi data
        this.tanggal_masuk = tanggal; //inisialisasi data
    }
}