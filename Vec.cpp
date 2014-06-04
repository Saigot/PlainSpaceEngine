/* 
 * File:   Vec.cpp
 * Author: Michael17
 * 
 * Created on May 30, 2014, 11:40 AM
 * 
 * TODO:
 * Add support for anchor
 * Make sure all params are copied as intended when preforming operatios.
 */

#include "Vec.h"
//#include "Point.h"

Vec::Vec() {
}

Vec::Vec(const Vec& orig) {
}

Vec::~Vec() {
}
/*Vec::Vec(float x, float y , float z, Point &p){
        this->x = x;
        this->y = y;
        this->z = z;
        twoD = false;
        anchored = true;
        anchor = p;
}*/

Vec::Vec(float x, float y , float z){
        this->x = x;
        this->y = y;
        this->z = z;
        twoD = false;
        anchored = false;
    }
Vec::Vec(float x, float y , float z, bool twoD){
        this->x = x;
        this->y = y;
        this->z = z;
        twoD = false;
        if(twoD){
            this->z = 0;
            twoD = true;
        }
    }

/*Vec::Vec(float x, float y , float z, Point &p, bool twoD){
        this->x = x;
        this->y = y;
        this->z = z;
        twoD = false;
        if(twoD){
            this->z = 0;
            twoD = true;
        }
        anchored = true;
}*/

Vec Vec::operator+(const Vec  &vec) {
    Vec ret(x + vec.x, y + vec.y, z + vec.z);
    return ret;
}
Vec Vec::operator-(){
  //Vec v(*this);
  Vec v;
  v.x = -x;
  v.y = -y;
  v.z = -z;
  return v;
}

float Vec::operator*(const Vec  &vec) {
    return x*vec.x + y*vec.y + z*vec.z;
}

bool Vec::operator==(const Vec  &vec){
    bool ret = x == vec.x && y == vec.y;
    if(twoD != vec.twoD) return false;
    ret = ret && z == vec.z;
    if(anchored != vec.anchored) return false;
//    if(anchored) ret = ret && anchor == vec.anchor;
}

void Vec::operator+=(const Vec  &vec) {
    Vec ret(x + vec.x, y + vec.y, z + vec.z);
    x+=vec.x;
    y+=vec.y;
    z+=vec.z;
}




Vec Vec::operator-(const Vec  &vec) {
    Vec ret(x - vec.x, y - vec.y, z - vec.z);
    return ret;
}

 Vec Vec::cross(Vec &v){
        Vec ret = Vec(y * v.z - v.y*z,
                z * v.x - x * v.z, 
                x * v.y - v.x * y);
        return ret;
}
 
Vec Vec::operator*(float s){
    return Vec(x*s, y*s, z*s);
}

void Vec::operator*=(float s){
    x*=s;
    y*=s;
    z*=s;
}

Vec Vec::proj(Vec vec){
        float constant = (vec**this) / (*this**this);
        Vec ret;
        ret*=constant;
        return ret;
}
Vec Vec::perp(Vec vec){
    return vec - proj(vec);
}