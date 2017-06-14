/* Inputkan harga bagi satu barang. Seterusnya kuantiti bagi barang tersebut
juga perlu diinputkan. Kira jumlah harga semua barang
(formula: harga * kuantiti = jumlah).

Sekiranya jumlah melebihi 100, potongan sebanyak 15% akan diberkan,
sebaliknya tiada potongan diberikan. */

#include <stdio.h>
float fJumlah, fDiskaun;
int nKuantiti;

void main()
{

printf("Masukkan harga barang:");
scanf("%f", &fJumlah);
printf("Masukkan kuantiti barang:");
scanf("%d", &nKuantiti);

if (fJumlah > 100)
{
fDiskaun = fJumlah * 0.15;
fJumlah = fJumlah - fDiskaun;
printf("Harganya bagi kuantiti sebanyak %d ialah %.2f\n", nKuantiti, fJumlah);
}

else
{	fJumlah = nKuantiti * fJumlah;
	printf("Harganya bagi kuantiti sebanyak %d ialah %.2f\n", nKuantiti, fJumlah);
}

}
