#include <iostream>

using namespace std;

int main()
{
    int inicio, fim;

    cout << "Digite o inicio e o fim do jogo: ";
    cin >> inicio >> fim;

    int hora_inicio = inicio / 100;
    int min_inicio = inicio % 100;
    int hora_fim = fim / 100;
    int min_fim = fim % 100;

    int inicio_em_minutos = (hora_inicio * 60) + min_inicio;
    int fim_em_minutos = (hora_fim * 60) + min_fim;
    int duracao_em_minutos = fim_em_minutos - inicio_em_minutos;
    
    int duracao_hora = duracao_em_minutos / 60;
    int duracao_min = duracao_em_minutos % 60;

    cout << "O jogo durou " << duracao_hora << " horas e " << duracao_min << " minutos." << endl;

    return 0;
}