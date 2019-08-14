#include <iostream>

using namespace std;

int main()
{
    int n;

    do {
        cout << "Digite a quantidade de elementos: ";
        cin >> n;
    } while (n < 0 || n > 100);

    int vet[n];

    for (int i=0; i<n; i++)
    {
        cout << "Digite o " << i << "-esimo valor: ";
        cin >> vet[i];
    }

    // forma 1
    for (int i=n-1; i>=0; i--)
        cout << vet[i] << endl;

    // forma 2
    for (int i=0; i<n; i++)
        cout << vet[n - i - 1] << endl;

    return 0;
}