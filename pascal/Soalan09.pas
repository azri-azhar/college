(* Soalan9: Tuliskan Satu Aturcara Yang Terperinci Untuk Membilang Berapa
Kali Nombor Pertama Di Dalam Satu Senarai Nombor Timbul. Contohnya, Input:
3 8 7 1 3 3 0, Output: Nombor 3 Muncul 3 Kali. Pastikan Aturcara Anda
Memeriksa Keadaan Tiada Data Yang Diberikan Dengan Mengeluarkan Mesej Yang
Sepatutnya. Gunakan Satu nombor Penutup (Yang Bukan Data) Sebagai Pengakhir
Senarai Nombor Input *)


Program Azri_Soalan9;

Uses Crt;

Var
   n1,n2,jumlah:integer;

Begin
     Clrscr;
     jumlah:=0;

     write('Masukkan Nombor:');
     readln(n1);

     While n2 <> 123 Do  (* 123 adalah nombor penutup *)
     Begin
         Write('Masukkan Nombor:');
         readln(n2);

         if n1 = n2 then
         jumlah:=jumlah+1;
     End;

Write('Nombor ',n1, ' muncul ', jumlah+1 , ' kali');
(* Jumlah ditambah dengan satu supaya nilai n1 juga diambil dikira,
kalau tak faham, semak soalan dengan teliti *)

Readln;

End.
