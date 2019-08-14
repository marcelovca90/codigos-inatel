#include <iostream>
#include <cmath>

using namespace std;

int main()
{
    float x, y;

    cout << "Entre com os valores de x e y: ";
    cin >> x >> y;

    float f;
    if (x > y)
        f = pow(x, 2.0) - pow(y, 2.0) + 2*x*y;
    else if (x < y)
        f = pow(x, 2.0) + pow(y, 2.0) + 2*x*y;
    else
        f = 2*x*y + x + y;
    
    cout << "f(x,y) = " << f << endl;

    return 0;
}