(* Soalan4: Sebuah Pasaraya Ingin Mengadakan Jualan Murah Sempena Hari
Kebangsaan Dengan Memberikan Potongan Harga Sebanyak 30 Peratus. Anda Diminta
Untuk Merekabentuk Bagi Mengeluarkan Senarai Harga Barang Yang Baru Untuk
Rujukkan Mereka Dan Outputkan Ke C:\harga.txt. Tuliskan Aturcaranya Dengan
Terperinci *)

Program Azri_Soalan4;

Uses crt;

Var
    harga,potongan,jawapan:real;
    nama:string;
    Outfile:text;

    Label Tamat;

Begin
     TextBackground(2);
     TextColor(10);

     Writeln('                                           ');
     Writeln('ARAHAN: 1. Masukkan Nama Barang            ');
     Writeln('ARAHAN: 2. Masukkan Harga Barang           ');
     Writeln('ARAHAN: 3. Taip Tamat Jika Selesai         ');
     Writeln('                                           ');

     TextBackground(7);
     TextColor(8);

     Writeln('http://i.am/azri                           ');

     Assign(outfile, 'C:\harga.txt');
     Rewrite(outfile);

     Writeln(outfile, 'OUTPUT UNTUK SOALAN 4');
     Writeln(outfile, '=====================');
     Writeln(outfile, ' ');

     Repeat

     Clrscr;
     TextBackground(1);
     TextColor(12);

     Writeln;
     Writeln;

     Write('Masukkan Nama Barang: ');
     Readln(nama);

     If nama=('tamat') Then Goto Tamat;

     Write('Masukkan Harga Barang: RM ');
     Readln(harga);

     potongan:= (0.3*harga);
     jawapan:= harga-potongan;

     Writeln(outfile, 'Nama Barang = ' , nama);
     Writeln(outfile, 'Harga Asal = RM ' , harga:4:2);
     Writeln(outfile, 'Harga Selepas Potongan = RM ' , jawapan:4:2);
     Writeln(outfile,' ');

     Writeln;

     TextBackground(7);
     TextColor(0);

     Write('Harga ');
     Write(Nama);
     Writeln(' selepas potongan 30% ialah: RM ' , jawapan:4:2);

     Writeln;

     Writeln('Sila lihat fail C:\harga.txt');

     Until nama=('Tamat');

     Tamat: Begin close(outfile); End;

End.
