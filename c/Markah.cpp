/* Bangunkan satu aturcara C yang boleh menerima input, nama, no IC,
No Matrik dan markah 3 matapelajaran atau lebih. Aturcara tersebut juga mesti
boleh mengira markah purata bagi kesemua matapelajaran tersebut.

1. Bincang & analisa cara untuk membangunkan aturcara ini.
2. Bangunkan aturcara anda.
- Buat kumpulan (2-3 orang). */

#include <stdio.h>
#include <conio.h>

char strNama[50];
char strIC[50];
char strMatrik[50];
int nMarkah[4];
int ctIndex;
float fPurata;

void main()
{
	printf("\nMasukkan nama: ");
	scanf("%s",&strNama);

	printf("\nMasukkan no. IC: ");
	scanf("%s", &strIC);

	printf("\nMasukkan no. Matrik: ");
	scanf("%s", &strMatrik);

  for(ctIndex = 1;ctIndex < 4;ctIndex = ctIndex + 1)
  {
  printf("\nMasukkan Markah %d: ",ctIndex);
  scanf("%d", &nMarkah[ctIndex]);
  }

fPurata= ((nMarkah[1] + nMarkah[2] + nMarkah[3])/3);
printf("\nPurata markah adalah: %.2f", fPurata);
getch();

}
