(* Soalan6: Bina Satu Aturcara Untuk Mengira Nombor Faktorial Bagi Sebarang
Nombor. Nombor Faktorial Bagi N Ditakrifkan Sebagai 1x2x3....x(N-1)x(N-1)xN
Nilai Faktorial Bagi 5 ialah 1x2x3x4x5=120. Apakah Nilai Faktorial Bagi
4,6 dan 10. *)

Program Azri_Soalan6;

Uses Crt;

Var
   N,Jumlah,bil,i:integer;

Begin
     Clrscr;
     Jumlah:=1;  (* Sebab Nombor Pertamanya Adalah Bernilai 1 *)
     Bil:=0;

     Write('Masukkan Nombor Faktorial: ');
     Readln(N);

Repeat
      Bil:=Bil+1;
      Jumlah:=Jumlah*bil;

Until Bil=N;

Write('Jawapannya Ialah: ',Jumlah);
Readln;

End.
