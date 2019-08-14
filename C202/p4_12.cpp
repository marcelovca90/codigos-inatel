#include <iostream>

using namespace std;

int main()
{
    float altura, menor = 1000.0, altura_total = 0.0;
    int sexo, homens = 0, mulheres = 0;

    do {
        cout << "Digite a altura: ";
        cin >> altura;
        if (altura != 0.0)
        {
            cout << "Digite o sexo (1-M, 2-F): ";
            cin >> sexo;
            // trata caso masculino
            if (sexo == 1)
            {
                homens++;
            }
            // trata caso feminino
            else
            {
                mulheres++;
                altura_total += altura;
            }
            // mantem menor altura
            if (altura < menor)
            {
                menor = altura;
            }
        }
    } while (altura != 0.0);

    // a)
    if (homens > 0)
        cout << "Numero de homens: " << homens << endl;
    else
        cout << "Nao ha homens no grupo" << endl;    
    
    // b)
    if (homens + mulheres > 0)
        cout << "Menor altura do grupo: " << menor << endl;
    else
        cout << "Nao ha membros no grupo" << endl;
    
    // c)
    if (mulheres > 0)
        cout << "Media das alturas das mulheres: " << (altura_total / mulheres) << endl;
    else
        cout << "Nao ha mulheres no grupo" << endl;    

    return 0;
}