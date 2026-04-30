# Aplikasi Catat Lari

## 👥 Anggota Kelompok 2 Paralel IV-B :
1. Safira Choirun Nisa’ (24082010046)
2. Patrich Moratti (24082010080)
3. Achmad Atfal Jaya R. (24082010085)
4. Muhammad Yahya Zahid (24082010086)

## 📝 Deskripsi Aplikasi 
CatatLari adalah aplikasi Android yang digunakan untuk membantu pengguna mencatat dan memantau aktivitas olahraga lari. Aplikasi ini memungkinkan pengguna menyimpan data riwayat lari seperti tanggal pelaksanaan, jarak, dan durasi lari, sehingga pengguna dapat melihat perkembangan aktivitas larinya dari waktu ke waktu. Aplikasi ini dikembangkan menggunakan arsitektur Model-View-ViewModel (MVVM) untuk memisahkan antara tampilan, logika aplikasi, dan pengolahan data agar kode lebih terstruktur dan mudah dikembangkan.

## 📚 Daftar Fitur 
1. Autentikasi Pengguna
   - Register : Pengguna dapat membuat akun baru
   - Login : Pengguna masuk ke dalam aplikasi menggunakan akun yang telah dibuat
3. Home
   - Read : Menampilkan daftar riwayat aktivitas lari
   - Create : Pengguna dapat menambahkan data aktivitas lari, dengan cara menginputkan data tanggal pelaksanaan lari, jarak lari (km), dan durasi lari (menit)
   - Edit : Pengguna dapat mengubah data aktivitas lari yang sudah tersimpan
   - Delete : Pengguna dapat menghapus data aktivitas lari yang tidak diperlukan
5. Profile
   - Menampilkan informasi pengguna (username dan email)
   - Terdapat tombol "Logout" untuk keluar dari aplikasi dan diarahkan ke halaman login

## ⚙️ Tech Stack
1. Kotlin : Bahasa pemrograman utama yang digunakan untuk mengembangkan aplikasi Android.
2. Android SDK : Framework yang menyediakan tools dan API untuk membangun aplikasi Android.
3. MVVM (Model-View-ViewModel) : Arsitektur aplikasi yang digunakan untuk memisahkan antara tampilan, logika aplikasi, dan pengolahan data agar lebih terstruktur dan mudah untuk dikembangkan.
4. LiveData : Digunakan untuk mengamati perubahan data secara real-time dan mengupdate UI secara otomatis.
5. RecyclerView : Digunakan untuk menampilkan data dalam bentuk list secara efisien.
6. View Binding : Digunakan untuk menghubungkan file layout XML dengan kode Kotlin secara aman dan menghindari kesalahan null pointer.
7. Room Database : Library dari Android Jetpack yang digunakan untuk menyimpan data secara lokal. Room bekerja di atas SQLite, namun menyediakan abstraksi yang lebih mudah sehingga pengembang tidak perlu menulis query SQL secara manual.

## 📉 Improve Aplikasi Catat Lari
🎨 Peningkatan Tampilan (UI/UX)
- Menerapkan warna utama ungu (#7C4DFF) sebagai identitas visual yang konsisten
- Menggunakan header melengkung untuk memberikan kesan modern dan elegan
- Menampilkan data dengan card-based layout agar lebih rapi dan mudah dibaca
- Menggunakan font Poppins untuk tampilan yang bersih dan profesional
- Menyediakan empty state yang informatif saat belum ada data
- Menggunakan Floating Action Button (FAB) untuk mempermudah penambahan data
- Menggunakan Bottom Navigation Bar untuk navigasi yang lebih intuitif
- Menerapkan perbedaan warna tombol aksi (ungu untuk edit, merah untuk hapus) agar mudah dikenali
