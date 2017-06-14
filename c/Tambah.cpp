/* Dua nombor diinputkan. Hasil tambah bagi dua nombor tersebut
akan dikira dan dipaparkan. Proses tersebut akan dilaksanakan
selagi kedua-dua nombor tersebut bukan sifar. */

#include <stdio.h>
void main()
{
	int nNombor1, nNombor2, nHasil;

	do
	{
		printf("\nMasukkan nombor pertama:");
		scanf("%d", &nNombor1);
		printf("\nMasukkan nombor kedua:");
		scanf("%d", &nNombor2);

		nHasil = nNombor1 + nNombor2;
		printf("\nHasil tambah kedua-dua nombor ialah %d\n", nHasil);
	}
	while ((nNombor1 != 0) && (nNombor2 != 0));
}
