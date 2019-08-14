#include <iostream>
#include <cmath>

using namespace std;

struct ponto
{
    double x;
    double y;
};

double dist(ponto p1, ponto p2)
{
    double d = pow(p1.x - p2.x, 2.0) + pow(p1.y - p2.y, 2.0);
    
    return sqrt(d);
}

int main()
{
    ponto p1, p2;
    cin >> p1.x >> p2.x >> p1.y >> p2.y;
    
    double ans = dist(p1, p2);
    cout << ans << endl;

    return 0;
}