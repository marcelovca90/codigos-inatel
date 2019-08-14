#include <iostream>

#define QTD 3
#define TAM 80

using namespace std;

int main()
{
    char nomes[QTD][TAM];
    int notas[QTD];
    int soma = 0, media;

    // entrada
    for (int i=0; i<QTD; i++)
    {
        cout << "Digite o " << i << "-esimo nome: ";
        cin.getline(nomes[i], TAM);
        do {
            cout << "Digite a " << i << "-esima nota: ";
            cin >> notas[i];
        } while (notas[i] < 0 || notas[i] > 10);
        cin.ignore();
        soma += notas[i];
    }

    // processamento
    media = (soma/QTD);

    // saida
    for (int i=0; i<QTD; i++)
        cout << "Nome: " << nomes[i] << " Nota: " << notas[i] << endl;
    cout << "Media da turma: " << media << endl;

    return 0;
}