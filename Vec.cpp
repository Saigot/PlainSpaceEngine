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

//Addition operator for 2 vectors, returns a new vector
Vec Vec::operator+(const Vec  &vec) {
    Vec ret(x + vec.x, y + vec.y, z + vec.z);
    return ret;
}

//Creates a new Vector with each element of this vector negated
Vec Vec::operator-(){
  //Vec v(*this);
  Vec v;
  v.x = -x;
  v.y = -y;
  v.z = -z;
  return v;
}

//preforms the standard inner product between these two vecs 
float Vec::operator*(const Vec  &vec) {
    return x*vec.x + y*vec.y + z*vec.z;
}

//Checks if two vectors are equivilent
bool Vec::operator==(const Vec  &vec){
    bool ret = x == vec.x && y == vec.y;
    if(twoD != vec.twoD) return false;
    ret = ret && z == vec.z;
    if(anchored != vec.anchored) return false;
//    if(anchored) ret = ret && anchor == vec.anchor;
}

//Mutates this object, adds this vector to vec
void Vec::operator+=(const Vec  &vec) {
    Vec ret(x + vec.x, y + vec.y, z + vec.z);
    x+=vec.x;
    y+=vec.y;
    z+=vec.z;
}

//subtracts two vectors, returns a new vector
Vec Vec::operator-(const Vec  &vec) {
    Vec ret(x - vec.x, y - vec.y, z - vec.z);
    return ret;
}

//the cross product of this and v, returns anew vector
 Vec Vec::cross(Vec &v){
        Vec ret = Vec(y * v.z - v.y*z,
                z * v.x - x * v.z, 
                x * v.y - v.x * y);
        return ret;
}

//returns a vector that is scaled, must be of the form vec*scalar
Vec Vec::operator*(float s){
    return Vec(x*s, y*s, z*s);
}

//equivalent to this = this*scalar
void Vec::operator*=(float s){
    x*=s;
    y*=s;
    z*=s;
}

//returns a new vector that is the result of a vec projected onto this
Vec Vec::proj(Vec vec){
        float constant = (vec * *this) / (*this * *this);
        Vec ret;
        ret.x = vec.x;
        ret.y = vec.y;
        ret.z = vec.z;
        ret*=constant;
        return ret;
}

//Returns a new vector that is the result of perp of vec onto this
Vec Vec::perp(Vec vec){
    return vec - proj(vec);
}