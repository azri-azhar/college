/* Contoh penggunaan function yang ada return value */

#include <stdio.h>

void InputData();
double KiraBonus(double, double);
double KiraGajiBersih(double, double);
void PaparGaji_Bonus(double, double, double);

void main()
{
	InputData();
}

void InputData()
{
	double dGaji, dKadarbonus, dBonus, dGajibersih;

	printf("Masukkan gaji asas:");
	scanf("%lf", &dGaji);
	printf("Masukkan kadar bonus:");
	scanf("%lf", &dKadarbonus);

	dBonus = KiraBonus(dGaji, dKadarbonus);
	dGajibersih = KiraGajiBersih(dGaji, dBonus);

	PaparGaji_Bonus(dGaji, dBonus, dGajibersih);

}

double KiraBonus(double dGaji, double dKadarbonus)
{
	double dBonus;
	dBonus = dGaji*dKadarbonus;
	return (dBonus);
}

double KiraGajiBersih(double dGaji, double dBonus)
{
	double dGajibersih;
	dGajibersih = dGaji + dBonus;
	return (dGajibersih);
}

void PaparGaji_Bonus(double dGaji, double dBonus, double dGajibersih)
{
	printf("Gaji asas = %.2lf\n", dGaji);
	printf("Bonus = %.2lf\n", dBonus);
	printf("Gaji bersih = %.2lf\n", dGajibersih);
}
