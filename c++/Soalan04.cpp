/* Dengan menggunakan gelung for, while dan do..while, cetakkan satu siri
sifir dari julat 1 hingga 12 bagi satu nombor yang diinputkan oleh pengguna */

#include <iostream.h>
#include <stdlib.h>

void main()
{
	int nNombor, nGandaan = 1, nBil;

	cout<<"Masukkan suatu nombor: ";
    cin>>nNombor;

	for (nBil= 0; nBil <= 12; nBil++)
	{
		nGandaan = nBil*nNombor;
        
        cout<<nBil <<" x " <<nNombor <<" = " <<nGandaan <<endl;
	}
	system("PAUSE");
}
