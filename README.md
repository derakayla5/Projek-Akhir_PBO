# Projek-Akhir_PBO


Nama Projek	: 
Pengelolaan Data Penumpang Pesawat


Deskripsi Projek :

Projek ini mengambil tema pengelolaan data penumpang pesawat. namun lebih spesifiknya program ini mempunyai role yaitu admin dan pegawai. Pada program ini admin bisa melakukan menu CRUD (Create, Read, Update, Delete) untuk Maskapai dan Pegawai. Lalu pada role pegawai bisa melakukan menu CRUD (Create, Read, Update, Delete) untuk penumpang.






Flowchart :

![image](https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/54718fed-be05-4c28-9838-c0e749041621)







ERD :

![image](https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/ea20681e-6b35-46e5-a58f-e4a9af894ad4)






Hirarki :

![image](https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/11c7625b-3e3c-43b6-b8d7-8c89d96d1a85)





ScreenShot Codingan beserta penjelasan :

Codingan untuk connect ke database :

1. Penjelasan Package Database
<img width="535" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/5b0187b4-de08-4cea-9e4a-88540790e154">



Penjelasan Package Database:
- public class database : kelas Java dengan nama "database". Kelas ini akan digunakan untuk mengelola koneksi ke database MySQL.
- private static Connection mysqlconfig;: deklarasi variabel statis mysqlconfig yang bertipe Connection. Variabel ini digunakan untuk menyimpan koneksi ke database
- public static Connection configDB(): metode atau fungsi statis dengan nama "configDB". Metode ini digunakan untuk mendapatkan koneksi ke database MySQL. Metode ini mengembalikan objek Connection, yang merepresentasikan koneksi ke database.
- Di dalam metode configDB, terdapat sebuah blok try-catch. Blok try digunakan untuk mencoba menjalankan kode yang mungkin dapat menghasilkan eksepsi (pengecualian). Blok catch digunakan untuk menangani eksepsi jika terjadi kesalahan.
- String url = "jdbc:mysql://localhost:3306/bandara";: Ini adalah URL koneksi ke database MySQL. URL ini menunjukkan bahwa program akan terhubung ke server database MySQL yang berjalan di localhost (mesin yang sama) pada port 3306, dan menggunakan database bernama "bandara".
- String user = "root";: Ini adalah nama pengguna MySQL yang akan digunakan untuk mengakses database.
- String password = "";: Ini adalah kata sandi yang digunakan untuk mengakses database. Dalam contoh ini, kata sandi dikosongkan.
- mysqlconfig = DriverManager.getConnection(url, user, password); digunakan untuk mencoba mendapatkan koneksi ke database MySQL dengan menggunakan informasi URL, nama pengguna, dan kata sandi yang telah ditentukan. Hasil koneksi disimpan dalam variabel mysqlconfig.
- Jika terjadi kesalahan selama proses koneksi (misalnya, jika database tidak dapat diakses), maka blok catch akan menangkap eksepsi tersebut dan mencetak pesan kesalahan ke konsol dengan menggunakan System.err.println().
- metode configDB mengembalikan objek mysqlconfig yang berisi koneksi ke database MySQL.




2. Penjelasan Package Controller
ada 3 controller yaitu controller maskapai, pegawai, dan penumpang. ketiga controller ini memiliki codingan yang kurang lebih sama, maka kami akan jelaskan salah satunya yaitu controller maskapai menu.



<img width="729" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/b14afcec-49f3-4702-9317-6e6463c769fc">

<img width="611" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/5f3946c8-8914-4807-97fc-7a8b88aa2f11">


<img width="536" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/e3a80d46-5b36-4810-80ae-a1e3a1248bff">


<img width="680" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/b9c89c35-80d0-4829-93c9-3880c53f38a1">


<img width="734" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/32747564-7f1b-418a-b41f-a135d10c861b">



Penjelasan Package Controller :
ini adalah sebuah kelas Java dengan nama controllerMaskapai yang mengimplementasikan suatu antarmuka (interface) dengan nama implementMaskapai. Tujuannya adalah untuk mengelola data terkait maskapai dalam suatu database.
- Connection connection;: Ini adalah variabel yang digunakan untuk menyimpan objek koneksi ke database. Koneksi ini diperoleh dari pemanggilan database.configDB(), yang merupakan metode yang didefinisikan dalam kelas database.
- Terdapat beberapa variabel string yang digunakan untuk menyimpan query SQL:
insert: Query SQL untuk menyisipkan data baru ke dalam tabel maskapai.
update: Query SQL untuk memperbarui data maskapai yang sudah ada di tabel.
delete: Query SQL untuk menghapus data maskapai dari tabel berdasarkan id_penerbangan.
select: Query SQL untuk mengambil semua data dari tabel maskapai.
carimaskapai: Query SQL untuk mencari data maskapai berdasarkan nama_maskapai yang cocok.
Konstruktor public controllerMaskapai(): Ini adalah konstruktor kelas controllerMaskapai. Ketika objek controllerMaskapai dibuat, koneksi ke database diinisialisasi dengan memanggil database.configDB()

- Implementasi metode-metode dari antarmuka implementMaskapai:

insert(modelMaskapai b): Metode ini digunakan untuk menyisipkan data maskapai baru ke dalam tabel dengan menggunakan prepared statement. Nilai-nilai atribut maskapai diambil dari objek modelMaskapai yang diterima sebagai parameter.

update(modelMaskapai b): Metode ini digunakan untuk memperbarui data maskapai yang sudah ada di tabel berdasarkan id_penerbangan. Nilai-nilai atribut maskapai diambil dari objek modelMaskapai yang diterima sebagai parameter.

delete(String id_penerbangan): Metode ini digunakan untuk menghapus data maskapai dari tabel berdasarkan id_penerbangan.

getcariMaskapai(String nama_maskapai): Metode ini digunakan untuk mencari data maskapai berdasarkan nama_maskapai yang cocok (menggunakan "LIKE"). Hasil pencarian dikembalikan dalam bentuk daftar modelMaskapai.

getALL(): Metode ini digunakan untuk mengambil semua data maskapai dari tabel dan mengembalikannya dalam bentuk daftar modelMaskapai.









3. Penjelasan Package Gui


<img width="580" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/e25f82cf-3416-407f-ac4d-c7de536e7e7a">



<img width="602" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/721685c7-212b-4c62-b172-ee6c1684145c">



<img width="593" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/be9fdd45-c572-40a3-9ec9-857031035626">




<img width="527" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/59580dd2-5f58-439e-964d-5ebf9948fcaa">




<img width="506" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/c2ecce84-bbed-4a1a-8bb4-8c2d8ddb3564">




<img width="418" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/5d8b4204-a781-488a-8f9c-fb0dc3abd253">



Penjelasan GUI pada package GUI ini terdapat package gui maskapai, penumpang, dan pegawai. disini kami akan jelaskan package gui maskapai

Codingan ini adalah bagian dari sebuah program Java yang mengimplementasikan antarmuka grafis (GUI) dengan menggunakan Java Swing. Program ini adalah aplikasi CRUD (Create, Read, Update, Delete) yang berfokus pada entitas "maskapai". 
- maskapai Maskapai;: Ini adalah deklarasi variabel Maskapai yang bertipe maskapai. Variabel ini digunakan untuk mengelola entitas maskapai dalam aplikasi.
- Konstruktor public CrudMaskapai(): Ini adalah konstruktor dari kelas CrudMaskapai. Konstruktor ini akan dipanggil ketika objek dari kelas CrudMaskapai dibuat. Dalam konstruktor, beberapa operasi dijalankan:
- initComponents(): Ini adalah metode yang digenerate otomatis oleh IDE (Form Editor) dan digunakan untuk menginisialisasi komponen-komponen GUI.
- Maskapai = new maskapai(this);: Membuat objek maskapai dan menginisialisasinya dengan objek CrudMaskapai saat ini. Ini mungkin digunakan untuk menghubungkan antara kelas CrudMaskapai dengan maskapai.
- Metode-metode yang digenerate otomatis oleh IDE (Form Editor) seperti initComponents dan beberapa action event handlers (seperti btntambahActionPerformed, btnupdateActionPerformed, dan lain-lain) digunakan untuk mengatur tampilan dan interaksi pengguna dengan elemen-elemen GUI. Namun, kode yang terkait dengan fungsi aplikasi sebagian besar berada di dalam objek maskapai.
- Dalam metode btnkembaliActionPerformed, terdapat perpindahan ke jendela lain, mungkin ke jendela menu admin, dengan membuat objek adminMenu dan memanggil metode setVisible(true) serta menutup jendela saat ini (this.dispose()).
- Aplikasi ini memiliki beberapa tombol aksi, seperti "Tambah," "Update," "Hapus," "Cari," dan "Kembali." Ketika tombol-tombol ini ditekan, mereka akan memanggil metode pada objek maskapai untuk melakukan operasi yang sesuai.
- Beberapa komponen GUI yang digunakan dalam aplikasi, seperti teks input, label, tabel (modeltabelmaskapai), tombol, dan combo box (btnmaskapaiclass) diinisialisasi dalam metode initComponents. Juga, ada JTextField yang digunakan untuk mencari data berdasarkan nama_maskapai (txtcarimaskapai).









4. Penjelasan Package Implement
disini terdapat 3 package implement yaitu implement maskapai, penumpang dan pegawai. disini kami akan menjelaskan codingan implement maskapai


 <img width="533" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/be98e118-c75e-417f-ab99-fb03954381fd">


- Codingan ini adalah bagian dari sebuah package yang berisi sebuah antarmuka (interface) Java dengan nama implementMaskapai. Antarmuka ini digunakan untuk mendefinisikan kontrak atau aturan yang harus diikuti oleh kelas-kelas yang akan mengimplementasikan (menggunakan) antarmuka ini. Antarmuka ini berisi beberapa metode yang harus diimplementasikan oleh kelas-kelas yang menggunakan antarmuka ini. Berikut adalah penjelasan dari antarmuka implementMaskapai:
- public void insert(modelMaskapai b);: Ini adalah metode tanpa implementasi yang memiliki satu parameter bertipe modelMaskapai. Metode ini digunakan untuk menyisipkan (insert) data maskapai ke dalam database. Kelas yang mengimplementasikan antarmuka ini harus menyediakan implementasi dari metode ini.
- public void update(modelMaskapai b);: Ini adalah metode tanpa implementasi yang memiliki satu parameter bertipe modelMaskapai. Metode ini digunakan untuk memperbarui (update) data maskapai dalam database. Kelas yang mengimplementasikan antarmuka ini juga harus menyediakan implementasi dari metode ini.
- public void delete(String ID);: Ini adalah metode tanpa implementasi yang memiliki satu parameter bertipe String yang mewakili ID penerbangan maskapai. Metode ini digunakan untuk menghapus (delete) data maskapai dari database. Implementasi dari metode ini harus disediakan oleh kelas yang mengimplementasikan antarmuka ini.
- public java.util.List<modelMaskapai> getALL();: Ini adalah metode tanpa implementasi yang mengembalikan daftar (List) objek modelMaskapai. Metode ini digunakan untuk mengambil semua data maskapai dari database. Kelas yang mengimplementasikan antarmuka ini harus memberikan implementasi dari metode ini.
- public java.util.List<modelMaskapai> getcariMaskapai(String nama_maskapai);: Ini adalah metode tanpa implementasi yang mengembalikan daftar objek modelMaskapai. Metode ini digunakan untuk mencari data maskapai berdasarkan nama maskapai. Parameter nama_maskapai digunakan sebagai kriteria pencarian. Kelas yang mengimplementasikan antarmuka ini harus menyediakan implementasi dari metode ini.
- Antarmuka ini berfungsi sebagai panduan atau kontrak yang harus diikuti oleh berbagai kelas yang ingin mengelola data maskapai dalam aplikasi. Dengan menggunakan antarmuka ini, pengembang dapat memastikan bahwa setiap kelas yang mengimplementasikan antarmuka ini memiliki implementasi yang sesuai untuk operasi CRUD (Create, Read, Update, Delete) terkait data maskapai.

 



5. Penjelasan Package Menucrud Maskapai


   <img width="702" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/37f88565-a5a3-4b7f-ac5b-e50c36603708">


   <img width="776" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/371844a6-20e0-4072-b4b0-f441bd66ac88">


   <img width="777" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/653af7a6-a191-4e6c-9f79-0f5b1d5a13c6">


<img width="701" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/1341566e-91e1-4bf3-809e-266e3eff1c81">



- Codingan ini adalah bagian dari sebuah kelas Java dengan nama maskapai yang digunakan untuk mengelola operasi CRUD (Create, Read, Update, Delete) pada entitas maskapai. Kelas ini berinteraksi dengan elemen-elemen GUI yang ada di kelas CrudMaskapai dan berkomunikasi dengan implementasi dari antarmuka implementMaskapai. Berikut penjelasan dari setiap metode dan variabel dalam kelas maskapai:
Variabel-variabel:
- CrudMaskapai frameMenus: Variabel ini digunakan untuk menyimpan referensi ke objek CrudMaskapai yang merupakan tampilan GUI utama untuk aplikasi CRUD maskapai.
- implementMaskapai Implementmaskapai: Variabel ini digunakan untuk menyimpan objek yang mengimplementasikan antarmuka implementMaskapai. Ini akan digunakan untuk mengakses operasi CRUD terkait maskapai.
- List<modelMaskapai> listmaskapai: Variabel ini digunakan untuk menyimpan daftar maskapai yang diambil dari database.
- Konstruktor public maskapai(CrudMaskapai frameMenu): Konstruktor ini akan dipanggil ketika objek dari kelas maskapai dibuat. Di dalam konstruktor, beberapa inisialisasi dilakukan:
- Menginisialisasi frameMenus dengan objek frameMenu yang digunakan untuk berinteraksi dengan elemen GUI.
- Menginisialisasi Implementmaskapai dengan objek controllerMaskapai yang mengimplementasikan antarmuka implementMaskapai.
- Mengisi listmaskapai dengan data maskapai yang diambil dari database menggunakan Implementmaskapai.getALL().
- Metode reset(): Metode ini digunakan untuk mengatur ulang (reset) nilai-nilai elemen GUI seperti teks input dan combo box ke nilai awal atau kosong.
- Metode isiTable(): Metode ini digunakan untuk mengisi tabel yang menampilkan data maskapai. Ini memperbarui daftar maskapai dengan mengambil data dari database dan memperbarui model tabel yang digunakan untuk menampilkan data tersebut.
- Metode isiField(int row): Metode ini digunakan untuk mengisi elemen GUI dengan data maskapai yang dipilih oleh pengguna dalam tabel. Ini memungkinkan pengguna untuk mengedit data maskapai yang ada dalam database.
- Metode insert(): Metode ini digunakan untuk menyisipkan (insert) data maskapai ke dalam database. Data yang diambil dari elemen GUI akan disimpan ke dalam objek modelMaskapai dan kemudian disisipkan ke dalam database menggunakan Implementmaskapai.insert(). Selain itu, metode ini juga melakukan validasi untuk memastikan bahwa semua field yang diperlukan diisi sebelum menyimpan data.
- Metode update(): Metode ini digunakan untuk memperbarui (update) data maskapai dalam database. Data yang diambil dari elemen GUI akan disimpan ke dalam objek modelMaskapai dan kemudian diupdate ke dalam database menggunakan Implementmaskapai.update(). Metode ini juga melakukan validasi untuk memastikan bahwa data yang akan diupdate telah dipilih.
- Metode delete(): Metode ini digunakan untuk menghapus (delete) data maskapai dari database. Data yang diambil dari elemen GUI digunakan untuk mengidentifikasi data yang akan dihapus menggunakan Implementmaskapai.delete(). Metode ini juga melakukan validasi untuk memastikan data yang akan dihapus telah dipilih.
- Metode isiTabelCariNama(): Metode ini digunakan untuk mengisi tabel dengan hasil pencarian data maskapai berdasarkan nama maskapai. Ini memperbarui daftar maskapai dengan data hasil pencarian dan memperbarui model tabel yang digunakan untuk menampilkan data tersebut.
- Metode cariNama(): Metode ini digunakan untuk melakukan pencarian data maskapai berdasarkan nama maskapai. Metode ini memanggil Implementmaskapai.getcariMaskapai() dengan kriteria pencarian yang diambil dari elemen GUI. Hasil pencarian akan ditampilkan dalam tabel.
Kelas maskapai bertindak sebagai penghubung antara elemen-elemen GUI dalam kelas CrudMaskapai dan operasi-operasi CRUD yang diimplementasikan dalam kelas controllerMaskapai. Ini memungkinkan pengguna untuk berinteraksi dengan data maskapai dan melakukan operasi CRUD dengan bantuan GUI.




6. Penjelasan Package ModelMaskapai
   terdapat Package model maskapai, model pegawai, model penumpang. kami akan jelaskan codingan yang ada di model maskapai


   <img width="448" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/9d2f1c5b-fca0-4d61-9126-ed751ca5590a">


<img width="490" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/08e75837-3b4c-48d2-87ec-d560ac75a0f5">



Codingan ini adalah kelas Java dengan nama modelMaskapai yang digunakan untuk merepresentasikan objek maskapai. Ini adalah contoh dari apa yang sering disebut sebagai "POJO" (Plain Old Java Object) yang digunakan untuk mengelola dan menyimpan data maskapai. Di dalam kelas modelMaskapai, terdapat beberapa variabel anggota (fields) serta metode-metode akses (getter) dan mutator (setter) untuk mengakses dan mengubah data dalam objek maskapai. Berikut penjelasan dari setiap elemen dalam kelas modelMaskapai:

Variabel-variabel (fields):

- private String id_penerbangan: Variabel ini digunakan untuk menyimpan ID penerbangan dari maskapai.
- private String nama_maskapai: Variabel ini digunakan untuk menyimpan nama maskapai.
- private String kota_keberangkatan: Variabel ini digunakan untuk menyimpan kota keberangkatan maskapai.
- private String kota_kedatangan: Variabel ini digunakan untuk menyimpan kota kedatangan maskapai.
- private String maskapai_class: Variabel ini digunakan untuk menyimpan kelas maskapai (misalnya: "Economy class" atau "Business class").
Metode akses (getter) dan mutator (setter):
Metode-metode getter digunakan untuk mengambil nilai dari masing-masing variabel anggota. Contohnya, getId_penerbangan() digunakan untuk mengambil nilai ID penerbangan.
Metode-metode setter digunakan untuk mengatur nilai dari masing-masing variabel anggota. Contohnya, setId_penerbangan(String id_penerbangan) digunakan untuk mengatur nilai ID penerbangan.
Dengan menggunakan kelas modelMaskapai ini, Anda dapat membuat objek maskapai, mengatur dan mengambil nilai dari properti-propertinya, dan mengoperasikannya dalam aplikasi Anda, misalnya dalam operasi CRUD pada database atau dalam tampilan (GUI) aplikasi.







7. Penjelasan Package Model Tabel Maskapai

Terdapat package model tabel maskapai, Model tabel pegawai, model tabel penumpang. kami akan menjelaskan salah satunya yaitu model tabel maskapai


<img width="542" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/3c03aec2-daa5-4257-9df1-7df76c683b22">


Codingan ini adalah kelas Java dengan nama modeltabelmaskapai, yang merupakan turunan dari kelas AbstractTableModel dalam Java. Tujuan kelas ini adalah untuk menyediakan model data yang sesuai dengan tabel (table model) untuk digunakan dalam komponen GUI yang menampilkan data dalam bentuk tabel, seperti JTable. Berikut penjelasan mengenai kelas modeltabelmaskapai:

Konstruktor:
Konstruktor modeltabelmaskapai(List<modelMaskapai> listMaskapai) menerima daftar maskapai (List<modelMaskapai>) sebagai argumen dan menginisialisasi variabel listMaskapai dengan daftar tersebut. Ini berarti bahwa objek modeltabelmaskapai akan digunakan untuk menampilkan data dari daftar maskapai yang diberikan.
Override Metode-Metode dari AbstractTableModel:

- getRowCount(): Metode ini mengembalikan jumlah baris (row) dalam tabel, yang sesuai dengan jumlah elemen dalam daftar maskapai.
- getColumnCount(): Metode ini mengembalikan jumlah kolom (column) dalam tabel, yang dalam kasus ini adalah 5 kolom (ID Penerbangan, Nama Maskapai, Kota Keberangkatan, Kota Kedatangan, dan Maskapai Class).
- getColumnName(int column): Metode ini mengembalikan nama kolom pada indeks tertentu. Dalam kasus ini, ia menggunakan switch untuk mengembalikan nama kolom berdasarkan indeks kolom yang diberikan.
- getValueAt(int row, int column): Metode ini mengembalikan nilai yang akan ditampilkan dalam sel tabel pada posisi (row, column) yang diberikan. Ia juga menggunakan switch untuk mengambil nilai yang sesuai dari objek maskapai dalam daftar maskapai. Dengan menggunakan kelas modeltabelmaskapai ini, Anda dapat membuat model data yang cocok untuk digunakan dalam komponen JTable. Model ini akan digunakan untuk menampilkan data maskapai dalam tabel, dan kelas ini memungkinkan Anda mengakses data tersebut dengan mudah dan menampilkan data dalam tampilan tabel yang sesuai.








   














ScreenShot Output :




1. Menu awal untuk Login

<img width="626" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/3f078c2a-1614-45eb-9979-e75104abe0c8">


2. Menu awal untuk Register


   <img width="547" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/b13ff95c-3099-4933-bff9-6e17d29a5d9c">



3. Tampilan saat berhasil login sebagai admin


   <img width="377" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/536fae56-7f9a-4185-915c-09328d6d3d69">

   <img width="335" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/c2aef641-9c52-45fc-b67c-40ad291be68a">


4. Tampilan Saat admin memilih menu Crud Maskapai


   <img width="367" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/5e0b6e4c-9974-4eb5-8bda-87371f179053">


5. Tampilan saat admin memilih menu Crud Pegawai


   <img width="369" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/170b496b-6651-47d1-9c68-92753ea621d1">


6. Tampilan saat berhasil register dan login sebagai pegawai


<img width="371" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/e6299eb3-965c-495e-b61e-267de466d25b">


7. Tampilan saat pegawai melakukan Crud Penumpang


   <img width="422" alt="image" src="https://github.com/derakayla5/Projek-Akhir_PBO/assets/127472591/ceb7cba4-bef2-47ea-9307-b5fe60c7cce0">











