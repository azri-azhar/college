(* Membuat Undian Untuk Penyanyi Yang Paling Popular *)

Program Azri_Penyayi;
Uses Crt;
Var Pilihan,jawapan,jawapan2:integer;

Procedure Menu;
Begin
 Clrscr;
 Writeln('- Mohamad Azri Bin Azhar');
 Writeln('- Orang Yang Suka Meniru Tanpa Kebenaran Adalah Orang Yang Sangat Jahat');
 Writeln;
 Writeln('=============================================');
 Writeln('- Pertandingan Penyanyi Wanita Paling Popular');
 Writeln('- Sila Buat Pilihan Yang Dikehendaki');
 Writeln('=============================================');
 Writeln;
 Writeln('1. Calon Yang Dipertandingkan.');
 Writeln('2. Keputusan.');
 Writeln('3. Keluar Dari Program Ini.');
 Writeln;
 Write('Pilihan:');
End;

Procedure Calon(var jawapan,jawapan2:integer);
 Var namacalon:integer;
     siti,paku:integer;
 begin
 Clrscr;
 Writeln('Calon-Calon Yang Dipertandingkan');
 Writeln('==================================');
 Writeln('1. Siti Nurhaliza');
 Writeln('2. Siti Paku Payung');
 Writeln;
 Write('Sila Buat Pilihan Anda:');
 Readln(namacalon);

 Case NamaCalon Of
 1: begin siti:=siti+1; jawapan:=siti; end;
 2: begin paku:=paku+1; jawapan2:=paku; end;
 end;
End;

Procedure Keputusan(jawapan,jawapan2:integer);
begin
clrscr;
If jawapan > jawapan2 Then
Writeln('Siti Nurhaliza Menang!!')
 Else
Writeln('Siti Paku Payung Menang!!');
Writeln;
Write('Tekan 3 Untuk Keluar Dari Program Atau 1 Untuk Ke Menu:');
readln(pilihan);
end;

Begin
 Pilihan:=10;
 While Pilihan <> 3 Do
  Begin
   Clrscr;
   Menu;
   Readln(Pilihan);

   Case Pilihan Of
   1: Calon(jawapan,jawapan2);
   2: Keputusan(jawapan,jawapan2);

  end;
  end;
End.
