(* Soalan1: Tuliskan Aturcara Yang Am Untuk Menyelesaikan Masalah Mencari
Purata 2 Nombor *)

Program Azri_Soalan1;

Uses Crt;

Var
    nombor1, nombor2,jumlah:integer;
    purata:real;

Begin
     Clrscr;

     Write('Masukkan nombor pertama:');
     Readln(nombor1);
     Write('Masukkan nombor kedua:');
     Readln(nombor2);

     jumlah:=nombor1+nombor2;
     purata:=(jumlah/2);

     Write('Purata = ', purata:4:2);
     readln;
End.
