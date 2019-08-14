#include <iostream>

#define N_ALUNOS 3
#define N_QUESTOES 3
#define MEDIA 2

using namespace std;

int main()
{
    char gabarito[N_QUESTOES];
    int matriculas[N_ALUNOS];
    char respostas[N_ALUNOS][N_QUESTOES];
    int acertos;
    float aprovados = 0.0;

    cout << "---- LEITURA DO GABARITO ----" << endl;
    for (int i=0; i<N_QUESTOES; i++)
    {
        cout << "Digite o gabarito da " << i << "-esima questao: ";
        cin >> gabarito[i];
    }

    cout << "---- LEITURA DE MATRICULAS E RESPOSTAS ----" << endl;
    for (int i=0; i<N_ALUNOS; i++)
    {
        cout << "Digite a matricula do " << i << "-esimo aluno: ";
        cin >> matriculas[i];
        acertos = 0;
        for (int j=0; j<N_QUESTOES; j++)
        {
            cout << "  Digite a resposta da " << j << "-esima questao: ";
            cin >> respostas[i][j];
            if (respostas[i][j] == gabarito[j])
                acertos++;
        }
        if (acertos >= MEDIA)
            aprovados++;
        cout << "  Matricula: " << matriculas[i] << " -> Nota: " << acertos << "/" << N_QUESTOES << endl;
    }

    cout << "---- PORCENTAGEM DE APROVACAO ----" << endl;
    double pct_aprov = 100.0 * (aprovados / N_ALUNOS);
    cout << "O percentual de aprovacao foi de " << pct_aprov << "%" << endl;

    return 0;
}