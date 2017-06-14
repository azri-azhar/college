/* Mohamad Azri Bin Azhar */
/* http://azri.free.fr/   */

#include <stdio.h>
#include <conio.h>
#include <string.h>
#include <ctype.h>

int ctCounter, ctCounter2, nUjian1[15], nUjian2[15], nUjianAkhir[15];
int nMarkahAkhir[15]; int nJumlahLulus, nJumlahGagal;
char strStatus[5]; char chrYes;

FILE *txtOut;

void fnHeader();
void fnCetakSkrin();
void fnCetakText();

void main()
{
  fnHeader();
  nJumlahLulus = 0;
  nJumlahGagal = 0;

  for (ctCounter = 0; ctCounter < 15; ctCounter++)
    {
      printf("\nMasukkan Markah Bagi Pelajar Yang ke %d\n", ctCounter+1);

      do {
		printf("Masukkan markah Ujian 1: ");
		scanf("%d", &nUjian1[ctCounter]); }
      while ((nUjian1[ctCounter] > 25) || (nUjian1[ctCounter] < 0));

      do {
		printf("Masukkan markah Ujian 2: ");
		scanf("%d", &nUjian2[ctCounter]); }
      while ((nUjian2[ctCounter] > 25) || (nUjian2[ctCounter] < 0));

      do {
		printf("Masukkan markah Peperiksaan Akhir: ");
		scanf("%d", &nUjianAkhir[ctCounter]); }
      while ((nUjianAkhir[ctCounter] > 50) || (nUjianAkhir[ctCounter] < 0));

    nMarkahAkhir[ctCounter] = nUjian1[ctCounter] + nUjian2[ctCounter] + nUjianAkhir[ctCounter];
  }

fnCetakSkrin();
}

void fnHeader()
{   
	// textcolor(BLUE);
	// textbackground(WHITE);
	// clrscr();
	printf("===================================\n");
	printf("Aturcara Mengira Markah Peperiksaan\n");
	printf("===================================\n\n");
}

void fnCetakSkrin()
{
	// textbackground(CYAN);
	// clrscr();
	printf("\n============================================================================\n");
	printf("Pelajar   \t U1\t U2\t Ujian Akhir\t Markah Akhir\t Status\n");
	printf("============================================================================\n");

 for (ctCounter2 = 0; ctCounter2 < 15; ctCounter2++)
  {
	 if (nMarkahAkhir[ctCounter2] >= 50)
	 {
	   strcpy(strStatus, "Lulus");
	   nJumlahLulus++;
	 }

	 else
	 {
	  strcpy(strStatus, "Gagal");
	  nJumlahGagal++;
	 }
 
	  printf("Pelajar %d\t", ctCounter2+1);
	  printf(" %d\t", nUjian1[ctCounter2]);
	  printf(" %d\t", nUjian2[ctCounter2]);
	  printf("    %d\t\t\t", nUjianAkhir[ctCounter2]);
	  printf("%d\t", nMarkahAkhir[ctCounter2]);
	  printf("  %s\n", strStatus);
  }
	printf("\n\nJumlah Pelajar Yang Lulus: %d Orang\n", nJumlahLulus);
	printf("Jumlah Pelajar Yang Gagal: %d Orang\n", nJumlahGagal);

	printf("\nAdakah Anda Mahu Menyimpannya di Pelajar.txt (Y/N) ?: ");
	fflush(stdin);
	chrYes = getchar();

if (toupper(chrYes) == 'Y')
{
	fnCetakText();
	printf("\nMaklumat Telah Disimpan di Pelajar.txt\n");
}
else
{
	printf("Terima Kasih\n");
}
	printf("\nAdakah Anda Meneruskan Operasi (Y/N) ?: ");
	fflush(stdin);
	chrYes = getchar();

if (toupper(chrYes) == 'Y')
{
	// clrscr();
	main();
}
else
{
	printf("Terima Kasih\n");
}

}

void fnCetakText()
{
	txtOut = fopen("Pelajar.txt", "w");
	fprintf(txtOut, "\n============================================================================\n");
	fprintf(txtOut, "Pelajar   \t U1\t U2\t Ujian Akhir\t Markah Akhir\t Status\n");
	fprintf(txtOut, "============================================================================\n");

 for (ctCounter2 = 0; ctCounter2 < 15; ctCounter2++)
  {
	 if (nMarkahAkhir[ctCounter2] >= 50)
	 {
	   strcpy(strStatus, "Lulus");
	   nJumlahLulus++;
	 }

	 else
	 {
	  strcpy(strStatus, "Gagal");
	  nJumlahGagal++;
	 }
 
	  fprintf(txtOut, "Pelajar %d\t", ctCounter2+1);
	  fprintf(txtOut, " %d\t", nUjian1[ctCounter2]);
	  fprintf(txtOut, " %d\t", nUjian2[ctCounter2]);
	  fprintf(txtOut, "    %d\t\t\t", nUjianAkhir[ctCounter2]);
	  fprintf(txtOut, "%d\t", nMarkahAkhir[ctCounter2]);
	  fprintf(txtOut, "  %s\n", strStatus);
  }
	fprintf(txtOut, "\n\nJumlah Pelajar Yang Lulus: %d Orang\n", nJumlahLulus/2);
	fprintf(txtOut, "Jumlah Pelajar Yang Gagal: %d Orang\n", nJumlahGagal/2);
}
