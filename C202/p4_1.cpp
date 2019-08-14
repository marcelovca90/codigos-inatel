#include <iostream>

using namespace std;

int main()
{
    int num, maior = -999999;

    do 
    {
        cout << "Digite um numero: ";
        cin >> num;
        if (num > maior)
            maior = num;

    } while (num != -1);

    cout << "Maior numero lido: " << maior << endl;

    return 0;
}