/* 
 * File:   Vec.h
 * Author: Michael17
 *
 * Created on May 30, 2014, 11:40 AM
 */

//#include "Point.h"
#ifndef VEC_H
#define	VEC_H

class Vec {
public:
    float x;
    float y;
    float z;
//    Point anchor;
    bool twoD;
    bool anchored;
    Vec(float x, float y , float z);
    //Vec(float x, float y , float z, Point &p);
    Vec(float x, float y , float z, bool twoD);
    //Vec(float x, float y , float z, Point &p, bool twoD);
    Vec();
    Vec operator+(const Vec  &vec);
    void operator+=(const Vec  &vec);
    bool operator==(const Vec  &vec);
    float operator*(const Vec  &vec);
    Vec operator*(float s);
    void operator*=(float s);
    Vec proj(Vec vec);
    Vec perp(Vec vec);
    Vec operator-(const Vec  &vec);
    Vec operator-();
    Vec(const Vec& orig);
    Vec cross(Vec &v);
    virtual ~Vec();
private:

};

#endif	/* VEC_H */

