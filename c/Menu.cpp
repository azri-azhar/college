/* Tulis satu program untuk melakukan operasi asas matematik berdasarkan
kepada senarai pilihan dari MENU UTAMA. Senarai MENU UTAMA program anda
adalah seperti yang digambarkan oleh skrin output dibawah:

Mengoperasi Dua Nilai Integer

MENU UTAMA
1. Operasi Campur
2. Operasi Tolak
3. Operasi Darab
x. Keluar

Masukkan kod operasi anda [ 1, 2, 3, x ] :

Skrin output diatas akan diulang secara berterusan dengan meminta pengguna
supaya memasukkan Kod Operasi. Jika Kod Operasi yang diinputkan oleh
pengguna selain daripada 1, 2, 3 atau X, satu mesej "Anda tidak membuat
pilihan dengan tepat!" akan dipaparkan yang bermakna kod operasi yang
diinputkan tidak sah. Kod Operasi X pula akan menyebabkan mesej "Terima
Kasih" akan dipaparkan dan keseluruhan program tersebut akan ditamatkan. */

#include <stdio.h>
#include <conio.h>

void fnMenu();
void fnCampur();
void fnTolak();
void fnDarab();

void main()
{
 char chrPilihan;

do
  {
   fnMenu();
   fflush(stdin);
   scanf("%c", &chrPilihan);

   if ((chrPilihan == 'x') || (chrPilihan == 'X'))
   {
    printf("Terima Kasih");
    break;
    }

   switch (chrPilihan) {

   case '1':
    fnCampur();
    break;

   case '2':
    fnTolak();
    break;

   case '3':
    fnDarab();
    break;

   default:
    printf("\nAnda tidak membuat pilihan dengan tepat!\n");
   }
  }
  while (chrPilihan |= 'x');
}

void fnMenu()
{
 printf("\n  \n");
 printf("\nMengoperasi Dua Nilai\n");
 printf("=======================\n");
 printf("  \n");
 printf("MENU UTAMA\n");
 printf("=================\n");
 printf("1. Operasi Campur\n");
 printf("2. Operasi Tolak\n");
 printf("3. Operasi Darab\n");
 printf("X. Keluar\n");
 printf("  \n");
 printf("Sila Buat Pilihan Anda: ");
 }

void fnCampur()
{
 int nJumlah, nNombor1, nNombor2;
 printf("Masukkan Nombor Pertama: ");
 scanf("%d", &nNombor1);
 printf("Masukkan Nombor Kedua: ");
 scanf("%d", &nNombor2);
 nJumlah = nNombor1 + nNombor2;
 printf("Hasilnya ialah %d\n", nJumlah);
 printf("\nPress ENTER to continue\n");
 getch();
}

void fnTolak()
{
 int nJumlah, nNombor1, nNombor2;
 printf("Masukkan Nombor Pertama: ");
 scanf("%d", &nNombor1);
 printf("Masukkan Nombor Kedua: ");
 scanf("%d", &nNombor2);
 nJumlah = nNombor1 - nNombor2;
 printf("Hasilnya ialah %d\n", nJumlah);
 printf("\nPress ENTER to continue\n");
 getch();
}

void fnDarab()
{
 int nJumlah, nNombor1, nNombor2;
 printf("Masukkan Nombor Pertama: ");
 scanf("%d", &nNombor1);
 printf("Masukkan Nombor Kedua: ");
 scanf("%d", &nNombor2);
 nJumlah = nNombor1 * nNombor2;
 printf("Hasilnya ialah %d\n", nJumlah);
 printf("\nPress ENTER to continue\n");
 getch();
}
