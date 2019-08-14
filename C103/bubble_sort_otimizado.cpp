#include <iostream>

using namespace std;

int main()
{
    // declaracao do vetor de numeros inteiros
    int vet[] = { 5, 1, 4, 2, 8, 9 };

    // calculo do tamanho (quantidade de elementos) do vetor
    int tam = sizeof(vet)/sizeof(vet[0]);

    // imprime o vetor antes da ordenacao
    for (int i=0; i<tam; i++)
        cout << vet[i] << " ";
    cout << endl;

    // percorre o vetor do inicio ao penultimo elemento
    for (int i=0; i<tam-1; i++)
    {
        // flag que indica se houve troca na ultima travessia do vetor
        bool houve_troca = false;

        // percorre a porcao desordenada do vetor
        for (int j=0; j<tam-i-1; j++)
        {
            // se o elemento aa direita for maior que o elemento aa direita,
            // entao eles devem ser trocados usando uma variavel auxiliar
            // para que nenhum valor seja perdido durante a troca
            if (vet[j] > vet[j+1])
            {
                // realiza a troca
                int aux = vet[j];
                vet[j] = vet[j+1];
                vet[j+1] = aux;

                // seta o indicador de troca
                houve_troca = true;
            }
        }
        // se nao houve troca na ultima travessia do vetor,
        // entao ele ja esta ordenado, e o algoritmo pode parar
        if (houve_troca == false)
            break;
    }

    // imprime o vetor depois da ordenacao
    for (int i=0; i<tam; i++)
        cout << vet[i] << " ";
    cout << endl;

    return 0;
}
