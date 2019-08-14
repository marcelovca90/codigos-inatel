#include <iostream>
#include <iomanip>

#define N_MESES 3
#define N_SEMANAS 4

using namespace std;

int main()
{
    char meses[][20] = 
    {
        "janeiro",
        "fevereiro",
        "marco",
        "abril",
        "maio",
        "junho",
        "julho",
        "agosto",
        "setembro",
        "outubro",
        "novembro",
        "dezembro"
    };

    float vendas[N_MESES][N_SEMANAS];
    float total_mes[N_MESES];
    float total_ano = 0.0;

    // entrada
    for (int i=0; i<N_MESES; i++)
    {
        cout << "Dados do mes " << (i+1) << ":" << endl;
        for (int j=0; j<N_SEMANAS; j++)
        {
            cout << "  Vendas na semana " << (j+1) << ": ";
            cin >> vendas[i][j];
        }
    }

    // processamento
    for (int i=0; i<N_MESES; i++)
    {
        total_mes[i] = 0;
        for (int j=0; j<N_SEMANAS; j++)
        {
            total_mes[i] += vendas[i][j];
        }
        total_ano += total_mes[i];
    }

    // saida
    cout << fixed << setprecision(2);
    for (int i=0; i<N_MESES; i++)
    {
        cout << "Vendas no mes de " << meses[i] << ": R$ " << total_mes[i] << endl;
    }
    cout << "Vendas totais (no ano): R$ " << total_ano << endl;

    return 0;
}