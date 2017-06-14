/* Contoh function yang tidak ada return value */

#include <stdio.h>

void InputData();
void KiraBonus(double, double);
void KiraGajiBersih(double, double);
void PaparGaji_Bonus(double, double, double);

void main()
{
	InputData();
}

void InputData()
{
	double dGaji, dKadarbonus;

	printf("Masukkan gaji asas:");
	scanf("%lf", &dGaji);
	printf("Masukkan kadar bonus:");
	scanf("%lf", &dKadarbonus);

	KiraBonus(dGaji, dKadarbonus);
}

void KiraBonus(double dGaji, double dKadarbonus)
{
	double dBonus;
	dBonus = dGaji*dKadarbonus;
	KiraGajiBersih(dGaji, dBonus);
}

void KiraGajiBersih(double dGaji, double dBonus)
{
	double dGajibersih;
	dGajibersih = dGaji + dBonus;

	PaparGaji_Bonus(dGaji, dBonus, dGajibersih);
}

void PaparGaji_Bonus(double dGaji, double dBonus, double dGajibersih)
{
	printf("Gaji asas = %.2lf\n", dGaji);
	printf("Bonus = %.2lf\n", dBonus);
	printf("Gaji bersih = %.2lf\n", dGajibersih);
}
