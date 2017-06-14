(* Tulis Satu Aturcara Yang Serupa Dengan ReadWrite.Pas Tetapi Outputnya
Mestilah Berada Ditengah-Tengah Dan Di Dalam Sebuah  Kotak. Guna ASCII
Alt+206, Alt+205, Alt+186 *)

Program Azri_Gotoxy;

Uses Crt;

Var Kursus, Nomatrik, Nama, Tahun:String;

Begin
     Clrscr;
      Write('Masukkan Nama: ');Readln(Nama);
      Write('Masukkan Kursus: ');Readln(Kursus);
      Write('Masukkan No. Matrik: ');Readln(Nomatrik);
      Write('Masukkan Tahun: ');Readln(Tahun);
     Clrscr;
      Gotoxy(20,08);Writeln('ฮอออออออออออออออออออออออออออออออออออออออออฮ');
      Gotoxy(20,09);Writeln('บ                                         บ');
      Gotoxy(20,10);Writeln('บ Nama:                                   บ');
      Gotoxy(20,11);Writeln('บ Kursus:                                 บ');
      Gotoxy(20,12);Writeln('บ No.Matrik:                              บ');
      Gotoxy(20,13);Writeln('บ Tahun:                                  บ');
      Gotoxy(20,14);Writeln('บ                                         บ');
      Gotoxy(20,15);Writeln('ฮอออออออออออออออออออออออออออออออออออออออออฮ');
      Gotoxy(28,10);Write(Nama);
      Gotoxy(30,11);Write(Kursus);
      Gotoxy(33,12);Write(Nomatrik);
      Gotoxy(29,13);Write(Tahun);
      Readln;

End.
