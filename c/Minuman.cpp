/* Tuliskan aturcara C yang lengkap bagi melaksanakan perkara-perkara
   dibawah:

Diberi jadual seperti dibawah:

Kod  Jenis Minuman  Harga
===========================
1    Milo           Rm 1.50
2    Kopi           Rm 1.00
3    Coca Cola      Rm 1.20
4    Jus Oren       Rm 1.80

Kod minuman perlu diinputkan. Jenis minuman beserta harga akan dipaparkan.
Paparkan dalam format yang anda fikirkan sesuai. Sekiranya jumlah melebihi
100, potongan sebanyak 15% akan diberkan, sebaliknya tiada potongan
diberkan. */

#include <stdio.h>

int nKod, nKuantiti;
float fJumlah, fDiskaun;

void main()
{
	printf("Masukkan kod minuman:");
	scanf("%d", &nKod);
	printf("Masukkan kuantiti:");
	scanf("%d", &nKuantiti);

	if (nKod == 1)
	{
		printf("Jenis minuman: Milo   Harga: Rm 1.50\n");
		fJumlah = 1.5 * nKuantiti;
	}

	else if (nKod == 2)
	{
		printf("Jenis minuman: Kopi   Harga: Rm 1.00\n");
		fJumlah = 1.00 * nKuantiti;
	}

	else if (nKod == 3)
	{
		printf("Jenis minuman: Coca-Cola   Harga: Rm 1.20\n");
		fJumlah = 1.2 * nKuantiti;
	}

	else if (nKod == 4)
	{
		printf("Jenis minuman: Jus Oren   Harga: Rm  1.80\n");
		fJumlah = 1.8 * nKuantiti;
	}

	else
		printf("----Out of range----");


if (fJumlah > 100)
{
fDiskaun = fJumlah * 0.15;
fJumlah = fJumlah - fDiskaun;
printf("Harganya bagi kuantiti sebanyak %d ialah RM %.2f\n", nKuantiti, fJumlah);
}

else
printf("Harganya bagi kuantiti sebanyak %d ialah RM %.2f\n", nKuantiti, fJumlah);

}
