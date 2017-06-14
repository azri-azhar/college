// Tugasan 2 - Soalan 2


#include <iostream.h>


class Banggunan                     
{              
      public:
             int bilangan_t, keluasan;
             void Papar_Banggunan();
             Banggunan(int, int);
             Banggunan() { }; //default constructor
};      
      

Banggunan::Banggunan(int tingkat, int keluasan_b)
{
      bilangan_t = tingkat;
      keluasan = keluasan_b;
}

void Banggunan::Papar_Banggunan()
{
      cout<<"Bilangan Tingkat: "<< bilangan_t << endl;
      cout<<"Keluasan: "<< keluasan << endl;
}


class Rumah:public Banggunan
{
      private:
              int bilangan_bilik;
              int bilangan_bmandi;
      public:
              Rumah(int, int, int, int);
              void Papar_Rumah();              
};


Rumah::Rumah(int tingkat_r, int keluasan_r, int b_bilik, int b_mandi)
{
      bilangan_t = tingkat_r;
      keluasan = keluasan_r;
      bilangan_bilik = b_bilik;
      bilangan_bmandi = b_mandi;
}    


void Rumah::Papar_Rumah()
{
     Papar_Banggunan();
     cout<<"Bilangan bilik: " <<bilangan_bilik << endl;
     cout<<"Bilangan bilik mandi: " <<bilangan_bmandi <<endl;
}
                         

class Pejabat:public Banggunan
{
      private:
              int bilangan_pemadam;
              int bilangan_telefon;
      public:
             Pejabat(int, int, int, int);
             void Papar_Pejabat();
};


Pejabat::Pejabat(int tingkat_p, int keluasan_p, int pemadam, int telefon) 
{
      bilangan_t = tingkat_p;
      keluasan = keluasan_p;
      bilangan_pemadam = pemadam;
      bilangan_telefon = telefon;     
}      

void Pejabat::Papar_Pejabat()
{
     Papar_Banggunan();
     cout<<"Bilangan pemadam api: " <<bilangan_pemadam<< endl;
     cout<<"Bilangan telefon: " <<bilangan_telefon<< endl;
}


int main()
{
      Banggunan WTC(110, 30000);
      Rumah OsamaLaden(1, 500, 3, 2);
      Pejabat GeorgeBush(5, 2000, 200, 100);
      
      cout<<"\nBanggunan" <<endl;
      cout<<"==========" <<endl;     
      WTC.Papar_Banggunan();

      cout<<"\nRumah" <<endl;
      cout<<"======" <<endl;     
      OsamaLaden.Papar_Rumah();
      
      cout<<"\nPejabat" <<endl;
      cout<<"========" <<endl;     
      GeorgeBush.Papar_Pejabat();
           
      return 0;
}
