(* Tulis Satu Aturcara Yang Menukarkan Nilai Ringgit Kepada US Dollar.
1 Ringgit Bersamaan Dengan 3.8 Dollar. *)

Program Azri_DivMod;

Uses crt;

Var
   Rm,Dollar,Baki:longint;
   Cent:Real;

Begin
     Clrscr;

     TextColor(3);
     TextBackground(12);

     Write('Masukkan RM:');
     Readln(Rm);

     Rm:=Rm*100;
     Dollar:=Rm div 380;

     Baki:=Rm mod 380;
     Cent:=Baki/380;


     TextColor(3);
     TextBackground(9);

Write(Dollar, ' Dollar ' , Cent:4:2, ' Cent');
Readln;

End.
