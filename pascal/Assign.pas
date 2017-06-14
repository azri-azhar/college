(* Tulis Satu Aturcara Keputusan Peperiksaan Subjek Pascal Yang Meminta
Nama, No.KP, Markah Dan Menghasilkan Output Nama, No.KP, Gred dan Komen
Ke File Yang Bernama hasil.txt *)

Program Azri_Assign;

Uses crt;

Var
   nama:string;
   markah:integer;
   kp:string;
   komen:string;
   Gred:string;
   outfile:text;

Begin
Clrscr;
Write('Nama:');
Readln(nama);
Write('No.KP:');
Readln(kp);
Write('Markah:');
Readln(markah);

Assign(outfile, 'C:\hasil.txt');
rewrite(outfile);

Case markah of
90..100: begin Gred:='A'; komen:='Cemerlang';end;
85..89: begin Gred:='A-'; komen:='Cemerlang';end;
0..87:begin Gred:='Lain-lain';komen:='Tak Cemerlang';end;
end;

Writeln(outfile, 'Keputusan Subjek Pascal:');
Writeln(outfile, 'Nama Pelajar:',nama);
Writeln(outfile, 'No. Kad Pengenalan:',kp);
Writeln(outfile, 'Gred:',gred);
Writeln(outfile, 'Komen:',komen);
close(outfile);
End.
                                     *)