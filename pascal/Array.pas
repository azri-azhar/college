(* Mendarab Data-Data Dalam Array 2 Dimensi Dengan Dengan Data-Data Array
1 Demensi Dan Meletakkannya Di Array Yang Lain Serta Mencetak Output *)

Program Azri_Array;
Uses Crt;
Var a:Array[1..3, 1..2] of Integer;
    b:Array[1..2] of Integer;
    c:Array[1..3, 1..2] of Integer;
    d,e,f,g,h,i:Integer;

Begin
 Clrscr;

For d:= 1 to 3 Do
  For e:= 1 to 2 Do
   begin
    Write('Masukkan 6 Nombor Yang Dikehendaki:');
    Readln(a[d,e]);
   end;

For f:=1 to 2 Do
 begin
  Write('Masukkan 2 Nombor Yang Dikehendaki:');
  Readln(b[f]);
 end;

Writeln;

For g:=1 to 3 Do
 For h:=1 to 2 Do
  begin
   c[g,h]:=a[g,h]*b[h];
   Writeln(c[g,h]);
  end;
  Readln;

End.
