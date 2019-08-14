#include <iostream>
#include <cmath>

#define TAM 7

using namespace std;

int main()
{
    int temp[TAM];
    int soma = 0;
    int media;

    // entrada
    for (int i=0; i<TAM; i++)
    {
        cout << "Entre com a " << i << "-esima temperatura: ";
        cin >> temp[i];
        soma += temp[i];
    }
    media = (soma / TAM);

    // processamento
    int maior = temp[0];
    int menor = temp[0];
    int menores_media = 0;
    int menores_iguais_zero = 0;

    for (int i=0; i<TAM; i++)
    {
        // maior temperatura
        if (temp[i] > maior)
            maior = temp[i];
        // menor temperatura
        if (temp[i] < menor)
            menor = temp[i];
        // temperaturas inferiores a media
        if (temp[i] < media)
            menores_media++;
            // temperaturas inferiores ou iguais a zero
        if (temp[i] <= 0)
            menores_iguais_zero++;
    }

    // saida
    cout << "Menor temperatura: " << menor << endl;
    cout << "Maior temperatura: " << maior << endl;
    cout << "Temperatura media: " << media << endl;
    cout << "Temperaturas menores que a media: " << menores_media << endl;
    cout << "Temperaturas menores ou iguais a zero: " << menores_iguais_zero << endl;

    return 0;
}