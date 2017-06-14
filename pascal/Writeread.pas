(* Tulis Satu Aturcara Yang Meminta Nama, Kursus, No. Matrik, Tahun Dan
Mencetaknya Kembali Sebagai Output *)

Program Azri_ReadWrite;

Uses crt;

Var
   matrik,tahun,nama,kursus:string;

Begin
     Clrscr;

     Write('Masukkan Nama:');
     Readln(nama);
     Write('Kursus Apa:');
     Readln(kursus);
     Write('No Matrik:');
     Readln(matrik);
     Write('Tahun:');
     Readln(tahun);

     Writeln;
     Writeln;
     Writeln;

     Writeln('***********************************');
     Writeln('*                                 *');
     Writeln('* Nama: ', nama                     );
     Writeln('* Kursus: ', kursus                 );
     Writeln('* No. Matrik: ', matrik             );
     Writeln('* Tahun: ', tahun                   );
     Writeln('*                                 *');
     Writeln('************************************');

Readln;

End.
