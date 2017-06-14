/* April 2000 (final) Soalan 6 - No description available */

#include <iostream.h>
#include <stdlib.h>
#include <string.h>



class Pekerja
{
      protected:
                char strNama[30];
                int iTahunMasuk;
                double fGaji;
      public:
                Pekerja() {};
                Pekerja(char Nama[30], int iTahunMasuk, double Gaji);
                void fnCetak();
};

Pekerja::Pekerja(char Nama[30], int Tahun, double Gaji)
{      
      strcpy(strNama, Nama);
      iTahunMasuk = Tahun;
      fGaji = Gaji;
}

void Pekerja::fnCetak()
{
     cout<<"\n-----------------" <<endl;
     cout<<"\nNama: " <<strNama <<endl;
     cout<<"Tahun masuk: " <<iTahunMasuk <<endl;
     cout<<"Gaji: RM "  <<fGaji <<endl;
}

class Pengaturcara:public Pekerja
{
     private:
             double fBonus; 
     public:
             Pengaturcara();
             void fnKiraBonus();
             void fnKiraBayaran();
};

Pengaturcara::Pengaturcara()
{
     cout<<"\n-----------------" <<endl;
     cout<<"\nMasukkan nama: ";
     cin.getline(strNama, 30);
     cout<<"Masukkan tahun masuk: ";
     cin>>iTahunMasuk;
     cout<<"Masukkan gaji: ";                                
     cin>>fGaji;
}

void Pengaturcara::fnKiraBonus()
{
     if ( (2001 - iTahunMasuk) > 2 )
        fBonus = 200.0;
     else
        fBonus = 0.0;
}        

void Pengaturcara::fnKiraBayaran()
{
     double fBayaranPenuh;
     fBayaranPenuh = fGaji + fBonus;
     
     cout<<"Jumlah bonus: RM " <<fBonus <<endl;
     cout<<"Bayaran gaji penuh ialah: RM " <<fBayaranPenuh <<endl; 
     cout<<"\n-----------------" <<endl <<endl;
}

int main()
{
      Pekerja Kuli("George Bush", 1998, 1000);
      Kuli.fnCetak();
      
      Pengaturcara Azri;
      Azri.fnCetak();
      Azri.fnKiraBonus();
      Azri.fnKiraBayaran();
      
      system("PAUSE");
      return 0;
}
