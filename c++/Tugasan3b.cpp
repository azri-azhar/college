/* Mei 2000 Soalan 1 - Aturcara JamRandik mudah menggunakan time.h */

#include <iostream.h>
#include <stdlib.h>
#include <time.h>


class CJamRandik
{
     private:
             clock_t start;
     public:
             void fnMula();
             void fnBerhenti();
};

void CJamRandik::fnMula()
{
     start = clock();
}

void CJamRandik::fnBerhenti()
{
     clock_t total = clock()-start;
     system("CLS");
     cout<<"\n\n==========================" <<endl;
     cout<<"Jumlah detik: "<<total <<" detik" <<endl;
     cout<<"Dalam saat: "<< double(total/CLK_TCK) <<" saat" <<endl;
     cout<<"==========================" <<endl;
}

int main()
{ 
    char chrPilihan;      

    CJamRandik dummy;
      
    while(1)
     {      
       cout<<"\n\nSenarai pilihan anda: " <<endl <<endl;
       cout<<"1. Reset dan Mula jam randik" <<endl;
       cout<<"2. Hentikan jam randik dan Papar" <<endl;
       cout<<"3. Keluar" <<endl <<endl;
       cout<<"Nombor pilihan anda: ";
       cin>>chrPilihan;
      
       if (chrPilihan == '1')  
        {
         dummy.fnMula();

         system("CLS");
         cout<<"\n=========================================================="; 
         cout<<"===" <<endl;
         cout<<"Jam randik telah dimulakan. Tekan 2 untuk berhenti dan papar\n";
         cout<<"==========================================================";
         cout<<"==="; 
        }
            
       else if (chrPilihan == '2')  
           dummy.fnBerhenti();
            
       else if (chrPilihan == '3')
           exit(0);                                 
         
       else
          {
           system("CLS");
           cout<<"\n=============\n"; 
           cout<<"Pilihan Salah";
           cout<<"\n=============";
          }                                                                                                                                                                                           
      }
      
    return 0;
    system("PAUSE");
}
