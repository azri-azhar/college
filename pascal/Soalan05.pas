(* Soalan5: Tuliskan Aturcara Untuk Mengira Isipadu Kiub *)

Program Azri_Soalan5;

Uses Crt;

Var
   Panjang,lebar,tinggi,jawapan:longint;

Begin
     Clrscr;
     Write('Masukkan Panjang:');
     Readln(panjang);
     Write('Masukkan Lebar:');
     Readln(lebar);
     Write('Masukkan Tinggi:');
     Readln(tinggi);

     jawapan:=panjang*lebar*tinggi;

     Write('Jawapannya ialah:');
     Write(jawapan);

     Readln;

End.
