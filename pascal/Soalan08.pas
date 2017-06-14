(* Soalan8: Anda Mungkin Pernah Terjumpa Dengan Rumus Matematik Berikut:
 X=Jumlah 1/i= 1 + 1/2 + 1/3 +.....1(1/n) + (1/n). Tuliskan Satu Aturcara
 Untuk Mencari Nilai X Bagi Sebarang Nilai N. *)


Program Azri_Soalan8;

Uses Crt;

Var
    N,bil:integer;
    Jumlah:real;

Begin
     Clrscr;

     bil:=0;
     Jumlah:=0;

     Write('Masukkan Nilai Nombor: ');
     Readln(n);

Repeat
     bil:=bil+1;
     Jumlah:=Jumlah+(1/bil);

Until bil=n;

Writeln(Jumlah:4:2);
Readln;

End.
