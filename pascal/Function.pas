(* Contoh Penggunaan Function Untuk Menambah Sebarang 2 nombor *)

Program Azri_Function;

Var
  nombor1,nombor2:integer;
  jwpn:integer;

Function MenambahDuaNombor(pertama,kedua:integer):integer;
  Begin
   MenambahDuaNombor:=pertama+kedua;
  End;

Begin
 Write('Masukkan Nombor Pertama:');
 Readln(nombor1);
 Write('Masukkan Nombor Kedua:');
 Readln(nombor2);

 Jwpn:= MenambahDuaNombor(nombor1,nombor2);
 Write('Jawapannya Ialah:', jwpn);
 Readln;

End.
