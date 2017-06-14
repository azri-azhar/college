// Tugasan 2 - Soalan 1


#include <iostream.h>


class Kenderaan
{
      public:
            int bil_roda, jarak;
          
            Kenderaan(int, int);
            Kenderaan() { };  // Default Constructor
            ~Kenderaan() { cout<<"Destructing Kenderaan\n"; }
            void Papar_k();
};

      
Kenderaan::Kenderaan(int w, int r)
{ bil_roda = w; jarak = r; }


void Kenderaan::Papar_k()
{
     cout<<"Roda: " <<bil_roda <<" Biji" <<endl;
     cout<<"Jarak: "<<jarak <<" Km" <<endl;
}   


class Kereta:public Kenderaan
{
      int penumpang;
      public:
            Kereta(int, int, int);
            ~Kereta() { cout<<"Destructing Kerata\n"; }
            void papar();
};


Kereta::Kereta(int bil_penumpang, int roda, int jauh)
{
      bil_roda = roda;
      jarak = jauh;    
      penumpang = bil_penumpang;         
}


void Kereta::papar()
{
     Papar_k();
     cout<<"Penumpang: " <<penumpang <<" Orang" <<endl <<endl;
}


class Trak:public Kenderaan
{
      int muatan;
      public:
             Trak(int, int, int);
             ~Trak() { cout<<"Destructing Trak\n"; }
             void papar();
};


Trak::Trak(int kandungan, int roda, int jauh)
{
      bil_roda = roda;
      jarak = jauh;   
      muatan = kandungan;
}


void Trak::papar()
{
     Papar_k();
     cout<<"Muatan: " <<muatan <<" Kg" <<endl <<endl;
}
                
      
int main()
{
      Kereta Proton(5, 4, 500);
      Trak Trak1(3000, 12, 1200);
      
      cout<<"Kereta " <<endl;
      cout<<"=======" <<endl;
      Proton.papar();
      cout<<"Trak " <<endl;
      cout<<"======" <<endl;
      Trak1.papar();
      
      return 0;
}
