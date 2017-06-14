/* Mei 2001 Soalan 2 - Permodelan objek di bawah menunjukkan hubungan kelas
pelajar dan kelas matapelajaran yang diambil. Tulis satu aturcara lengkap untuk
memaparkan keputusan ujian 2 matapelajaran yang diambil oleh seorang pelajar.
(Kekangan: Keputusan markah melebihi dan sama dengan 50 adalah lulus manakala
markah kurang daripada 50 adalah gagal) */

#include <iostream.h>
#include <stdlib.h>


class Pelajar
{
      private:
              char strNama[30];
              char strMatrik[30];
      public:
              int iBilMataPel;
              void fnInputData();
};

void Pelajar::fnInputData()
{
     cout<<"\nTaip nama anda: ";
     cin.getline(strNama, 30);
     cout<<"Taip nombor matriks anda: ";
     cin.getline(strMatrik, 30);
     cout<<"Taip bilangan matapelajaran yang di ambil: ";
     cin>>iBilMataPel;
}

class MataPelajaran
{
     private:
             char strNama[30];
     public: 
             int iMarkah;
             void fnInputData();
};

void MataPelajaran::fnInputData()
{
      cout<<"\nTaip nama matapelajaran anda: ";
      cin.ignore(1);
      cin.getline(strNama, 30);
      cout<<"Taip markah ujian " <<strNama <<" anda: ";
      cin>>iMarkah;
}

class Keputusan
{
      public:
             Keputusan(int);
};

Keputusan::Keputusan(int Markah)
{
     if (Markah >=50)
        cout<<"Keputusan ujian anda Lulus\n\n";
     else
        cout<<"Keputusan ujian anda Gagal\n\n";
}

int main()
{
      int i = 0; 
      
      Pelajar Ahmad;    
      MataPelajaran dummy;
       
      Ahmad.fnInputData();
      
      for (i = 0; i < Ahmad.iBilMataPel; i++)
      {
          dummy.fnInputData();
          Keputusan dummy2(dummy.iMarkah);    
      }  


      system("PAUSE");
      
      return 0;
}
