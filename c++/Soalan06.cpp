/* a) Tentukan nombor terbesar bagi dua nombor yang merupakan senarai parameter
bagi fungsi tersebut. Seterusnya pulangkan nilai terbesar tersebut.

   b) Cipta satu fungsi untuk meminta input data dua nombor dari pengguna. 
Seterusnya panggil fungsi di(a) dengan menghantar dua nilai yang telah
diinputkan. Cetakkan nilai tersbesar di dalam fungsi ini */

#include <iostream.h>
#include <stdlib.h>

void fnInput();
int fnPerbandingan(int, int);

int main()
{
 fnInput();  
}

void fnInput()
{
 int nNom1, nNom2, nTerbesar;

    cout<<"Masukkan Nombor pertama: ";
    cin>>nNom1;
    cout<<"Masukkan Nombor kedua: ";
    cin>>nNom2;
    
    nTerbesar = fnPerbandingan(nNom1, nNom2);
    
    cout<<"\nNombor yang terbesar ialah: " <<nTerbesar << endl;
    
    system("PAUSE");
}

int fnPerbandingan(int a, int b)
{
 if (a > b)
  return a;
 else
  return b;
}
