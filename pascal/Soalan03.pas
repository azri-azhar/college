(* Soalan3: Tuliskan Aturcara Untuk Mengira Luas Sesuatu Bulatan Dan
Outputkan ke text C:\luas.txt *)

Program Azri_Soalan3;

Uses Crt;

Const
      pai=3.142;

Var
    jejari:integer;
    jawapan:real;
    Outfile:text;

Begin
     Clrscr;

     Write('Masukkan panjang jejari:');
     Readln(jejari);

     jawapan:= pai*(jejari*jejari);

     Assign(outfile, 'C:\luas.txt');
     rewrite(outfile);

     Writeln;
     Writeln(outfile, 'OUTPUT UNTUK SOALAN 3');
     Writeln(outfile, '=====================');
     Writeln(outfile, ' ');
     Writeln(outfile, 'Jejari = ' ,jejari);
     Write(outfile, 'Luas Bulatan = ');
     Write(outfile, jawapan:4:2);
     Close(outfile);

     Writeln('Luas Bulatan = ',jawapan:4:2);
     Writeln;
     Writeln('Sila lihat fail C:\luas.txt');

     Readln;

End.
