#include <iostream>

using namespace std;

int main()
{
    float num, den, soma = 0.0;

    for (int i=38; i>1; i--)
    {
        num = i * (i - 1);
        den = (39 - i);
        soma += (num/den);

        cout << i << "x" << (i - 1) << "/" << (39 - i) << endl;
    }

    cout << "soma = " << soma << endl;

    return 0;
}