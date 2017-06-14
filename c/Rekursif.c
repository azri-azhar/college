/* Aturcara rekursif untuk mengira faktorial, Fibonacci, dan no tabie  */

#include <stdio.h>


long int fakt(long int n)
{
	if(n<2)
		return (1);
	else
		return (n* fakt(n-1));
}


long int fab(long int n)
{
	if ((n==0) || (n==1))
		return(n);
	else
		return(fab(n-2) + fab(n-1));
}


long int darab(long int a, long int b)
{
	if (b==1)
		return(a);
	else
		return(darab(a, b-1) + a);
}


int main()
{
	long int a, b, c, d, e, f, iFaktorial, iFibonacci, iTabie, iKombinasi;

	printf("Masukkan nombor Faktorial yang hendak dipaparkan: ");
	scanf("%d", &a);
	iFaktorial = fakt(a);
	printf("Faktorial bagi nombor %d ialah %d\n\n", a, iFaktorial);


	printf("Masukkan nombor Fibonacci yang hendak dipaparkan: ");
	scanf("%d", &b);
	iFibonacci = fab(b);
	printf("Fibonacci bagi nombor %d ialah %d\n\n", b, iFibonacci);


	printf("Masukkan nombor Tabie pertama: ");
	scanf("%d", &c);
	printf("Masukkan nombor Tabie kedua: ");
	scanf("%d", &d);
	iTabie = darab(c, d);
	printf("Nombor tabie bagi nombor %d ialah %d\n\n", a, iTabie);

	return 0;
}
