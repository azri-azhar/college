/* Inputkan satu aksara. Selagi aksara yang diinputkan ialah Y
atau y, mesej "Malaysia Boleh" akan dipaparkan */

#include <stdio.h>

void main()
{
	char chYes;

	printf("Masukkan aksara:");
	chYes = getchar();
	while (( chYes == 'y') || ( chYes == 'Y'))
	{
		printf("Malaysia boleh\n");
		fflush(stdin);
		printf("Masukkan aksara:");
		chYes = getchar();
	}
}
