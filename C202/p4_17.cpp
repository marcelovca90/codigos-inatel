#include <iostream>

using namespace std;

int main()
{
    char nome[100];
    int diarias, preco, taxa;
    int total_preco = 0, total_diarias = 0;

    for (int i=1; i<=5; i++)
    {
        cout << "Digite o nome: ";
        cin.getline(nome, 100);
        do {
            cout << "Digite a quantidade de diarias: ";
            cin >> diarias;
            cin.ignore();
        } while (diarias <= 0);
        total_diarias += diarias;

        if (diarias < 15)
            taxa = 20;
        else if (diarias == 15)
            taxa = 14;
        else
            taxa = 12;

        preco = 300 * diarias + taxa;
        total_preco += preco;

        cout << "Nome: " << nome << endl;
        cout << "Total a pagar: " << preco << endl;
    }
    cout << "Preco total: " << total_preco << endl;
    cout << "Diarias totais: " << total_diarias << endl;

    return 0;
}