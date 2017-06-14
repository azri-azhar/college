(* Menukar Nombor Ke Format Hexadecimal *)

Program Azri_Hex2;
Uses crt;

Var a:longint;
    b:string;

Function Hex(nombor: longint):string;
 Const
 panduan: string = '0123456789ABCDEF';

Var
 pemegang1, pemegang2: longint;
 akhir: string;
Begin
 akhir := '';
 while pemegang1 <> 0 do
  begin
   pemegang1 := nombor div 16;
   pemegang2 := nombor mod 16;
   akhir := panduan[pemegang2 + 1] + akhir;
   nombor := pemegang1;
  end;
 Hex:= akhir;
end;

Begin
 Clrscr;
 Write('Masukkan Nombor:');
 Readln(a);
 b:=Hex(a);
 Write(a ,' dalam Hexadecimal ialah:', b);
 Readln;
End.
