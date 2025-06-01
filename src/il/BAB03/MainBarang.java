/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.BAB03;

/**
 *
 * @author Shadow
 */
public class MainBarang {
    public static void main(String[] args) {
         barang aio = new barang(5, "B002", "Nvidia RTX 5090", "12 Februari 2025");
          System.out.println("ID Barang : " + aio.id_barang);
        System.out.println("Nama Barang : " + aio.Nama_Barang);
        System.out.println("Tanggal Masuk : " + aio.tanggal_masuk);
        System.out.println("Stok : " + aio.stok_barang);
     }
}
