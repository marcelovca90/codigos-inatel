#include <iostream>
#include <cstring>

using namespace std;

struct registro
{
    int codigo;
    char cargo[100];
    float salario;
};

int main()
{
    registro vet[5] =
    {
        1, "Analista de salarios", 1500.0,
        2, "Auxiliar de contabilidade", 1100.0,
        3, "Contador", 2000.0,
        4, "Gerente", 3000.0,
        17, "Secretaria", 850.0
    };
    
    while (true)
    {
        int codigo;
        cout << "  Digite o codigo: ";
        cin >> codigo;
        if (codigo == -1)
        {
            cout << "Saindo" << endl;
            break;
        }
        else
        {
            float salario_minimo;
            cout << "Resultado da busca:" << endl;
            for (int i=0; i<5; i++)
            {
                if (vet[i].codigo == codigo)
                {
                    cout << "  Cargo: " << vet[i].cargo << "\tSalario: " << vet[i].salario << endl;
                    salario_minimo = vet[i].salario;
                }
            }
            cout << "Cargos com salarios superiores:" << endl;
            for (int i=0; i<5; i++)
                if (vet[i].salario > salario_minimo)
                    cout << "  Codigo: " << vet[i].codigo << "\tCargo: " << vet[i].cargo << endl;
        }
    };

    return 0;
}