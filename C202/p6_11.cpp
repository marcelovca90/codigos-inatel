#include <iostream>
#include <cmath>

using namespace std;

double senh(double x)
{
    return (exp(x) - exp(-x)) / 2.0;
}

double cosh(double x)
{
    return (exp(x) + exp(-x)) / 2.0;
}

void tanh(double senh_x, double cosh_x, double &tanh_x)
{
    tanh_x = senh_x / cosh_x;
}

void tanh_ptr(double senh_x, double cosh_x, double *tanh_x)
{
    *tanh_x = senh_x / cosh_x;
}

int main()
{
    double x;
    cout << "x = ";
    cin >> x;

    double sinh_x = sinh(x);
    cout << "sinh(" << x << ") = " << sinh_x << endl;

    double cosh_x = cosh(x);
    cout << "cosh(" << x << ") = " << cosh_x << endl;

    double tanh_x;
    tanh(sinh_x, cosh_x, tanh_x);
    cout << "tanh(" << x << ") = " << tanh_x << endl;

    double tanh_x_ptr;
    tanh_ptr(sinh_x, cosh_x, &tanh_x_ptr);
    cout << "tanh_ptr(" << x << ") = " << tanh_x_ptr << endl;

    return 0;
}