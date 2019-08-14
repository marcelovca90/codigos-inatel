#include <iostream>
#include <iomanip>

#define TAM 5

using namespace std;

int main()
{
    float a[TAM], b[TAM];

    // entrada
    for (int i=0; i<TAM; i++)
    {
        cout << "Entre com o " << i << "-esimo valor: ";
        cin >> a[i];
    }

    // processamento
    for (int i=0; i<TAM; i++)
    {
        // par
        if (i % 2 == 0)
            b[i] = a[i] / 2;
        // impar
        else
            b[i] = a[i] * 3;
    }

    // saida
    cout << fixed << setprecision(1);
    for (int i=0; i<TAM; i++)
    {
        cout << "a[" << i << "] = " << a[i] << "\t";
        cout << "b[" << i << "] = " << b[i] << endl;
    }

    return 0;
}