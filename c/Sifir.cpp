/* Satu nombor perlu diinputkan. Paparkan sifir bagi nombor
yang diinputkan. Contoh sekiranya nombor 3 diinputkan, paparkan
sifir 3 */

#include <stdio.h>
#include <conio.h>

void main()
{
	unsigned nNombor, nGandaan = 1, nBil;

	printf("Masukkan suatu nombor:");
	scanf("%u", &nNombor);

	for (nBil= 0; nBil <= 12; nBil++)
	{
		nGandaan = nBil*nNombor;
		printf("%u x %u = %u\n", nBil, nNombor, nGandaan);
	}
	getch();
}
