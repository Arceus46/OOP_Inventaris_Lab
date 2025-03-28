/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.BAB1;

/**
 *
 * @author Shadow
 */
public class Main {
    public static void main(String[] args) {
    inventaris_lab li = new inventaris_lab();
     //ketika akan menggunakan method dari class Mahasiswa maka harus menyertakan nama object
     li.datapinjam("P001");
     li.datauser("U031");
     li.dataadmin("A096");
     li.databarang("B004");
     li.datadenda(10000);
     li.datatglpinjam("24 Maret 2025");
     System.out.println("Peminjaman Barang Inventaris Lab");
     System.out.println("------------------------------------");
     System.out.println("Id Peminjaman      : "+ li.pinjam()); 
     System.out.println("Id User            : "+ li.user()); 
     System.out.println("Id Admin           : "+ li.admin()); 
     System.out.println("Id Barang          : "+ li.barang()); 
     System.out.println("Denda              : Rp."+ li.dendaa()); 
     System.out.println("Tanggal Peminjaman : "+ li.tanggal());
}
}
