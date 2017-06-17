# Github Crawler
## JSON
* JSON (JavaScript Object Notation) adalah file format dalam bentuk teks yang berisi data atau array yang ditandai dengan filetype .jsonutil
* Tipe data yang disupport oleh JSON meliputi
	- Number
	- String
	- Boolean
	- Array (ordered list)
	- Object (unordered list)
	- null
* JSON dibuat dengan bentuk sebagai berikut
	```jsonutil
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
## ReST
* ReST (Representational State Transfer) adalah arsitektur di web yang menyebabkan client & server dapat berinteraksi, dengan memanfaatkan constraint yaitu penggunaan web resources tertentu (untuk dikirim ke server dan diterima client). Akibatnya performa aplikasi menjadi baik
* Ketika clien melakukan request pada server server akan memberikan balasan yang dapat berupa XML, HTML, atau JSON, tergantung pada kesepakatan di awal.
* ReST bersifat stateless, yaitu server tidak menyimpan hal-hal mengenai session dari client pada waktu berkomunikasi. State aplikasi disimpan pada client itu sendiri.

## Github API
* Github API yang memanfaatkan restful web service diakses melalui http://api.github.com
* Setiap request melalui Github API dilayani dengan menggunakan JSON yang berisi data yang dibutuhkan
