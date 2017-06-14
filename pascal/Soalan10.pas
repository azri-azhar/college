(*  Soalan10: Tuliskan Satu Aturcara Untuk Membilang Berapa Nombor-Nombor
Yang Lebih Besar Dari Nombor Pertama Di Dalam Satu Senarai Input Seperti
Di Dalam Soalan (9) Di Atas  *)


Program Azri_Soalan10;

Uses Crt;

Var
   n1,n2,jumlah:integer;

Begin
     Clrscr;

     Write('Masukkan Nombor:');
     readln(n1);

Repeat
      Write('Masukkan Nombor:');
      readln(n2);

      if n1 > n2 then
      jumlah:=jumlah+1;

Until n2=123;  (*123 adalah nombor penutup*)

Writeln;

Write('Di Dalam Senarai Nombor Di Atas, Nombor ');
Write(n1, ' lebih besar sebanyak ', jumlah , ' kali');
Readln;

end.
