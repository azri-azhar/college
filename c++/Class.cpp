/* Contoh ringkas penggunaan class dan object */

#include <iostream.h>
#include <stdlib.h>
#include <string.h>

class Pekerja
{
  public:
  void InputData();
  void KiraBonus();
  void Cetak();
  
  private:
   char strNama[30], strNoPekerja[30], strAlamat[30];
   float fGajiAsas, fKadarBonus, fBonusDiterima, fGajiBersih;
   int nTempoh;
};

class Buku
{
  public:
  void InputData();
  void KiraPotongan();
  void Cetak();
  
  private:
  char strISDN[30], strTajuk[30], strNamaPengarang[30],strPenerbit[30];
  float fHarga, fDiskaun, fHargaDiskaun;
  char strTahun[5];
};

class Kereta
{
  public:
  void InputData();
  void KiraPotongan();
  void Cetak();
  
  private:
  char strJenama[30], strModel[30], strNoPendaftaran[10];
  float fHargaAsal, fPotongan, fHarga;
};

  void Kereta::InputData()
  {
    cout<<"\n\n====================" << endl;
    cout<<"       Kereta" << endl;
    cout<<"====================" << endl;
    cout<<"\nMasukkan Jenama: ";
    cin.getline(strJenama, 30);
    cout<<"Masukkan Model: ";
    cin.getline(strModel, 30);
    cout<<"Masukkan No Pendaftaran: ";
    cin.getline(strNoPendaftaran, 10);
    cout<<"Masukkan Harga: ";
    cin>>fHargaAsal; 
   }
   
  void Kereta::KiraPotongan()
  {
    if (fHargaAsal > 40000)
     fPotongan = fHargaAsal * 0.25;
    else
     fPotongan = 0.0;
    
    fHarga = fHargaAsal - fPotongan;
  }
  
  void Kereta::Cetak()
  {
    cout<<"\n\nJenama: " <<strJenama <<endl;
    cout<<"Model: " <<strModel <<endl;
    cout<<"No Pendaftaran: " <<strNoPendaftaran <<endl;
    cout<<"Harga Asal: " <<fHargaAsal <<endl;
    cout<<"Harga Selepas Potongan: " <<fHarga  <<endl;
  }
  
  void Buku::InputData()
  {
    cout<<"\n\n====================" << endl;
    cout<<"        Buku" << endl;
    cout<<"====================" << endl;
    cout<<"\nMasukkan ISDN: " ;  
    cin.ignore(1); 
    cin.getline(strTajuk, 30);
    cout<<"Masukkan Nama Pengarang: ";
    cin.getline(strNamaPengarang, 30);
    cout<<"Masukkan Penerbit: ";
    cin.getline(strPenerbit, 30);
    cout<<"Masukkan Harga: ";
    cin>>fHarga;
    cout<<"Masukkan Tahun Diterbitkan: ";
    cin.getline(strTahun, 5);   
  }
  
  void Buku::KiraPotongan()
  {
    if (stricmp(strPenerbit, "Mc Graw Hill") == 0)
     fDiskaun = 0.10 * fHarga;
    else
     fDiskaun = 0.50 * fHarga;
    
    fHargaDiskaun = fHarga - fDiskaun;  
  }

  void Buku::Cetak()
  {
    cout<<"\n\nISDN: " <<strISDN <<endl;
    cout<<"Tajuk " <<strTajuk <<endl;
    cout<<"Nama Pengarang: " <<strNamaPengarang <<endl;
    cout<<"Penerbit: " <<strPenerbit <<endl;
    cout<<"Tahun Diterbitkan: " <<strTahun <<endl;
    cout<<"Harga: "<<fHarga <<endl;
    cout<<"Harga Selepas Diskaun: "<<fHargaDiskaun <<endl;
  }
    
  void Pekerja::InputData()
  {
    cout<<"\n\n====================" << endl;
    cout<<"       Pekerja" << endl;
    cout<<"====================" << endl; 
    cout<<"\nMasukkan Nama: ";
    cin.getline(strNama, 30);
    cout<<"Masukkan Nombor Pekerja: ";
    cin.getline(strNoPekerja, 30);
    cout<<"Masukkan Alamat: ";
    cin.getline(strAlamat, 30);
    cout<<"Masukkan Gaji Asas: ";
    cin>>fGajiAsas;   
    cout<<"Masukkan Tempoh Perkhidmatan: ";
    cin>>nTempoh;
  }
   
   void Pekerja::KiraBonus()
   {
    if (nTempoh < 1)
       fKadarBonus = 0;
    if ((nTempoh >= 2) && (nTempoh <= 3))
       fKadarBonus = 0.07;
    if ((nTempoh >= 4) && (nTempoh <= 6))
       fKadarBonus = 0.09;
    if ((nTempoh >= 7) && (nTempoh <= 10))
       fKadarBonus = 0.12;
    if (nTempoh > 10)
       fKadarBonus = 0.15;
    
    fBonusDiterima = fGajiAsas * fKadarBonus;
    fGajiBersih = fGajiAsas + fBonusDiterima;
   }    
    
   void Pekerja::Cetak()
   {
    cout<<"\n\nNama: " <<strNama <<endl;
    cout<<"No. Pekerja: " <<strNoPekerja <<endl;
    cout<<"Alamat: " <<strAlamat <<endl;
    cout<<"Gaji Asas: " <<fGajiAsas <<endl;
    cout<<"Tempoh Pekerjaan: " <<nTempoh <<" Tahun" <<endl;
    cout<<"Bonus Diterima: "<<fBonusDiterima <<endl;
    cout<<"Gaji Bersih: "<<fGajiBersih <<endl;
    }
    
int main()
{
    Pekerja Zahrah;
    Buku Pengaturcaraan;
    Kereta BMW;
                
    Zahrah.InputData();
    Zahrah.KiraBonus();
    Zahrah.Cetak();
    
    Pengaturcaraan.InputData();
    Pengaturcaraan.KiraPotongan();
    Pengaturcaraan.Cetak();
                
    BMW.InputData();
    BMW.KiraPotongan();
    BMW.Cetak();

      cout<<"-----------------------------" <<endl;      
      system("PAUSE");
      return 0;
}
