/* 
 * File:   Point.cpp
 * Author: Michael Scovell
 * 
 * Created on May 30, 2014, 11:43 AM
 */

#include "Point.h"

Point::Point(float X, float Y, float Z) {
        x = X;
        y = Y;
        z = Z;
}

Point::Point(const Point& orig) {
}

Point::~Point() {
}

bool Point::operator==(const Point  &pt){
    return x == pt.x && y == pt.y && z == pt.z;
}



