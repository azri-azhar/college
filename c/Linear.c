/* Aturcara Selitan Secara Linear */

#include <stdio.h>

void main()
{
	int i, k, d = 10, n = 10, j, berikut;

	int x[10] = {90, 20, 70, 30, 40, 20, 50, 30, 20, 10};


	for (i=1; i<n; i++)
	{
		berikut = x[i];
		x[0] = berikut;
		j = i;

	while(berikut < x[j-1])
	{
		x[j] = x[j-1];
		j--;
		x[j] = berikut;
	}
	
	for (k = 0; k<n; k++) {
		printf("%5d", x[k]);}
	
	}
	printf("\n");
}
