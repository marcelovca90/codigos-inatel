#include <iostream>

#define QTD 3
#define TAM 100

using namespace std;

int main()
{
    char nomes[QTD][TAM];
    int notas[QTD];
    int soma = 0;

    for (int i=0; i<QTD; i++)
    {
        cout << "Digite o nome do aluno: ";
        cin.getline(nomes[i], TAM);
        do {
            cout << "Digite a nota do aluno (de 0 a 10): ";
            cin >> notas[i];
        } while (notas[i] < 0 || notas[i] > 10);
        cin.ignore();
        soma += notas[i];
    }
    
    for (int i=0; i<QTD; i++)
        cout << "Aluno: " << nomes[i] << " Nota: " << notas[i] << endl;
    
    cout << "Media da turma: " << (soma/QTD) << endl;

    return 0;
}