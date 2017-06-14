(* Soalan2: Tuliskan Aturcara Untuk Mencari Purata Bagi Sebarang Bilangan
N Nombor *)

Program Azri_Soalan2;
Uses crt;

Var
   Nombor,N,bil,jumlah:integer;
   Purata:real;

Begin

Clrscr;

jumlah:=0;
bil:=0;

Write('Masukkan Jumlah Nombor (N): ');
Readln(N);

Repeat
Write('Masukkan Nombor: ');
Readln(Nombor);
bil:=bil+1;
jumlah:=jumlah+Nombor;
purata:=jumlah/N;

until bil=N;
write('Purata = ',purata:4:2);

Readln;
End.
