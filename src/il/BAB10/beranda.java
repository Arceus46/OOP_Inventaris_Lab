package il.BAB10;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; // jika ada koneksi ke database

/*
 *
 * @author rpl a
 */
public class beranda extends javax.swing.JFrame {
Connection connect = koneksi.ordal();
private String idPeminjamanTerpilih;

    /**
     * Creates new form login
     */
    public beranda() {
        initComponents();
        tblbarang();
        tblPinjam();
        tanggal();
        tbluser();
        tblkembali();
        nim();
        barang();

    }
    private void nim() {
    try {
        // Bersihkan isi comboBox
        nimbox.removeAllItems();

        // Tambahkan item default
        nimbox.addItem("Pilih");

        // Query untuk mengambil data NIM dari tabel user
        String sql = "SELECT nim FROM user";
        Statement stat = connect.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        // Tambahkan setiap NIM ke comboBox
        while (rs.next()) {
            String nim = rs.getString("nim");
            nimbox.addItem(nim);
        }

        // Tutup koneksi
        rs.close();
        stat.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal mengambil data: " + e.getMessage());
    }
}
    private void barang() {
    try {
        // Bersihkan isi comboBox
        idbarbox.removeAllItems();

        // Tambahkan item default
        idbarbox.addItem("Pilih");

        // Query untuk mengambil data NIM dari tabel user
        String sql = "SELECT id_barang FROM barang";
        Statement stat = connect.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        // Tambahkan setiap NIM ke comboBox
        while (rs.next()) {
            String idbar = rs.getString("id_barang");
            idbarbox.addItem(idbar);
        }

        // Tutup koneksi
        rs.close();
        stat.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal mengambil data: " + e.getMessage());
    }
}

private void tblbarang() {
       // membuat tampilan model tabel
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("ID Barang");
       model.addColumn("Nama Barang");
       model.addColumn("Jumlah");
       model.addColumn("Jenis");
       model.addColumn("Kondisi");
       model.addColumn("Deskripsi");
       model.addColumn("Denda");

       //menampilkan data database kedalam tabel
       try {
           String sql = "select * from barang";
           java.sql.Statement stm = connect.createStatement();
           java.sql.ResultSet res = stm.executeQuery(sql);
           while (res.next()) {
               model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7)});
           }
           jTable3.setModel(model);
       } catch (Exception e) {
       }

   }
private void tbluser() {
       // membuat tampilan model tabel
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("NIM");
       model.addColumn("Nama");
       model.addColumn("No WhatsApp");
       model.addColumn("Alamat");
       model.addColumn("Password");

       //menampilkan data database kedalam tabel
       try {
           String sql = "select * from user";
           java.sql.Statement stm = connect.createStatement();
           java.sql.ResultSet res = stm.executeQuery(sql);
           while (res.next()) {
               model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)});
           }
           jTable1.setModel(model);
       } catch (Exception e) {
       }

   }

   private void tblPinjam() {
        DefaultTableModel model = new DefaultTableModel();
       model.addColumn("ID Peminjaman");
       model.addColumn("NIM");
       model.addColumn("ID Barang");
       model.addColumn("ID Admin");
       model.addColumn("Tanggal Pinjam");
       model.addColumn("Tanggal Kembali");
       model.addColumn("Denda");
       model.addColumn("Status");
       jTable2.setModel(model);
       try {
           Statement state = connect.createStatement();
           ResultSet data = state.executeQuery("select * from  peminjaman");
           while (data.next()) {
               model.addRow(new Object[]{
                   data.getString("id_peminjaman"),
                   data.getString("nim"),
                   data.getString("id_barang"),
                   data.getString("id_admin"),
                   data.getString("tanggal_pinjam"),
                   data.getString("tanggal_kembali"),
                   data.getString("denda"),
                   data.getString("status")
               });
               jTable2.setModel(model);
           }
       } catch (Exception e) {
           System.err.println("Terjadi Kesalahan" + e);	 }
   }

    private void tblkembali() {
       // membuat tampilan model tabel
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("ID Pengembalian");
       model.addColumn("ID Peminjaman");
       model.addColumn("Tanggal Dikembalikan");
       model.addColumn("Denda");

       //menampilkan data database kedalam tabel
      jTable4.setModel(model);
       try {
           Statement state = connect.createStatement();
           ResultSet data = state.executeQuery("select * from pengembalian");
           while (data.next()) {
               model.addRow(new Object[]{
                   data.getString("id_pengembalian"),
                   data.getString("id_peminjaman"),
                   data.getString("tanggal_dikembalikan"),
                   data.getString("denda")
               });
               jTable4.setModel(model);
           }
       } catch (Exception e) {
           System.err.println("Terjadi Kesalahan" + e);
   }
    }
    public void tanggal() {
       Date tgl = new Date();
       jDateChooser1.setDate(tgl);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        homebtn = new javax.swing.JButton();
        barangbtn = new javax.swing.JButton();
        userbtn = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        exit1 = new javax.swing.JButton();
        pinjambtn = new javax.swing.JButton();
        kembalibtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        barang = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtjum = new javax.swing.JTextField();
        txtjen = new javax.swing.JTextField();
        txtnam = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtdes = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        txtkon = new javax.swing.JTextField();
        txtcharge = new javax.swing.JTextField();
        user = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JTextField();
        txtwa = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtnim = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtalamat = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField19 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        pinjam = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        nimbox = new javax.swing.JComboBox<>();
        idbarbox = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        kembaliiiii = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jTextField7 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        homebtn.setBackground(new java.awt.Color(255, 255, 255));
        homebtn.setText("HOME");
        homebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homebtnActionPerformed(evt);
            }
        });

        barangbtn.setBackground(new java.awt.Color(255, 255, 255));
        barangbtn.setText("BARANG");
        barangbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barangbtnActionPerformed(evt);
            }
        });

        userbtn.setBackground(new java.awt.Color(255, 255, 255));
        userbtn.setText("USER");
        userbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbtnActionPerformed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(255, 0, 0));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        exit1.setBackground(new java.awt.Color(255, 0, 0));
        exit1.setText("LOG OUT");
        exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit1ActionPerformed(evt);
            }
        });

        pinjambtn.setBackground(new java.awt.Color(255, 255, 255));
        pinjambtn.setText("PEMINJAMAN");
        pinjambtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinjambtnActionPerformed(evt);
            }
        });

        kembalibtn.setBackground(new java.awt.Color(255, 255, 255));
        kembalibtn.setText("PENGEMBALIAN");
        kembalibtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembalibtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exit1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(homebtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(barangbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pinjambtn, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(kembalibtn, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homebtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barangbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pinjambtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kembalibtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(exit1)
                .addGap(18, 18, 18)
                .addComponent(exit)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.CardLayout());

        home.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SELAMAT DATANG ADMIN TERCINTA");

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/il/BAB10/images.jpg"))); // NOI18N

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(homeLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(208, 208, 208))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(home, "card2");

        barang.setBackground(new java.awt.Color(255, 255, 255));

        jTable3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Barang", "Nama", "Jumlah", "Jenis", "Kondisi", "Deskripsi", "Denda"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable3);

        jLabel20.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("NAMA BARANG");

        jLabel24.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("JUMLAH BARANG");

        jLabel25.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("JENIS BARANG");

        jLabel26.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("DESKRIPSI BARANG");

        jLabel27.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("KONDISI BARANG");

        jLabel28.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("DENDA");

        txtjum.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtjen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtnam.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtdes.setColumns(20);
        txtdes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtdes.setRows(5);
        jScrollPane6.setViewportView(txtdes);

        jButton1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cari.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jButton2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton11.setText("Delete");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        txtkon.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtcharge.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout barangLayout = new javax.swing.GroupLayout(barang);
        barang.setLayout(barangLayout);
        barangLayout.setHorizontalGroup(
            barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
            .addGroup(barangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(barangLayout.createSequentialGroup()
                        .addGroup(barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(barangLayout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addGroup(barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtnam, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(txtjum)))
                            .addGroup(barangLayout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addComponent(txtjen))
                            .addComponent(jLabel20)
                            .addComponent(jLabel24))
                        .addGroup(barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(barangLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel27))
                            .addGroup(barangLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel26))
                            .addGroup(barangLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel28))))
                    .addGroup(barangLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barangLayout.createSequentialGroup()
                        .addComponent(cari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane6)
                    .addComponent(txtkon)
                    .addComponent(txtcharge))
                .addContainerGap())
        );
        barangLayout.setVerticalGroup(
            barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(jLabel20)
                        .addComponent(txtnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtkon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(barangLayout.createSequentialGroup()
                        .addGroup(barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel24)
                            .addComponent(txtjum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtjen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)))
                    .addComponent(txtcharge, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(barangLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(barangLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(barangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton11))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(barang, "card3");

        user.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("NIM");

        jLabel17.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("NAMA");

        jLabel21.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("No. WA");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("PASSWORD");

        txtpassword.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtwa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtnama.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtnim.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("ALAMAT");

        txtalamat.setColumns(20);
        txtalamat.setRows(5);
        jScrollPane1.setViewportView(txtalamat);

        jButton6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton6.setText("Submit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton12.setText("Update");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton13.setText("Delete");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama", "No. Wa", "Alamat", "Password"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jTextField19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jButton7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userLayout = new javax.swing.GroupLayout(user);
        user.setLayout(userLayout);
        userLayout.setHorizontalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(userLayout.createSequentialGroup()
                        .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(userLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(userLayout.createSequentialGroup()
                                .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel21))
                                .addGap(60, 60, 60)
                                .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtwa)
                                    .addComponent(txtnama)
                                    .addComponent(txtnim))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userLayout.createSequentialGroup()
                                .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField19, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(userLayout.createSequentialGroup()
                                        .addComponent(jButton6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                        .addComponent(jButton12)))
                                .addGap(18, 18, 18)
                                .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton13)
                                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        userLayout.setVerticalGroup(
            userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addGroup(userLayout.createSequentialGroup()
                        .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtnim)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtnama))
                        .addGap(18, 18, 18)
                        .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtwa))))
                .addGap(18, 18, 18)
                .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtpassword)
                        .addComponent(jButton6)
                        .addComponent(jButton12)
                        .addComponent(jButton13)))
                .addGap(24, 24, 24)
                .addGroup(userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField19)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208))
        );

        jPanel3.add(user, "card5");

        pinjam.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("NIM");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("ID Barang");

        nimbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        idbarbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Tanggal Pinjam");

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Tanggal Kembali");

        jButton4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton4.setText("Submit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton5.setText("delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton8.setText("Update");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton9.setText("Search");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Peminjaman", "NIM", "ID Barang", "ID Admin", "Tanggal Pinjam", "Tanggal Kembali", "Denda", "Status"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        jButton14.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton14.setText("Kembalikan");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pinjamLayout = new javax.swing.GroupLayout(pinjam);
        pinjam.setLayout(pinjamLayout);
        pinjamLayout.setHorizontalGroup(
            pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pinjamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(pinjamLayout.createSequentialGroup()
                        .addGroup(pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nimbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idbarbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pinjamLayout.createSequentialGroup()
                                .addGroup(pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addGroup(pinjamLayout.createSequentialGroup()
                                        .addComponent(jButton4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton14)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pinjamLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton8)
                                        .addGap(24, 24, 24)
                                        .addComponent(jButton5))
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pinjamLayout.createSequentialGroup()
                                .addComponent(jTextField6)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9)))))
                .addGap(32, 32, 32))
        );
        pinjamLayout.setVerticalGroup(
            pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pinjamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nimbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addGroup(pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idbarbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4)
                        .addComponent(jButton5)
                        .addComponent(jButton8)
                        .addComponent(jButton14)))
                .addGap(15, 15, 15)
                .addGroup(pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pinjamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(pinjam, "card6");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Pengembalian", "ID Peminjaman", "Tanggal Dikembalikan", "Denda"
            }
        ));
        jScrollPane5.setViewportView(jTable4);

        jTextField7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        jButton10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jButton10.setText("Search");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("DATA PENGEMBALIAN");

        javax.swing.GroupLayout kembaliiiiiLayout = new javax.swing.GroupLayout(kembaliiiii);
        kembaliiiii.setLayout(kembaliiiiiLayout);
        kembaliiiiiLayout.setHorizontalGroup(
            kembaliiiiiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kembaliiiiiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jTextField7)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addContainerGap())
        );
        kembaliiiiiLayout.setVerticalGroup(
            kembaliiiiiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kembaliiiiiLayout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(kembaliiiiiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kembaliiiiiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton10))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(kembaliiiii, "card7");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit1ActionPerformed
         login panggil = new login();
        panggil.show();
        this.dispose();
    }//GEN-LAST:event_exit1ActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void userbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userbtnActionPerformed
        home.setVisible(false);
        barang.setVisible(false);
        user.setVisible(false);
        user.setVisible(true);
        pinjam.setVisible(false);
        kembaliiiii.setVisible(false);
    }//GEN-LAST:event_userbtnActionPerformed

    private void barangbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barangbtnActionPerformed
        home.setVisible(false);
        barang.setVisible(true);
        user.setVisible(false);
        user.setVisible(false);
        pinjam.setVisible(false);
        kembaliiiii.setVisible(false);
    }//GEN-LAST:event_barangbtnActionPerformed

    private void homebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homebtnActionPerformed
        home.setVisible(true);
        barang.setVisible(false);
        user.setVisible(false);
        user.setVisible(false);
        pinjam.setVisible(false);
        kembaliiiii.setVisible(false);
    }//GEN-LAST:event_homebtnActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        String nim = txtnim.getText();
        String nama = txtnama.getText();
        String noWa = txtwa.getText();
        String alamat = txtalamat.getText();
        String password = txtpassword.getText();

        // Validasi input
        if (nim.isEmpty() || nama.isEmpty() || noWa.isEmpty() || alamat.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String sql = "UPDATE user SET nama = ?, no_wa = ?, Alamat = ?, password = ? WHERE nim = ?";
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setString(2, noWa);
            pst.setString(3, alamat);
            pst.setString(4, password);
            pst.setString(5, nim);

            int updated = pst.executeUpdate();

            if (updated > 0) {
                JOptionPane.showMessageDialog(this, "Data user berhasil diperbarui!", "SUKSES", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "NIM tidak ditemukan!", "GAGAL", JOptionPane.WARNING_MESSAGE);
            }
        tbluser();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal memperbarui user: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void pinjambtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinjambtnActionPerformed
        home.setVisible(false);
        barang.setVisible(false);
        user.setVisible(false);
        user.setVisible(false);
        pinjam.setVisible(true);
        kembaliiiii.setVisible(false);
    }//GEN-LAST:event_pinjambtnActionPerformed

    private void kembalibtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembalibtnActionPerformed
        home.setVisible(false);
        barang.setVisible(false);
        user.setVisible(false);
        user.setVisible(false);
        pinjam.setVisible(false);
        kembaliiiii.setVisible(true);
    }//GEN-LAST:event_kembalibtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
try {
    // Ambil data dari form
    String nim = (String) nimbox.getSelectedItem();
    String idBarang = (String) idbarbox.getSelectedItem();
    java.util.Date tglPinjam = jDateChooser1.getDate();
    java.util.Date tglKembali = jDateChooser2.getDate();

    // Validasi input tidak boleh kosong
    if (nim == null || idBarang == null || tglPinjam == null || tglKembali == null 
        || idBarang.equals("Pilih") || nim.equals("Pilih")) {
        JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!!!", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Validasi tanggal kembali
    if (tglKembali.before(tglPinjam)) {
        JOptionPane.showMessageDialog(this, "Tanggal kembali tidak boleh lebih awal dari tanggal pinjam!", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Format tanggal
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String tanggalPinjam = sdf.format(tglPinjam);
    String tanggalKembali = sdf.format(tglKembali);

    // Ambil ID Admin dari login
    String idAdmin = login.idAdminLogin;

    // Generate ID_Peminjaman otomatis (format: PMJ001, PMJ002, ...)
    String newIdPeminjaman = "PMJ001"; // Default jika belum ada data
    Statement stat = connect.createStatement();
    ResultSet rs = stat.executeQuery("SELECT id_peminjaman FROM peminjaman ORDER BY id_peminjaman DESC LIMIT 1");
    if (rs.next()) {
        String lastId = rs.getString("id_peminjaman"); // contoh: PMJ007
        int nomor = Integer.parseInt(lastId.substring(3)) + 1;
        newIdPeminjaman = String.format("PMJ%03d", nomor); // hasil: PMJ008
    }
    rs.close();
    stat.close();

    // Masukkan data ke database
    String sql = "INSERT INTO peminjaman (id_peminjaman, nim, id_barang, id_admin, tanggal_pinjam, tanggal_kembali, denda, status) VALUES (?, ?, ?, ?, ?, ?, 0, 'Diverifikasi')";
    PreparedStatement pst = connect.prepareStatement(sql);
    pst.setString(1, newIdPeminjaman);
    pst.setString(2, nim);
    pst.setString(3, idBarang);
    pst.setString(4, idAdmin);
    pst.setString(5, tanggalPinjam);
    pst.setString(6, tanggalKembali);
    pst.executeUpdate();

    JOptionPane.showMessageDialog(this, "Data peminjaman berhasil disimpan!", "SUKSES", JOptionPane.INFORMATION_MESSAGE);

    // Reset form
    nimbox.setSelectedIndex(0);
    idbarbox.setSelectedIndex(0);
    jDateChooser1.setDate(null);
    jDateChooser2.setDate(null);

    // Refresh tabel
    tblPinjam();

} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String keyword = jTextField7.getText();
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Pengembalian");
        model.addColumn("ID Peminjaman");
        model.addColumn("Tanggal Dikembalikan");
        model.addColumn("Denda");

        try {
            String sql = "SELECT * FROM pengembalian WHERE "
                       + "id_pengembalian LIKE ? OR "
                       + "id_peminjaman LIKE ? OR "
                       + "tanggal_dikembalikan LIKE ? OR "
                       + "denda LIKE ?";

            PreparedStatement ps = connect.prepareStatement(sql);
            for (int i = 1; i <= 4; i++) {
                ps.setString(i, "%" + keyword + "%");
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_pengembalian"),
                    rs.getString("id_peminjaman"),
                    rs.getString("tanggal_dikembalikan"),
                    rs.getString("denda")
                });
            }

            jTable4.setModel(model);
            rs.close();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mencari data: " + e.getMessage());
        }
        jTextField7.setText("");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
    int baris = jTable2.getSelectedRow(); // Ambil baris yang dipilih

    if (baris != -1) {
        // Format tanggal
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Ambil nilai dan tampilkan ke komponen
        String nim = jTable2.getValueAt(baris, 1).toString();
        String idBarang = jTable2.getValueAt(baris, 2).toString();
        String tglPinjamStr = jTable2.getValueAt(baris, 4).toString();
        String tglKembaliStr = jTable2.getValueAt(baris, 5).toString();

        // Set comboBox
        nimbox.setSelectedItem(nim);
        idbarbox.setSelectedItem(idBarang);

        // Set tanggal (dari String ke Date)
        try {
            Date tglPinjam = sdf.parse(tglPinjamStr);
            Date tglKembali = sdf.parse(tglKembaliStr);
            jDateChooser1.setDate(tglPinjam);
            jDateChooser2.setDate(tglKembali);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Format tanggal salah: " + e.getMessage());
        }
        String idPeminjaman = jTable2.getValueAt(baris, 0).toString(); // Kolom ke-0 biasanya ID Peminjaman
        // simpan ke variabel global atau langsung gunakan
        this.idPeminjamanTerpilih = idPeminjaman;
    }

    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int selectedRow = jTable2.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data di tabel terlebih dahulu");
            return;
        }
        try {
            String idPeminjaman = jTable2.getValueAt(selectedRow, 0).toString(); // Kolom ID Peminjaman
            String nim = nimbox.getSelectedItem().toString();
            String idBarang = idbarbox.getSelectedItem().toString();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tglPinjam = sdf.format(jDateChooser1.getDate());
            String tglKembali = sdf.format(jDateChooser2.getDate());

            String sql = "UPDATE peminjaman SET nim=?, id_barang=?, tanggal_pinjam=?, tanggal_kembali=? WHERE id_peminjaman=?";
            PreparedStatement ps = connect.prepareStatement(sql);

            ps.setString(1, nim);
            ps.setString(2, idBarang);
            ps.setString(3, tglPinjam);
            ps.setString(4, tglKembali);
            ps.setString(5, idPeminjaman);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil diupdate");

            // Refresh tabel
            tblPinjam(); // pastikan kamu punya fungsi ini untuk reload data ke jTable2

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal update data: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    int selectedRow = jTable2.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus dari tabel");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String idPeminjaman = jTable2.getValueAt(selectedRow, 0).toString(); // Ambil ID Peminjaman dari kolom 0

            String sql = "DELETE FROM peminjaman WHERE id_peminjaman=?";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, idPeminjaman);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");

            tblPinjam(); // Panggil fungsi untuk refresh tabel

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
    String keyword = jTextField6.getText();
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Peminjaman");
    model.addColumn("NIM");
    model.addColumn("ID Barang");
    model.addColumn("ID Admin");
    model.addColumn("Tanggal Pinjam");
    model.addColumn("Tanggal Kembali");
    model.addColumn("Denda");
    model.addColumn("Status");
    try {
        String sql = "SELECT * FROM peminjaman WHERE "
                   + "id_peminjaman LIKE ? OR "
                   + "nim LIKE ? OR "
                   + "id_barang LIKE ? OR "
                   + "id_admin LIKE ? OR "
                   + "tanggal_pinjam LIKE ? OR "
                   + "tanggal_kembali LIKE ? OR "
                   + "denda LIKE ? OR "
                   + "status LIKE ?";

        PreparedStatement ps = connect.prepareStatement(sql);
        for (int i = 1; i <= 8; i++) {
            ps.setString(i, "%" + keyword + "%");
        }

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("id_peminjaman"),
                rs.getString("nim"),
                rs.getString("id_barang"),
                rs.getString("id_admin"),
                rs.getString("tanggal_pinjam"),
                rs.getString("tanggal_kembali"),
                rs.getString("denda"),
                rs.getString("status")
            });
        }

        jTable2.setModel(model);
        rs.close();
        ps.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Gagal mencari data: " + e.getMessage());
    }
    jTextField6.setText("");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String nim = txtnim.getText();
        String nama = txtnama.getText();
        String noWa = txtwa.getText();
        String alamat = txtalamat.getText();
        String password = txtpassword.getText();

        // Validasi input
        if (nim.isEmpty() || nama.isEmpty() || noWa.isEmpty() || alamat.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO user (nim, nama, no_wa, Alamat, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.setString(1, nim);
            pst.setString(2, nama);
            pst.setString(3, noWa);
            pst.setString(4, alamat);
            pst.setString(5, password);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "User berhasil ditambahkan!", "SUKSES", JOptionPane.INFORMATION_MESSAGE);

            // Reset input
            txtnim.setText("");
            txtnama.setText("");
            txtwa.setText("");
            txtalamat.setText("");
            txtpassword.setText("");
            tbluser();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menambahkan user: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int baris = jTable1.getSelectedRow(); // Ambil baris yang diklik

    if (baris != -1) {
        // Ambil nilai dari masing-masing kolom tabel
        String nim = jTable1.getValueAt(baris, 0).toString();       // kolom nim
        String nama = jTable1.getValueAt(baris, 1).toString();      // kolom nama
        String noWa = jTable1.getValueAt(baris, 2).toString();      // kolom no_wa
        String alamat = jTable1.getValueAt(baris, 3).toString();    // kolom alamat
        String password = jTable1.getValueAt(baris, 4).toString();  // kolom password

        // Set ke komponen input
        txtnim.setText(nim);
        txtnim.setEnabled(false);
        txtnama.setText(nama);
        txtwa.setText(noWa);
        txtalamat.setText(alamat);
        txtpassword.setText(password);
    }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus dari tabel");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String nim = jTable1.getValueAt(selectedRow, 0).toString(); // Ambil ID Peminjaman dari kolom 0

                String sql = "DELETE FROM user WHERE nim=?";
                PreparedStatement ps = connect.prepareStatement(sql);
                ps.setString(1, nim);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Data berhasil dihapus");

                tbluser(); // Panggil fungsi untuk refresh tabel

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String keyword = jTextField19.getText();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("No WhatsApp");
        model.addColumn("Alamat");
        model.addColumn("Password");

        try {
            String sql = "SELECT * FROM user WHERE "
                       + "nim LIKE ? OR "
                       + "nama LIKE ? OR "
                       + "no_wa LIKE ? OR "
                       + "Alamat LIKE ? OR "
                       + "password LIKE ?";

            PreparedStatement ps = connect.prepareStatement(sql);
            for (int i = 1; i <= 5; i++) {
                ps.setString(i, "%" + keyword + "%");
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("nim"),
                    rs.getString("nama"),
                    rs.getString("no_wa"),
                    rs.getString("Alamat"),
                    rs.getString("password")
                });
            }

            jTable1.setModel(model);
            rs.close();
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mencari data: " + e.getMessage());
        }
        jTextField19.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        int baris = jTable3.getSelectedRow(); // Ambil baris yang diklik

    if (baris != -1) {
        // Ambil nilai dari masing-masing kolom tabel
        String id = jTable3.getValueAt(baris, 0).toString();       // kolom id barang
        String name = jTable3.getValueAt(baris, 1).toString();      // kolom nama barabg
        String jumlah = jTable3.getValueAt(baris, 2).toString();      // kolom jumlah barang
        String jenis = jTable3.getValueAt(baris, 3).toString();    // kolom jenis barang
        String kondisi = jTable3.getValueAt(baris, 4).toString();  // kolom kondisi barang
        String desk = jTable3.getValueAt(baris, 5).toString();  // kolom deskripsi barang
        String charge = jTable3.getValueAt(baris, 6).toString();  // kolom denda barang

        // Set ke komponen input
        txtnam.setText(name);
        txtjum.setText(jumlah);
        txtjen.setText(jenis);
        txtkon.setText(kondisi);
        txtdes.setText(desk);
        txtcharge.setText(charge);
    }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String keyword = cari.getText();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Jenis");
        model.addColumn("Kondisi");
        model.addColumn("Deskripsi");
        model.addColumn("Denda");

        try {
            String sql = "SELECT * FROM barang WHERE "
                       + "id_barang LIKE ? OR "
                       + "nama_barang LIKE ? OR "
                       + "jumlah LIKE ? OR "
                       + "jenis LIKE ? OR "
                       + "kondisi LIKE ? OR "
                       + "deskripsi LIKE ? OR "
                       + "denda LIKE ?";

            PreparedStatement ps = connect.prepareStatement(sql);
            for (int i = 1; i <= 7; i++) {
                ps.setString(i, "%" + keyword + "%");
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("jumlah"),
                    rs.getString("jenis"),
                    rs.getString("kondisi"),
                    rs.getString("deskripsi"),
                    rs.getString("denda")
                });
            }

            jTable3.setModel(model);
            rs.close();
            ps.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal mencari data: " + e.getMessage());
            }
        cari.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
        // Ambil data dari form
        String nama = txtnam.getText();
        String jumlah = txtjum.getText();
        String jenis = txtjen.getText();
        String kon = txtkon.getText();
        String des = txtdes.getText();
        String charge = txtcharge.getText();

        // Validasi input tidak boleh kosong
        if (nama.isEmpty() || jumlah.isEmpty() || kon.isEmpty() || des.isEmpty() 
            || charge.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!!!", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Generate ID_Peminjaman otomatis (format: B001, B002, ...)
        String idbar = "B001"; // Default jika belum ada data
        Statement stat = connect.createStatement();
        ResultSet rs = stat.executeQuery("SELECT id_barang FROM barang ORDER BY id_barang DESC LIMIT 1");
        if (rs.next()) {
            String terakhir = rs.getString("id_barang"); // contoh: B007
            int no = Integer.parseInt(terakhir.substring(3)) + 1;
            idbar = String.format("B%03d", no); // hasil: B008
        }
        rs.close();
        stat.close();

        // Masukkan data ke database
        String sql = "INSERT INTO barang (id_barang, nama_barang, jumlah, jenis, kondisi, deskripsi, denda) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = connect.prepareStatement(sql);
        pst.setString(1, idbar);
        pst.setString(2, nama);
        pst.setString(3, jumlah);
        pst.setString(4, jenis);
        pst.setString(5, kon);
        pst.setString(6, des);
        pst.setString(7, charge);
        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data Barang berhasil disimpan!", "SUKSES", JOptionPane.INFORMATION_MESSAGE);

        // Reset form
        txtnam.setText("");
        txtjum.setText("");
        txtjen.setText("");
        txtkon.setText("");
        txtdes.setText("");
        txtcharge.setText("");

        // Refresh tabel
        tblbarang();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int selectedRow = jTable3.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus dari tabel");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                String id_barang = jTable3.getValueAt(selectedRow, 0).toString(); // Ambil ID Barang dari kolom 0

                String sql = "DELETE FROM barang WHERE id_barang=?";
                PreparedStatement ps = connect.prepareStatement(sql);
                ps.setString(1, id_barang);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Data berhasil dihapus");

                tblbarang(); // Panggil fungsi untuk refresh tabel

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String nama = txtnam.getText();
        String jumlah = txtjum.getText();
        String jenis = txtjen.getText();
        String kon = txtkon.getText();
        String des = txtdes.getText();
        String charge = txtcharge.getText();

        // Validasi input
        if (nama.isEmpty() || jumlah.isEmpty() || jenis.isEmpty() || kon.isEmpty() || des.isEmpty() 
        || charge.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!!!", "PERHATIAN", JOptionPane.WARNING_MESSAGE);
        return;
        }
        int selectedRow = jTable3.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data di tabel terlebih dahulu");
            return;
        }
        try {
            String idbar = jTable3.getValueAt(selectedRow, 0).toString();
            String sql = "UPDATE barang SET nama_barang = ?, jumlah = ?, jenis = ?, kondisi = ?, deskripsi = ?, denda = ? WHERE id_barang = ?";
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.setString(1, nama);
            pst.setString(2, jumlah);
            pst.setString(3, jenis);
            pst.setString(4, kon);
            pst.setString(5, des);
            pst.setString(6, charge);
            pst.setString(7, idbar);

            int updated = pst.executeUpdate();

            if (updated > 0) {
                JOptionPane.showMessageDialog(this, "Data Barang berhasil diperbarui!", "SUKSES", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "ID Barang tidak ditemukan!", "GAGAL", JOptionPane.WARNING_MESSAGE);
            }
        tblbarang();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal memperbarui Barang: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        String idBarang = idbarbox.getSelectedItem().toString();

        try {

            // Ambil data peminjaman dan denda
            String query = "SELECT p.tanggal_kembali, p.id_barang, b.denda " +
                           "FROM peminjaman p JOIN barang b ON p.id_barang = b.id_barang " +
                           "WHERE p.id_peminjaman = ?";
            PreparedStatement stmt = connect.prepareStatement(query);
            stmt.setString(1, idPeminjamanTerpilih);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "ID Peminjaman tidak ditemukan!", "ERROR", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String tanggalKembali = rs.getString("tanggal_kembali");
            int dendaPerHari = rs.getInt("denda");

            // Hitung denda
            LocalDate kembali = LocalDate.parse(tanggalKembali);
            LocalDate sekarang = LocalDate.now(); // Tanggal hari ini otomatis

            long hariTerlambat = ChronoUnit.DAYS.between(kembali, sekarang);
            int denda = hariTerlambat > 0 ? (int) hariTerlambat * dendaPerHari : 0;
            // Update denda di tabel peminjaman
            PreparedStatement updateDenda = connect.prepareStatement("UPDATE peminjaman SET denda = ? WHERE id_peminjaman = ?");
            updateDenda.setInt(1, denda);
            updateDenda.setString(2, idPeminjamanTerpilih);
            updateDenda.executeUpdate();

            // Generate id_pengembalian
            Statement maxIdStmt = connect.createStatement();
            ResultSet maxIdRs = maxIdStmt.executeQuery("SELECT MAX(id_pengembalian) AS last_id FROM pengembalian");
            String lastId = null;
            if (maxIdRs.next()) {
                lastId = maxIdRs.getString("last_id");
            }

            int newNum = 1;
            if (lastId != null) {
                newNum = Integer.parseInt(lastId.substring(1)) + 1;
            }
            String idPengembalian = String.format("K%04d", newNum);

            // Simpan ke tabel pengembalian
            String tanggalDikembalikan = sekarang.toString();
            PreparedStatement insert = connect.prepareStatement("INSERT INTO pengembalian (id_pengembalian, id_peminjaman, tanggal_dikembalikan, denda) VALUES (?, ?, ?, ?)");
            insert.setString(1, idPengembalian);
            insert.setString(2, idPeminjamanTerpilih);
            insert.setString(3, tanggalDikembalikan);
            insert.setInt(4, denda);

            if (insert.executeUpdate() > 0) {
                // Update status peminjaman
                PreparedStatement updateStatus = connect.prepareStatement("UPDATE peminjaman SET status = 'Telah Dikembalikan' WHERE id_peminjaman = ?");
                updateStatus.setString(1, idPeminjamanTerpilih);
                updateStatus.executeUpdate();

                // Tambah jumlah barang
                PreparedStatement updateBarang = connect.prepareStatement("UPDATE barang SET jumlah = jumlah + 1 WHERE id_barang = ?");
                updateBarang.setString(1, idBarang);
                updateBarang.executeUpdate();

                JOptionPane.showMessageDialog(this, "Data berhasil dikembalikan!", "SUKSES", JOptionPane.INFORMATION_MESSAGE);
                // Ganti panel dari pinjam ke kembali
                pinjam.setVisible(false);
                kembaliiiii.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Data Gagal dikembalikan!", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
            tblkembali();
            tblPinjam();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton14ActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(beranda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(beranda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(beranda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(beranda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new beranda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barang;
    private javax.swing.JButton barangbtn;
    private javax.swing.JTextField cari;
    private javax.swing.JButton exit;
    private javax.swing.JButton exit1;
    private javax.swing.JPanel home;
    private javax.swing.JButton homebtn;
    private javax.swing.JComboBox<String> idbarbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JButton kembalibtn;
    private javax.swing.JPanel kembaliiiii;
    private javax.swing.JComboBox<String> nimbox;
    private javax.swing.JPanel pinjam;
    private javax.swing.JButton pinjambtn;
    private javax.swing.JTextArea txtalamat;
    private javax.swing.JTextField txtcharge;
    private javax.swing.JTextArea txtdes;
    private javax.swing.JTextField txtjen;
    private javax.swing.JTextField txtjum;
    private javax.swing.JTextField txtkon;
    private javax.swing.JTextField txtnam;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnim;
    private javax.swing.JTextField txtpassword;
    private javax.swing.JTextField txtwa;
    private javax.swing.JPanel user;
    private javax.swing.JButton userbtn;
    // End of variables declaration//GEN-END:variables
}
