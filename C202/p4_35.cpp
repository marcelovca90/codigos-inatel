#include <iostream>

using namespace std;

int main()
{
    int numerador;
    float denominador = 0.0;
    float sinal = 1.0;
    float soma = 0.0;

    for (int i=1; i<=50; i++)
    {
        // numerador
        float fatorial = 1.0;
        for (int j=1; j<=i; j++)
            fatorial = fatorial * j;
        numerador = fatorial * sinal;
        sinal = sinal * -1.0;

        // denominador
        denominador = 2.0 * denominador + 1.0;

        // acumulador
        soma += (numerador / denominador);
    }   

    cout << "A soma da serie eh " << soma << endl;

    return 0;
}