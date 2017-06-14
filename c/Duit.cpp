/* Kuantiti/bilangan wang dalam bentuk keping/syiling bagi setiap kategori akan
diinputkan iaitu RM50, RM10, RM5, 50 sen, 20 sen, 10 sen, 5 sen dan 1 sen.
Jumlah keseluruhan wang perlu dikira dan dipaparkan. Bagi wang syiling
(50 sen, 1 sen.. ) kuantiti yang dimasukkan mestilah tidak boleh melebihi
50 keping. Sekiranya kuantiti yang dimasukkan melebihi 50 keping bagi wang
syiling, pengguna perlu menginputkannya sekali lagi. Proses ini akan
dilaksanaka selagi pengguna ingin meneruskan pilihan. */

#include <stdio.h>
#include <ctype.h>

void main()
 {
  int nRM50, nRM10, nRM5, nRM1, n50sen, n20sen, n10sen, n5sen, n1sen;
  float fJumlah=0.00;
  char chrPilihan;

   do {
    printf("\nBerapa keping/syiling yang anda ada bagi matawang:\n");

    printf("RM 50: ");
    scanf("%d", &nRM50);

    printf("RM 10: ");
    scanf("%d", &nRM10);

    printf("RM 5: ");
    scanf("%d", &nRM5);

    printf("RM 1: ");
    scanf("%d", &nRM1);

     do {
     printf("50 Sen: ");
     scanf("%d", &n50sen); }
     while (n50sen > 50);

     do {
     printf("20 Sen: ");
     scanf("%d", &n20sen); }
     while (n20sen > 50);

    do {
    printf("10 Sen: ");
    scanf("%d", &n10sen); }
    while (n10sen > 50);

    do {
    printf("5 Sen: ");
    scanf("%d", &n5sen); }
    while (n5sen > 50);

    do {
    printf("1 Sen: ");
    scanf("%d", &n1sen); }
    while (n1sen > 50);

   fJumlah = ((nRM50 * 50) + (nRM10 * 10) + (nRM5 * 5) + (nRM1 * 1) +
   (n50sen * 0.50) + (n20sen * 0.20) + (n10sen * 0.10) + (n5sen * 0.05) +
   (n1sen * 0.01));

   printf("\nJumlah wang anda ialah: RM %.2f", fJumlah);

   printf("\nAdakah anda ingin meneruskan (Y/N): ");
   scanf("%s", &chrPilihan);
 }
   while (toupper(chrPilihan) == 'Y');
}
