#include <iostream>

using namespace std;

int main()
{
    int quantidade;

    cout << "Digite uma quantidade em milimetros: ";
    cin >> quantidade;

    int metros = (quantidade / 1000);
    quantidade -= (metros * 1000); 

    int decimetros = (quantidade / 100);
    quantidade -= (decimetros * 100);

    int centimetros = (quantidade / 10);
    quantidade -= (centimetros * 10);

    int milimetros = quantidade;
    quantidade -= milimetros;

    cout << metros << " metros, ";
    cout << decimetros << " decimetros, ";
    cout << centimetros << " centimetros e ";
    cout << milimetros << " milimetros" << endl;

    return 0;
}