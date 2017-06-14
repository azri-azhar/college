(* Contoh Penggunaan Procedure Untuk Menambah Sebarang 2 nombor *)

Program Azri_Procedure;

Uses Crt;

Var
   nombor1,nombor2,jwp:integer;

Procedure MenambahNombor(n1,n2:integer; Var jawapan:integer);
Begin
  jawapan:=n1+n2;
End;

Begin
 Clrscr;
 Write('Masukkan Nombor Pertama:');
 Readln(nombor1);
 Write('Masukkan Nombor Kedua:');
 Readln(nombor2);

 MenambahNombor(nombor1,nombor2,jwp);

 Write(jwp);
 Readln;
End.
