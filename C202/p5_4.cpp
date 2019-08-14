#include <iostream>
#include <cmath>

#define TAM 20

using namespace std;

int main()
{
    int a[TAM];

    // entrada
    for (int i=0; i<TAM; i++)
    {
        cout << "Entre com o " << i << "-esimo valor: ";
        cin >> a[i];
    }

    // processamento
    int soma = 0;
    for (int i=0, j=TAM-1; i<TAM/2; i++, j--)
        soma += pow(a[i] - a[j], 2);

    // saida
    cout << "A soma eh " << soma << endl;

    return 0;
}