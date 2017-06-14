(* Mencari Hasil Kuasa Sebarang Nombor *)

Program Azri_Kuasa;

Uses Crt;

Var nombor,NomborKuasa:integer;
    jawapan:real;

Function Kuasa(number, exponent: integer): real;
Begin
 Kuasa := Exp(Exponent*Ln(Number));
End;

Begin
 Clrscr;
 Write('Masukkan Nombor Integer:');
 Readln(nombor);
 Write('Kuasa Berapa?:');
 Readln(NomborKuasa);
 Jawapan:=Kuasa(nombor,NomborKuasa);
 Writeln;
 Writeln('Jawapannya ialah ' , jawapan:4:0);
 Readln;
End.
