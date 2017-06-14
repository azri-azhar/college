(* Mencari Hasil Kuasa Sebarang Nombor, X^Y *)

Program Azri_Recursive;

Uses Crt;

Var a,b,jawapan:integer;

Function Kuasa(R,N:integer):integer;
Begin
 If N < 1 Then
  Kuasa:=1
Else
 Kuasa:=R*kuasa(R,n-1);
End;

Begin
 Clrscr;
 Write('Masukkan Nombor:');
 Readln(a);
 Write('Kuasa Berapa:');
 Readln(b);
 jawapan:=kuasa(a,b);
 Writeln;
 Writeln('Jawapannya ialah ', jawapan);
 Readln;
End.
