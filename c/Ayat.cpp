/*Inputkan satu perkataan. Tentukan berapakah bil huruf vokal dan huruf
konsonan yang terdapat di dalam perkataan tersebut. */

#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <conio.h>

void main()
{
char chrAyat[256];
int nKonsonan=0, nVokal=0, nPembilang;
printf("Masukkan perkataan atau ayat: ");
gets(chrAyat);

for(nPembilang=0; nPembilang < strlen(chrAyat); nPembilang++)
{
if ((toupper(chrAyat[nPembilang])>='A') && (toupper(chrAyat[nPembilang])<='Z'))
if 	(
(toupper(chrAyat[nPembilang])=='A')||
(toupper(chrAyat[nPembilang])=='E')||
(toupper(chrAyat[nPembilang])=='I')||
(toupper(chrAyat[nPembilang])=='O')||
(toupper(chrAyat[nPembilang])=='U')
)
nVokal++;
else
nKonsonan++;
}
printf("\nHuruf Konsonan : %d \nHuruf Vokal : %d", nKonsonan, nVokal);
getch();
}
