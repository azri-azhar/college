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
      Gotoxy(20,08);Writeln('�������������������������������������������');
      Gotoxy(20,09);Writeln('�                                         �');
      Gotoxy(20,10);Writeln('� Nama:                                   �');
      Gotoxy(20,11);Writeln('� Kursus:                                 �');
      Gotoxy(20,12);Writeln('� No.Matrik:                              �');
      Gotoxy(20,13);Writeln('� Tahun:                                  �');
      Gotoxy(20,14);Writeln('�                                         �');
      Gotoxy(20,15);Writeln('�������������������������������������������');
      Gotoxy(28,10);Write(Nama);
      Gotoxy(30,11);Write(Kursus);
      Gotoxy(33,12);Write(Nomatrik);
      Gotoxy(29,13);Write(Tahun);
      Readln;

End.
