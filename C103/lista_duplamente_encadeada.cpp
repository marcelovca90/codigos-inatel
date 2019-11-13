#include <iostream>

using namespace std;

typedef struct No
{
    int info;
    struct No* ant;
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
    novo->ant = NULL;
    novo->prox = list;
    // se a lista não estiver vazia, conecta-a ao novo elemento
    if (list != NULL)
    {
        list->ant = novo;
    }
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
        Lista* aux = list;
        // e percore a lista enquanto o elemento seguinte não for nulo
        // (ou seja, ant será um ponteiro para o penúltimo elemento da lista)
        while (aux->prox != NULL)
        {
            aux = aux->prox;
        }
        // cria o novo (último) elemento da lista
        Lista* novo = new Lista;
        novo->info = valor;
        novo->ant = aux;
        novo->prox = NULL;
        // faz o "salto" no penúltimo elemento
        aux->prox = novo;
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

void imprimirDoInicioAoFim(Lista* list)
{
    // cria um ponteiro para o primeiro elemento da lista
    // e percore a lista enquanto o elemento atual não for nulo
    for (Lista* p = list; p != NULL; p = p->prox)
        cout << p->info << endl;
    cout << endl;
}

void imprimirDoFimAoInicio(Lista* list)
{
    // cria um ponteiro para o primeiro elemento da lista
    Lista* p = list;
    // e percore a lista enquanto o elemento seguinte ao atual não for nulo
    while (p->prox != NULL)
        p = p->prox;
    // neste momento, p armazena o ponteiro para o último elemento não nulo
    // portanto, pode-se agora percorrer a lista do fim até o início
    while (p != NULL)
    {
        cout << p->info << endl;
        p = p->ant;
    }
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
        Lista *novoInicio = list->prox;
        // desaloca memória do primeiro elemento (a ser removido)
        delete list;
        // conserta o ponteiro do elemento anterior ao novo início
        // (somente se o novo inicio nao for nulo)
        if (novoInicio != NULL)
        {
            novoInicio->ant = NULL;
        }
        // retorna o novo início da lista (isto é, o "ex" segundo elemento)
        return novoInicio;
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
        // só procede com a remoção caso o elemento tenha sido encontrado
        if (atual != NULL)
        {
            // conecta o elemento anterior ao que será removido
            // ao elemento posterior do que será removido
            anterior->prox = atual->prox;
            // conecta o elemento posterior ao que será removido
            // ao elemento anterior do que será removido
            // isto só acontece se a remoção não for na última posição
            if (atual->prox != NULL)
            {
                atual->prox->ant = anterior;
            }
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
    
    cout << "impressao do inicio ao fim" << endl;
    imprimirDoInicioAoFim(l);
    
    cout << "impressao do fim ao inicio" << endl;
    imprimirDoFimAoInicio(l);
    
    cout << "isEmpty ? " << estaVazia(l) << endl << endl;
    
    cout << "teste 1: removendo um elemento nao existente" << endl;
    l = remover(l, 0);
    imprimirDoInicioAoFim(l);
    
    cout << "teste 2: removendo o elemento do inicio" << endl;
    l = remover(l, 2);
    imprimirDoInicioAoFim(l);
    
    cout << "teste 3: removendo um elemento do meio" << endl;
    l = remover(l, 5);
    imprimirDoInicioAoFim(l);
    
    cout << "teste 4: removendo o elemento do final" << endl;
    l = remover(l, 11);
    imprimirDoInicioAoFim(l);

    cout << "teste 5: removendo todos elementos repetidos" << endl;
    l = inserirNoFinal(l, 13);
    l = inserirNoFinal(l, 13);
    l = inserirNoFinal(l, 13);
    cout << "antes da remocao: " << endl;
    imprimirDoInicioAoFim(l);
    l = removerTodos(l, 13);
    cout << "depois da remocao: " << endl;
    imprimirDoInicioAoFim(l);
    
    cout << "3 esta presente ? " << estaPresente(l, 3) << endl;
    cout << "7 esta presente ? " << estaPresente(l, 7) << endl;
    cout << "11 esta presente ? " << estaPresente(l, 11) << endl;
    
    return 0;
}
