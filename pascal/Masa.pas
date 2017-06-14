(* Tulis Satu Aturcara Yang Akan Menunjukkan Sistem Menu Yang Mudah Yang
Membolehkan Pengguna Memilih Untuk: 1. Menukar Saat ke Jam, Minit Dan Saat;
2. Menukar Sistem Masa 24 Jam Ke Sistem AM/PM; 3. Keluar Dari Program *)

Program Azri_Masa;

Uses Crt;

Var Pilihan:integer;

Procedure Menu;
Begin
 Clrscr;
 Writeln('Sila Buat Pilihan Yang Dikehendaki');
 Writeln('==================================');
 Writeln('1. Menukar Saat Ke Jam, Minit Dan Saat.');
 Writeln('2. Menukar Sistem Masa 24 Jam Ke Sistem Am/Pm.');
 Writeln('3. Keluar Dari Program Ini.');
 Writeln;
 Write('Pilihan:');
End;


Procedure Saat;
Var
 jumlahsaat,jam,minit,saat,temp:longint;
Begin
 Clrscr;
 Write('Masukkan Jumlah Saat Yang Hendak Ditukarkan:');
 Readln(jumlahsaat);

 temp:=jumlahsaat div  60;
 jam:=temp div 60;
 minit:=temp mod 60;
 saat:=jumlahsaat mod 60;

 Writeln;
 Writeln(jumlahsaat, ' Saat Adalah Bersamaan Dengan ',jam, ' jam ',minit,
 ' minit ' ,saat, ' Saat ');
 Writeln;
 Write('Sila Tekan ENTER Untuk Teruskan');
 Readln;
End;


Procedure Jam;
Var
 jam,minit:integer;
 meridian:string;
Begin
 Clrscr;
 Write('Masukkan Nilai Jam Dalam Sistem Waktu 24 Jam:');
 Readln(jam);
 Write('Masukkan Nilai Minit Dalam Sistem Waktu 24 Jam:');
 Readln(minit);

 If jam >= 12 Then
  Begin
  meridian:='PM';
  jam:=jam-12
  End
 Else
  meridian:='AM';
  If jam=0 Then
  jam:=12;
  Writeln;
  Write('Pukul ');
  Write(jam);
  Write(':');
 If minit < 10 Then
  Write('0');
  Write(minit,' ',meridian);

Writeln;
Writeln;
Write('Sila Tekan ENTER Untuk Teruskan');
Readln;
End;


Begin
 Pilihan:=10;

 While Pilihan <> 3 Do
  Begin
   Clrscr;
   Menu;
   Readln(Pilihan);

   Case Pilihan Of
   1: Saat;
   2: Jam;

  End;
End;
End.
