#include <iostream>

using namespace std;

int main()
{
    int x, y, z;

    cout << "Digite os tres lados do triangulo: ";
    cin >> x >> y >> z;

    // verificar se eh um triangulo
    if ((x<y+z) && (y<x+z) && (z<x+y))
    {
        cout << "Os lados podem formar um triangulo!" << endl;
        // verificar o tipo de triangulo
        // equilatero
        if ((x == y) && (y == z))
            cout << "Trata-se de um triangulo equilatero" << endl;
        // escaleno
        else if ((x != y) && (x != z) && (y != z))
            cout << "Trata-se de um triangulo escaleno" << endl;
        // isosceles
        else
            cout << "Trata-se de um triangulo isosceles" << endl;
    }
    else
        cout << "Os lados NAO podem formar um triangulo!" << endl;

    return 0;
}