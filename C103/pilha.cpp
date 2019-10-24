#include <iostream>

using namespace std;

struct pilha
{
    int topo;         // guarda a posicao do topo
    int capacidade;   // guarda a capacidade da pilha
    float *elementos; // vetor que armazena os valores
};

void init(pilha *p, int c)
{
    p->topo = -1;                // indica que a pilha está vazia
    p->capacidade = c;           // define a capacidade da pilha
    p->elementos = new float[c]; // aloca memória para a capacidade fornecida
}

bool isEmpty(pilha *p)
{
    if (p->topo == -1)
        return true;
    else
        return false;
}

bool isFull(pilha *p)
{
    if (p->topo == p->capacidade-1)
        return true;
    else
        return false;
}

void push(pilha *p, float v)
{
    p->topo++;
    p->elementos[p->topo] = v;
}

float pop(pilha* p)
{
    float aux = p->elementos[p->topo];
    p->topo--;
    return aux;
}

float top(pilha* p)
{
    return p->elementos[p->topo];
}

int main()
{
    pilha p;                     // declaração da pilha
    init(&p, 5);                 // inicialização da pilha
    cout << isEmpty(&p) << endl; // imprime se a pilha está vazia
    cout << isFull(&p) << endl;  // imprime se a pilha está cheia
    push(&p, 10.0f);             // insere o valor 10.0 na pilha
    cout << top(&p) << endl;     // imprime o valor do elemento no topo da pilha
    push(&p, 5.0f);              // insere o valor 5.0 na pilha
    cout << top(&p) << endl;     // imprime o valor do elemento no topo da pilha
    push(&p, 15.0f);             // insere o valor 15.0 na pilha
    cout << top(&p) << endl;     // imprime o valor do elemento no topo da pilha
    float rem = pop(&p);         // remove o elemento do topo da pilha, salvando-o em "rem"
    cout << top(&p) << endl;     // imprime o valor do elemento no topo da pilha
    cout << rem << endl;         // imprime o valor recém removido do topo da pilha
    
    return 0;
}
