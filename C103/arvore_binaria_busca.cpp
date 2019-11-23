#include <iostream>

#define VAZIO NULL

using namespace std;

typedef struct No
{
    int altura;
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

Arvore* buscar(Arvore* arv, int v)
{
    if (arv == VAZIO)
    {
        cout << "no vazio" << endl;
        return VAZIO;
    }
    else if (v < arv->conteudo)
    {
        cout << "saindo de " << arv->conteudo << " buscando aa esquerda" << endl;
        return buscar(arv->esq, v);
    }
    else if (v > arv->conteudo)
    {
        cout << "saindo de " << arv->conteudo << " buscando aa direita" << endl;
        return buscar(arv->dir, v);
    }
    else
    {
        cout << "achei! " << arv->conteudo << endl;
        return arv;
    }
}

Arvore* inserir(Arvore* arv, int v)
{
    if (arv == VAZIO)
        arv = criar(v, VAZIO, VAZIO);
    else if (v < arv->conteudo)
        arv->esq = inserir(arv->esq, v);
    else
        arv->dir = inserir(arv->dir, v);    
    return arv;
}

Arvore* remover(Arvore* arv, int v)
{
    // arvore vazia
    if (arv == VAZIO)
    {
        cout << "no vazio" << endl;
        return VAZIO;
    }
    // valor a ser removido eh menor que o do no atual
    // ou seja, esta localizado na subarvore da esquerda
    else if (v < arv->conteudo)
    {
        cout << "saindo de " << arv->conteudo << " buscando aa esquerda" << endl;
        arv->esq = remover(arv->esq, v);
    }
    // valor a ser removido eh maior que o do no atual
    // ou seja, esta localizado na subarvore da direita
    else if (v > arv->conteudo)
    {
        cout << "saindo de " << arv->conteudo << " buscando aa direita" << endl;
        arv->dir = remover(arv->dir, v);
    }
    // encontrou o no a remover
    else
    {
        // caso 1: no sem filhos
        if (arv->esq == VAZIO && arv->dir == VAZIO)
        {
            cout << "estou em " << arv->conteudo << " caso 1: nao tenho filhos" << endl;
            delete arv;
            arv = VAZIO;
        }
        // caso 2: no so tem um filho
        // caso 2.1: so tem o filho da direita
        else if (arv->esq == VAZIO)
        {
            cout << "estou em " << arv->conteudo << " caso 2.1: so tenho filho maior" << endl;
            Arvore* aux = arv;
            arv = arv->dir;
            delete aux;
        }
        // caso 2.2: so tem o filho da esquerda
        else if (arv->dir == VAZIO)
        {
            cout << "estou em " << arv->conteudo << " caso 2.2: so tenho filho menor" << endl;
            Arvore* aux = arv;
            arv = arv->esq;
            delete aux;
        }
        // caso 3: no tem dois filhos
        else
        {
            cout << "estou em " << arv->conteudo << " caso 3: tenho dois filhos" << endl;
            Arvore* aux = arv->esq;
            cout << "buscando maior valor da subarvore aa esquerda" << endl;
            while (aux->dir != VAZIO)
                aux = aux->dir;
            cout << "trocando " << aux->conteudo << " por " << v << endl;
            arv->conteudo = aux->conteudo; // troca os valores
            aux->conteudo = v;
            arv->esq = remover(arv->esq, v);
        }
    }
    return arv;
}


int main()
{
    Arvore* arv = VAZIO;
    
    arv = inserir(arv, 2);
    arv = inserir(arv, 1);
    arv = inserir(arv, 3);
    arv = inserir(arv, 7);
    arv = inserir(arv, 4);
    arv = inserir(arv, 8);
    arv = inserir(arv, 0);
    arv = inserir(arv, 6);
    
    emOrdem(arv);
    cout << endl;
    
    arv = remover(arv, 7);
    
    emOrdem(arv);
    cout << endl;
    
    destruir(arv);
    
    return 0;
}
