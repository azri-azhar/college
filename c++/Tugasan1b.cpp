/* Pelajar mempunyai data sepertimana berikut: nama, noic, markah ujian1, markah
ujian 2, dan markah peperiksaan akhir. Markah penuh bagi setiap ujian ialah 25
dan markah penuh bagi peperiksaan akhir ialah 50. Markah lulus bagi setiap ujian
ialah 10 dan markah lulus bagi peperiksaan akhir ialah 25. Ketiga-tiga markah
ini iaitu ujian 1, ujian 2, dan peperiksaan akhir akan dicampurkan menjadi
markah akhir. Kategori 'L' akan diberi sekiranya mendapat markah sekurang-
kurangnya 40 dari markah akhir. Sekiranya markah kurang dari 40, status 'G' akan
diberi. Data-data bagi nama, noic, markah ujian1, markah ujian2 dan peperiksaan
akhir akan diinputkan melalui peranti input. Seterusnya perkara berikut perlu
ditentukan:

1. Paparkan nama dan noic pelajar yang lulus ujian 1.
2. Paparkan nama dan noic pelajar yang lulus ujian 2.
3. Paparkan nama dan noic pelajar yang lulus peperiksaan akhir.
4. Paparkan maklumat lengkap yang mengandungi nama, noic, markah peperiksaan
akhir dan gred dimana penentuan gred adalah berdasarkan, (D: 0-39, C: 40-59, 
B: 60-79, A: 80-100)   */


#include <iostream.h>
#include <stdlib.h>

class CPelajar
{
      private:
       char strNama[30], strIC[20], chrGred;
       int iMarkah1, iMarkah2, iPeperiksaan, iMarkahAkhir;
       
      public:
       void InputData();
       void TentuGred();
       void CetakData();
};

void CPelajar::InputData()
{
     cout<<"\nMasukkan Nama: ";
     cin.getline(strNama, 30);
     
     cout<<"Masukkan No. IC: ";
     cin.getline(strIC, 20);
     
     //do..while Digunakan Bagi Memastikan Pengguna Memasukkan Markah Dalam
     //Julat Yang Betul. Markah Tersebut Akan Diminta Semula Sehingga Pengguna
     //Memasukkannya Dalam Julat Yang Betul.
     
     do {
      cout<<"Masukkan Markah Ujian 1: ";
      cin>>iMarkah1; 
      
       if (iMarkah1>25)
       {
       cout<<"\nError - Sila Masukkan Semula!\n\n";
       continue;
       }
     }
     while(iMarkah1>25);
     
     do {
      cout<<"Masukkan Markah Ujian 2: ";
      cin>>iMarkah2;    
      
        if (iMarkah2>25)
        {
        cout<<"\nError - Sila Masukkan Semula!\n\n";
        continue;
        }
      }    
      while(iMarkah2>25);
     
     do {
      cout<<"Masukkan Markah Peperiksaan Akhir: ";
      cin>>iPeperiksaan;
       if (iMarkah2>25)
        {
        cout<<"\nError - Sila Masukkan Semula!\n\n";
        continue;
        }
      }
     while(iPeperiksaan>50);
     
     system("cls");
}

void CPelajar::TentuGred()
{
     iMarkahAkhir = iMarkah1 + iMarkah2 + iPeperiksaan;
     
     if ((iMarkahAkhir >=0) && (iMarkahAkhir <= 39)) 
     chrGred = 'D';
    
     if ((iMarkahAkhir >=40) && (iMarkahAkhir <= 59)) 
     chrGred = 'C';
     
     if ((iMarkahAkhir >=60) && (iMarkahAkhir <= 79)) 
     chrGred = 'B';
     
     if ((iMarkahAkhir >=80) && (iMarkahAkhir <= 100)) 
     chrGred = 'A';
}

void CPelajar::CetakData()
{
    //Cetak Maklumat Pelajar Yang Lulus Ujian 1
     if (iMarkah1 >= 10) 
     {
       cout<<"\n------------------------------------------\n";
       cout<<"Pelajar Yang Lulus Ujian 1: \n\n";
       cout<<"Nama: " <<strNama <<endl;
       cout<<"No IC: " <<strIC <<endl;
     }
     else
         cout<<"\nTiada Pelajar Yang Lulus Ujian 1!\n";
     
     //Cetak Maklumat Pelajar Yang Lulus Ujian 2
     if (iMarkah2 >= 10) 
     {
       cout<<"------------------------------------------\n";
       cout<<"Pelajar Yang Lulus Ujian 2: \n\n";
       cout<<"Nama: " <<strNama <<endl;
       cout<<"No IC: " <<strIC <<endl;
     }
     else
         cout<<"\nTiada Pelajar Yang Lulus Ujian 2!\n";
     
     //Cetak Maklumat Pelajar Yang Lulus Peperiksaan Akhir
     if (iMarkah1 >= 25) 
     {
       cout<<"------------------------------------------\n";
       cout<<"Pelajar Yang Lulus Peperiksaan Akhir: \n\n";
       cout<<"Nama: " <<strNama <<endl;
       cout<<"No IC: " <<strIC <<endl;
     }
     else
         cout<<"\nTiada Pelajar Yang Lulus Peperiksaan Akhir!\n";
     
     //Paparkan Maklumat Lengkap Pelajar, Markah Akhir dan Gred.
     cout<<"------------------------------------------\n";
     cout<<"Maklumat Lengkap Pelajar:\n\n";
     cout<<"Nama: " <<strNama <<endl;
     cout<<"No IC: " <<strIC <<endl;
     cout<<"Markah Akhir: " <<iMarkahAkhir <<endl;
     cout<<"Gred: " <<chrGred <<endl<<endl;
}
                        
int main()
{
      int iBil = 0, ctInstance;
           
      cout<<"Aturcara Mengira Markah Pelajar\n";
      cout<<"-------------------------------\n";
     
      //Untuk Menentukan Bilangan Instance
      cout<<"\nBerapa Ramaikah Bilangan Pelajar ?: ";
      cin>>iBil;
      
      CPelajar P[iBil];
      
      for (ctInstance = 0; ctInstance < iBil; ctInstance++)
      { 
       cin.ignore(1);
       P[ctInstance].InputData();
       P[ctInstance].TentuGred();
       P[ctInstance].CetakData();
       system("PAUSE");
       system("cls");
      }
      
return 0;
}
