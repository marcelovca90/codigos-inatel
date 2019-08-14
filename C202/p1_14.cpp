#include <iostream>
#include <cstdlib>

using namespace std;

int main()
{    
    int ano;

    cout << "Digite o ano: ";
    cin >> ano;

    if (((ano % 4 == 0) && (ano % 100 != 0)) || (ano % 400 == 0))
        cout << "O ano eh bissexto" << endl;
    else
        cout << "O ano NAO eh bissexto" << endl;

    return 0;
}