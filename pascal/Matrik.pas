(* Mendarab Matrik 2x3 dengan 3x2 *)

Program Azri_Matrik;
Uses crt;
Var
   a:Array[1..2,1..3] of integer;
   b:Array[1..3,1..2] of integer;
   c:Array[1..2,1..2] of integer;
   x,y,d,e,f,g,h:integer;

Begin
 clrscr;
 For x:= 1 to 2 Do
   For y:= 1 to 3 Do
    begin
     Write('Masukkan nilai matrik A:');
     Readln(a[x,y]);
    end;

 For d:= 1 to 3 Do
  For e:= 1 to 2 Do
   begin
    Write('Masukkan nilai matrik B:');
    Readln(b[d,e]);
   end;

 Clrscr;

 For f:= 1 to 3 Do
  begin
   c[1,1]:= c[1,1] + a[1,f] * b[f,1];
   c[1,2]:= c[1,2] + a[1,f] * b[f,2];
   c[2,1]:= c[2,1] + a[2,f] * b[f,1];
   c[2,2]:= c[2,2] + a[2,f] * b[f,2];
  end;

 For g:= 1 to 2 Do
  For h:= 1 to 2 Do
   begin
    Gotoxy(g*4,h*4);Write(c[h,g]:5);
   end;
Readln;
End.
