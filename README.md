# Github Crawler

## Pengenalan Singkat JSON, ReST, dan Github API

### JSON
* JSON (JavaScript Object Notation) adalah file format dalam bentuk teks yang berisi data atau array yang ditandai dengan filetype .util
* Tipe data yang disupport oleh JSON meliputi
	- Number
	- String
	- Boolean
	- Array (ordered list)
	- Object (unordered list)
	- null
* JSON dibuat dengan bentuk sebagai berikut
	```util
	{
		"atributString": "string-atribut1",
		"atributNumber": 123,
		"atributBoolean": true,
		"atributObject": {
			"objectID": 1,
			"objectDesc": "abc"
		},
		"atributArray": [
			{
				"arrayNumber": 1
			}
			{
				"arrayNumber": 2
			}		
		]
	}
	```

### ReST
* ReST (Representational State Transfer) adalah arsitektur di web yang menyebabkan client & server dapat berinteraksi, dengan memanfaatkan constraint yaitu penggunaan web resources tertentu (untuk dikirim ke server dan diterima client). Akibatnya performa aplikasi menjadi baik
* Ketika client melakukan request pada server, server akan memberikan balasan yang dapat berupa XML, HTML, atau JSON, tergantung pada kesepakatan di awal.
* ReST bersifat stateless, yaitu server tidak menyimpan hal-hal mengenai session dari client pada waktu berkomunikasi. State aplikasi disimpan pada client itu sendiri.
* ReST memanfaatkan method seperti POST, GET dan PUT, untuk melakukan pengubahan dan pengambilan data.

### Github API
* Github API yang memanfaatkan restful web service diakses melalui http://api.github.com
* Setiap request melalui Github API dilayani dengan menggunakan JSON yang berisi data yang dibutuhkan
* Github API terbatas pada 10 request untuk request yang tidak diautentifikasi

## Penjelasan fitur dan Screenshot
### Fitur Aplikasi
Aplikasi ini dapat melakukan fitur sebagai berikut : 

1. Mencari user berdasarkan username/e-mail/nama lengkap
2. Menggunakan filter untuk membatasi pencarian (berdasarkan jumlah repository dan/atau followers)
3. Melihat detail dari user yang dipilih berdasar hasil pencarian
4. Melihat list repository dari user yang dipilih
5. Membuka repository yang dimiliki user pada web browser

### Penggunaan Aplikasi
* Ketika aplikasi dijalankan, maka akan muncul tampilan seperti berikut :

![Tampilan Utama](/docs/screenshot/ss-1.jpg?raw=true "Tampilan Utama")

* Untuk menggunakan aplikasi, pengguna memasukkan keyword dan kemudian  memilih opsi pencarian, apakah akan menggunakan username/email/nama lengkap
* Karena GitHub memiliki batasan 10 request setiap menit, maka aplikasi akan memberikan pesan sebagai berikut jika tidak dapat memenuhi request.

![Tampilan Error](/docs/screenshot/ss-2.jpg?raw=true "Tampilan Error")

Keterangan : File Executable JAR dapat ditemukan di folder executables
