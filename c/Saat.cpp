/* Penukaran Saat Ke Jam, Minit, Dan, Saat. Contoh Penggunaan Modulus */

#include <stdio.h>

#define saat_jam 3600
#define saat_minit 60

unsigned saat, minit, jam, baki_saat, baki_minit;

main()
{
  printf("Masukkan Nilai Dalam Saat (<6500): ");
  scanf("%u", &saat);

  jam = saat / saat_jam;
  minit = saat / saat_minit;
  baki_saat = saat % saat_minit;
  baki_minit = minit % saat_minit;

  printf("%u saat adalah bersamaan dengan ", saat);
  printf("%u jam, %u minit, dan %u saat\n", jam, baki_minit, baki_saat);

  return 0;

}
