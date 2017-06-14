(* Soalan7: Anda Diberikan Senarai Nama Pelajar Dan Anda Telah Diminta
Oleh Pensyarah Anda Untuk Membina Aturcara Bagi Mengira Bilangan Pelajar
Didalam Senarai Tersebut. Tuliskan Aturcara Ini Dengan Terperinci. *)

Program Azri_Soalan7;

Uses Crt;

Var
   Bil:integer;
   Nama:string;

Begin

     Clrscr;

     Writeln('Taip ''tamat'' Setelah Selesai Memasukkan Nama');
     Writeln;
     Writeln;

     (* Perhatian: 'tamat' adalah case sensitive, jika 'tamat' dieja
     sebagai 'TAMAT' atau 'Tamat', program ini tidak akan berakhir dan
     akan dikira sebagai suatu input nama. *)

     While Nama <> 'tamat' Do

     Begin

     Write('Masukkan Nama Pelajar: ');
     Readln(Nama);
     bil:=bil+1;

     End;

     Writeln;
     Writeln('Bilangan Pelajar = ' , bil-1 , ' Orang');
     Readln;

End.
