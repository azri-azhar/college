/* Kira tambang yang diperolehi dimana kadar tambang seorang ialah RM 25
dan bilangan penumpang merupakan senarai parameter bagi fungsi tersebut.
seterusnya pulangkan nilai jumlah tambang tersebut */

#include <iostream.h>
#include <stdlib.h>

#define TAMBANG 25

int fnTambang(int);

int main()
{
  int nJumlah = 0, nBilangan;
  
  cout<<"Masukkan bilangan penumpang:";
  cin>>nBilangan;
  
  nJumlah = fnTambang(nBilangan);
  
  cout<<"\nJumlah tambang yang diperoleh ialah: " <<nJumlah <<endl;
  
  system("PAUSE");
  
  return 0;        
}

int fnTambang(int nBilangan)
{
 int nJumlah = 0;
 
 nJumlah = nBilangan * TAMBANG;
 return (nJumlah);
}
