(* Tulis Satu Aturcara Untuk Menukar Nombor Asas 10 Ke Asas 2 *)

Program Azri_Binary;
Uses Crt;
Var x,y,m:integer;
    binary:Array[1..100] of integer;

Begin
 Clrscr;
 Write('Masukkan Nombor Anda:');
 Readln(x);
 y:= x div 2;
 Binary[1]:=x mod 2;
 m:= 2;
  While y <> 0 Do
   Begin
    Binary[M]:= y Mod 2;
    m:= m+1;
    y:= y Div 2;
   End;
 Write('Nombor Perduan Bagi ',x, ' ialah: ');
 For x:= m Downto 1 Do
  Write(Binary[x]:3);
  Readln;
End.
