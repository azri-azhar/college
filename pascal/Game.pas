(* Permainan Meneka Nombor DiAntara 1 Hingga 100 *)

Program Azri_Game;

Uses Crt;

Var
   NomborRawak,Cubaan,Teka:integer;
   pilihan:char;

Begin
 Clrscr;
 Randomize;

  While upcase(pilihan) <> 'T' do
   Begin
    Clrscr;
    NomborRawak:=Random(100)+1;
    Cubaan:=6;
    Teka:=1000;
    Write('Cuba Teka Nombor Apakah Yang Sedang Saya Fikirkan:');

     While (NomborRawak <> Teka) And (Cubaan > 0) do
      Begin
       Readln(teka);
       Writeln;
       If teka = NomborRawak Then
        Writeln('Tahniah! Anda Berjaya Meneka Dengan Betul.')
        Else
         Begin
          Cubaan:=cubaan-1;
          If Cubaan = 0 Then
           Writeln('Maaf! Anda Tidak Mempunyai Peluang Untuk Meneka Lagi. ',
           'Nombor Yang Saya Fikirkan Adalah ', NomborRawak)
            Else
             If teka > NomborRawak Then
              Writeln('Nombor Yang Anda Teka Adalah Terlalu Besar. ' ,
               '( ',cubaan,' Tekaan Lagi!)')
                Else
                 Writeln('Nombor Yang Anda Teka Adalah Terlalu Kecil. ' ,
                  '( ',cubaan,' Tekaan Lagi!)');

      end;
         end;

     Writeln;
     Write('Adakah Anda Mahu Main Permainan Ini Lagi?');
     Readln(pilihan);

   end;

End.
