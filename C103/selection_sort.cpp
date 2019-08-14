#include <iostream>

using namespace std;

int main()
{
    // declaracao do vetor de numeros inteiros
    int vet[] = { 5, 3, 1, 7, 4, 8 };
    
    // calculo do tamanho (quantidade de elementos) do vetor
    int tam = sizeof(vet)/sizeof(vet[0]);

    // imprime o vetor antes da ordenacao
    for (int i=0; i<tam; i++)
        cout << vet[i] << " ";
    cout << endl;

    // percorre o vetor do inicio ao penultimo elemento
    for (int i=0; i<tam-1; i++)
    {
        // adota i-esimo valor  do vetor como referencia,
        // armazenando seu indice para uso posterior
        int pos_menor_valor = i;

        // busca o maior valor a partir da posicao i+1 do vetor
        for (int j=i+1; j<tam; j++)
        {
            // se o valor atual (ou seja, na posicao j) for menor que o
            // menor elemento encontrado ate o momento, entao seu indice
            // eh armazenado para uso posterior (no momento da troca)
            if (vet[j] < vet[pos_menor_valor])
            {
                pos_menor_valor = j;
            }
        }
        // troca o elemento na posicao i pelo maior valor encontrado usando uma
        // variavel auxiliar para que nenhum valor seja perdido durante a troca
        int aux = vet[i];
        vet[i] = vet[pos_menor_valor];
        vet[pos_menor_valor] = aux;
    }

    // imprime o vetor depois da ordenacao
    for (int i=0; i<tam; i++)
        cout << vet[i] << " ";
    cout << endl;

    return 0;
}