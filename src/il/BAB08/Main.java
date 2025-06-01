/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package il.BAB08;
import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 *
 * @author Shadow
 */

public class Main {
    public static void main(String[] args) {
        try {
            il li = new il();  // objek dari class il
            Scanner keyboard = new Scanner(System.in);

            System.out.println("====== Program Peminjaman Barang ======");
            
            System.out.print("Masukkan ID Peminjaman = ");
            li.setIdPeminjaman(keyboard.next());

            System.out.print("Masukkan ID Admin = ");
            li.setIdAdmin(keyboard.next());

            System.out.print("Masukkan ID User = ");
            li.setIdUser(keyboard.next());

            System.out.print("Masukkan ID Barang = ");
            li.setIdBarang(keyboard.next());

            System.out.print("Masukkan Tanggal Pinjam = ");
            keyboard.nextLine(); // flush newline dari input sebelumnya
            li.setTanggalPinjam(keyboard.nextLine());

            System.out.print("Masukkan Tanggal Kembali = ");
            li.setTanggalKembali(keyboard.nextLine());

            System.out.print("Masukkan Denda = ");
            li.setDenda(Integer.parseInt(keyboard.next()));

            // tampilkan data
            System.out.println("\n=== Data Peminjaman ===");
            System.out.println("ID Peminjaman : " + li.getIdPeminjaman());
            System.out.println("ID Admin      : " + li.getIdAdmin());
            System.out.println("ID User       : " + li.getIdUser());
            System.out.println("ID Barang     : " + li.getIdBarang());
            System.out.println("Tanggal Pinjam: " + li.getTanggalPinjam());
            System.out.println("Tanggal Kembali: " + li.getTanggalKembali());
            System.out.println("Denda         : Rp." + li.getDenda());

        } catch (Exception c) {
            JOptionPane.showMessageDialog(null, "Ada Kesalahan input data" + c, "Warning", 2);
        }
    }
}