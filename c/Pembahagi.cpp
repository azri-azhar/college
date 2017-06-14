/* Satu nombor. Pengguna perlu memilih pembahagi bagi nombor tersebut
diantara 2-5. Berdasarkan pembahagi yang dipilih, paparkan baki bagi nombor
tersebut. Sekiranya tiada baki, paparkan mesej "TIADA". Proses tersebut
berterusan selagi pengguna ingin meneruskan pilihan. Rekabentuk output anda
mengikut kesesuaian. */

#include <stdio.h>
#include <ctype.h>

void main()
{
 int nNombor, nPembahagi, nBaki=0;
 char chrPilihan;

 do {
  printf("Masukkan suatu nombor: ");
  scanf("%d", &nNombor);
  printf("Masukkan pembahagi (2/3/4/5): ");
  scanf("%d", &nPembahagi);

  printf("\nNombor yang dipilih : %d\n", nNombor);
  printf("Pembahagi           : %d\n", nPembahagi);

  nBaki = nNombor % nPembahagi;

  if (nBaki == 0)
   printf("Baki                : TIADA\n");
  else
   printf("Baki                : %d\n", nBaki);

  printf("\nAdakah anda ingin meneruskan ? (Y/N): ");
  scanf("%s", &chrPilihan); }

 while (toupper(chrPilihan) == 'Y');
}
