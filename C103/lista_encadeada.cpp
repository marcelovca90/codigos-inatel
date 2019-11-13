#include <iostream>

using namespace std;

typedef struct No
{
    int info;
    struct No* prox;
} Lista;

Lista* criar()
{
    // a princípio, a lista está vazia
    return NULL;
}

Lista* inserirNoInicio(Lista* list, int valor)
{
    // aloca memória para o novo elemento da lista
    Lista* novo = new Lista;
    // define o valor do novo elemento
    novo->info = valor;
    // indica que o novo elemento será o primeiro da lista
    novo->prox = list;
    // retorna o novo elemento (ou seja, a nova lista)
    return novo;
}

Lista* inserirNoFinal(Lista* list, int valor)
{
    // se a lista estiver vazia, a inserção é no início
    if (list == NULL)
    {
        return inserirNoInicio(list, valor);
    }
    // senão, encontra o penultimo nó da lista
    else
    {
        // cria um ponteiro para o primeiro elemento da lista
        Lista* ant = list;
        // e percore a lista enquanto o elemento seguinte não for nulo
        // (ou seja, ant será um ponteiro para o penúltimo elemento da lista)
        while (ant->prox != NULL)
        {
            ant = ant->prox;
        }
        // cria o novo (último) elemento da lista
        Lista* novo = new Lista;
        novo->info = valor;
        novo->prox = NULL;
        // faz o "salto" no penúltimo elemento
        ant->prox = novo;
        return list;
    }
}

bool estaVazia(Lista* list)
{
    // se o ponteiro da lista estiver nulo,
    // então pode-se dizer que a lista está vazia
    return list == NULL;
}

bool estaPresente(Lista* list, int valor)
{
    // cria um ponteiro para o primeiro elemento da lista
    // e percore a lista enquanto o elemento atual não for nulo
    for (Lista* p = list; p != NULL; p = p->prox)
        if (p->info == valor)
            return true;
    return false;
}

void imprimir(Lista* list)
{
    // cria um ponteiro para o primeiro elemento da lista
    // e percore a lista enquanto o elemento atual não for nulo
    for (Lista* p = list; p != NULL; p = p->prox)
        cout << p->info << endl;
    cout << endl;
}

Lista* remover(Lista* list, int valor)
{
    // caso 1: lista vazia
    if (list == NULL)
    {
        // retorna uma lista vazia
        return NULL;
    }
    // caso 2: remoção na primeira posição
    else if (list->info == valor)
    {
        // salva a posição do segundo elemento
        Lista *novo = list->prox;
        // desaloca memória do primeiro elemento (a ser removido)
        delete list;
        // retorna o novo início da lista (isto é, o "ex" segundo elemento)
        return novo;
    }
    // caso 3: remoção em qualquer outra posição
    else
    {
        // ponteiros para o elemento que será removido
        // e para o elemento anterior ao que será removido
        Lista* atual = list;
        Lista* anterior = NULL;
        // encontra o elemento a ser removido na lista
        // ou o final da lista, caso tal elemento não exista
        while (atual != NULL && atual->info != valor)
        {
            anterior = atual;
            atual = atual->prox;
        }
        // só procede com a remoção caso o elemento não sido encontrado
        if (atual != NULL)
        {
            // "salta" o elemento que será removido
            anterior->prox = atual->prox;
            // desaloca memória do elemento a ser removido
            delete atual;
            // retorna início da lista (não foi alterado)
        }
        return list;
    }
}

Lista* removerTodos(Lista* list, int valor)
{
    while (estaPresente(list, valor))
    {
        list = remover(list, valor);
    }
    return list;
}

int main()
{
    Lista* l = criar();
    
    cout << "isEmpty ? " << estaVazia(l) << endl << endl;
    
    l = inserirNoFinal(l, 2);
    l = inserirNoFinal(l, 3);
    l = inserirNoFinal(l, 5);
    l = inserirNoFinal(l, 7);
    l = inserirNoFinal(l, 11);
    
    imprimir(l);
    
    cout << "isEmpty ? " << estaVazia(l) << endl << endl;
    
    cout << "teste 1: removendo um elemento nao existente" << endl;
    l = remover(l, 0);
    imprimir(l);
    
    cout << "teste 2: removendo o elemento do inicio" << endl;
    l = remover(l, 2);
    imprimir(l);
    
    cout << "teste 3: removendo um elemento do meio" << endl;
    l = remover(l, 5);
    imprimir(l);
    
    cout << "teste 4: removendo o elemento do final" << endl;
    l = remover(l, 11);
    imprimir(l);

    cout << "teste 5: removendo todos elementos repetidos" << endl;
    l = inserirNoFinal(l, 13);
    l = inserirNoFinal(l, 13);
    l = inserirNoFinal(l, 13);
    cout << "antes da remocao: " << endl;
    imprimir(l);
    l = removerTodos(l, 13);
    cout << "depois da remocao: " << endl;
    imprimir(l);
    
    cout << "3 esta presente ? " << estaPresente(l, 3) << endl;
    cout << "7 esta presente ? " << estaPresente(l, 7) << endl;
    cout << "11 esta presente ? " << estaPresente(l, 11) << endl;
    cout << "13 esta presente ? " << estaPresente(l, 13) << endl;

    return 0;
}
