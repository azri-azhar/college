/* November 2000 Soalan 6 - Berdasarkan rajah kelas dan rajah instance di 
bawah. Bina satu aturcara lengkap (Katakan pai = 3.142. Formula untuk mengira 
luas adalah pai*j*j dan lilitan adalah 2*pai*j) */

#include <iostream.h>
#include <stdlib.h>

#define PAI 3.142


class Bulatan
{
      private:
              double jejari;
      public:
             Bulatan();
             void KiraLuas();
             void KiraLilitan();
};

Bulatan::Bulatan()
{
      cout<<"Masukkan nilai jejari: ";
      cin>>jejari;
}

void Bulatan::KiraLuas()
{
      double luas;
      luas =  PAI * jejari * jejari;
      
      cout<<"\nLuas bagi bulatan berjejari "<<jejari <<" cm ";
      cout<<"ialah: " <<luas <<" cm persegi" <<endl;
}

void Bulatan::KiraLilitan()
{
      double lilitan;
      lilitan =  2 * PAI * jejari;
      
      cout<<"\nLilitan bagi bulatan berjejari "<<jejari <<" cm ";
      cout<<"ialah: " <<lilitan <<" cm" <<endl;
}

int main()
{
      Bulatan Bulatan1, Bulatan2;
      
      Bulatan1.KiraLuas();
      Bulatan1.KiraLilitan();
      
      Bulatan2.KiraLuas();
      
      system("PAUSE");
      return 0;
}
