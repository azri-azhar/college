/* Sebuah pasaraya membayar gaji para pekerjanya berdasarkan jumlah jam
bekerja seminggu dan kategori yang diinputkan. Kategori adalah seperti
didalam jadual. Sekiranya jumlah jam bekerja lebih daripada 44 jam, ianya
akan dikira sebagai kerja lebih masa (OT) dimana jam lebih masa tersebut
akan dibayar 120% daripada kadar bayaran sejam bagi kategori A1, A2 dan M1.
Bagi lain-lain kategori tiada bayaran lebih masa walaupun jam bekerja lebih
dari 44 jam. Walaubagaimanapun, jam bekerja seminggu tidak boleh melebihi 60
jam seminggu. Kira bayaran gaji sebulan bagi setiap pekerja. Nama dan No. IC
pekerja juga perlu diinputkan. Paparkan output bagi aturcara anda mengikut
kesesuaian/format yang anda rasakan sesuai seperti slip gaji dimana ianya
mestilah mengandungi maklumat nama pasaraya/syarikat, kategori, No IC, nama,
jumlah jam bekerja seminggu, jumlah jam bekerja sebulan, gaji pokok, bayaran
lebih masa (jika ada) dan juga gaji bersih.

|================|=====================|
|Kategori        | Bayaran Sejam       |
|================|=====================|
|AI              | RM 5                |
|A2              | RM 7                |
|M1              | RM 10               |
|M2              | RM 15               |
|BB              | RM 20               |
======================================== */

#include <stdio.h>
#include <string.h>
#include <ctype.h>

void main()
{
  char strNama[80], strKP[15], strKategori[2], chrPilihan;
  int nJamseminggu, nJamlebih = 0;
  float fGajibersih = 0.00, fGajipokok = 0.00;

do {
   printf("             \n");
   printf("Masukkan Nama: ");
   fflush(stdin);
   gets(strNama);
   printf("Masukkan No. K/P: ");
   scanf("%s", strKP);
   printf("Masukkan Kategori (A1/A2/M1/M2/BB): ");
   scanf("%s", strKategori);
   printf("Masukkan Jumlah Jam Bekerja Seminggu: ");
   scanf("%d", &nJamseminggu);

   if (stricmp(strKategori, "A1") == 0) {
     if ((nJamseminggu  > 44) && (nJamseminggu <= 60))
      {
       nJamlebih = nJamseminggu - 44;
       fGajipokok = (44 * 5.00) * 4;
       fGajibersih = (fGajipokok + (nJamlebih * 6 * 4));
       }
	else if ((nJamseminggu <= 44) && (nJamseminggu > 0))
	 {
	  fGajibersih = (nJamseminggu * 5.00) * 4;
	 }
	  else printf("\nJam bekerja seminggu tidak boleh melebihi 60 jam\n");
   }

   if (stricmp(strKategori, "A2") == 0) {
     if ((nJamseminggu  > 44) && (nJamseminggu <= 60))
      {
       nJamlebih = nJamseminggu - 44;
       fGajipokok = (44 * 7.00) * 4;
       fGajibersih = (fGajipokok + (nJamlebih * 8.40 * 4));
       }
	else if ((nJamseminggu <= 44) && (nJamseminggu > 0))
	 {
	  fGajibersih = (nJamseminggu * 7.00) * 4;
	 }
	  else printf("\nJam bekerja seminggu tidak boleh melebihi 60 jam\n");
   }

   if (stricmp(strKategori, "M1") == 0) {
     if ((nJamseminggu  > 44) && (nJamseminggu <= 60))
      {
       nJamlebih = nJamseminggu - 44;
       fGajipokok = (44 * 10.00) * 4;
       fGajibersih = (fGajipokok + (nJamlebih * 12.00 * 4));
       }
	else if ((nJamseminggu <= 44) && (nJamseminggu > 0))
	 {
	  fGajibersih = (nJamseminggu * 10.00) * 4;
	 }
	  else printf("\nJam bekerja seminggu tidak boleh melebihi 60 jam\n");
   }

   if (stricmp(strKategori, "M2") == 0) {
     if ((nJamseminggu  > 0) && (nJamseminggu <= 60))
      {
       fGajibersih = (nJamseminggu * 15.00) * 4;
       fGajipokok = fGajibersih;
       }
	else printf("\nJam bekerja seminggu tidak boleh melebihi 60 jam\n");
   }

   if (stricmp(strKategori, "BB") == 0) {
     if ((nJamseminggu  > 0) && (nJamseminggu <= 60))
      {
       fGajibersih = (nJamseminggu * 20.00) * 4;
       fGajipokok = fGajibersih;
       }
	else printf("\nJam bekerja seminggu tidak boleh melebihi 60 jam\n");
   }

  printf("                                               \n");
  printf("Syarikat Azri The Hackers Underground Sdn. Bhd.\n");
  printf("===============================================\n");
  printf("                                               \n");
  printf("Nama Pekerja: %s\n", strNama);
  printf("No K/P: %s\n", strKP);
  printf("Kategori: %s\n", strKategori);
  printf("Jumlah Jam Bekerja Seminggu: %d Jam\n", nJamseminggu);
  printf("Jumlah Jam Bekerja Sebulan: %d Jam\n", nJamseminggu * 4);
  printf("Gaji Pokok: RM %.2f\n", fGajipokok);
  printf("Bayaran Lebih Masa: RM %.2f\n", fGajibersih - fGajipokok);
  printf("Gaji Bersih: RM %.2f\n", fGajibersih);
  printf("                                               \n");
  printf("Adakah anda ingin meneruskan (Y/N) ?: ");
  scanf("%s", &chrPilihan); }
while (toupper(chrPilihan) == 'Y');
}
