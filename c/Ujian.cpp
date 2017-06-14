/* Jawapan untuk soalan ujian */

#include <stdio.h>
#include <string.h>
#include <conio.h>

void main()
{
	int kod, jumlah, bilangan, semester;
	char nama[100];

	printf("Kod masukkan: ");
	scanf("%d", &kod);

	printf("Bilangan subjek per semester: ");
	scanf("%d", &bilangan);

	if (kod == 1)
	{
		strcpy(nama, "Diploma In Computer Science");
		jumlah = 40*bilangan;
		semester = jumlah * 4;
	}

	else if (kod == 2)
	{
		strcpy(nama, "Diploma In Accountacy");
		jumlah = 30*bilangan;
		semester = jumlah * 4;
	}

	else
	{
		strcpy(nama, "Diploma In Business Studies");
		jumlah = 20*bilangan;
		semester = jumlah * 4;
	}

printf("===============================\n");
printf("Nama Kursus: %s\n", nama);
printf("Yuran Bulanan: %d\n", jumlah);
printf("Bayaran Satu Semester: %d\n", semester);
getch();
}
