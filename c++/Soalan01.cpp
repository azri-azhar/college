/* Inputkan dua nombor dan satu pengoperasian, seterusnya laksanakan
operasi yang bersesuaian berdasarkan pengoperasian yang diinputkan oleh
pengguna seperti mana jadual dibawah. Contoh: Pengguna inputkan 10, 25 dan
'*', hasil yang akan dipaparkan ialah 250 */

#include <iostream.h>
#include <stdlib.h>

int main()
{
 int nNom1, nNom2, nHasil = 0;
 char chOperasi, chPilihan;
 
    cout<<"Masukkan Nombor pertama: ";
    cin>>nNom1;
    cout<<"Masukkan Nombor kedua: ";
    cin>>nNom2;
    cout<<"Masukkan Pengoperasi: ";
    cin>>chOperasi;
    
    switch (chOperasi)
    {
      case '+':
           nHasil = nNom1 + nNom2;
           break;
      case '-':
           nHasil = nNom1 - nNom2;
           break;
      case '*':
           nHasil = nNom1 * nNom2;
           break;
      case '/':
           nHasil = nNom1 + nNom2;
           break;
      default:
            cout<<"Error";
            break;
    }
  
    cout<<"\nHasilnya ialah: " <<nHasil <<endl;
    system("PAUSE");
      
  return 0;        
}
