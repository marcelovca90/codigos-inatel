#include <iostream>

using namespace std;

int main()
{
    int num, maior, menor;

    cout << "Digite um numero (-9999 para sair): ";
    cin >> num;
    menor = num;
    maior = num;
    while (num != -9999)
    {
        if (num < menor)
            menor = num;
        if (num > maior)
            maior = num;
        cout << "Digite um numero (-9999 para sair): ";
        cin >> num;
    }

    cout << "Menor numero: " << menor << endl;
    cout << "Maior numero: " << maior << endl;

    return 0;
}