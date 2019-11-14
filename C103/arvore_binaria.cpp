#include <iostream>

#define VAZIO NULL

using namespace std;

typedef struct No {
    int conteudo;
    struct No* esq;
    struct No* dir;
} Arvore;

Arvore* criar(int v, Arvore* esq, Arvore* dir)
{
    Arvore* arv = new Arvore;
    arv->conteudo = v;
    arv->esq = esq;
    arv->dir = dir;
    return arv;
}

Arvore* destruir(Arvore* arv)
{
    if (arv != VAZIO)
    {
        destruir(arv->esq);
        destruir(arv->dir);
        delete arv;
    }
    return VAZIO;
}

void preOrdem(Arvore* arv)
{
    if (arv == VAZIO)
        return;
    cout << arv->conteudo << endl;
    preOrdem(arv->esq);
    preOrdem(arv->dir);
}

void emOrdem(Arvore* arv)
{
    if (arv == VAZIO)
        return;
    emOrdem(arv->esq);
    cout << arv->conteudo << endl;
    emOrdem(arv->dir);
}

void posOrdem(Arvore* arv)
{
    if (arv == VAZIO)
        return;
    posOrdem(arv->esq);
    posOrdem(arv->dir);
    cout << arv->conteudo << endl;
}

int main()
{
    /*--------------*
    |        1      |
    |       / \     |
    |      2   3    |
    |     / \       |
    |    4   5      |
    *--------------*/
    
    Arvore* a4 = criar(4, VAZIO, VAZIO);
    Arvore* a5 = criar(5, VAZIO, VAZIO);
    Arvore* a2 = criar(2, a4, a5);
    Arvore* a3 = criar(3, VAZIO, VAZIO);
    Arvore* a1 = criar(1, a2, a3);
    
    preOrdem(a1); // 1 2 4 5 3
    cout << endl;
    
    emOrdem(a1); // 4 2 5 1 3
    cout << endl;
    
    posOrdem(a1); // 4 5 2 3 1
    cout << endl;
    
    destruir(a1);
    
    return 0;
}
