#include <iostream>

using namespace std;

int main()
{
    float largura, comprimento;
    float area, iluminacao;

    cout << "Digite a largura do comodo: ";
    cin >> largura;

    cout << "Digite o comprimento do comodo: ";
    cin >> comprimento;

    area = (largura * comprimento);
    cout << "Area do comodo: " << area << " m2" << endl;

    iluminacao = (18.0 * area);
    cout << "Iluminacao (potencia total) do comodo: " << iluminacao << " W" << endl;

    return 0;
}