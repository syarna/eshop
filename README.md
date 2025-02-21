# Tutorial Advanced Programming
Nama  : Syarna Savitri <br>
NPM   : 2206083565 <br>

## Laporan Tutorial 1
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



