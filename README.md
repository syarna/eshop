# Tutorial Advanced Programming
Nama  : Syarna Savitri <br>
NPM   : 2206083565 <br>

## Laporan Tutorial dan Exercise Tutorial 1
Exercise 1: <br>
ke 4 poin berhasil saya kerjakan (dapat dilihat dari commit history) <br>

Reflection 1: <br>
Saat menambahkan fitur delete dan edit product, saya memiliki 1 kesulitan yaitu untuk membuat ID
yang ditampilkan berurut khususnya ketika delete product saya belum tau bagaimana cara mengurutkan
ID nya. contoh: <br>

Jika terdapat 3 produk yang saya tambahkan, misalnya: <br>
(ID = 1) -> ayam <br>
(ID = 2) -> bebek <br>
(ID = 3) -> telur <br>

dan saya hapus produk ke-2, maka hasilnya: <br>
(ID = 1) -> ayam <br>
(ID = 3) -> telur <br>

seharusnya ID telur adalah 2. namun saya telah berhasil memperbaiki kodenya sehingga hasilnya sesuai. <br>

## Laporan Tutorial dan Exercise 2
Selama latihan ini, saya mengatasi beberapa masalah terkait integrasi SonarQube dalam proyek Gradle, yaitu:

- Plugin SonarQube Tidak Ditemukan, masih belum fix.
- Task 'sonarqube' Tidak Ditemukan, masih belum fix.
- Token SonarQube Tidak Valid, fixed.
saya memverifikasi SONAR_TOKEN dan set secara manual atau melalui gradle.properties.


Saat ini, implementasi CI/CD belum sepenuhnya terpenuhi, karena masih ada kendala seperti kegagalan menjalankan SonarQube dan belum melakukan deployment ke PaaS
- Continuous Integration Belum Sempurna karena SonarQube masih gagal sehingga tahap CI masih belum bisa.
- kode belum diunggah ke PaaS.
- Karena ada masalah pada SonarQube dan belum ada deployment ke PaaS.


## Laporan Tutorial dan Exercise 3
1.) Saya menerapkan beberapa prinsip SOLID sebagai berikut:

- Single Responsibility Principle (SRP):
memisahkan process flow dari controller, sehingga setiap kelas memiliki satu tanggung jawab utama.
- Open/Closed Principle (OCP):
membuat interface `CarRepository` dan mengimplementasikan beberapa kelas untuk berbagai jenis penyimpanan data (misalnya `InMemoryCarRepository`).
- Liskov Substitution Principle (LSP):
setiap subclass dari Car dapat menggantikan parent class tanpa mengubah perilaku program.
- Interface Segregation Principle (ISP):
membagi interface menjadi bagian-bagian yang lebih spesifik sehingga class hanya mengimplementasikan metode yang benar-benar dibutuhkan.
- Dependency Inversion Principle (DIP):
menggunakan dependency injection pada `CarService`, sehingga tidak bergantung langsung pada implementasi spesifik dari `CarRepository`.

2.) Keuntungan Menerapkan Prinsip SOLID

- Kode lebih mudah dipahami dan dikelola <br>
Contoh: Dengan memisahkan `CarService` dari `CarController`, kita bisa menguji `CarService` secara independen tanpa perlu memanggil API HTTP.
- Lebih fleksibel dan mudah diperluas <br>
Contoh: Jika ingin menambahkan jenis mobil baru (misalnya HybridCar), kita cukup membuat subclass tanpa harus mengubah kode lain yang sudah ada.
- Lebih mudah diuji (testable) <br>
Contoh: Dengan menggunakan `CarRepository` sebagai interface, kita bisa menggunakan mock repository dalam unit test tanpa harus terhubung ke database asli.
- Mengurangi dampak perubahan (low coupling) <br>
Contoh: Jika kita ingin mengganti penyimpanan data dari in-memory ke database, kita cukup mengganti implementasi `CarRepository` tanpa mengubah `CarService`.

3.) Kerugian Jika Tidak Menerapkan Prinsip SOLID

- Kode sulit dipahami dan dimodifikasi <br>
Contoh: Jika semua logika dimasukkan ke dalam satu kelas, maka setiap perubahan kecil akan mempengaruhi seluruh sistem.
- Sulit untuk melakukan testing <br>
Contoh: Jika `CarService` langsung bergantung pada `InMemoryCarRepository`, kita harus selalu terhubung ke database untuk menjalankan unit test, yang memperlambat proses pengujian.
- Rentan terhadap bug akibat perubahan kode <br>
Contoh: Jika kita harus mengubah kode `CarController` setiap kali ada perubahan di `CarService`, maka ada kemungkinan besar muncul bug yang tidak terduga.
- Kode menjadi tidak fleksibel dan sulit dikembangkan <br>
Contoh: Jika kita ingin menambahkan metode baru untuk `ElectricCar`, kita mungkin harus mengubah banyak bagian dalam kode yang seharusnya tidak perlu disentuh.

## Laporan dan Exercise Tutorial 4

### Evaluasi TDD Workflow
- **Apakah TDD membantu dalam memahami kebutuhan kode sebelum implementasi?**  
  Ya, TDD membantu saya memecah fitur menjadi bagian-bagian kecil yang lebih terstruktur. Namun, saya masih sulit untuk menuliskan tes sebelum implementasi karena kurangnya pemahaman awal terhadap flow yang kompleks.


- **Apakah tes yang saya buat cukup spesifik dan fokus pada satu hal?**  
  Sebagian besar tes saya cukup spesifik, tetapi ada beberapa tes yang mencakup lebih dari satu skenario. Mungkin ke depannya, saya akan membuat tes yang benar-benar fokus hanya pada satu hal agar lebih mudah dalam debugging.


- **Apakah saya mengikuti siklus Red-Green-Refactor dengan baik?**  
  Saya sudah mencoba menerapkan siklus Red-Green-Refactor sebisa saya. Namun, ada beberapa kasus di mana saya langsung menulis implementasi sebelum tes berwarna *red* terlebih dahulu, yang sebenarnya mengurangi manfaat dari TDD itu sendiri.


- **Apa yang dapat diperbaiki dalam implementasi TDD saya?**  
  Untuk tutorial kali ini saya mencoba untuk menulis tes sebelum implementasi dan lebih sering melakukan *refactoring* setelah kode berhasil di run. Mungkin kedepannya saya akan mencoba *mocking* untuk menghindari ketergantungan pada database atau API eksternal.

### Evaluasi Terhadap F.I.R.S.T. Principles
| **Prinsip**  | **Evaluasi**                                                                                                                                                                                                      |
|--------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Fast** (Cepat) | Tes berjalan cukup cepat, tetapi beberapa pengujian yang melibatkan database bisa diperbaiki dengan menggunakan mock objects.                                                                                     |
| **Independent** (Independen) | Sebagian besar tes sudah independen, tetapi ada beberapa yang masih memiliki ketergantungan antar satu sama lain. Sehingga saya harus memastikan setiap tes dapat berjalan sendiri tanpa urutan tertentu.         |
| **Repeatable** (Dapat diulang) | Tes yang saya buat dapat dijalankan di lingkungan yang berbeda tanpa hasil yang berubah.                                                          |
| **Self-Validating** (Self-validating) | Semua tes memberikan hasil yang jelas (*pass/fail*) tanpa memerlukan inspeksi manual.                                                                                                                             |
| **Timely** (Dibuat tepat waktu) | Saya mencoba membuat tes sebelum implementasi (sesuai TDD), tetapi ada beberapa kasus di mana saya baru menulis tes setelah implementasi selesai. |

