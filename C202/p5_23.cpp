#include <iostream>

using namespace std;

int acha_maior(int vet[4])
{
    int maior_desta_linha = vet[0];
    for (int j=0; j<4; j++)
    {
        if (vet[j] > maior_desta_linha)
            maior_desta_linha = vet[j];
    }
    return maior_desta_linha;
}

int main()
{
    int mat[6][4];

    // entrada
    for (int i=0; i<6; i++)
        for (int j=0; j<4; j++)
            cin >> mat[i][j];

    // processamento
    for (int i=0; i<6; i++)
    {
        // encontra maior valor da i-esima linha
        int maior_desta_linha = acha_maior(mat[i]);
        // multiplica todos os numeros da i-esima
        // linha pelo maior valor encontrado antes
        for (int j=0; j<4; j++)
        {
            mat[i][j] = mat[i][j] * maior_desta_linha;
        }
    }

    // saida
    for (int i=0; i<6; i++)
    {
        for (int j=0; j<4; j++)
        {
            cout << mat[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}