/* Membandingkan Nombor Yang Mana Lebih Besar. Contoh Multiple Return
   Statements Dalam Sesuatu Function */

#include <stdio.h>
int nNombor1, nNombor2, nHasil;
int fnPerbandingan(int, int);

main()
{
 printf("\nMasukkan nombor pertama:");
 scanf("%d", &nNombor1);
 printf("Masukkan nombor kedua:");
 scanf("%d", &nNombor2);

 nHasil = fnPerbandingan(nNombor1, nNombor2);

 printf("\nNombor yang lebih besar adalah %d", nHasil);

 return 0;
}

int fnPerbandingan(int a, int b)
{
 if (a > b)
  return a;
 else
  return b;
}

/* Contoh Function Untuk Satu Return Statement Sahaja:

int fnPerbandingan(int a, int b)
{
 int nSave;

 if (a > b)
  nSave = a;
 else
  nSave = b;

 return nSave;
}

*/
