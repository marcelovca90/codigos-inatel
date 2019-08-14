#include <iostream>
#include <cstring>

using namespace std;

struct aluno
{
    int matricula;
    char nome[100];
    float nota;
};

int main()
{
    aluno a;
    int i = 0;
    float soma_notas = 0.0;
    float menor_nota = 999.0;
    char menor_nome[100];

    while (true)
    {
        cout << "Aluno " << i+1 << ":" << endl;
        cout << "  Digite a matricula: ";
        cin >> a.matricula;
        if (a.matricula == -1)
            break;
        
        cout << "  Digite o nome: ";
        cin.ignore();
        cin.getline(a.nome, 100);
        cout << "  Digite a nota: ";
        cin >> a.nota;

        soma_notas += a.nota;
        if (a.nota < menor_nota)
        {
            menor_nota = a.nota;
            strcpy(menor_nome, a.nome);
        }
        i++;
    };

    cout << "Media da turma: " << soma_notas/i << endl;
    cout << "Aluno com pior nota: " << menor_nome << " (" << menor_nota << ")" << endl;

    return 0;
}