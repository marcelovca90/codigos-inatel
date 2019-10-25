#include <iostream>

using namespace std;

struct fila
{
    int fim;          // guarda a posição do fim da fila
    int capacidade;   // guarda a capacidade da fila
    double *elementos; // vetor que armazena os valores
};

void init(fila *f, int c)
{
    f->fim = -1;                 // indica que a fila está vazia
    f->capacidade = c;           // define a capacidade da fila
    f->elementos = new double[c]; // aloca memória para a capacidade fornecida
}

bool isEmpty(fila *f)
{
    if (f->fim == -1)
        return true;
    else
        return false;
}

bool isFull(fila *f)
{
    if (f->fim == f->capacidade-1)
        return true;
    else
        return false;
}

void enqueue(fila *f, double v)
{
    f->fim++;
    f->elementos[f->fim] = v;
}

double dequeue(fila *f)
{
    double aux = f->elementos[0];
    for (int i = 0; i < f->fim; i++)
        f->elementos[i] = f->elementos[i+1];
    f->fim--;
    return aux;
}

double front(fila *f)
{
    return f->elementos[0];
}

int main()
{
    fila f;                      // declaração da fila
    init(&f, 5);                 // inicialização da fila
    cout << isEmpty(&f) << endl; // imprime se a fila está vazia
    cout << isFull(&f) << endl;  // imprime se a fila está cheia
    enqueue(&f, 10.0f);          // insere o valor 10.0 na fila
    cout << front(&f) << endl;   // imprime o valor do elemento na frente da fila
    enqueue(&f, 5.0f);           // insere o valor 5.0 na fila
    cout << front(&f) << endl;   // imprime o valor do elemento na frente da fila
    enqueue(&f, 15.0f);          // insere o valor 15.0 na fila
    cout << front(&f) << endl;   // imprime o valor do elemento na frente da fila
    float rem = dequeue(&f);     // remove o elemento na frente da fila, salvando-o em "rem"
    cout << front(&f) << endl;   // imprime o valor do elemento na frente da fila
    cout << rem << endl;         // imprime o valor recém removido na frente da fila
    
    return 0;
}
