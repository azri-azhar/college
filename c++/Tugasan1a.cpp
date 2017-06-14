/* Satu invoice mengandungi kesemua maklumat yang diperlukan untuk memproses
satu invoice. Anggapkan invoice tersebut mesti mempunyai no id barang, nama
barang, kuantiti hendak ditempah, harga seunit, jumlah kasar, kadar cukai atas
jualan, jumlah cukai atas jualan, kos penghantaran dan jumlah bersih. Jumlah
kasar perlu dikira dengan mendarabkan harga seunit dan kuantiti. Jumlah cukai
atas jualan terhadap barangan perlu dikira dengan mendarabkan kadar cukai atas
jualan dengan jumlah kasar. Jumlah bersih perlu dikira dengan mencampurkan 
jumlah kasar, jumlah cukai atas jualan dan kos penghantaran. Seterusnya data-data
invoice perlu dicetakkan seperti mana didalam format dibawah. */

#include <iostream>
#include <cstdlib>

using namespace std;

class CInvoice
{
      private:
       int iKuantiti;
       double dHarga, dJumlahKasar, dKadarCukai, dJumlahCukai, dKosHantar;
       double dJumlahBersih;
       char strID[10], strNamaBarang[30];
      
      public:
       void InputData();
       void ProsesData();
       void CetakData();     
};      

void CInvoice::InputData()
{
     cout<<"\nMasukkan Nama Barang: ";
     cin.getline(strNamaBarang, 30);
     
     cout<<"\nMasukkan ID Barang: ";
     cin.getline(strID, 10);
     
     cout<<"\nMasukkan Harga Seunit: ";
     cin>>dHarga;
     
     cout<<"\nMasukkan Kuantiti: ";
     cin>>iKuantiti;
     
     cout<<"\nMasukkan Kos Penghantaran: " ;
     cin>>dKosHantar;     
     
     cout<<"\nMasukkan Kadar Cukai: " ;
     cin>>dKadarCukai;
}

void CInvoice::ProsesData()
{
     dJumlahKasar = dHarga * iKuantiti;
     dJumlahCukai = dKadarCukai * dJumlahKasar;
     dJumlahBersih = dJumlahKasar + dJumlahCukai + dKosHantar;
}

void CInvoice::CetakData()
{
     system("cls");
     cout<<"\n\n\t\t\t\t   ***Invoice***\n\n\n";
     cout<<"Id Item\t\t NamaItem\t Harga Seunit\t Kuantiti\t JumlahKasar\n";
     cout<<"----------------------------------------------------------------"<<
     "----------------\n\n";
     
     cout<<strID<<"\t\t";
     cout<<strNamaBarang<<"\t\t";
     cout <<dHarga<<"\t\t";
     cout<<iKuantiti<<"\t\t";
     cout<<dJumlahKasar<<"\t\n\n";
     
     cout<<"Cukai Jualan: "<<dJumlahCukai<<endl;
     cout<<"Kos Penghantaran: "<<dKosHantar<<endl;
     cout<<"Jumlah Bersih: "<<dJumlahBersih<<"\n\n\n\n";   
}

int main()
{
         CInvoice Barang;

         Barang.InputData();
         Barang.ProsesData();
         Barang.CetakData();
         
      system("PAUSE");
      return 0;
}
