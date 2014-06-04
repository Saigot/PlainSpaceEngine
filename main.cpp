/* 
 * File:   main.cpp
 * Author: Michael17
 *
 * Created on May 30, 2014, 11:39 AM
 */

#include <cstdlib>
#include <iostream>
using namespace std;
#include "Vec.h"
/*
 * 
 */
int main(int argc, char** argv) {
    Vec v1(1,2,3);
    Vec v2(2,3,4);
    Vec v3 = v2*2;
    cout << "Hello World" << endl;
    cout << v3.x << ", " << v3.y << ", " << v3.z << endl;
    cout << v1*v2 << endl;
    int n;
    cin >> n; 
    return 0;
}

