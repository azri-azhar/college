// Tugasan 2 - Soalan 5


#include <iostream.h>


class Person
{
      protected:
                char Nama[30];
                int Age;
                char Sex[10];
      public:
             void Add();
             void Display();
};

void Person::Add()
{            
     cout<<"Masukkan nama: ";
     cin>>Nama;
     cout<<"Masukkan umur: ";
     cin>>Age;
     cout<<"Masukkan jantina: ";
     cin>>Sex;
}

void Person::Display()
{
     cout<<"\n\nNama: " <<Nama <<endl;
     cout<<"Umur: " <<Age <<endl;
     cout<<"Jantina: " <<Sex <<endl;
}


class Student:public Person
{
      private:
                char StudNo[30];
                int  Marks;
                char Status;
      
      public:
             void AddStudInfo();
             void IdentifyGred();
             void displayStudInfo();
};

void Student::AddStudInfo()
{
     Add();
     cout<<"Masukkan No Matrik: ";
     cin>>StudNo;
     cout<<"Masukkan Markah: ";
     cin>>Marks;
}


void Student::IdentifyGred()
{
     if (Marks >= 50)
        Status = 'L';
     else
         Status = 'G';
}


void  Student::displayStudInfo()
{
      Display();  
      cout<<"No Matrik: " << StudNo << endl;
      cout<<"Markah: " << Marks << endl;
      cout<<"Status: " << Status <<endl <<endl <<endl;
}


class Employee:public Person
{
      private:
              char EmpNo[20];
              double Salary, Bonus, NetSalary;
      
      public:
             void AddEmpInfo();
             void CalculateNetSalary();
             void displayEmpInfo();
};


void Employee::AddEmpInfo()
{   
     Add();
     cout<<"Masukkan employee number: ";
     cin>>EmpNo;
     cout<<"Masukkan salary: ";
     cin>>Salary;
     cout<<"Masukkan kadar bonus: ";
     cin>>Bonus;
}


void Employee::CalculateNetSalary()
{
     NetSalary = Salary * Bonus;
} 


void Employee::displayEmpInfo()
{
     Display();
     cout<<"Salary: " << Salary << endl;
     cout<<"Kadar bonus: " << Bonus <<endl;
     cout<<"Gaji bersih: "<< NetSalary <<endl <<endl;
}

    
int main()
{
      Student Pelajar;
      Employee Pekerja;
      
      
      cout<<"Pelajar" <<endl;
      cout<<"========" <<endl <<endl;
      Pelajar.AddStudInfo();
      Pelajar.IdentifyGred();
      Pelajar.displayStudInfo();
      

      cout<<"Pekerja" <<endl;
      cout<<"========" <<endl <<endl;
      Pekerja.AddEmpInfo();
      Pekerja.CalculateNetSalary();
      Pekerja.displayEmpInfo();
      
      return 0;
}
