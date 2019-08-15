#include <iostream>

using namespace std;

int main()
{
    // declaracao do vetor de numeros inteiros
    int vet[] = { 7, 8, 5, 2, 4, 6, 3 };
    
    // calculo do tamanho (quantidade de elementos) do vetor
    int tam = sizeof(vet)/sizeof(vet[0]);

    // imprime o vetor antes da ordenacao
    for (int i=0; i<tam; i++)
        cout << vet[i] << " ";
    cout << endl;

    // percorre o vetor do segundo ao ultimo elemento
    for (int i=1; i<tam; i++)
    {
        // adora o i-esimo elemento como referencia
        int ref = vet[i];

        // percorre o vetor de i para tras, jogando elementos mal
        // posicionados (ou seja, vet[j] > vet[j+1]) para a direita
        // (ate que a posicao correta seja encontrada ou que o inicio
        // do vetor seja atingido - o que ocorrer primeiro)
        int j = i;
        while (j > 0 && vet[j-1] > ref)
        {
            vet[j] = vet[j-1];
            j--;
        }
        // coloca a referencia (ou seja, o i-esimo elemento)
        // na posicao correta (encontrada pelo while)
        vet[j] = ref;
    }

    // imprime o vetor depois da ordenacao
    for (int i=0; i<tam; i++)
        cout << vet[i] << " ";
    cout << endl;

    return 0;
}