(* Menukar Nombor Ke Format Hexadecimal *)

Program Azri_Hex;
Uses Crt;

Var x:word;
    y:string;

Function Hex(decimal : word) : string;
 const hexDigit : array [0..15] of char = '0123456789ABCDEF';
  begin
   hex := hexDigit[(decimal shr 12)]
       + hexDigit[(decimal shr 8) and $0F]
       + hexDigit[(decimal shr 4) and $0F]
       + hexDigit[(decimal and $0F)];
end;

Begin
 Clrscr;
 Write('Masukkan Nombor:');
 Readln(x);
 y:=Hex(x);
 Write(x, ' dalam Hexadecimal ialah ', y);
 Readln;
End.
