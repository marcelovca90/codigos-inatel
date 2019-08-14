#include <iostream>

#define N_ALUNOS 120
#define N_QUESTOES 50
#define N_APROVACAO 35

using namespace std;

int main()
{
    char gabarito[N_QUESTOES];
    int matricula[N_ALUNOS];
    char respostas[N_ALUNOS][N_QUESTOES];
    int acertos;
    float aprovacoes = 0.0;

    cout << "---- LEITURA DE GABARITO ----" << endl;
    for (int i=0; i<N_QUESTOES; i++)
    {
        cout << "Gabarito da " << i << "-esima questao: ";
        cin >> gabarito[i];
    }

    cout << "---- LEITURA DE MATRICULAS E RESPOSTAS ----" << endl;
    for (int i=0; i<N_ALUNOS; i++)
    {
        // entrada
        cout << "Matricula do " << i << "-esimo aluno: ";
        cin >> matricula[i];
        acertos = 0;
        for (int j=0; j<N_QUESTOES; j++)
        {
            cout << "  Resposta da " << j << "-esima questao: ";
            cin >> respostas[i][j];
            // processamento
            if (respostas[i][j] == gabarito[j])
                acertos++;
        }
        if (acertos >= N_APROVACAO)
            aprovacoes++;
        // saida
        cout << "Aluno de matricula " << matricula[i] << " tirou " << acertos << endl;
    }

    float pct_aprovacao = (100.0 * (aprovacoes/N_ALUNOS));
    cout << "Porcentagem de aprovacao: " << pct_aprovacao << endl;

    return 0;
}