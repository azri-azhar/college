(* Tulis Satu Aturcara Untuk Menukar Nombor Asas 10 Ke Asas 8 *)

Program Azri_Octal;
Uses Crt;
Var x,y,m:integer;
    octal:Array[1..100] of integer;

Begin
 Clrscr;
 Write('Masukkan Nombor Anda:');
 Readln(x);
 y:= x div 8;
 octal[1]:=x mod 8;
 m:= 2;
  While y <> 0 Do
   Begin
    octal[M]:= y Mod 8;
    m:= m+1;
    y:= y Div 8;
   End;
 Write('Nombor Perlapanan Bagi ',x, ' ialah: ');
 For x:= m Downto 1 Do
  Write(octal[x]:3);
  Readln;
End.
