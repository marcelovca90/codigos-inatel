#include <iostream>

using namespace std;

struct habitante
{
    char cpf[15];
    double salario;
    int idade;
    int filhos;
};

int main()
{
    // entrada
    int n;

    do {
        cout << "Quantidade de habitantes (>0): ";
        cin >> n;
    } while (n <= 0);

    habitante hab[n];
    for (int i=0; i<n; i++)
    {
        cout << "Habitante " << (i+1) << endl;
        cout << "  CPF: ";
        cin >> hab[i].cpf;
        cout << "  Salario: ";
        cin >> hab[i].salario;
        cout << "  Idade: ";
        cin >> hab[i].idade;
        cout << "  Flhos: ";
        cin >> hab[i].filhos;
    }

    // processamento
    double total_filhos = 0.0;
    double maior_idade = hab[0].idade;
    int indice_maior_idade = 0;
    for (int i=0; i<n; i++)
    {
        total_filhos += hab[i].filhos;
        if (hab[i].idade > maior_idade)
        {
            maior_idade = hab[i].idade;
            indice_maior_idade = i;
        }
    }

    double media_filhos = total_filhos / n;
    cout << "Quantidade media de filhos: " << media_filhos << endl;

    cout << "Salario da pessoa mais velha: ";
    cout << hab[indice_maior_idade].salario << endl;

    cout << "CPF da pessoa mais velha: ";
    cout << hab[indice_maior_idade].cpf << endl;

    return 0;
}