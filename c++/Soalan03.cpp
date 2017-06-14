/* Inputkan dua nombor dan satu pengoperasian, seterusnya laksanakan
operasi yang bersesuaian berdasarkan pengoperasian yang diinputkan oleh
pengguna seperti mana jadual dibawah. Contoh: Pengguna inputkan 10, 25 dan
'*', hasil yang akan dipaparkan ialah 250. Gunakan gelung do..while supaya 
ianya dapat dilaksanakan berulangkali bergantung kepada input pengguna */

#include <iostream.h>
#include <ctype.h>

int main()
{
 int nNom1, nNom2, nHasil = 0;
 char chOperasi, chPilihan;
 
 do
  {
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
    cout<<"\nAdakah anda mahu meneruskan aturcara ini? [Y/N]: ";
    cin>>chPilihan;
  
  } while (toupper(chPilihan) == 'Y');  
  
  return 0;        
}
